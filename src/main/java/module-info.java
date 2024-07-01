module com.ap.gwentgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.media;


    opens com.ap.gwentgame to javafx.fxml;
    exports com.ap.gwentgame;
    exports com.ap.gwentgame.model;
    opens com.ap.gwentgame.model to javafx.fxml;
    exports com.ap.gwentgame.controller;
    opens com.ap.gwentgame.controller to javafx.fxml;
    exports com.ap.gwentgame.view;
    opens com.ap.gwentgame.view to javafx.fxml;
}