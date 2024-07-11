package com.ap.gwentgame.client.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ap.gwentgame.client.enums.Question;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.model.User;
import com.ap.gwentgame.client.view.ProfileMenu;
import com.ap.gwentgame.client.view.ViewUtilities;
import javafx.application.Platform;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.assertj.core.annotations.Beta;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.framework.junit5.ApplicationTest;

@ExtendWith(MockitoExtension.class)
public class EditMenuControllerTest extends ApplicationTest {
    @InjectMocks
    private EditMenuController controller;
    private User mockUser;

    @Mock
    private Session mockSession;

    @Mock
    private MouseEvent mockMouseEvent;

    private TextField nameField;
    private TextField nicknameField;
    private TextField emailField;
    private PasswordField currentPasswordField;
    private PasswordField newPasswordField;
    private PasswordField confirmPasswordField;
    private ImageView back;

    @Override
    public void start(Stage stage) {
    }


    @BeforeAll
    public static void bu(){
        User user = new User("validuser", "validpass", "nickname", "email@example.com", Question.QUESTION_1, "answer");
        Session.setLoggedInUser(user);
    }

    @BeforeEach
    public void setUp() throws Exception {
        controller = new EditMenuController();

        nameField = new TextField();
        nicknameField = new TextField();
        emailField = new TextField();
        currentPasswordField = new PasswordField();
        newPasswordField = new PasswordField();
        confirmPasswordField = new PasswordField();
        back = new ImageView();

        controller.nameField = nameField;
        controller.nicknameField = nicknameField;
        controller.emailField = emailField;
        controller.currentPasswordField = currentPasswordField;
        controller.newPasswordField = newPasswordField;
        controller.confirmPasswordField = confirmPasswordField;
        controller.back = back;

        mockUser = mock(User.class);
        Session.setLoggedInUser(mockUser);
        ApplicationTest.launch(TestApp.class);
    }

    @Test
    public void testInitialize() {
        when(mockUser.getName()).thenReturn("TestUser");
        when(mockUser.getNickName()).thenReturn("TestNick");
        when(mockUser.getEmail()).thenReturn("test@example.com");

        String result = controller.initialize();

        assertEquals("done", result);
        assertEquals("TestUser", nameField.getText());
        assertEquals("TestNick", nicknameField.getText());
        assertEquals("test@example.com", emailField.getText());
    }

    @Test
    public void testSave_NoChanges() {
        when(mockUser.getName()).thenReturn("TestUser");
        when(mockUser.getNickName()).thenReturn("TestNick");
        when(mockUser.getEmail()).thenReturn("test@example.com");

        nameField.setText("TestUser");
        nicknameField.setText("TestNick");
        emailField.setText("test@example.com");

        String result = controller.save(mockMouseEvent);

        assertEquals("done", result);
        // Verify that the alert was shown with the correct message
    }

    @Test
    public void testSave_InvalidUsernameEmpty() {
        nameField.setText("");

        String result = controller.save(mockMouseEvent);

        assertEquals("invalid username", result);
    }

    @Test
    public void testSave_InvalidUsername() {
        nameField.setText("...");
        String result = controller.save(mock(MouseEvent.class));
        assertEquals("invalid username", result);
    }
    @Test
    public void testRegister_InvalidNicknameEqualName() {
        nicknameField.setText("aryana");
        nameField.setText("aryana");
        String result = controller.save(mock(MouseEvent.class));
        assertEquals("invalid nickname", result);
    }

    @Test
    public void testLogin_InvalidEmailIsEmpty() {
        nameField.setText("validuser");
        nicknameField.setText("arara");
        emailField.setText("");
        String result = controller.save(mock(MouseEvent.class));
        Platform.runLater(() -> {
            assertEquals("invalid email", result);
        });
    }
    @Test
    public void testLogin_InvalidEmail() {
        nameField.setText("validuser");
        nicknameField.setText("arara");
        emailField.setText("dddd");
        String result = controller.save(mock(MouseEvent.class));
        Platform.runLater(() -> {
            assertEquals("invalid email", result);
        });
    }

    @Test
    public void testSave_ValidChanges() {
        nameField.setText("NewName");
        nicknameField.setText("NewNick");
        emailField.setText("new@example.com");

        String result = controller.save(mockMouseEvent);

        assertEquals("done", result);
        verify(mockUser).setName("NewName");
        verify(mockUser).setNickName("NewNick");
        verify(mockUser).setEmail("new@example.com");
    }

    @Test
    public void testSavePassword_EmptyCurrentPassword() {
        currentPasswordField.setText("");

        String result = controller.savePassword(mockMouseEvent);

        assertEquals("invalid password", result);
    }

    @Test
    public void testSavePassword_InvalidCurrentPassword() {
        currentPasswordField.setText("wrongpassword");

        when(mockUser.getPassword()).thenReturn("correctpassword");

        String result = controller.savePassword(mockMouseEvent);

        assertEquals("invalid password", result);
    }

    //TODO check
    @Test
    public void testSavePassword_SameAsCurrentPassword() {
        currentPasswordField.setText("NhXh_K4*&u_xzhQ");
        newPasswordField.setText("NhXh_K4*&u_xzh");

        when(mockUser.getPassword()).thenReturn("NhXh_K4*&u_xzhQ");

        String result = controller.savePassword(mockMouseEvent);

        assertEquals("done", result);
    }

    @Test
    public void testSavePassword_SameAsCurrentPassword2() {
        currentPasswordField.setText("validpass");
        newPasswordField.setText("validpass");

        when(mockUser.getPassword()).thenReturn("validpass");

        String result = controller.savePassword(mockMouseEvent);

        assertEquals("same password", result);
    }

//    @Test
//    public void testSavePassword_InvalidNewPassword() {
//        currentPasswordField.setText("correctpassword");
//        newPasswordField.setText("newpassword");
//
//        when(mockUser.getPassword()).thenReturn("correctpassword");
//
//        String result = controller.savePassword(mockMouseEvent);
//
//        assertEquals("invalid password", result);
//    }

//    @Test
//    public void testSavePassword_ValidPasswordChange() {
//        currentPasswordField.setText("correctpassword");
//        newPasswordField.setText("newpassword");
//
//        when(mockUser.getPassword()).thenReturn("correctpassword");
//
//        String result = controller.savePassword(mockMouseEvent);
//
//        assertEquals("done", result);
//        verify(mockUser).setPassword("newpassword");
//    }

    @Test
    public void testBackToProfileMenu() {
        String result = controller.backToProfileMenu(mockMouseEvent);

        Platform.runLater(() -> {
            assertEquals("done", result);
        });
        // Verify that ProfileMenu.start() was called
    }
}
