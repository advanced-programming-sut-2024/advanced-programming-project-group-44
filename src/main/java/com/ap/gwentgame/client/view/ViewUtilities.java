package com.ap.gwentgame.client.view;

import com.ap.gwentgame.client.view.viewController.MusicController;
import com.ap.gwentgame.client.enums.assets.Icons;
import com.ap.gwentgame.client.model.gameElementViews.CardViewContainer;
import com.ap.gwentgame.client.model.gameElementViews.ItemView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class ViewUtilities {
    public static void setImageViewBackground(Pane pane, Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(pane.getWidth());
        imageView.setFitHeight(pane.getHeight());
        pane.getChildren().add(imageView);
    }

    public static String showWarningAlert(String title, String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(title);
            alert.setHeaderText(title);
            alert.setContentText(message);
            alert.show();
        });
        return "warning";
    }

    public static boolean showConfirmationAlert(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

    public static void showInformationAlert(String title, String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(title);
            alert.setHeaderText(title);
            alert.setContentText(message);
            alert.show();
        });
    }

    public static void showErrorAlert(String title, String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText(title);
            alert.setContentText(message);
            alert.show();
        });
    }

    public static void changeNumber(Label numberLabel, int targetNumber) {
        final int totalDuration = 2000;
        final int incrementCount = targetNumber - Integer.parseInt(numberLabel.getText());
        double incrementDuration = (double) totalDuration / incrementCount;

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(incrementDuration), event -> {
            numberLabel.setText(String.valueOf(Integer.parseInt(numberLabel.getText()) + 1));
        }));
        timeline.setCycleCount(incrementCount);
        timeline.play();
    }

    public static void changeCardContainer(AnchorPane root, CardViewContainer from, CardViewContainer to, AnchorPane cardView) {
        double startX = from.getLayoutX() + cardView.getLayoutX();
        double startY = from.getLayoutY() + cardView.getLayoutY();
        double endX = to.getLayoutX() + (to.getChildren().size() * (cardView.getWidth() + to.getHgap()));
        double endY = to.getLayoutY();

        root.getChildren().add(cardView);

        TranslateTransition transition = new TranslateTransition(Duration.seconds(2), cardView);
        transition.setFromX(startX);
        transition.setFromY(startY);
        transition.setToX(endX);
        transition.setToY(endY);

        transition.setOnFinished(event -> {
            to.getChildren().add(cardView);
            cardView.setTranslateX(0);
            cardView.setTranslateY(0);
            root.getChildren().remove(cardView);
        });

        transition.play();
    }

    public static void toggleMute(Button muteButton, ImageView muteButtonIcon) {
        if (MusicController.getInstance().getMediaPlayer().isMute()) {
            MusicController.getInstance().getMediaPlayer().setMute(false);
            muteButtonIcon.setImage(Icons.UNMUTE.getImage());
        } else {
            MusicController.getInstance().getMediaPlayer().setMute(true);
            muteButtonIcon.setImage(Icons.MUTE.getImage());
        }
    }

    public static void ItemSelector(AnchorPane pane, ArrayList<? extends ItemView> itemViews, AtomicReference<ItemView> selectedItemReference, Button submitButton) {
        AnchorPane itemSelector = new AnchorPane();
        itemSelector.setPrefWidth(pane.getWidth());
        itemSelector.setPrefHeight(pane.getHeight());
        itemSelector.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);");

        HBox cardBox = new HBox();
        cardBox.setSpacing(-60);
        cardBox.setAlignment(javafx.geometry.Pos.CENTER);

        double cardWidth = 150;
        double cardHeight = 200;
        double enlargedCardWidth = 200;
        double enlargedCardHeight = 270;

        for (ItemView itemView : itemViews) {
            itemView.setPrefWidth(cardWidth);
            itemView.setPrefHeight(cardHeight);
            cardBox.getChildren().add(itemView);
        }

        updateSelectedItemView(itemViews, selectedItemReference.get());

        Button leftButton = new Button("<");
        leftButton.setLayoutX(20);
        leftButton.setLayoutY(pane.getHeight() / 2 - 20);
        leftButton.setOnAction(event -> {
            int selectedIndex = itemViews.indexOf(selectedItemReference.get());
            if (selectedIndex > 0) {
                selectedIndex--;
                selectedItemReference.set(itemViews.get(selectedIndex));
                updateSelectedItemView(itemViews, selectedItemReference.get());
            }
        });

        Button rightButton = new Button(">");
        rightButton.setLayoutX(pane.getWidth() - 50);
        rightButton.setLayoutY(pane.getHeight() / 2 - 20);
        rightButton.setOnAction(event -> {
            int selectedIndex = itemViews.indexOf(selectedItemReference.get());
            System.out.println(selectedIndex);
            if (selectedIndex < itemViews.size() - 1) {
                selectedIndex++;
                selectedItemReference.set(itemViews.get(selectedIndex));
                updateSelectedItemView(itemViews, selectedItemReference.get());
            }
        });

        cardBox.setLayoutX((pane.getWidth() - (enlargedCardWidth + (cardWidth + cardBox.getSpacing()) * (itemViews.size() - 1))) / 2);
        cardBox.setLayoutY((pane.getHeight() - cardHeight) / 2);

        itemSelector.getChildren().addAll(leftButton, rightButton, cardBox);
        pane.getChildren().add(itemSelector);

        submitButton.setLayoutX(250);
        submitButton.setLayoutY(500);
        submitButton.setText("Submit");

        submitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            pane.getChildren().remove(itemSelector);
        });

        itemSelector.getChildren().add(submitButton);
    }


    private static void updateSelectedItemView(ArrayList<? extends ItemView> itemViews, ItemView selectedItemView) {
        for (ItemView itemView : itemViews) {
            if (itemView.equals(selectedItemView)) {
                itemView.setScaleX(1.3);
                itemView.setScaleY(1.3);
                itemView.setLayoutY(-30); // Move the enlarged card up
                itemView.setStyle("-fx-font-weight: bold;");
            } else {
                itemView.setScaleX(1);
                itemView.setScaleY(1);
                itemView.setLayoutY(0); // Reset the position of other cards
                itemView.setStyle("-fx-font-weight: normal;");
            }
        }
    }
}
