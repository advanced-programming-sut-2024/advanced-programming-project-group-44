package com.ap.gwentgame.controller;

import com.ap.gwentgame.enums.assets.Icons;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.view.ProfileMenu;
import com.ap.gwentgame.view.ViewUtilities;
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


    public void initialize() {
        nameField.setText(Session.getLoggedInUser().getName());
        nicknameField.setText(Session.getLoggedInUser().getNickName());
        emailField.setText(Session.getLoggedInUser().getEmail());
        back.setImage(Icons.BACK.getImage());
    }

    public void save(MouseEvent mouseEvent) {
        if(nameField.getText().equals(Session.getLoggedInUser().getName()) && nicknameField.getText().equals(Session.getLoggedInUser().getNickName()) && emailField.equals(Session.getLoggedInUser().getEmail())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No changes were made");
            alert.show();
        }

        ControllerUtilities.validateUsername(nameField);
        ControllerUtilities.validateUsername(nicknameField);
        ControllerUtilities.validateEmail(emailField);

        Session.getLoggedInUser().setName(nameField.getText());
        Session.getLoggedInUser().setNickName(nicknameField.getText());
        Session.getLoggedInUser().setEmail(emailField.getText());

        ViewUtilities.showInformationAlert("Success","Changes saved successfully");
    }

    public void savePassword(MouseEvent mouseEvent) {
        if (currentPasswordField.getText().isEmpty()) {
            ViewUtilities.showErrorAlert("Error", "Please fill all the fields");
        }

        if(!currentPasswordField.getText().equals(Session.getLoggedInUser().getPassword())){
            ViewUtilities.showErrorAlert("Error", "Current password is incorrect");
        }

        if (currentPasswordField.equals(newPasswordField)) {
            ViewUtilities.showErrorAlert("Error", "New password cannot be the same as the current password");
        }

        ControllerUtilities.validatePassword(currentPasswordField, newPasswordField);

        Session.getLoggedInUser().setPassword(newPasswordField.getText());
        ViewUtilities.showInformationAlert("Success", "Password changed successfully");
    }

    public void backToProfileMenu(MouseEvent mouseEvent) {
        try {
            ProfileMenu profileMenu = new ProfileMenu();
            profileMenu.start(Session.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}