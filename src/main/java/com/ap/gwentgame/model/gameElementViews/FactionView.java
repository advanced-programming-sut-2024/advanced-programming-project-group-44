package com.ap.gwentgame.model.gameElementViews;

import com.ap.gwentgame.controller.ControllerUtilities;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Faction;
import com.ap.gwentgame.model.gameElements.Leader;
import javafx.scene.image.Image;

public class FactionView extends ItemView{
    public FactionView(Faction faction) {
        super(faction);
    }

    @Override
    public void initializeGraphic() {
        super.initializeGraphic();
        this.setHeight(56);
        this.setWidth(56);
    }

    @Override
    public Image getImage() {
        String path = ControllerUtilities.getResourcePath("images/cards/factions/" + item.getName() + ".jpg");
        return new Image(path);
    }

}
