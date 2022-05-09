package giezz.jdbc_jfx.controllers;

import java.sql.SQLException;
import giezz.jdbc_jfx.JDBCHandler;
import giezz.jdbc_jfx.models.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
public class EmployeeManagementController {

    @FXML
    private Label lblMsg;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<Employee> tvEmployee;

    @FXML
    private TableColumn<Employee, String> colDateOfBirth;

    @FXML
    private TableColumn<Employee, String> colDriverCategory;

    @FXML
    private TableColumn<Employee, String> colEmail;

    @FXML
    private TableColumn<Employee, String> colINN;

    @FXML
    private TableColumn<Employee, Integer> colId;

    @FXML
    private TableColumn<Employee, String> colLastName;

    @FXML
    private TableColumn<Employee, String> colMiddleName;

    @FXML
    private TableColumn<Employee, String> colName;

    @FXML
    private TableColumn<Employee, String> colPhone;

    @FXML
    private DatePicker dpDateOfBirth;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfEmail1;

    @FXML
    private TextField tfINN;

    @FXML
    private TextField tfINN1;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfLastName1;

    @FXML
    private TextField tfMiddleName;

    @FXML
    private TextField tfMiddleName1;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfName1;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfPhone1;

    @FXML
    private ComboBox<String> cbLicenseCategories;

    @FXML
    private ComboBox<String> cbLicenseCategories1;

    @FXML
    void initialize() {

        ObservableList<String> categories = FXCollections.observableArrayList(null, "A", "A1", "B", "BE", "C", "CE", "C1", "C1E");
        ObservableList<String> categoriesForFilter = FXCollections.observableArrayList(null, "Без прав", "A", "A1", "B", "BE", "C", "CE", "C1", "C1E");
        cbLicenseCategories.setItems(categories);
        cbLicenseCategories1.setItems(categoriesForFilter);
        cbLicenseCategories.getSelectionModel().selectFirst();
        cbLicenseCategories1.getSelectionModel().selectFirst();

        colId.setCellValueFactory(new PropertyValueFactory<>("id_employee"));
        colINN.setCellValueFactory(new PropertyValueFactory<>("inn"));
        colDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        colName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        colMiddleName.setCellValueFactory(new PropertyValueFactory<>("middle_name"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colDriverCategory.setCellValueFactory(new PropertyValueFactory<>("driver_license_category"));

        showEmployees();
    }


    @FXML
    void handleButtonAction(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            case "btnUpdate" -> {
                System.out.println(btnUpdate.getId());
                showEmployees();
            }
            case "btnInsert" -> {
                System.out.println(btnInsert.getId());
                try {
                    if (tfINN.getText().isEmpty()
                            || dpDateOfBirth.getValue() == null
                            || tfName.getText().isEmpty()
                            || tfLastName.getText().isEmpty()
                            || tfPhone.getText().isEmpty()
                            || tfEmail.getText().isEmpty()) {
                        lblMsg.setTextFill(Color.RED);
                        lblMsg.setText("Заполните все поля не отмеченные звездочкой");
                    } else {
                        JDBCHandler handler = JDBCHandler.getInstance();
                        handler.addEmployee(tfINN.getText(), dpDateOfBirth.getValue(), tfName.getText(), tfLastName.getText(), tfMiddleName.getText(), tfPhone.getText(), tfEmail.getText(), cbLicenseCategories.getValue());
                        lblMsg.setTextFill(Color.GREEN);
                        lblMsg.setText("Данные успешно введены");
                        showEmployees();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            case "btnDelete" -> {
                System.out.println(btnDelete.getId());
                try {
                    Employee selectedEmployeeRow = tvEmployee.getSelectionModel().getSelectedItem();
                    JDBCHandler handler = JDBCHandler.getInstance();
                    handler.deleteEmployee(selectedEmployeeRow.getId_employee());
                    showEmployees();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            case "btnSearch" -> {
                System.out.println(btnSearch.getId());
                String sql =  "SELECT * FROM employees WHERE ";
                if (!tfINN1.getText().isEmpty())
                    sql += " (inn LIKE '" + tfINN1.getText() + "') AND ";
                else
                    sql += " (inn LIKE '%') AND ";
                if (!tfName1.getText().isEmpty())
                    sql += " (first_name LIKE '" + tfName1.getText() + "') AND ";
                else
                    sql += " (first_name LIKE '%') AND ";
                if (!tfLastName1.getText().isEmpty())
                    sql += " (last_name LIKE '" + tfLastName1.getText() + "') AND ";
                else
                    sql += " (last_name LIKE '%') AND ";
                if (!tfMiddleName1.getText().isEmpty())
                    sql += " (middle_name LIKE '" + tfMiddleName1.getText() + "') AND ";
                else
                    sql += " ((middle_name LIKE '%') OR (middle_name IS NULL)) AND ";
                if (!tfPhone1.getText().isEmpty())
                    sql += " (phone LIKE '" + tfPhone1.getText() + "') AND ";
                else
                    sql += " (phone LIKE '%') AND ";
                if (!tfEmail1.getText().isEmpty())
                    sql += " (email LIKE '" + tfEmail1.getText() + "') AND ";
                else
                    sql += " (email LIKE '%') AND ";
                if (cbLicenseCategories1.getValue() != null)
                    sql += " (driver_license_category LIKE '" + cbLicenseCategories1.getValue() + "') ";
//                else if (cbLicenseCategories1.getSelectionModel().isSelected(1))
//                    sql += " (driver_license_category IS NULL) ";
                else
                    sql += " ((driver_license_category LIKE '%') OR (driver_license_category IS NULL)) ";

                System.out.println(sql);
                try {
                    JDBCHandler handler = JDBCHandler.getInstance();
                    ObservableList<Employee> filteredEmployee= handler.getFilteredEmployee(sql);
                    tvEmployee.setItems(filteredEmployee);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    void updateTableView(MouseEvent mouseEvent) {
        if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
            if (mouseEvent.getClickCount() == 2) {
                System.out.println("double click");
                showEmployees();
            }
        }
    }

    void showEmployees() {
        try {
            JDBCHandler handler = JDBCHandler.getInstance();
            ObservableList<Employee> employees = handler.getEmployees();
            tvEmployee.setItems(employees);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
