package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.Client;
import com.ap.gwentgame.client.enums.Question;
import com.ap.gwentgame.client.enums.assets.FXMLs;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.view.MainMenu;
import com.ap.gwentgame.client.view.StartMenu;
import com.ap.gwentgame.client.enums.assets.Backgrounds;
import com.ap.gwentgame.client.model.User;
import com.ap.gwentgame.client.view.ViewUtilities;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;

import static com.ap.gwentgame.ServerCommands.*;
import static com.ap.gwentgame.client.view.ViewUtilities.showWarningAlert;

public class LoginMenuController {
    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ImageView imageview;


    public void initialize() {
        imageview.setImage(Backgrounds.LOGIN_MENU.getImage());
    }

    public void login(MouseEvent mouseEvent) {
        if (userNameField.getText().isEmpty()) {
            showWarningAlert("Invalid Username", "Enter a username first");
            return;
        }

        ServerMessage responseMessage = RequestSender.loginUser(userNameField.getText(), passwordField.getText());
        String responseText = responseMessage.getMessageText();

        if (LOGIN_FAILED_INCORRECT_PASSWORD.getMatcher(responseText).matches()) {
            ViewUtilities.showErrorAlert("Incorrect Password", "The password you entered is incorrect.");
            return;
        }

        if (LOGIN_FAILED_USER_NOT_FOUND.getMatcher(responseText).matches()) {
            ViewUtilities.showErrorAlert("User Not Found", "The user you entered does not exist.");
            return;
        }

        try {
            User user = Client.getGson().fromJson(responseMessage.getAdditionalText(), User.class);
            Session.setLoggedInUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }


        MainMenu main = new MainMenu();
        try {
            main.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backToStartMenu(MouseEvent mouseEvent) {
        StartMenu main = new StartMenu();
        try {
            main.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToQuestionMenu(MouseEvent mouseEvent) {
        if (!ControllerUtilities.validateLoginUsername(userNameField)) return;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(new URL(ControllerUtilities.getResourcePath("fxml/ForgotPasswordMenu.fxml")));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Forgot Password");
            stage.setScene(new Scene(fxmlLoader.load()));

            ForgotPasswordMenuController forgotPasswordMenuController = fxmlLoader.getController();

            ServerMessage getQuestionResponseMessage = RequestSender.getQuestion(userNameField.getText());
            Question question = Client.getGson().fromJson(getQuestionResponseMessage.getAdditionalText(), Question.class);

            if (GET_QUESTION_FAILED_USER_NOT_FOUND.getMatcher(getQuestionResponseMessage.getMessageText()).matches()) {
                showWarningAlert("User Not Found", "The user you entered does not exist.");
                return;
            }

            forgotPasswordMenuController.setSecurityQuestion(question.toString());
            Button sendAnswerButton = forgotPasswordMenuController.getSendAnswerButton();
            sendAnswerButton.setOnMouseClicked(event -> {
                forgotPasswordMenuController.checkAnswerAndClose(userNameField.getText());
            });
            stage.showAndWait();

            if (forgotPasswordMenuController.getValidateAnswerResponse() != null) {
                if (VALIDATE_ANSWER_SUCCESSFUL.getMatcher(forgotPasswordMenuController.getValidateAnswerResponse().getMessageText()).matches()) {
                    User user = Client.getGson().fromJson(forgotPasswordMenuController.getValidateAnswerResponse().getAdditionalText(), User.class);
                    userNameField.setText(user.getName());
                    passwordField.setText(user.getPassword());
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}