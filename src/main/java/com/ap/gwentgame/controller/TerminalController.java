package com.ap.gwentgame.controller;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        terminalArea.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                processCommand();
                event.consume();
            }
        });
    }

    private void processCommand() {
        String fullText = terminalArea.getText().trim();
        String[] lines = fullText.split("\n");
        String command = lines[lines.length - 1].trim();

        switch (command.toLowerCase()) {
            case "clear":
                terminalArea.clear();
                break;
            case "help":
                terminalArea.appendText("\nAvailable commands: clear, help, ...");
                terminalArea.appendText("\n");
                break;
            default:
                terminalArea.appendText("\nUnknown command: " + command);
                terminalArea.appendText("\n");
        }
    }
}
