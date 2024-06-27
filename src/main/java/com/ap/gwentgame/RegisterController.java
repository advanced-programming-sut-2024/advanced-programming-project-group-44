package com.ap.gwentgame;

import com.ap.gwentgame.enums.Question;
import com.ap.gwentgame.enums.assets.Backgrounds;
import com.ap.gwentgame.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.security.SecureRandom;
import java.util.Optional;

public class RegisterController {
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
        if(name.getText() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("invalid username");
            alert.setContentText("enter a username");
            alert.show();
            return;
        }
        if(password.getText().length() < 8){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("invalid password");
            alert.setContentText("your password must have at least 8 characters");
            alert.show();
            return;
        }
        if(nickName.getText() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("invalid nickname");
            alert.setContentText("enter a nickname");
            alert.show();
            return;
        }
        if(nickName.getText().equals(nickName.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("nickname and username are same");
            alert.setContentText("change either username or your nickname");
            alert.show();
            return;
        }
        if(answer.getText() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("set an answer");
            alert.setContentText("you should set an answer for the security question");
            alert.show();
            return;
        }
        if(!isValidEmail(email.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("invalid email");
            alert.setContentText("write a valid email");
            alert.show();
            return;
        }
        if(App.getUserByName(name.getText()) != null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("this username exist");
            alert.setContentText("there is already s user with this username. choose another one.");
            alert.show();
            return;
        }
        if (!password.getText().equals(repeatedPassword.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("passwords dont match");
            alert.setContentText("repeat your password again");
            alert.show();
            return;
        }

        //new user
        User user = new User(name.getText() , password.getText() , nickName.getText() ,
                email.getText() , securityQuestion.getValue() , answer.getText());
        App.addUser(user);

    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        return email.matches(emailRegex);
    }

    public void reset(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("reset username and password?");
        alert.showAndWait();
        if (alert.getResult().getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE) return;
        name.setText("");
        password.setText("");
        repeatedPassword.setText("");
    }

    public void back(KeyEvent keyEvent) {
        System.out.println("gaga");
        if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
            System.out.println("pressed");
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

    public void generatePassword(MouseEvent mouseEvent) {
        int randomLength = getRandomNumberInRange(8, 12); // Get a random length between 8 and 12
        String randomPassword = generateRandomPassword(randomLength);

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

    private String generateRandomPassword(int randomLength) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqr" +
                "stuvwxyz0123456789!@#$%^&*()-_+=<>?";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < randomLength; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }

        return password.toString();
    }

    private int getRandomNumberInRange(int min, int max) {
        SecureRandom random = new SecureRandom();
        return random.nextInt((max - min) + 1) + min;
    }
}
