package com.ap.gwentgame.controller;

import com.ap.gwentgame.model.Session;
import com.ap.gwentgame.model.gameElementViews.CardView;
import com.ap.gwentgame.model.gameElementViews.PlayerView;
import com.ap.gwentgame.model.gameElementViews.UnitCardView;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.UnitCard;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.security.SecureRandom;

import static com.ap.gwentgame.view.ViewUtilities.showConfirmationAlert;
import static com.ap.gwentgame.view.ViewUtilities.showWarningAlert;


public class ControllerUtilities {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIALS = "&@$*_";
    private static final String ALL_CHARS = LOWERCASE + UPPERCASE + DIGITS + SPECIALS;
    private static final SecureRandom random = new SecureRandom();

    public static String getResourcePath(String path) {
        return ControllerUtilities.class.getResource("/com/ap/gwentgame/" + path).toExternalForm();
    }

    public static boolean validateUsername(TextField usernameField) {
        String username = usernameField.getText();
        if (username.isEmpty()) {
            showWarningAlert("Invalid Username", "Enter a username");
            return false;
        }
        if (!username.matches("^[A-Za-z0-9_]+$")) {
            showWarningAlert("Invalid Username", "Write a valid username (contains only uppercase, lowercase, numbers, and/or _)");
            return false;
        }
        if (Session.getUserByName(username) != null && username.equals(Session.getUserByName(username).getName())) {
            String suggestedUsername = generateSuggestedUsername(username);
            if (showConfirmationAlert("Already Existing Username", "Suggesting Username",
                    "You should pick another username, or you can choose the suggested username.\nDo you want to change your username to " + suggestedUsername + "?")) {
                usernameField.setText(suggestedUsername);
            }
            return false;
        }
        return true;
    }

    public static boolean validatePassword(PasswordField passwordField, PasswordField repeatedPasswordField) {
        String password = passwordField.getText();
        String repeatedPassword = repeatedPasswordField.getText();
        if (password.isEmpty()) {
            showWarningAlert("Invalid Password", "Enter a password");
            return false;
        }
        if (!isValidPassword(password)) {
            showWarningAlert("Invalid Password", "Write a valid password (contains only uppercase, lowercase, numbers, and/or special characters)");
            return false;
        }
        if (!isStrongPassword(password)) {
            showWarningAlert("Weak Password", "Write a strong password (at least 8 characters, containing uppercase, lowercase, numbers, and special characters)");
            return false;
        }
        if (!password.equals(repeatedPassword)) {
            showWarningAlert("Passwords Don't Match", "Repeat your password again");
            return false;
        }
        return true;
    }

    public static boolean validateNickname(TextField usernameField, TextField nicknameField) {
        String username = usernameField.getText();
        String nickname = nicknameField.getText();
        if (nickname.isEmpty()) {
            showWarningAlert("Invalid Nickname", "Enter a nickname");
            return false;
        }
        if (nickname.equals(username)) {
            showWarningAlert("Nickname and Username Are Same", "Change either username or your nickname");
            return false;
        }
        return true;
    }

    public static boolean validateEmail(TextField emailField) {
        String email = emailField.getText();
        if (email.isEmpty()) {
            showWarningAlert("Invalid Email", "Enter your email");
            return false;
        }
        if (!isValidEmail(email)) {
            showWarningAlert("Invalid Email", "Write a valid email");
            return false;
        }
        return true;
    }

    public static boolean validateAnswer(TextField answerField) {
        String answer = answerField.getText();
        if (answer.isEmpty()) {
            showWarningAlert("Set an Answer", "You should set an answer for the security question");
            return false;
        }
        return true;
    }

    public static boolean validateLoginUsername(TextField usernameField) {
        String username = usernameField.getText();
        if (username.isEmpty()) {
            showWarningAlert("Invalid Username", "Enter a username first");
            return false;
        }
        if (Session.getUserByName(username) == null) {
            showWarningAlert("No User", "Username was not found!");
            return false;
        }
        return true;
    }

    private static String generateSuggestedUsername(String username) {
        String suggestedUsername;
        do {
            StringBuilder newUsername = new StringBuilder(username);
            int randomInt = getRandomNumberInRange(2, 30);
            newUsername.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
            if (randomInt % 4 == 0) {
                newUsername.append("_".charAt(random.nextInt(1)));
            }
            if (randomInt % 3 == 0) {
                newUsername.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
            }
            suggestedUsername = newUsername.toString();
        } while (Session.getUserByName(username) != null);
        return suggestedUsername;
    }

    private static boolean isStrongPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[&$@_*])[A-Za-z\\d&@$_*]{8,}$";
        return password.matches(passwordRegex);
    }

    private static boolean isValidPassword(String password) {
        String passwordRegex = "^[A-Za-z\\d&$@_*]+$";
        return password.matches(passwordRegex);
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._%+-]+\\.[a-zA-Z0-9._%+-]+$";
        return email.matches(emailRegex);
    }

    public static String generateRandomPassword() {
        int randomLength = getRandomNumberInRange(8, 15);
        StringBuilder password = new StringBuilder(randomLength);

        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIALS.charAt(random.nextInt(SPECIALS.length())));

        for (int i = 4; i < randomLength; i++) {
            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }

        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }

    public static void weatherAbility(PlayerView playerView , int row) {
        for (CardView cardView : playerView.getRowViews()[row].getCardViews()) {
            if (cardView instanceof UnitCardView unitCardView && !((UnitCard) cardView.getItem()).isHero()) {
                unitCardView.setScore(1);
            }
        }
    }

    public static int calculateScoreOfRowNotHero(PlayerView playerView , int row){
        int score = 0;
        for (Card card : playerView.getRowViews()[row].getCards()) {
            if (card instanceof UnitCard && !((UnitCard) card).isHero()) {
                score += ((UnitCard) card).getScore();
            }
        }
        return score;
    }
    public static int calculateMaxScoreOfRowNotHero(PlayerView player , int row){
        int maxScore = 0;
        for (Card card : player.getRowViews()[row].getCards()) {
            if (card instanceof UnitCard && !((UnitCard) card).isHero()) {
                if (((UnitCard) card).getScore() > maxScore) maxScore = ((UnitCard) card).getScore();
            }
        }
        return maxScore;
    }

    private static int getRandomNumberInRange(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
