package com.ap.gwentgame.client.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ap.gwentgame.client.enums.Question;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.model.User;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.framework.junit5.ApplicationTest;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@ExtendWith(MockitoExtension.class)
public class RegisterMenuControllerTest extends ApplicationTest{

    private RegisterMenuController controller;
    private TextField name;
    private PasswordField password;
    private ImageView imageview;
    private TextField nickname;
    private TextField email;
    private TextField answer;
    private PasswordField repeatedPassword;

    @Mock
    private MouseEvent mockMouseEvent;

    @Mock
    private Session session;
    @Override
    public void start(Stage stage) {
    }

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        controller = new RegisterMenuController();
        name = new TextField();
        password = new PasswordField();
        imageview = new ImageView();
        nickname = new TextField();
        email = new TextField();
        answer = new TextField();
        repeatedPassword = new PasswordField();
        controller.repeatedPassword = repeatedPassword;
        controller.email = email;
        controller.answer = answer;
        controller.nickName = nickname;
        controller.name = name;
        controller.password = password;
        controller.imageview = imageview;
        ApplicationTest.launch(TestApp.class);
    }

    @Test
    public void testInitialize() {
        String result = controller.initialize();
        assertEquals("done", result);
    }
    @Test
    public void testRegister_InvalidUsername() {
        name.setText("...");
        String result = controller.signup(mock(MouseEvent.class));
        assertEquals("invalid username", result);
    }
    @Test
    public void testRegister_InvalidNicknameIsEmpty() {
        nickname.setText("");
        name.setText("aryana");
        String result = controller.signup(mock(MouseEvent.class));
        assertEquals("invalid nickname", result);
    }
    @Test
    public void testRegister_InvalidNicknameEqualName() {
        nickname.setText("aryana");
        name.setText("aryana");
        String result = controller.signup(mock(MouseEvent.class));
        assertEquals("invalid nickname", result);
    }

    @Test
    public void testLogin_InvalidPasswordNull() {
        name.setText("validuser");
        nickname.setText("arara");
        password.setText("");
        repeatedPassword.setText("");
        String result = controller.signup(mock(MouseEvent.class));
        Platform.runLater(() -> {
            assertEquals("invalid password", result);
        });
    }

    @Test
    public void testLogin_InvalidPassword() {
        name.setText("validuser");
        nickname.setText("arara");
        password.setText("----");
        repeatedPassword.setText("");
        String result = controller.signup(mock(MouseEvent.class));
        Platform.runLater(() -> {
            assertEquals("invalid password", result);
        });
    }
    @Test
    public void testLogin_InvalidPasswordNotStrong() {
        name.setText("validuser");
        nickname.setText("arara");
        password.setText("NhXh_K4*&u_xzhQ");
        repeatedPassword.setText("NhXh_K4*&u_xzh");
        String result = controller.signup(mock(MouseEvent.class));
        Platform.runLater(() -> {
            assertEquals("invalid password", result);
        });
    }
    @Test
    public void testLogin_InvalidEmailIsEmpty() {
        name.setText("validuser");
        nickname.setText("arara");
        password.setText("NhXh_K4*&u_xzhQ");
        repeatedPassword.setText("NhXh_K4*&u_xzhQ");
        email.setText("");
        String result = controller.signup(mock(MouseEvent.class));
        Platform.runLater(() -> {
            assertEquals("invalid email", result);
        });
    }
    @Test
    public void testLogin_InvalidEmail() {
        name.setText("validuser");
        nickname.setText("arara");
        password.setText("NhXh_K4*&u_xzhQ");
        repeatedPassword.setText("NhXh_K4*&u_xzhQ");
        email.setText("dejfbwe");
        String result = controller.signup(mock(MouseEvent.class));
        Platform.runLater(() -> {
            assertEquals("invalid email", result);
        });
    }
    @Test
    public void testLogin_InvalidAnswer() {
        name.setText("validuser");
        nickname.setText("arara");
        password.setText("NhXh_K4*&u_xzhQ");
        repeatedPassword.setText("NhXh_K4*&u_xzhQ");
        email.setText("agag@bhs.mmkvm");
        answer.setText("");
        String result = controller.signup(mock(MouseEvent.class));
        Platform.runLater(() -> {
            assertEquals("invalid answer", result);
        });
    }
    @Test
    public void testLogin_validSignup() {
        name.setText("validuser");
        nickname.setText("arara");
        password.setText("NhXh_K4*&u_xzhQ");
        repeatedPassword.setText("NhXh_K4*&u_xzhQ");
        email.setText("agag@bhs.mmkvm");
        answer.setText("laaaaaa");
        String result = controller.signup(mock(MouseEvent.class));
        Platform.runLater(() -> {
            assertEquals("done", result);
        });
    }

    @Test
    public void testBackToStartMenu() throws Exception {
        String result = controller.backToStart(mock(MouseEvent.class));
        assertEquals("done", result);
    }

    @Test
    public void testGeneratePassword() {
        String mockRandomPassword = "MockRandomPassword123";

        String result = controller.generatePassword(mockMouseEvent);
        Platform.runLater(() -> {
            assertEquals("done", result);
        });
    }
}
