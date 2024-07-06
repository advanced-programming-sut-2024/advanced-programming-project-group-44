package com.ap.gwentgame.view;

import com.ap.gwentgame.model.gameElementViews.CardViewContainer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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

    public static boolean showConfirmationAlert(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
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

    public static ItemView ItemSelector(AnchorPane pane, ArrayList<? extends ItemView> itemViews){
        AtomicReference<ItemView> selectedItem = new AtomicReference<>(itemViews.get(0));
        AnchorPane itemSelector = new AnchorPane();
        itemSelector.setPrefWidth(pane.getWidth());
        itemSelector.setPrefHeight(pane.getHeight());
        itemSelector.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);");

        //set item views horizontally and make the selected item bigger than the others
        for (int i = 0; i < itemViews.size(); i++) {
            ItemView itemView = itemViews.get(i);
            itemView.setLayoutX(i * (pane.getWidth() / itemViews.size()));
            itemView.setLayoutY(0);
            itemSelector.getChildren().add(itemView);
        }

        itemSelector.setOnMouseMoved(event -> {
            for (ItemView itemView : itemViews) {
                if (itemView.getBoundsInParent().contains(event.getX(), event.getY())) {
                    selectedItem.set(itemView);
                    itemView.setScaleX(1.2);
                    itemView.setScaleY(1.2);
                } else {
                    itemView.setScaleX(1);
                    itemView.setScaleY(1);
                }
            }
        });

        itemSelector.setOnMouseClicked(event -> {
            pane.getChildren().remove(itemSelector);
        });

        pane.getChildren().add(itemSelector);

        return selectedItem.get();
    }
}
