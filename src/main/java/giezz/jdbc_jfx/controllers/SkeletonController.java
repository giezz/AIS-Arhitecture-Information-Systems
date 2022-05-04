package giezz.jdbc_jfx.controllers;

import giezz.jdbc_jfx.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.Objects;

public class SkeletonController {

    @FXML
    private Button btnPageHome;

    @FXML
    private Button btnPage1;

    @FXML
    private Button btnPage2;

    @FXML
    private Button btnPage3;


    @FXML
    private StackPane stackPane;

    @FXML
    void initialize() {
        try {
            Parent fxml = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("home-page.fxml")));
            stackPane.getChildren().removeAll();
            stackPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void handleNavButton(ActionEvent event) throws IOException {
        if (event.getSource() == btnPageHome) {
            Parent fxml = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("home-page.fxml")));
            stackPane.getChildren().removeAll();
            stackPane.getChildren().setAll(fxml);
        }
        else if (event.getSource() == btnPage1) {
            Parent fxml = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("page-1.fxml")));
            stackPane.getChildren().removeAll();
            stackPane.getChildren().setAll(fxml);
        }
        else if (event.getSource() == btnPage2) {
            Parent fxml = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("page-2.fxml")));
            stackPane.getChildren().removeAll();
            stackPane.getChildren().setAll(fxml);
        }
        else if (event.getSource() == btnPage3) {
            System.out.println(((Button) event.getSource()).getId());
        }
    }
}