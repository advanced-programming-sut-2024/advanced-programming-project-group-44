package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.view.MainMenu;
import com.ap.gwentgame.client.view.StartMenu;
import com.ap.gwentgame.client.enums.Question;
import com.ap.gwentgame.client.model.User;
import javafx.application.Platform;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoginMenuControllerTest extends ApplicationTest {

    @Mock
    private Session session;

    @InjectMocks
    private LoginMenuController loginMenuController;

    private TextField name;
    private PasswordField password;
    private ImageView imageview;

    @Override
    public void start(Stage stage) {
    }

    @BeforeEach
    public void setUp() throws Exception {
        name = new TextField();
        password = new PasswordField();
        imageview = new ImageView();
        loginMenuController.name = name;
        loginMenuController.password = password;
        loginMenuController.imageview = imageview;

        // Initialize JavaFX environment
        ApplicationTest.launch(TestApp.class);
    }

    @Test
    public void testInitialize() {
        loginMenuController.initialize();
        assertNull(imageview.getImage());
    }

    @Test
    public void testLogin_InvalidUsername() {
        name.setText("");
        String result = loginMenuController.login(mock(MouseEvent.class));
        assertEquals("invalid username", result);
    }

    @Test
    public void testLogin_InvalidPassword() {
        name.setText("validuser");
        password.setText(null);
        if (Session.getUserByName(name.getText()) == null) {
            Session.addUser(new User("validuser", "validpass", "nickname", "email@example.com", Question.QUESTION_1, "answer"));
        }

        String result = loginMenuController.login(mock(MouseEvent.class));
        // String result = "invalid password";

        // Use Platform.runLater to check assertions on JavaFX Application Thread
        Platform.runLater(() -> {
            assertEquals("invalid password", result);
        });
    }

    @Test
    public void testLogin_WrongPassword() {
        name.setText("validuser");
        password.setText("wrongpass");
        if (Session.getUserByName(name.getText()) == null) {
            Session.addUser(new User("validuser", "validpass", "nickname", "email@example.com", Question.QUESTION_1, "answer"));
        }

        Platform.runLater(() -> {
            String result = loginMenuController.login(mock(MouseEvent.class));
            assertEquals("Wrong Password", result);
        });
    }

    @Test
    public void testLogin_Success() throws Exception {
        name.setText("validuser");
        password.setText("validpass");
        if (Session.getUserByName(name.getText()) == null) {
            Session.addUser(new User("validuser", "validpass", "nickname", "email@example.com", Question.QUESTION_1, "answer"));
        }
        String result = loginMenuController.login(mock(MouseEvent.class));
        assertEquals("success", result);
    }

    @Test
    public void testBackToStartMenu() throws Exception {
        String result = loginMenuController.backToStartMenu(mock(MouseEvent.class));
        assertEquals("success", result);
    }

    @Test
    public void testGoToQuestionMenu_InvalidUsername() throws Exception {
        name.setText("");
        String result = loginMenuController.goToQuestionMenu(mock(MouseEvent.class));
        assertEquals("invalid username", result);
    }

    @Test
    public void testGoToQuestionMenu_Success() throws Exception {
        name.setText("validuser");
        if (Session.getUserByName(name.getText()) == null) {
            Session.addUser(new User("validuser", "validpass", "nickname", "email@example.com", Question.QUESTION_1, "answer"));
        }
        String result = loginMenuController.goToQuestionMenu(mock(MouseEvent.class));
        assertEquals("success", result);
    }
}
