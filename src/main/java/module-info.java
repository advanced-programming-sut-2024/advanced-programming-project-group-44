module com.ap.gwentgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.media;
    requires java.mail;
    requires java.persistence;


    exports com.ap.gwentgame.client.controller.model;
    opens com.ap.gwentgame.client.controller.model to javafx.fxml;
    exports com.ap.gwentgame.client.controller;
    opens com.ap.gwentgame.client.controller to javafx.fxml;
    exports com.ap.gwentgame.client.controller.view;
    opens com.ap.gwentgame.client.controller.view to javafx.fxml;
}