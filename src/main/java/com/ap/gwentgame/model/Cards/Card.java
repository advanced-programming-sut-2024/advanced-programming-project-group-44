package com.ap.gwentgame.model.Cards;

import com.ap.gwentgame.controller.Utilities;
import com.ap.gwentgame.enums.FactionType;
import com.ap.gwentgame.model.Abilities.Ability;
import com.ap.gwentgame.enums.Placement;
import com.ap.gwentgame.model.Game.Board;
import javafx.scene.image.Image;

public abstract class Card extends Item {
    private Ability ability;
    private final Placement placement;
    private final FactionType factionType;

    public Card(String name, Placement placement, FactionType factionType) {
        super(name);
        this.placement = placement;
        this.factionType = factionType;
    }

    public void executeAction(Board board) {
        ability.run(board);
    }

    public void stopAction(Board board) {
        //ability.stop(board);
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public Placement getPlacement() {
        return placement;
    }

    public FactionType getFactionType() {
        return factionType;
    }

    public Image getPreGameImage() {
        String path = Utilities.getResourcePath("images/cards/pregame/" + factionType.toString().toLowerCase() + "/" + getName().replaceAll("’", "").replaceAll("'", "") + ".jpg");
        return new Image(path);
    }

    public Image getGameImage() {
        String path = Utilities.getResourcePath("images/cards/game" + factionType.toString().toLowerCase().replaceAll("’", "").replaceAll("'", "") + "/" + getName() + ".jpg");
        return new Image(path);
    }
}
