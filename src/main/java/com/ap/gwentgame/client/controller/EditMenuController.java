package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.ClientCommands;
import com.ap.gwentgame.ServerMessage;
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

import static com.ap.gwentgame.ServerCommands.*;

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
        ServerMessage responseMessage = RequestSender.editProfile(nameField.getText(), nicknameField.getText(), emailField.getText());
        String responseText = responseMessage.getMessageText();

        if(EDIT_PROFILE_FAILED_NO_CHANGES.getMatcher(responseText).matches()){
            ViewUtilities.showErrorAlert("Error", "No changes were made");
            return;
        }

        if(!ControllerUtilities.validateUsername(nameField))return;
        if(!ControllerUtilities.validateNickname(nameField,nicknameField))return;
        if(!ControllerUtilities.validateEmail(emailField))return;

        if(EDIT_PROFILE_FAILED_USERNAME_TAKEN.getMatcher(responseText).matches()){
            ViewUtilities.showErrorAlert("Error", "Username is already taken");
            return;
        }

        if(EDIT_PROFILE_FAILED_NICKNAME_TAKEN.getMatcher(responseText).matches()){
            ViewUtilities.showErrorAlert("Error", "Nickname is already taken");
            return;
        }

        if(EDIT_PROFILE_FAILED_EMAIL_TAKEN.getMatcher(responseText).matches()){
            ViewUtilities.showErrorAlert("Error", "Email is already taken");
            return;
        }

        Session.getLoggedInUser().setName(nameField.getText());
        Session.getLoggedInUser().setNickName(nicknameField.getText());
        Session.getLoggedInUser().setEmail(emailField.getText());

        ViewUtilities.showInformationAlert("Success","Changes saved successfully");
    }

    public void savePassword(MouseEvent mouseEvent) {
        if (currentPasswordField.getText().isEmpty()) {
            ViewUtilities.showErrorAlert("Error", "Please fill all the fields");
        }

        ServerMessage responseMessage = RequestSender.editPassword(currentPasswordField.getText(), newPasswordField.getText());
        String responseText = responseMessage.getMessageText();

        if(EDIT_PASSWORD_FAILED_INCORRECT_PASSWORD.getMatcher(responseText).matches()){
            ViewUtilities.showErrorAlert("Error", "Current password is incorrect");
        }

        if(EDIT_PASSWORD_FAILED_NO_CHANGES.getMatcher(responseText).matches()) {
            ViewUtilities.showErrorAlert("Error", "New password cannot be the same as the current password");
        }

        if(!ControllerUtilities.validatePassword(currentPasswordField, newPasswordField))return;

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