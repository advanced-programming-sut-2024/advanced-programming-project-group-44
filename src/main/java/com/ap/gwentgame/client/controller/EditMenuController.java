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
    private TextField nameField;
    @FXML
    private TextField nicknameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField currentPasswordField;
    @FXML
    private PasswordField newPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private ImageView back;


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
        if(ControllerUtilities.validateUsername(nicknameField)) return "invalid nickname";
        if(ControllerUtilities.validateEmail(emailField)) return "invalid email";

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

        if (currentPasswordField.equals(newPasswordField)) {
            ViewUtilities.showErrorAlert("Error", "New password cannot be the same as the current password");
            return "same password";
        }

        if(!ControllerUtilities.validatePassword(currentPasswordField, newPasswordField)) return "invalid password";

        Session.getLoggedInUser().setPassword(newPasswordField.getText());
        ViewUtilities.showInformationAlert("Success", "Password changed successfully");
        return "done";
    }

    public String backToProfileMenu(MouseEvent mouseEvent) {
        try {
            ProfileMenu profileMenu = new ProfileMenu();
            profileMenu.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "done";
    }
}