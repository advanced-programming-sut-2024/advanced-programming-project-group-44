module com.ap.gwentgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.media;

    exports com.ap.gwentgame.controller;
    exports com.ap.gwentgame.view;
    exports com.ap.gwentgame.client.model;
    exports com.ap.gwentgame.client.model.gameElements;
    exports com.ap.gwentgame.client.model.gameElementViews;
    exports com.ap.gwentgame.client.model.Factions;
    exports com.ap.gwentgame.client.model.Abilities;
    exports com.ap.gwentgame.client.model.Leaders;
    exports com.ap.gwentgame.enums;
    exports com.ap.gwentgame.enums.assets;

    opens com.ap.gwentgame.controller to javafx.fxml;
    opens com.ap.gwentgame.view to javafx.fxml;
    opens com.ap.gwentgame.client.model to javafx.fxml;
    opens com.ap.gwentgame.client.model.gameElements to javafx.fxml;
    opens com.ap.gwentgame.client.model.gameElementViews to javafx.fxml;
    opens com.ap.gwentgame.client.model.Factions to javafx.fxml;
    opens com.ap.gwentgame.client.model.Abilities to javafx.fxml;
    opens com.ap.gwentgame.client.model.Leaders to javafx.fxml;
    opens com.ap.gwentgame.enums to javafx.fxml;
    opens com.ap.gwentgame.enums.assets to javafx.fxml;
}