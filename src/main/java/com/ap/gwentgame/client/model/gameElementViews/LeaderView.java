package com.ap.gwentgame.client.model.gameElementViews;

import com.ap.gwentgame.controller.ControllerUtilities;
import com.ap.gwentgame.client.model.gameElements.Card;
import com.ap.gwentgame.client.model.gameElements.Leader;
import com.ap.gwentgame.view.ViewUtilities;
import javafx.scene.image.Image;

public class LeaderView extends ItemView{
    public LeaderView(Leader leader) {
        super(leader);
        initializeGraphic();
    }

    @Override
    public void initializeGraphic() {
        super.initializeGraphic();
        this.setHeight(90);
        this.setWidth(60);
        ViewUtilities.setImageViewBackground(this, getImage());
    }

    @Override
    public Image getImage() {
        String path = ControllerUtilities.getResourcePath("images/cards/gameleaders/" + ((Leader)item).getFactionType().toString().toLowerCase().replaceAll("’", "").replaceAll("'", "") + "/" + item.getName() + ".jpg");
        return new Image(path);
    }

}
