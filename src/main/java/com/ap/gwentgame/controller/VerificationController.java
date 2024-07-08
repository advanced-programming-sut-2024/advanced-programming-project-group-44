package com.ap.gwentgame.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class VerificationController {
    public TextField sentCode;
    private int randomInt;
    private boolean isCodeCorrect;

    public void initialize() {
        isCodeCorrect = false;
    }

    public void setRandomInt(int randomInt) {
        this.randomInt = randomInt;
    }

    public void checkCode(MouseEvent mouseEvent) {
        if (Integer.parseInt(sentCode.getText()) == (randomInt)) {
            isCodeCorrect = true;
            sentCode.getScene().getWindow().hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("wrong code");
            alert.setContentText("enter the code sent to your email");
            alert.show();
        }
    }

    public boolean getIsCodeCorrect(){
        return this.isCodeCorrect;
    }

    public void back(MouseEvent mouseEvent) {
        sentCode.getScene().getWindow().hide();
    }
}
