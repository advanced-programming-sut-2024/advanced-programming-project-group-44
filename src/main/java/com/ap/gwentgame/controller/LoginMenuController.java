package com.ap.gwentgame.controller;

import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.view.MainMenu;
import com.ap.gwentgame.view.StartMenu;
import com.ap.gwentgame.enums.assets.Backgrounds;
import com.ap.gwentgame.client.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

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
        if (password.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("invalid password");
            alert.setContentText("enter a password");
            alert.show();
            return;
        }

        if(!Session.getUserByName(name.getText()).getPassword().equals(password.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Wrong Password");
            alert.setContentText("The Password is not correct");
            alert.show();
            return;
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
            if(!ControllerUtilities.validateLoginUsername(name)) return;
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
    }
}