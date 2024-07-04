package com.ap.gwentgame.model.gameElementViews;

import com.ap.gwentgame.controller.ControllerUtilities;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Leader;
import javafx.scene.image.Image;

public class LeaderView extends ItemView{
    public LeaderView(Leader leader) {
        super(leader);
    }

    @Override
    public void initializeGraphic() {
        super.initializeGraphic();
        this.setHeight(80);
        this.setWidth(56);
    }

    @Override
    public Image getImage() {
        String path = ControllerUtilities.getResourcePath("images/cards/leaders/" + ((Leader)item).getFactionType().toString().toLowerCase().replaceAll("’", "").replaceAll("'", "") + "/" + item.getName() + ".jpg");
        return new Image(path);
    }

}
