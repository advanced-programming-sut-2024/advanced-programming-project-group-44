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

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIALS = "&@$*_";
    private static final String ALL_CHARS = LOWERCASE + UPPERCASE + DIGITS + SPECIALS;
    private static final SecureRandom random = new SecureRandom();


    public void initialize() {
        imageview.setImage(Backgrounds.MAINBG.getImage());
        securityQuestion.getItems().setAll(Question.values());
        securityQuestion.setValue(Question.QUESTION_1);
    }

    public void signup(MouseEvent mouseEvent) {
//        if (name.getText() == null) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setHeaderText("invalid username");
//            alert.setContentText("enter a username");
//            alert.show();
//            return;
//        }
//
//        if (password.getText() == null) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setHeaderText("invalid password");
//            alert.setContentText("enter a password");
//            alert.show();
//            return;
//        }
//
//        if (nickName.getText() == null) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setHeaderText("invalid nickname");
//            alert.setContentText("enter a nickname");
//            alert.show();
//            return;
//        }
//        if (email.getText() == null) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setHeaderText("invalid email");
//            alert.setContentText("enter your email");
//            alert.show();
//            return;
//        }
//        if (nickName.getText().equals(name.getText())) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setHeaderText("nickname and username are same");
//            alert.setContentText("change either username or your nickname");
//            alert.show();
//            return;
//        }
//        if (answer.getText() == null) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setHeaderText("set an answer");
//            alert.setContentText("you should set an answer for the security question");
//            alert.show();
//            return;
//        }
//        if (!isValidUsername(name.getText())) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setHeaderText("invalid name");
//            alert.setContentText("write a valid username(contains only uppercase,lowercase,numbers and/or _");
//            alert.show();
//            return;
//        }
//        if (!isValidPassword(password.getText())) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setHeaderText("invalid password");
//            alert.setContentText("write a valid password(contains only uppercase,lowercase,numbers and/or special characters)");
//            alert.show();
//            return;
//        }
//        if (!isStrongPassword(password.getText())) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setHeaderText("weak password");
//            alert.setContentText("write a strong password(at least 8 characters , containing uppercase,lowercase,numbers and special characters");
//            alert.show();
//            return;
//        }
//        if (!isValidEmail(email.getText())) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setHeaderText("invalid email");
//            alert.setContentText("write a valid email");
//            alert.show();
//            return;
//        }
//        if (App.getUserByName(name.getText()) != null) {
//            String suggestedUsername = "";
//            do {
//                suggestedUsername = suggestUsername(name.getText());
//            } while (App.getUserByName(name.getText()) != null);
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("already existing username");
//            alert.setHeaderText("suggesting username");
//            alert.setContentText("you should pick another username, or you can choose the suggested username." +
//                    "do you want to change you username to " + suggestedUsername + "?");
//
//            Optional<ButtonType> result = alert.showAndWait();
//            if (result.isPresent() && result.get() == ButtonType.OK) {
//               name.setText(suggestedUsername);
//            }
//            return;
//        }
//        if (!password.getText().equals(repeatedPassword.getText())) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setHeaderText("passwords dont match");
//            alert.setContentText("repeat your password again");
//            alert.show();
//            return;
//        }
        if(!Utilities.validatingUsername(name)) return;
        if(!Utilities.validatingNickname(name , nickName)) return;
        if(!Utilities.validatingPassword(password , repeatedPassword)) return;
        if(!Utilities.validatingEmail(email)) return;
        if(!Utilities.validatingAnswer(answer));

        //new user
        User user = new User(name.getText(), password.getText(), nickName.getText(),
                email.getText(), securityQuestion.getValue(), answer.getText());
        App.addUser(user);
        MainMenu main = new MainMenu();
        try {
            main.start(App.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        return email.matches(emailRegex);
    }

    private boolean isStrongPassword(String password) {
        String emailRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[&$@_*])[A-Za-z\\d&@$_*]{8,}$";
        return password.matches(emailRegex);
    }

    private boolean isValidPassword(String password) {
        String emailRegex = "^[A-Za-z\\d&$@_*]+$";
        return password.matches(emailRegex);
    }

    private boolean isValidUsername(String password) {
        String emailRegex = "^[A-Za-z0-9_]+$";
        return password.matches(emailRegex);
    }

    private String suggestUsername(String existingUsername) {
        StringBuilder newUsername = new StringBuilder(existingUsername);
        int randomInt = getRandomNumberInRange(2, 30);
        // Append a random character to the existing username
        newUsername.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        if (randomInt % 4 == 0) newUsername.append("_".charAt(random.nextInt(1)));
        if (randomInt % 3 == 0) newUsername.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        return newUsername.toString();
    }

//    public void reset(MouseEvent mouseEvent) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setContentText("reset username and password?");
//        alert.showAndWait();
//        if (alert.getResult().getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE) return;
//        name.setText("");
//        password.setText("");
//        repeatedPassword.setText("");
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

    public void generatePassword(MouseEvent mouseEvent) {
        int randomLength = getRandomNumberInRange(8, 15); // Get a random length between 8 and 12
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

    private static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            // Swap the current character with a random character
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }

    public static String generateRandomPassword(int randomLength) {
        if (randomLength < 8) {
            throw new IllegalArgumentException("Password length must be at least 8 characters");
        }

        StringBuilder password = new StringBuilder(randomLength);

        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIALS.charAt(random.nextInt(SPECIALS.length())));

        for (int i = 4; i < randomLength; i++) {
            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }

        // Shuffle the password to ensure randomness
        return shuffleString(password.toString());
    }

    private int getRandomNumberInRange(int min, int max) {
        SecureRandom random = new SecureRandom();
        return random.nextInt((max - min) + 1) + min;
    }
}
