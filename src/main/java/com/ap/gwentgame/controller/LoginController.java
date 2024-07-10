package com.ap.gwentgame.controller;

import com.ap.gwentgame.view.MainMenu;
import com.ap.gwentgame.view.StartMenu;
import com.ap.gwentgame.enums.assets.Backgrounds;
import com.ap.gwentgame.model.App;
import com.ap.gwentgame.model.User;
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

public class LoginController {
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
        if(!Utilities.validatingUsernameForLoginMenu(name)) return;
        if (password.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("invalid password");
            alert.setContentText("enter a password");
            alert.show();
            return;
        }
        if(!App.getUserByName(name.getText()).getPassword().equals(password.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Wrong Password");
            alert.setContentText("The Password is not correct");
            alert.show();
            return;
        }
        MainMenu main = new MainMenu();
        try {
            main.start(App.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public void reset(MouseEvent mouseEvent) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setContentText("reset username and password?");
//        alert.showAndWait();
//        if (alert.getResult().getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE) return;
//        name.setText("");
//        password.setText("");
//        email.setText("");
//
//    }

    public void back(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
            StartMenu main = new StartMenu();
            try {
                main.start(App.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void backToStart(MouseEvent mouseEvent) {
        StartMenu main = new StartMenu();
        try {
            main.start(App.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToQuestionMenu(MouseEvent mouseEvent) {
        try {
            if(!Utilities.validatingUsernameForLoginMenu(name)) return;
            User user = App.getUserByName(name.getText());
            // Load the ForgotPassword popup FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/ap/gwentgame/fxml/ForgotPasswordMenu.fxml"));
            Parent root = fxmlLoader.load();

            // Access the controller for ForgotPassword.fxml
            ForgotPasswordController forgotPasswordController = fxmlLoader.getController();

            String securityQuestion = user.getQuestion().toString();
            forgotPasswordController.setSecurityQuestion(securityQuestion , user.getAnswer());

            // Create a new stage for the popup
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Forgot Password");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            // After popup closes, check if answer was correct and update login menu if needed
            String enteredAnswer = forgotPasswordController.getEnteredAnswer();
            if (enteredAnswer.equals(user.getAnswer())) {
                name.setText(user.getName());
                password.setText(user.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}