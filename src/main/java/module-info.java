module com.ap.gwentgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.media;


    opens com.ap.gwentgame to javafx.fxml;
    exports com.ap.gwentgame;
}