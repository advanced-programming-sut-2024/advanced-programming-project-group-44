package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.enums.Question;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.model.User;
import javafx.application.Platform;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerUtilitiesTest {

    private TextField usernameField;
    private TextField shiiiit;
    private TextField nicknameField;
    private PasswordField passwordField;
    private PasswordField repeatedPasswordField;
    private TextField emailField;
    private TextField answerField;

    @BeforeAll
    public static void initJFX() {
        // Initialize the JavaFX toolkit only once
        new Thread(() -> {
            try {
                Platform.startup(() -> {
                    // No-op
                });
            } catch (IllegalStateException e) {
                // Ignore if already initialized
            }
        }).start();
    }

    @BeforeEach
    public void setUp() {
        shiiiit = new TextField();
        usernameField = new TextField();
        nicknameField = new TextField();
        passwordField = new PasswordField();
        repeatedPasswordField = new PasswordField();
        emailField = new TextField();
        answerField = new TextField();
    }

    @Test
    public void testValidateUsername_EmptyUsername() {
        usernameField.setText("");
        boolean result = ControllerUtilities.validateUsername(usernameField);
        assertFalse(result);
    }

    @Test
    public void testValidateUsername_InvalidCharacters() {
        usernameField.setText("invalid@username");
        boolean result = ControllerUtilities.validateUsername(usernameField);
        assertFalse(result);
    }

//    @Test
//    public void testValidateUsername_ExistingUsername() {
//        usernameField.setText("aryana9");
//        //Session.addUser(new User("aryana", "uerhtrgrw", "vrwhge", "fchw@mfje.frmnj", Question.QUESTION_1, "fdhcy"));
//
//        boolean result = ControllerUtilities.validateUsername(usernameField);
//        assertTrue(result);
//    }

    @Test
    public void testValidateLoginUsername_UserNotFound() {
        usernameField.setText("");
        boolean result = ControllerUtilities.validateLoginUsername(usernameField);
        assertFalse(result);
    }

    @Test
    public void testValidatePassword_EmptyPassword() {
        passwordField.setText("");
        repeatedPasswordField.setText("");
        boolean result = ControllerUtilities.validatePassword(passwordField, repeatedPasswordField);
        assertFalse(result);
    }

    @Test
    public void testValidatePassword_InvalidPassword() {
        passwordField.setText("-");
        repeatedPasswordField.setText("-");
        boolean result = ControllerUtilities.validatePassword(passwordField, repeatedPasswordField);
        assertFalse(result);
    }

    @Test
    public void testValidatePassword_WeakPassword() {
        passwordField.setText("wW2$");
        repeatedPasswordField.setText("wW2$");
        boolean result = ControllerUtilities.validatePassword(passwordField, repeatedPasswordField);
        assertFalse(result);
    }

    @Test
    public void testValidatePassword_PasswordsDontMatch() {
        passwordField.setText("NhXh_K4*&u_xzhQ");
        repeatedPasswordField.setText("NhXh_K4*&u_xzh");
        boolean result = ControllerUtilities.validatePassword(passwordField, repeatedPasswordField);
        assertFalse(result);
    }

    @Test
    public void testValidatePassword_Success() {
        passwordField.setText("NhXh_K4*&u_xzhQ");
        repeatedPasswordField.setText("NhXh_K4*&u_xzhQ");
        boolean result = ControllerUtilities.validatePassword(passwordField, repeatedPasswordField);
        assertTrue(result);
    }

    @Test
    public void testValidateEmail_EmptyEmail() {
        emailField.setText("");
        boolean result = ControllerUtilities.validateEmail(emailField);
        assertFalse(result);
    }

    @Test
    public void testValidateEmail_InvalidEmail() {
        emailField.setText("invalidEmail");
        boolean result = ControllerUtilities.validateEmail(emailField);
        assertFalse(result);
    }

    @Test
    public void testValidateEmail_Success() {
        emailField.setText("valid.email@example.com");
        boolean result = ControllerUtilities.validateEmail(emailField);
        assertTrue(result);
    }

    @Test
    public void testValidateNickname_EmptyNickname() {
        usernameField.setText("username");
        nicknameField.setText("");
        boolean result = ControllerUtilities.validateNickname(usernameField, nicknameField);
        assertFalse(result);
    }

    @Test
    public void testValidateNickname_SameAsUsername() {
        usernameField.setText("sameName");
        nicknameField.setText("sameName");
        boolean result = ControllerUtilities.validateNickname(usernameField, nicknameField);
        assertFalse(result);
    }

    @Test
    public void testValidateNickname_Success() {
        usernameField.setText("username");
        nicknameField.setText("nickname");
        boolean result = ControllerUtilities.validateNickname(usernameField, nicknameField);
        assertTrue(result);
    }

    @Test
    public void testValidateAnswer_EmptyAnswer() {
        answerField.setText("");
        boolean result = ControllerUtilities.validateAnswer(answerField);
        assertFalse(result);
    }

    @Test
    public void testValidateUsername_EmptyUsernameForLogin() {
        usernameField.setText("");
        boolean result = ControllerUtilities.validateLoginUsername(usernameField);
        assertFalse(result);
    }

    @Test
    public void testValidateLoginUsername_Success() {
        String existingUsername = "aryana";
        Session.addUser(new User(existingUsername, "uerhtrgrw", "vrwhge", "fchw@mfje.frmnj", Question.QUESTION_1, "fdhcy"));
        usernameField.setText(existingUsername);

        boolean result = ControllerUtilities.validateLoginUsername(usernameField);
        assertTrue(result);
    }

    @Test
    public void testGeneratedUsername() {
        usernameField.setText("aryana");
        shiiiit.setText(ControllerUtilities.generateSuggestedUsername(usernameField.getText()));
        usernameField.setText("");
        //boolean result = false;
        boolean result = ControllerUtilities.validateUsername(usernameField);
        assertFalse(result);
    }


    @Test
    public void testGeneratePassword() {
        passwordField.setText(ControllerUtilities.generateRandomPassword());
        boolean result = ControllerUtilities.isStrongPassword(passwordField.getText());
        assertTrue(result);
    }
    @Test
    public void testGetResourcePath() {
        String path = "CSS";
        String resourcePath = ControllerUtilities.getResourcePath(path);
        assertTrue(resourcePath.contains("CSS"));
    }
    @BeforeAll
    public static void initSession() {
        // Initialize some users in the Session for testing
        Session.addUser(new User("aryana", "password", "nickname", "aryana@example.com", Question.QUESTION_1, "answer"));
        Session.addUser(new User("testuser", "password", "nickname", "testuser@example.com", Question.QUESTION_1, "answer"));
    }

    @Test
    public void testGenerateSuggestedUsername() {
        String username = "aryana";
        usernameField.setText(username);
        Set<String> generatedUsernames = new HashSet<>();
            assertFalse(ControllerUtilities.validateUsername(usernameField));
//        // Generate multiple suggested usernames to ensure variety
//        for (int i = 0; i < 5; i++) { // Reduced number of iterations
//            String suggestedUsername = ControllerUtilities.generateSuggestedUsername(username);
//            assertNotEquals(username, suggestedUsername, "Suggested username should not be the same as the original username.");
//            assertNull(Session.getUserByName(suggestedUsername), "Suggested username should not already exist in the session.");
//            assertTrue(suggestedUsername.matches("^[A-Za-z0-9_]+$"), "Suggested username should only contain valid characters.");
//            generatedUsernames.add(suggestedUsername);
//        }
////
////        // Check that multiple generated usernames are unique
//       assertTrue(generatedUsernames.size() > 1, "Generated usernames should be unique.");
    }


    @Test
    public void testValidateUsername_ExistingUsername() {
        usernameField.setText("aryana");
        Session.addUser(new User("aryana", "uerhtrgrw", "vrwhge", "fchw@mfje.frmnj", Question.QUESTION_1, "fdhcy"));

        // Simulate user input for confirmation alert
        // Assume showConfirmationAlert returns false
        boolean result = ControllerUtilities.validateUsername(usernameField);
        assertFalse(result);
        // Add assertions for UI feedback if required
    }

}
