package com.ap.gwentgame.client.model.gameElementViews;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.model.gameElements.PreGameCard;
import com.ap.gwentgame.client.view.ViewUtilities;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class PreGameCardView extends ItemView implements Cloneable {
    private final transient Label countLabel;

    public PreGameCardView(PreGameCard preGameCard) {
        super(preGameCard);
        this.countLabel = new Label(String.valueOf(((PreGameCard)item).getCount()));
        initializeGraphic();
    }

    public void setCount(int count) {
        ((PreGameCard)item).setCount(count);
        this.countLabel.setText(String.valueOf(count));
    }

    @Override
    public Image getImage() {
        String path = ControllerUtilities.getResourcePath("images/cards/pregame/" + (((PreGameCard)item).getCard().getFactionType().toString().toLowerCase() + "/" + item.getName() + ".jpg").replaceAll("’", "").replaceAll("'", ""));
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

    @Override
    public PreGameCardView clone() {
        return new PreGameCardView((PreGameCard) item);
    }

    public int getCount() {
        return ((PreGameCard)item).getCount();
    }
}
