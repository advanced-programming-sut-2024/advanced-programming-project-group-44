package com.ap.gwentgame.controller;

import com.ap.gwentgame.view.ProfileMenu;
import com.ap.gwentgame.enums.assets.Icons;
import com.ap.gwentgame.model.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class EditMenuController {
    @FXML
    public TextField name;
    @FXML
    public TextField nickname;
    @FXML
    public TextField email;
    @FXML
    public PasswordField currentPassword;
    @FXML
    public PasswordField newPassword;
    @FXML
    public PasswordField confirmPassword;
    @FXML
    public ImageView back;


    public void initialize() {
        name.setText(App.getLoggedinUser().getName());
        nickname.setText(App.getLoggedinUser().getNickName());
        email.setText(App.getLoggedinUser().getEmail());
        back.setImage(Icons.BACK.getImage());
    }

    public void save(MouseEvent mouseEvent) {

        if(name.equals(App.getLoggedinUser().getName()) && nickname.equals(App.getLoggedinUser().getNickName()) && email.equals(App.getLoggedinUser().getEmail())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No changes were made");
            alert.show();
        }

        Utilities.validatingUsername(name);
        Utilities.validatingUsername(nickname);
        Utilities.validatingEmail(email);

        App.getLoggedinUser().setName(name.getText());
        App.getLoggedinUser().setNickName(nickname.getText());
        App.getLoggedinUser().setEmail(email.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Changes saved successfully");
        alert.show();
    }

    public void savePassword(MouseEvent mouseEvent) {

        if (currentPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill all the fields");
            alert.show();
        }
        if(!currentPassword.equals(App.getLoggedinUser().getPassword())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Current password is incorrect");
            alert.show();
        }
        if (currentPassword == newPassword) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("New password cannot be the same as the current password");
            alert.show();
        }
        if(!newPassword.equals(confirmPassword)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Passwords do not match");
            alert.show();
        }
        Utilities.validatingPassword(currentPassword, newPassword);

        App.getLoggedinUser().setPassword(newPassword.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Password changed successfully");
        alert.show();
    }

    public void back(MouseEvent mouseEvent) {
        try {
            ProfileMenu profileMenu = new ProfileMenu();
            profileMenu.start(App.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}