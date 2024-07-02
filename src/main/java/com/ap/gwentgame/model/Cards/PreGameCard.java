package com.ap.gwentgame.model.Cards;

import com.ap.gwentgame.controller.Utilities;
import javafx.scene.image.ImageView;

public class PreGameCard extends Item{
        private final Card card;
        private final int count;

        public PreGameCard(Card card, int count) {
            super(card.getName());
            this.card = card;
            this.count = count;
        }

        public Card getCard() {
            return card;
        }

        public int getCount() {
            return count;
        }

        public void InitializeGraphic(){
            ImageView imageView = new ImageView(card.getPreGameImage());
            imageView.setFitWidth(this.getWidth());
            imageView.setFitHeight(this.getHeight());
            this.getChildren().add(imageView);
        }
}
