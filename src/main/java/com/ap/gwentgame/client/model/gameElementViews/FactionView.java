package com.ap.gwentgame.client.model.gameElementViews;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.model.gameElements.Faction;
import com.ap.gwentgame.client.view.ViewUtilities;
import javafx.scene.image.Image;

public class FactionView extends ItemView{
    public FactionView(Faction faction) {
        super(faction);
        initializeGraphic();
    }

    @Override
    public void initializeGraphic() {
        super.initializeGraphic();
        this.setHeight(60);
        this.setWidth(56);
        ViewUtilities.setImageViewBackground(this, getImage());
    }

    @Override
    public Image getImage() {
        String path = ControllerUtilities.getResourcePath("images/factions/" + item.getName().toLowerCase() + ".png");
        return new Image(path);
    }

}
