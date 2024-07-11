package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.view.MainMenu;
import com.ap.gwentgame.client.view.StartMenu;
import com.ap.gwentgame.client.enums.Question;
import com.ap.gwentgame.client.enums.assets.Backgrounds;
import com.ap.gwentgame.client.model.User;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

public class RegisterMenuController {
    @FXML
    public TextField name;

    public PasswordField password;

    public PasswordField repeatedPassword;
    @FXML
    public TextField email;
    @FXML
    public TextField answer;
    @FXML
    public TextField nickName;
    @FXML
    public ChoiceBox<Question> securityQuestion;
    @FXML
    public ImageView imageview;

    public String initialize() {
//        securityQuestion.getItems().setAll(Question.values());
//        securityQuestion.setValue(Question.QUESTION_1);
        return "done";
    }

    public String signup(MouseEvent mouseEvent) {
        if (!ControllerUtilities.validateUsername(name)) return "invalid username";
        if (!ControllerUtilities.validateNickname(name, nickName)) return "invalid nickname";
        if (!ControllerUtilities.validatePassword(password, repeatedPassword)) return "invalid password";
        if (!ControllerUtilities.validateEmail(email)) return "invalid email";
        if (!ControllerUtilities.validateAnswer(answer)) return "invalid answer";
        return "done";

    }

    public String backToStart(MouseEvent mouseEvent) {
        StartMenu main = new StartMenu();
        try {
            main.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "done";
    }

    public String generatePassword(MouseEvent mouseEvent) {
        String randomPassword = ControllerUtilities.generateRandomPassword();
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Random Password");
            alert.setHeaderText("Generated Random Password");
            alert.setContentText("Your random password is: " + randomPassword +
                    "\nDo you want to use this password?");

        });
        return "done";
    }
}
