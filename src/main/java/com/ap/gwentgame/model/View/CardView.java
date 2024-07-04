package com.ap.gwentgame.model.View;

import com.ap.gwentgame.controller.ControllerUtilities;
import com.ap.gwentgame.model.Cards.Card;
import com.ap.gwentgame.model.Cards.SpecialCard;
import com.ap.gwentgame.model.Cards.UnitCard;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class CardView extends AnchorPane {
    protected final Card card;

    public CardView(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public abstract void initializeGraphic();

    public Image getPreGameImage() {
        String path = ControllerUtilities.getResourcePath("images/cards/pregame/" + card.getFactionType().toString().toLowerCase() + "/" + card.getName().replaceAll("’", "").replaceAll("'", "") + ".jpg");
        return new Image(path);
    }

    public Image getGameImage() {
        String path = ControllerUtilities.getResourcePath("images/cards/game" + card.getFactionType().toString().toLowerCase().replaceAll("’", "").replaceAll("'", "") + "/" + card.getName() + ".jpg");
        return new Image(path);
    }

    protected void setImageView(Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(this.getWidth());
        imageView.setFitHeight(this.getHeight());
        this.getChildren().add(imageView);
    }

    public static CardView getCardView(Card card) {
        if (card instanceof SpecialCard) {
            return new SpecialCardView((SpecialCard) card);
        } else if (card instanceof UnitCard) {
            return new UnitCardView((UnitCard) card);
        }
        return null;
    }
}
