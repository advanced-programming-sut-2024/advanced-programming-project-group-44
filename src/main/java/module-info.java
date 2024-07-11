module com.ap.gwentgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.media;
    requires com.google.gson;
    requires java.xml;
    requires java.persistence;

    exports com.ap.gwentgame.client.controller;
    exports com.ap.gwentgame.client.view;
    exports com.ap.gwentgame.client.model;
    exports com.ap.gwentgame.client.model.gameElements;
    exports com.ap.gwentgame.client.model.gameElementViews;
    exports com.ap.gwentgame.client.model.Factions;
    exports com.ap.gwentgame.client.model.Abilities;
    exports com.ap.gwentgame.client.model.Leaders;
    exports com.ap.gwentgame.client.enums;
    exports com.ap.gwentgame.client.enums.assets;
    exports com.ap.gwentgame;

    opens com.ap.gwentgame.client.controller to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.client.view to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.client.model to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.client.model.gameElements to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.client.model.gameElementViews to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.client.model.Factions to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.client.model.Abilities to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.client.model.Leaders to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.client.enums to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame.client.enums.assets to javafx.fxml, com.google.gson;
    opens com.ap.gwentgame to javafx.fxml, com.google.gson;
    exports com.ap.gwentgame.server;
    opens com.ap.gwentgame.server to com.google.gson, javafx.fxml;

}