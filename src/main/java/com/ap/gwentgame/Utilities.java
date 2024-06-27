package com.ap.gwentgame;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.security.SecureRandom;
import java.util.Optional;

public class Utilities {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom random = new SecureRandom();
    private static final String DIGITS = "0123456789";
    private static final String SPECIALS = "&@$*_";
    private static final String ALL_CHARS = LOWERCASE + UPPERCASE + DIGITS + SPECIALS;

    public static String getResourcePath(String path) {
        return Utilities.class.getResource("/com/ap/gwentgame/" + path).toExternalForm();

    }

    public static boolean validatingUsername(TextField name) {
        if (name.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("invalid username");
            alert.setContentText("enter a username");
            alert.show();
            return false;
        }
        if (!name.getText().matches("^[A-Za-z0-9_]+$")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("invalid name");
            alert.setContentText("write a valid username(contains only uppercase,lowercase,numbers and/or _");
            alert.show();
            return false;
        }
        if (App.getUserByName(name.getText()) != null) {
            String suggestedUsername = "";
            do {
                StringBuilder newUsername = new StringBuilder(name.getText());
                SecureRandom random = new SecureRandom();
                int randomInt = random.nextInt(29) + 2;
                // Append a random character to the existing username
                newUsername.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
                if (randomInt % 4 == 0) newUsername.append("_".charAt(random.nextInt(1)));
                if (randomInt % 3 == 0) newUsername.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
                suggestedUsername = newUsername.toString();
            } while (App.getUserByName(name.getText()) != null);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("already existing username");
            alert.setHeaderText("suggesting username");
            alert.setContentText("you should pick another username, or you can choose the suggested username." +
                    "do you want to change you username to " + suggestedUsername + "?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                name.setText(suggestedUsername);
            }
            return false;
        }
        return true;
    }
    public static boolean validatingPassword(PasswordField password , PasswordField repeatedPassword){
        if (password.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("invalid password");
            alert.setContentText("enter a password");
            alert.show();
            return false;
        }
        if (!isValidPassword(password.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("invalid password");
            alert.setContentText("write a valid password(contains only uppercase," +
                    "lowercase,numbers and/or special characters)");
            alert.show();
            return false;
        }
        if (!isStrongPassword(password.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("weak password");
            alert.setContentText("write a strong password(at least 8 characters , " +
                    "containing uppercase,lowercase,numbers and special characters");
            alert.show();
            return false;
        }
        if (!password.getText().equals(repeatedPassword.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("passwords dont match");
            alert.setContentText("repeat your password again");
            alert.show();
            return false;
        }
        return true;
    }
    public static boolean validatingNickname(TextField name , TextField nickName){
        if (nickName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("invalid nickname");
            alert.setContentText("enter a nickname");
            alert.show();
            return false;
        }
        if (nickName.getText().equals(name.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("nickname and username are same");
            alert.setContentText("change either username or your nickname");
            alert.show();
            return false;
        }
        return true;
    }
    public static boolean validatingEmail(TextField email){
        if (email.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("invalid email");
            alert.setContentText("enter your email");
            alert.show();
            return false;
        }
        if (!isValidEmail(email.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("invalid email");
            alert.setContentText("write a valid email");
            alert.show();
            return false;
        }
        return true;
    }
    public static boolean validatingAnswer(TextField answer){
        if (answer.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("set an answer");
            alert.setContentText("you should set an answer for the security question");
            alert.show();
            return true;
        }
        return true;
    }
    public static boolean validatingUsernameForLoginMenu(TextField name){
        if(name.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("invalid username");
            alert.setContentText("enter a username first");
            alert.show();
            return false;
        }
        if (App.getUserByName(name.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("No User");
            alert.setContentText("Username was not found!");
            alert.show();
            return false;
        }
        return true;
    }
    private static boolean isStrongPassword(String password) {
        String emailRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[&$@_*])[A-Za-z\\d&@$_*]{8,}$";
        return password.matches(emailRegex);
    }
    private static boolean isValidPassword(String password) {
        String emailRegex = "^[A-Za-z\\d&$@_*]+$";
        return password.matches(emailRegex);
    }
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._%+-]+\\.[a-zA-Z0-9._%+-]+$";
        return email.matches(emailRegex);
    }
    public static void generatePassword(PasswordField password , PasswordField repeatedPassword){
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

    private static int getRandomNumberInRange(int min, int max) {
        SecureRandom random = new SecureRandom();
        return random.nextInt((max - min) + 1) + min;
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

}

