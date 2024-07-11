package com.ap.gwentgame.client.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class TerminalController implements Initializable {

    @FXML
    private TextArea terminalArea;

    private int lastCommandPosition = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        terminalArea.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                processCommand();
                event.consume();
            } else if (event.getCode() == KeyCode.BACK_SPACE) {
                if (terminalArea.getCaretPosition() <= lastCommandPosition) {
                    event.consume();
                }
            } else if (event.isControlDown() && event.getCode() == KeyCode.A) {
                //baraye cntrl A
                return;
            } else {
                if (terminalArea.getCaretPosition() < lastCommandPosition) {
                    terminalArea.positionCaret(terminalArea.getText().length());
                }
            }
        });
        lastCommandPosition = terminalArea.getText().length();
    }

    private void processCommand() {
        String fullText = terminalArea.getText().trim();
        String[] lines = fullText.split("\n");
        String command = lines[lines.length - 1].trim();

        switch (command.toLowerCase()) {
            case "clear":
                terminalArea.clear();
                terminalArea.appendText("Welcome to the terminal. Type 'help' for available commands.\n");
                break;
            case "help":
                terminalArea.appendText("\nAvailable commands: clear, help, tnx");
                terminalArea.appendText("\n");
                break;
            case "ki khare?":
                terminalArea.appendText("\nsobhan");
                terminalArea.appendText("\n");
                break;
            case "ki khar tare?":
                terminalArea.appendText("\nparmisss");
                terminalArea.appendText("\n");
                break;
            case "tnx":
                terminalArea.appendText("\nchakerim");
                terminalArea.appendText("\n");
                break;
            default:
                terminalArea.appendText("\nUnknown command: " + command);
                terminalArea.appendText("\n");
        }
        lastCommandPosition = terminalArea.getText().length();
        terminalArea.positionCaret(lastCommandPosition);
    }
}
