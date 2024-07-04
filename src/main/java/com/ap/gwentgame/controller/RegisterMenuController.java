package com.ap.gwentgame.controller;

import com.ap.gwentgame.model.Session;
import com.ap.gwentgame.view.MainMenu;
import com.ap.gwentgame.view.StartMenu;
import com.ap.gwentgame.enums.Question;
import com.ap.gwentgame.enums.assets.Backgrounds;
import com.ap.gwentgame.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

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
        Session.addUser(user);
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
