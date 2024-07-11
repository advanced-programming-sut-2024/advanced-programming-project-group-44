package com.ap.gwentgame.client.view;

import com.ap.gwentgame.client.controller.MusicController;
import com.ap.gwentgame.client.enums.assets.Icons;
import com.ap.gwentgame.client.model.gameElementViews.BoardView;
import com.ap.gwentgame.client.model.gameElementViews.CardViewContainer;
import com.ap.gwentgame.client.model.gameElementViews.ItemView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
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

    public static void showWarningAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.show();
    }

    public static boolean showConfirmationAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

    public static void showInformationAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.show();
    }

    public static void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.show();
    }

    public static void changeNumber(Label numberLabel, int targetNumber) {
        final int totalDuration = 1000;
        final int incrementCount = targetNumber - Integer.parseInt(numberLabel.getText());
        double incrementDuration = (double) totalDuration / incrementCount;

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(incrementDuration), event -> {
            numberLabel.setText(String.valueOf(Integer.parseInt(numberLabel.getText()) + 1));
        }));
        timeline.setCycleCount(incrementCount);
        timeline.play();
    }

    public static void changeCardContainer(BoardView boardView, CardViewContainer from, CardViewContainer to, ItemView cardView) {
        double startX = from.getLayoutX() + cardView.getLayoutX();
        double startY = from.getLayoutY() + cardView.getLayoutY();
        double endX = to.getLayoutX() + to.getCardViews().size() * (cardView.getWidth() + to.getHgap());
        double endY = to.getLayoutY();

        boardView.getGamePane().getChildren().add(cardView);
        cardView.setLayoutX(0);
        cardView.setLayoutY(0);

        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), cardView);
        transition.setInterpolator(javafx.animation.Interpolator.EASE_BOTH);
        transition.setFromX(startX);
        transition.setFromY(startY);
        transition.setToX(endX);
        transition.setToY(endY);

        //create a transition to remove the card from the previous container
        /*ArrayList replacingItemViews = from.getCardViews();
        for (ItemView replacingItemView : replacingItemViews) {
            if (from.getCardViews().indexOf(replacingItemView) > from.getCardViews().indexOf(cardView)) {
                replacingItemViews.add(replacingItemView);
            }
        }

        for (ItemView replacingItemView : from.getCardViews()) {
            if (from.getCardViews().indexOf(replacingItemView) > from.getCardViews().indexOf(cardView)) {
                TranslateTransition transition2 = new TranslateTransition(Duration.seconds(1), replacingItemView);
                transition2.setInterpolator(javafx.animation.Interpolator.EASE_BOTH);
                transition2.setFromX(from.getLayoutX() + replacingItemView.getLayoutX());
                transition2.setFromY(from.getLayoutY() + replacingItemView.getLayoutY());
                transition2.setToX(from.getLayoutX() + replacingItemView.getLayoutX() - (cardView.getWidth() + from.getHgap()));
                transition2.setToY(from.getLayoutY() + replacingItemView.getLayoutY());
                transition2.play();
            }
        }*/

        transition.setOnFinished(event -> {
            from.remove(cardView);
            to.add(cardView);
            boardView.getGamePane().getChildren().remove(cardView);
            boardView.updateScoreLabels();
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

        double cardBoxWidth = 100;

        HBox cardBox = new HBox();
        cardBox.setSpacing(60);
        cardBox.setLayoutX(pane.getWidth() / 2 - cardBoxWidth / 2);
        cardBox.setAlignment(javafx.geometry.Pos.CENTER);

        for (ItemView itemView : itemViews) {
            cardBox.getChildren().add(itemView);
            itemView.setSize(cardBoxWidth, itemView.getPrefHeight() * cardBoxWidth / itemView.getPrefWidth());
        }

        updateSizes(itemViews, selectedItemReference.get());
        cardBox.setLayoutY(pane.getHeight() / 2 - selectedItemReference.get().getPrefHeight() / 2);
        updatePositions(pane.getWidth() / 2 - (selectedItemReference.get().getLayoutX() + cardBox.getLayoutX() + cardBoxWidth / 2), cardBox);


        pane.setOnKeyPressed(event -> {
            int selectedIndex = itemViews.indexOf(selectedItemReference.get());
            if (event.getCode() == KeyCode.RIGHT && selectedIndex < itemViews.size() - 1) {
                selectedIndex++;
                selectedItemReference.set(itemViews.get(selectedIndex));
                updateSizes(itemViews, selectedItemReference.get());
                updatePositions(pane.getWidth() / 2 - (selectedItemReference.get().getLayoutX() + cardBox.getLayoutX() + cardBoxWidth / 2), cardBox);
            } else if (event.getCode() == KeyCode.LEFT && selectedIndex > 0) {
                selectedIndex--;
                selectedItemReference.set(itemViews.get(selectedIndex));
                updateSizes(itemViews, selectedItemReference.get());
                updatePositions(pane.getWidth() / 2 - (selectedItemReference.get().getLayoutX() + cardBox.getLayoutX() + cardBoxWidth / 2), cardBox);
            }
        });

        pane.requestFocus();

        Button leftButton = new Button("<");
        leftButton.setLayoutX(20);
        leftButton.setLayoutY(pane.getHeight() / 2 - 20);
        leftButton.setOnMouseClicked(event -> {
            int selectedIndex = itemViews.indexOf(selectedItemReference.get());
            if (selectedIndex > 0) {
                selectedIndex--;
                selectedItemReference.set(itemViews.get(selectedIndex));
                updateSizes(itemViews, selectedItemReference.get());
                updatePositions(pane.getWidth() / 2 - (selectedItemReference.get().getLayoutX() + cardBox.getLayoutX() + cardBoxWidth / 2), cardBox);
            }
        });

        Button rightButton = new Button(">");
        rightButton.setLayoutX(pane.getWidth() - 50);
        rightButton.setLayoutY(pane.getHeight() / 2 - 20);
        rightButton.setOnMouseClicked(event -> {
            int selectedIndex = itemViews.indexOf(selectedItemReference.get());
            System.out.println(selectedIndex);
            if (selectedIndex < itemViews.size() - 1) {
                selectedIndex++;
                selectedItemReference.set(itemViews.get(selectedIndex));
                updateSizes(itemViews, selectedItemReference.get());
                updatePositions(pane.getWidth() / 2 - (selectedItemReference.get().getLayoutX() + cardBox.getLayoutX() + cardBoxWidth / 2), cardBox);
            }
        });


        for (ItemView itemView : itemViews) {
            itemView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                selectedItemReference.set(itemView);
                updateSizes(itemViews, selectedItemReference.get());
                updatePositions(pane.getWidth() / 2 - (selectedItemReference.get().getLayoutX() + cardBox.getLayoutX() + cardBoxWidth / 2), cardBox);
            });
        }

        itemSelector.getChildren().addAll(cardBox, leftButton, rightButton);
        pane.getChildren().add(itemSelector);

        submitButton.setLayoutX(pane.getWidth() / 2 - submitButton.getPrefWidth() / 2);
        submitButton.setLayoutY(cardBox.getLayoutY() + selectedItemReference.get().getPrefHeight() + 200);
        submitButton.setText("Submit");
        submitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            pane.getChildren().remove(itemSelector);
        });

        itemSelector.getChildren().add(submitButton);
    }


    private static void updateSizes(ArrayList<? extends ItemView> itemViews, ItemView selectedItemView) {
        for (ItemView itemView : itemViews) {
            if (itemView.equals(selectedItemView)) {
                itemView.setScaleX(2);
                itemView.setScaleY(2);
                itemView.setStyle("-fx-font-weight: bold;");
            } else {
                itemView.setScaleX(1);
                itemView.setScaleY(1);
                itemView.setStyle("-fx-font-weight: normal;");
            }
        }
    }

    private static void updatePositions(double movement, HBox cardBox) {
        cardBox.setLayoutX(cardBox.getLayoutX() + movement);
    }
}
