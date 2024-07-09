module com.ap.gwentgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.media;
    requires com.google.gson;

    exports com.ap.gwentgame.controller;
    exports com.ap.gwentgame.view;
    exports com.ap.gwentgame.model;
    exports com.ap.gwentgame.model.gameElements;
    exports com.ap.gwentgame.model.gameElementViews;
    exports com.ap.gwentgame.model.Factions;
    exports com.ap.gwentgame.model.Abilities;
    exports com.ap.gwentgame.model.Leaders;
    exports com.ap.gwentgame.enums;
    exports com.ap.gwentgame.enums.assets;

    opens com.ap.gwentgame.controller to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.view to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.model to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.model.gameElements to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.model.gameElementViews to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.model.Factions to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.model.Abilities to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.model.Leaders to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.enums to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.enums.assets to javafx.fxml, com.google.gson;

}