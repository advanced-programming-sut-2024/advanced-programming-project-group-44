package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.client.enums.assets.Icons;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.view.ProfileMenu;
import com.ap.gwentgame.client.view.ViewUtilities;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class EditMenuController {
    @FXML
    public TextField nameField;
    @FXML
    public TextField nicknameField;
    @FXML
    public TextField emailField;
    @FXML
    public PasswordField currentPasswordField;
    @FXML
    public PasswordField newPasswordField;
    @FXML
    public PasswordField confirmPasswordField;
    @FXML
    public ImageView back;



    public String initialize() {
        nameField.setText(Session.getLoggedInUser().getName());
        nicknameField.setText(Session.getLoggedInUser().getNickName());
        emailField.setText(Session.getLoggedInUser().getEmail());
        back.setImage(Icons.BACK.getImage());
        return "done";
    }

    public String save(MouseEvent mouseEvent) {
        if(nameField.getText().equals(Session.getLoggedInUser().getName()) && nicknameField.getText().equals(Session.getLoggedInUser().getNickName()) && emailField.equals(Session.getLoggedInUser().getEmail())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No changes were made");
            alert.show();
        }

        if(!ControllerUtilities.validateUsername(nameField)) return "invalid username";
        if(!ControllerUtilities.validateNickname(nameField , nicknameField)) return "invalid nickname";
        if(!ControllerUtilities.validateEmail(emailField)) return "invalid email";

        Session.getLoggedInUser().setName(nameField.getText());
        Session.getLoggedInUser().setNickName(nicknameField.getText());
        Session.getLoggedInUser().setEmail(emailField.getText());

        ViewUtilities.showInformationAlert("Success","Changes saved successfully");
        return "done";
    }

    public String savePassword(MouseEvent mouseEvent) {
        if (currentPasswordField.getText().isEmpty()) {
            ViewUtilities.showErrorAlert("Error", "Please fill all the fields");
            return "invalid password";
        }

        if(!currentPasswordField.getText().equals(Session.getLoggedInUser().getPassword())){
            ViewUtilities.showErrorAlert("Error", "Current password is incorrect");
            return "invalid password";
        }
        if (currentPasswordField.getText().equals(newPasswordField.getText())) {
            ViewUtilities.showErrorAlert("Error", "New password cannot be the same as the current password");
            return "same password";
        }

        Session.getLoggedInUser().setPassword(newPasswordField.getText());
        ViewUtilities.showInformationAlert("Success", "Password changed successfully");
        return "done";
    }

    public String backToProfileMenu(MouseEvent mouseEvent) {
        return "done";
    }
}