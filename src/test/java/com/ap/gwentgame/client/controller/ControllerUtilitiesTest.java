package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.enums.Question;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.model.User;
import com.ap.gwentgame.client.view.ViewUtilities;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        // Initialize the JavaFX toolkit
        javafx.application.Platform.startup(() -> {
        });
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

    //
    @Test
    public void testValidateUsername_InvalidCharacters() {
        usernameField.setText("invalid@username");
        boolean result = ControllerUtilities.validateUsername(usernameField);
        assertFalse(result);
        // Add assertions for UI feedback if required
    }

    //
//    @Test
//    public void testValidateUsername_ExistingUsername() {
//        usernameField.setText("aryana");
//        Session.addUser(new User("aryana", "uerhtrgrw", "vrwhge", "fchw@mfje.frmnj", Question.QUESTION_1, "fdhcy"));
//
//        // Simulate user input for confirmation alert
//        // Assume showConfirmationAlert returns false
//        boolean result = ControllerUtilities.validateUsername(usernameField);
//        assertFalse(result);
//        // Add assertions for UI feedback if required
//    }
//
    @Test
    public void testValidatePassword_EmptyPassword() {
        passwordField.setText("");
        repeatedPasswordField.setText("");
        boolean result = ControllerUtilities.validatePassword(passwordField, repeatedPasswordField);
        assertFalse(result);
        // Add assertions for UI feedback if required
    }

    @Test
    public void testValidatePassword_InvalidPassword() {
        passwordField.setText("invalid");
        repeatedPasswordField.setText("invalid");
        boolean result = ControllerUtilities.validatePassword(passwordField, repeatedPasswordField);
        assertFalse(result);
        // Add assertions for UI feedback if required
    }

    @Test
    public void testValidatePassword_WeakPassword() {
        passwordField.setText("weak123");
        repeatedPasswordField.setText("weak123");
        boolean result = ControllerUtilities.validatePassword(passwordField, repeatedPasswordField);
        assertFalse(result);
        // Add assertions for UI feedback if required
    }

    @Test
    public void testValidatePassword_PasswordsDontMatch() {
        passwordField.setText("NhXh_K4*&u_xzhQ");
        repeatedPasswordField.setText("NhXh_K4*&u_xzh");
        boolean result = ControllerUtilities.validatePassword(passwordField, repeatedPasswordField);
        assertFalse(result);
        // Add assertions for UI feedback if required
    }

    @Test
    public void testValidatePassword_Success() {
        passwordField.setText("NhXh_K4*&u_xzhQ");
        repeatedPasswordField.setText("NhXh_K4*&u_xzhQ");
        boolean result = ControllerUtilities.validatePassword(passwordField, repeatedPasswordField);
        assertTrue(result);
        // Add assertions for UI feedback if required
    }

    @Test
    public void testValidateEmail_EmptyEmail() {
        emailField.setText("");
        boolean result = ControllerUtilities.validateEmail(emailField);
        assertFalse(result);
        // Add assertions for UI feedback if required
    }

    @Test
    public void testValidateEmail_InvalidEmail() {
        emailField.setText("invalidEmail");
        boolean result = ControllerUtilities.validateEmail(emailField);
        assertFalse(result);
        // Add assertions for UI feedback if required
    }

    @Test
    public void testValidateEmail_Success() {
        emailField.setText("valid.email@example.com");
        boolean result = ControllerUtilities.validateEmail(emailField);
        assertTrue(result);
        // Add assertions for UI feedback if required
    }

    @Test
    public void testValidateNickname_EmptyNickname() {
        usernameField.setText("username");
        nicknameField.setText("");
        boolean result = ControllerUtilities.validateNickname(usernameField, nicknameField);
        assertFalse(result);
        // Add assertions for UI feedback if required
    }

    @Test
    public void testValidateNickname_SameAsUsername() {
        usernameField.setText("sameName");
        nicknameField.setText("sameName");
        boolean result = ControllerUtilities.validateNickname(usernameField, nicknameField);
        assertFalse(result);
        // Add assertions for UI feedback if required
    }

    @Test
    public void testValidateNickname_Success() {
        usernameField.setText("username");
        nicknameField.setText("nickname");
        boolean result = ControllerUtilities.validateNickname(usernameField, nicknameField);
        assertTrue(result);
        // Add assertions for UI feedback if required
    }

    @Test
    public void testValidateAnswer_EmptyAnswer() {
        answerField.setText("");
        boolean result = ControllerUtilities.validateAnswer(answerField);
        assertFalse(result);
        // Add assertions for UI feedback if required
    }

    @Test
    public void testValidateUsername_EmptyUsernameForLogin() {
        usernameField.setText("");
        boolean result = ControllerUtilities.validateLoginUsername(usernameField);
        assertFalse(result);
    }

    //    @Test
//    public void testValidateLoginUsername_UserNotFound() {
//        usernameField.setText("nonExistingUser");
//        boolean result = ControllerUtilities.validateLoginUsername(usernameField);
//        assertFalse(result);
//    }
    @Test
    public void testValidateLoginUsername_Success() {
        String existingUsername = "aryana";
        Session.addUser(new User(existingUsername, "uerhtrgrw", "vrwhge", "fchw@mfje.frmnj", Question.QUESTION_1, "fdhcy"));
        usernameField.setText(existingUsername);

        boolean result = ControllerUtilities.validateLoginUsername(usernameField);
        assertTrue(result);
    }
//    @Test
//    public void testGeneratedUsername(){
//        usernameField.setText("aryana");
//        shiiiit.setText(ControllerUtilities.generateSuggestedUsername(usernameField.getText()));
//        boolean result = ControllerUtilities.validateUsername(shiiiit);
//        assertTrue(result);
//    }

    @Test
    public void testPasswordRegex(){
        String password = "NhXh_K4*&u_xzhQ";
        boolean result = ControllerUtilities.isStrongPassword(password);
        assertTrue(result);
    }
}


