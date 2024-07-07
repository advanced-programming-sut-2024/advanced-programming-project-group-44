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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import static com.ap.gwentgame.ServerCommands.*;

public class LoginMenuController {
    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private ImageView imageview;
    @FXML


    public void initialize() {
        imageview.setImage(Backgrounds.MAINBG.getImage());
    }

    public void login(MouseEvent mouseEvent) {
        if(!ControllerUtilities.validateLoginUsername(name)) return;

        ServerMessage responseMessage = RequestSender.loginUser(name.getText(), password.getText());
        String responseText = responseMessage.getMessageText();

        if(LOGIN_FAILED_INCORRECT_PASSWORD.getMatcher(responseText).matches()){
            ViewUtilities.showErrorAlert("Incorrect Password", "The password you entered is incorrect.");
            return;
        }

        if(LOGIN_FAILED_USER_NOT_FOUND.getMatcher(responseText).matches()){
            ViewUtilities.showErrorAlert("User Not Found", "The user you entered does not exist.");
            return;
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        System.out.println("salam");
        System.out.println(responseMessage.getAdditionalText());
        User user = gson.fromJson(responseMessage.getAdditionalText(), User.class);
        System.out.println("salamsalam");
        Session.setLoggedInUser(user);


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
            if(!ControllerUtilities.validateLoginUsername(name)) return;
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