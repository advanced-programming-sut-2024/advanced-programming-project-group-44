package com.ap.gwentgame.client.model.gameElementViews;

import javafx.scene.layout.FlowPane;

class CustomFlowPane extends FlowPane {
    public CustomFlowPane() {
        super();
    }
    
    @Override
    protected void layoutChildren() {
        double x = getInsets().getLeft();
        double y = getInsets().getTop();
        double maxHeight = 0;

        for (javafx.scene.Node child : getChildren()) {
            double width = child.prefWidth(-1);
            double height = child.prefHeight(-1);

            if (x + width > getWidth() - getInsets().getRight()) {
                x = getInsets().getLeft();
                y += maxHeight + this.getVgap();
                maxHeight = 0;
            }

            child.relocate(x, y);

            x += width + this.getHgap();
            maxHeight = Math.max(maxHeight, height);
        }
    }
}