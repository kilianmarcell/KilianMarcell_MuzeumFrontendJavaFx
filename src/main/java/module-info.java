module hu.petrik.muzeumfrontendjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens hu.petrik.muzeumfrontendjavafx to javafx.fxml, com.google.gson;
    exports hu.petrik.muzeumfrontendjavafx;
    exports hu.petrik.muzeumfrontendjavafx.controllers;
    opens hu.petrik.muzeumfrontendjavafx.controllers to javafx.fxml;
    exports hu.petrik.muzeumfrontendjavafx.apis;
    opens hu.petrik.muzeumfrontendjavafx.apis to com.google.gson, javafx.fxml;
}