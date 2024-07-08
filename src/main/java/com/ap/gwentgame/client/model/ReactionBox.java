package com.ap.gwentgame.client.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class ReactionBox extends AnchorPane {
    private TextField inputField;
    private Label resultLabel;

    private void createReactionMenu() {
        // Create the popup
        Popup popup = new Popup();

        // Create the dialog layout
        VBox dialogLayout = new VBox(10);
        dialogLayout.setPadding(new Insets(20));
        dialogLayout.setStyle("-fx-background-color: white; -fx-border-color: black;");

        // Create and add the prepared text options
        String[] preparedTexts = {"Great!", "Well done!", "Awesome!", "Thanks!"};
        ComboBox<String> textOptions = new ComboBox<>();
        textOptions.getItems().addAll(preparedTexts);
        textOptions.setValue(preparedTexts[0]);

        // Create and add the emoji options
        String[] emojis = {"😊", "👍", "🎉", "❤️"};
        ComboBox<String> emojiOptions = new ComboBox<>();
        emojiOptions.getItems().addAll(emojis);
        emojiOptions.setValue(emojis[0]);

        // Create and add the text field with a 12-character limit
        inputField = new TextField();
        inputField.setPromptText("Enter text (max 12 chars)");
        inputField.setTextFormatter(new TextFormatter<>(change ->
                change.getControlNewText().length() <= 12 ? change : null
        ));

        // Create and add the submit button
        Button submitButton = new Button("Submit");

        // Add action listener to the submit button
        submitButton.setOnAction(event -> {
            String selectedText = textOptions.getValue();
            String selectedEmoji = emojiOptions.getValue();
            String inputText = inputField.getText();
            String result = selectedText + " " + selectedEmoji + " " + inputText;
            resultLabel.setText(result);
            popup.hide();
        });

        // Add all components to the dialog layout
        dialogLayout.getChildren().addAll(textOptions, emojiOptions, inputField, submitButton);

        // Add the dialog layout to the popup
        popup.getContent().add(dialogLayout);

        // Show the popup in the center of the parent stage
        popup.show(getScene().getWindow());
    }

}
