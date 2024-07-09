package com.ap.gwentgame.client.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ForgotPasswordMenuController {
    @FXML
    private Label securityQuestionLabel;
    @FXML
    private TextField answerTextField;


    private String wantedAnswer;


    public void setSecurityQuestion(String question, String answer) {
        wantedAnswer = answer;
        securityQuestionLabel.setText(question);
    }

    public String getEnteredAnswer() {
        return answerTextField.getText().trim();
    }

    @FXML
    private void checkAnswerAndClose() {
        if(answerTextField.getText().equals(wantedAnswer))
        answerTextField.getScene().getWindow().hide();

        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("wrong answer");
            alert.setContentText("the answer for the question is not correct");
            alert.show();
        }
    }

    public void goBack(MouseEvent mouseEvent) {
        answerTextField.getScene().getWindow().hide();
    }
}
