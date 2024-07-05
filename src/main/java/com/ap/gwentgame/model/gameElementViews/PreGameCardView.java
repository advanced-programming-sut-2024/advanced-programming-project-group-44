package com.ap.gwentgame.model.gameElementViews;

import com.ap.gwentgame.controller.ControllerUtilities;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Item;
import com.ap.gwentgame.view.ViewUtilities;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class PreGameCardView extends ItemView {
    private final transient Label countLabel;
    private int count;

    public PreGameCardView(Card card, int count) {
        super(card);
        this.count = count;
        this.countLabel = new Label(String.valueOf(count));
        initializeGraphic();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        this.countLabel.setText(String.valueOf(count));
    }

    @Override
    public Image getImage() {
        String path = ControllerUtilities.getResourcePath("images/cards/pregame/" + (((Card)item).getFactionType().toString().toLowerCase() + "/" + item.getName() + ".jpg").replaceAll("’", "").replaceAll("'", ""));
        return new Image(path);
    }

    @Override
    public void initializeGraphic() {
        super.initializeGraphic();
        this.setHeight(278);
        this.setWidth(147);
        ViewUtilities.setImageViewBackground(this, getImage());

        countLabel.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #000000; -fx-font-size: 20px; -fx-font-weight: bold; -fx-padding: 5px;");
        this.getChildren().add(countLabel);
        countLabel.setLayoutX(120);
        countLabel.setLayoutY(10);
    }
}
