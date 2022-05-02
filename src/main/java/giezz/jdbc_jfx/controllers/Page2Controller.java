package giezz.jdbc_jfx.controllers;

import giezz.jdbc_jfx.JDBCHandler;
import giezz.jdbc_jfx.tables.EEP;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class Page2Controller {

    @FXML
    private TableColumn<EEP, Integer> colID;

    @FXML
    private TableColumn<EEP, String> colLastName;

    @FXML
    private TableColumn<EEP, String> colName;

    @FXML
    private TableColumn<EEP, String> colPos;

    @FXML
    private TableColumn<EEP, String> colSalary;

    @FXML
    private TableView<EEP> tvEEP;

    @FXML
    void initialize() {

        colID.setCellValueFactory(new PropertyValueFactory<>("id_employee"));
        colName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        colPos.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        showEEP();
    }

    void showEEP() {
        try {
            JDBCHandler handler = JDBCHandler.getInstance();
            ObservableList<EEP> eeps = handler.getEEP();
            tvEEP.setItems(eeps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
