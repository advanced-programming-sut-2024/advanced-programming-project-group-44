package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.view.MainMenu;
import com.ap.gwentgame.client.view.StartMenu;
import com.ap.gwentgame.client.enums.Question;
import com.ap.gwentgame.client.enums.assets.Backgrounds;
import com.ap.gwentgame.client.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

import static com.ap.gwentgame.ServerCommands.*;
import static com.ap.gwentgame.client.view.ViewUtilities.*;


public class RegisterMenuController {
    @FXML
    private TextField name;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField repeatedPassword;
    @FXML
    private TextField email;
    @FXML
    private TextField answer;
    @FXML
    private TextField nickName;
    @FXML
    private ChoiceBox<Question> securityQuestion;
    @FXML
    private ImageView imageview;

    public void initialize() {
        imageview.setImage(Backgrounds.MAINBG.getImage());
        securityQuestion.getItems().setAll(Question.values());
        securityQuestion.setValue(Question.QUESTION_1);
    }

    public void signup(MouseEvent mouseEvent) {
        if (!ControllerUtilities.validateUsername(name)) return;
        if (!ControllerUtilities.validateNickname(name, nickName)) return;
        if (!ControllerUtilities.validatePassword(password, repeatedPassword)) return;
        if (!ControllerUtilities.validateEmail(email)) return;
        if (!ControllerUtilities.validateAnswer(answer)) return;

        User user = new User(name.getText(), password.getText(), nickName.getText(),
                email.getText(), securityQuestion.getValue(), answer.getText());

        String responseText = RequestSender.registerUser(user).getMessageText();

        if (REGISTRATION_FAILED_USERNAME_TAKEN.getMatcher(responseText).matches()){
            String suggestedUsername = ControllerUtilities.generateSuggestedUsername(name.getText());
            if (showConfirmationAlert("Already Existing Username",
                    "You should pick another username, or you can choose the suggested username.\nDo you want to change your username to " + suggestedUsername + "?")) {
                name.setText(suggestedUsername);
            }
            return;
        }

        if (REGISTRATION_FAILED_EMAIL_TAKEN.getMatcher(responseText).matches()){
            showInformationAlert("Email Already Taken",
                    "The email you entered is already taken. Please enter another email.");
            return;
        }

        if(REGISTRATION_FAILED_NICKNAME_TAKEN.getMatcher(responseText).matches()){
            showInformationAlert("Nickname Already Taken",
                    "The nickname you entered is already taken. Please enter another nickname.");
            return;
        }

        if (!REGISTRATION_SUCCESSFUL.getMatcher(responseText).matches()){
            throw new RuntimeException("Unexpected response: " + responseText);
        }

        Session.setLoggedInUser(user);

        MainMenu main = new MainMenu();
        try {
            main.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void backToStart(MouseEvent mouseEvent) {
        StartMenu main = new StartMenu();
        try {
            main.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generatePassword(MouseEvent mouseEvent) {
        String randomPassword = ControllerUtilities.generateRandomPassword();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Random Password");
        alert.setHeaderText("Generated Random Password");
        alert.setContentText("Your random password is: " + randomPassword +
                "\nDo you want to use this password?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Set the password fields to the generated random password
            password.setText(randomPassword);
            repeatedPassword.setText(randomPassword);
        }
    }


}
