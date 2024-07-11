package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.view.MainMenu;
import com.ap.gwentgame.client.view.StartMenu;
import com.ap.gwentgame.client.enums.assets.Backgrounds;
import com.ap.gwentgame.client.model.User;
import javafx.application.Platform;
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

public class LoginMenuController {

    public TextField name;

    @FXML
    public PasswordField password;

    @FXML
    public ImageView imageview;
    @FXML


    public void initialize() {
        //imageview.setImage(Backgrounds.MAINBG.getImage());
    }

    public String login(MouseEvent mouseEvent) {
        if(!ControllerUtilities.validateLoginUsername(name)) return "invalid username";
        if (password.getText() == null) {
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Invalid Password");
                alert.setContentText("Please enter a password.");
                alert.show();
            });
            return "invalid password";
        }

        if(!Session.getUserByName(name.getText()).getPassword().equals(password.getText())){
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Wrong Password");
                alert.setContentText("The Password is not correct");
                alert.show();
            });
            return "Wrong Password";
        }

        MainMenu main = new MainMenu();
        try {
            main.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    public String backToStartMenu(MouseEvent mouseEvent) {
        StartMenu main = new StartMenu();
        try {
            main.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    public String goToQuestionMenu(MouseEvent mouseEvent) {
        try {
            if(!ControllerUtilities.validateLoginUsername(name)) return "invalid username";
            User user = Session.getUserByName(name.getText());
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}