package com.ap.gwentgame;

import com.ap.gwentgame.enums.assets.Backgrounds;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class LoginController {
    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private TextField email;
    @FXML
    private Label usernameLabel;

    private String randomUsername;

    @FXML
    private ImageView imageview;

    public void initialize() {
        imageview.setImage(Backgrounds.MAINBG.getImage());
    }

    public void login(MouseEvent mouseEvent) {
        if (App.getUserByName(name.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("No User");
            alert.setContentText("Username was not found!");
            alert.show();
            return;
        }

        if(!App.getUserByName(name.getText()).getPassword().equals(password.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Wrong Password");
            alert.setContentText("The Password is not correct");
            alert.show();
            return;
        }

        if(!App.getUserByName(name.getText()).getEmail().equals(email.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Wrong email");
            alert.setContentText("The email is not correct");
            alert.show();
            return;
        }
        //TODO
        //goto main menu
    }


//    public void reset(MouseEvent mouseEvent) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setContentText("reset username and password?");
//        alert.showAndWait();
//        if (alert.getResult().getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE) return;
//        name.setText("");
//        password.setText("");
//        email.setText("");
//
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

    public void goToQuestionMenu(MouseEvent mouseEvent) {
    }
}