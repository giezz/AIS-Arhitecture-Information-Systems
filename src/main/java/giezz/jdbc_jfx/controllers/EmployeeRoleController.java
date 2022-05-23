package giezz.jdbc_jfx.controllers;

import giezz.jdbc_jfx.dao.DAO;
import giezz.jdbc_jfx.dao.EmployeeEmployeePositionDAO;
import giezz.jdbc_jfx.models.EmployeeEmployeePosition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeRoleController {

    @FXML
    private TableColumn<EmployeeEmployeePosition, Integer> colID;

    @FXML
    private TableColumn<EmployeeEmployeePosition, String> colLastName;

    @FXML
    private TableColumn<EmployeeEmployeePosition, String> colName;

    @FXML
    private TableColumn<EmployeeEmployeePosition, String> colPos;

    @FXML
    private TableColumn<EmployeeEmployeePosition, String> colSalary;

    @FXML
    private TableView<EmployeeEmployeePosition> tvEEP;

    private final DAO<EmployeeEmployeePosition, Integer> EEPIntegerDAO = new EmployeeEmployeePositionDAO();

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
        ObservableList<EmployeeEmployeePosition> empPositions = EEPIntegerDAO.getAll();
        tvEEP.setItems(empPositions);
    }
}
