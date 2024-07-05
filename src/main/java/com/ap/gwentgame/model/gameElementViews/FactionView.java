package com.ap.gwentgame.model.gameElementViews;

import com.ap.gwentgame.controller.ControllerUtilities;
import com.ap.gwentgame.model.gameElements.Card;
import com.ap.gwentgame.model.gameElements.Faction;
import com.ap.gwentgame.model.gameElements.Leader;
import com.ap.gwentgame.view.ViewUtilities;
import javafx.scene.image.Image;

public class FactionView extends ItemView{
    public FactionView(Faction faction) {
        super(faction);
        initializeGraphic();
    }

    @Override
    public void initializeGraphic() {
        super.initializeGraphic();
        this.setHeight(56);
        this.setWidth(56);
        ViewUtilities.setImageViewBackground(this, getImage());
    }

    @Override
    public Image getImage() {
        String path = ControllerUtilities.getResourcePath("images/factions/" + item.getName().toLowerCase() + ".png");
        return new Image(path);
    }

}
