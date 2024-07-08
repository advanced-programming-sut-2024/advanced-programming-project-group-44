package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.view.MainMenu;
import com.ap.gwentgame.client.view.StartMenu;
import com.ap.gwentgame.client.enums.assets.Backgrounds;
import com.ap.gwentgame.client.model.User;
import com.ap.gwentgame.client.view.ViewUtilities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import static com.ap.gwentgame.ServerCommands.*;
import static com.ap.gwentgame.client.view.ViewUtilities.showWarningAlert;

public class LoginMenuController {
    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ImageView imageview;

    @FXML


    public void initialize() {
        imageview.setImage(Backgrounds.MAINBG.getImage());
    }

    public void login(MouseEvent mouseEvent) {
        if (userNameField.getText().isEmpty()) {
            showWarningAlert("Invalid Username", "Enter a username first");
            return;
        }

        System.out.println("salamsalam");
        ServerMessage responseMessage = RequestSender.loginUser(userNameField.getText(), passwordField.getText());
        System.out.println("salam");
        String responseText = responseMessage.getMessageText();

        if (LOGIN_FAILED_INCORRECT_PASSWORD.getMatcher(responseText).matches()) {
            ViewUtilities.showErrorAlert("Incorrect Password", "The password you entered is incorrect.");
            return;
        }

        if (LOGIN_FAILED_USER_NOT_FOUND.getMatcher(responseText).matches()) {
            ViewUtilities.showErrorAlert("User Not Found", "The user you entered does not exist.");
            return;
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            User user = gson.fromJson(responseMessage.getAdditionalText(), User.class);
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
        try {
            if (!ControllerUtilities.validateLoginUsername(userNameField)) return;
            /*User user = Session.getUserByName(name.getText());
            FXMLLoader fxmlLoader = new FXMLLoader(new URL(ControllerUtilities.getResourcePath("fxml/ForgotPasswordMenu.fxml")));
            Parent root = fxmlLoader.load();

            ForgotPasswordMenuController forgotPasswordMenuController = fxmlLoader.getController();
            String securityQuestion = user.getQuestion().toString();
            forgotPasswordMenuController.setSecurityQuestion(securityQuestion , user.getAnswer());

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Forgot Password");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            String enteredAnswer = forgotPasswordMenuController.getEnteredAnswer();
            if (enteredAnswer.equals(user.getAnswer())) {
                name.setText(user.getName());
                password.setText(user.getPassword());
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}