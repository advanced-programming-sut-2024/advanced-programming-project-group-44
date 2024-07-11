package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.ServerMessage;
import com.ap.gwentgame.client.Client;
import com.ap.gwentgame.client.model.Session;
import com.ap.gwentgame.client.model.User;
import com.ap.gwentgame.client.view.MainMenu;
import com.ap.gwentgame.client.view.ViewUtilities;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.ap.gwentgame.ServerCommands.VERIFICATION_CODE_FAILED;

public class VerificationController {
    @FXML
    public TextField sentCode;

    public void initialize()  {
    }

    public void checkCode(MouseEvent mouseEvent) {
        ServerMessage responseMessage = RequestSender.verifyUser(sentCode.getText());
        String responseText = responseMessage.getMessageText();

        if (VERIFICATION_CODE_FAILED.getMatcher(responseText).matches()){
            ViewUtilities.showErrorAlert("Incorrect Code", "The code you entered is incorrect.");
            return;
        }
        ViewUtilities.showInformationAlert("Success", "You have successfully verified your account.");

        User user = Client.getGson().fromJson(responseMessage.getAdditionalText(), User.class);
        System.out.println(user.getName());
        Session.setLoggedInUser(user);
        sentCode.getScene().getWindow().hide();

        try {
            MainMenu mainMenu = new MainMenu();
            mainMenu.start(Session.getStage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void backToRegisterMenu(MouseEvent mouseEvent) {
        sentCode.getScene().getWindow().hide();
    }

}
