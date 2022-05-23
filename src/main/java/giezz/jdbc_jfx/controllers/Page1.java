package giezz.jdbc_jfx.controllers;

import giezz.jdbc_jfx.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.Objects;

public class Page1 {

    @FXML
    private ComboBox<String> cbTest;

    @FXML
    private StackPane stackPane;

    @FXML
    void initialize() throws IOException {
        ObservableList<String> test = FXCollections.observableArrayList("Управление персоналом", "Позиции персонала", "3", "4");
        cbTest.setItems(test);
        cbTest.getSelectionModel().selectFirst();
        handleComboBoxAction(null);
    }

    @FXML
    void handleComboBoxAction(ActionEvent event) throws IOException {
        if (cbTest.getSelectionModel().isSelected(0)) {
            Parent fxml = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("employee-management.fxml")));
            stackPane.getChildren().removeAll();
            stackPane.getChildren().setAll(fxml);
        }
        else if (cbTest.getSelectionModel().isSelected(1)) {
            Parent fxml = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("employee-role.fxml")));
            stackPane.getChildren().removeAll();
            stackPane.getChildren().setAll(fxml);
        }
        else if (cbTest.getSelectionModel().isSelected(2)) {
            System.out.println(event.getSource());
        }
    }

}
