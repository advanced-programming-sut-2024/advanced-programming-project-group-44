package com.ap.gwentgame.client.model.gameElementViews;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.model.gameElements.Leader;
import com.ap.gwentgame.client.view.ViewUtilities;
import javafx.scene.image.Image;

public class LeaderView extends ItemView {
    public LeaderView(Leader leader) {
        super(leader);
        initializeGraphic();
    }

    @Override
    public void initializeGraphic() {
        super.initializeGraphic();
        toPreGameMode();
    }

    @Override
    public Image getImage() {
        String path = ControllerUtilities.getResourcePath("images/cards1/gameleaders/" + ((Leader) item).getFactionType().toString().toLowerCase().replaceAll("’", "").replaceAll("'", "") + "/" + item.getName() + ".jpg");
        return new Image(path);
    }

    public Image getPreGameImage() {
        System.out.println();
        String path = ControllerUtilities.getResourcePath("images/cards1/pregameleaders/" + ((Leader) item).getFactionType().toString().toLowerCase().replaceAll("’", "").replaceAll("'", "") + "/" + item.getName() + ".jpg");
        return new Image(path);
    }

    public void toPreGameMode() {
        if (!this.getChildren().isEmpty())
            this.getChildren().remove(0);
        ViewUtilities.setImageViewBackground(this, getPreGameImage());
        setSize(82, 160);
    }

    public void toGameMode() {
        if (!this.getChildren().isEmpty())
            this.getChildren().remove(0);
        ViewUtilities.setImageViewBackground(this, getImage());
        setSize(41, 60);
    }


}
