package com.ap.gwentgame.client.controller;

import com.ap.gwentgame.ServerMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static com.ap.gwentgame.ServerCommands.VALIDATE_ANSWER_FAILED_INCORRECT_ANSWER;
import static com.ap.gwentgame.ServerCommands.VALIDATE_ANSWER_SUCCESSFUL;
import static com.ap.gwentgame.client.view.ViewUtilities.showWarningAlert;

public class ForgotPasswordMenuController {
    @FXML
    private Label securityQuestionLabel;
    @FXML
    private TextField answerTextField;
    @FXML
    private Button sendAnswerButton;

    private ServerMessage validateAnswerResponse;

    public void setSecurityQuestion(String question) {
        securityQuestionLabel.setText(question);
    }

    public Button getSendAnswerButton() {
        return sendAnswerButton;
    }

    public ServerMessage getValidateAnswerResponse() {
        return validateAnswerResponse;
    }


    @FXML
    public void checkAnswerAndClose(String username) {
        validateAnswerResponse = RequestSender.validateAnswer(username, answerTextField.getText().trim());

        if (VALIDATE_ANSWER_FAILED_INCORRECT_ANSWER.getMatcher(validateAnswerResponse.getMessageText()).matches()) {
            showWarningAlert("Incorrect Answer", "The answer you entered is incorrect.");
        }

        if (VALIDATE_ANSWER_SUCCESSFUL.getMatcher(validateAnswerResponse.getMessageText()).matches()) {
            answerTextField.getScene().getWindow().hide();
        }
    }

    public void goBack(MouseEvent mouseEvent) {
        answerTextField.getScene().getWindow().hide();
    }
}
