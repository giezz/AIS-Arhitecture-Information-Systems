package giezz.jdbc_jfx.controllers;

import giezz.jdbc_jfx.App;
import giezz.jdbc_jfx.excel.ExcelDemo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.Objects;

public class SkeletonController {

    @FXML
    private Button btnPage1;

    @FXML
    private Button btnPage2;

    @FXML
    private Button btnPage3;

    @FXML
    private Button btnPageHome;

    @FXML
    private MenuItem menuEmployee;

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
        Button source = ((Button) event.getSource());
        if (btnPageHome.equals(source)) {
            Parent fxml = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("home-page.fxml")));
            stackPane.getChildren().removeAll();
            stackPane.getChildren().setAll(fxml);
        }
        else if (btnPage1.equals(source)) {
            Parent fxml = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("page-1.fxml")));
            stackPane.getChildren().removeAll();
            stackPane.getChildren().setAll(fxml);
        }
        else if (btnPage2.equals(source)) {
            Parent fxml = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("page-2.fxml")));
            stackPane.getChildren().removeAll();
            stackPane.getChildren().setAll(fxml);
        }
        else if (btnPage3.equals(source)) {
            Parent fxml = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("page-3.fxml")));
            stackPane.getChildren().removeAll();
            stackPane.getChildren().setAll(fxml);
        }
    }

    @FXML
    void handleMenuItemClick(ActionEvent event) {
        /* TODO: сделать в отдельном потоке */
        ExcelDemo.export();
    }
}