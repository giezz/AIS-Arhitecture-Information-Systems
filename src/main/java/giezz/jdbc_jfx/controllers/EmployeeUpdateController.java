package giezz.jdbc_jfx.controllers;

import giezz.jdbc_jfx.JDBCHandler;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class EmployeeUpdateController {
    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cbDriveCategory;

    @FXML
    private DatePicker dpDateOfBirth;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfINN;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfMiddleName;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPhone;

    @FXML
    void initialize() {

    }

    public int employeeID;

    @FXML
    void handleButtonAction() {
        try {
            JDBCHandler handler = JDBCHandler.getInstance();
            String sql = "UPDATE employees SET ";
            if (!tfINN.getText().isEmpty())
                sql += " inn = '" + tfINN.getText() + "', ";
            else
                sql += " inn = '" + tfINN.getPromptText() + "', ";
            if (!(dpDateOfBirth.getValue() == null))
                sql += " date_of_birth = '" + dpDateOfBirth.getValue() + "'::date , ";
            else
                sql += " date_of_birth = '" + dpDateOfBirth.getPromptText() + "', ";
            if (!tfName.getText().isEmpty())
                sql += " first_name = '" + tfName.getText() + "', ";
            else
                sql += " first_name = '" + tfName.getPromptText() + "', ";
            if (!tfMiddleName.getText().isEmpty())
                sql += " middle_name = '" + tfMiddleName.getText() + "', ";
            else
                sql += " middle_name = '" + tfMiddleName.getPromptText() + "', ";
            if (!tfLastName.getText().isEmpty())
                sql += " last_name = '" + tfLastName.getText() + "', ";
            else
                sql += " last_name = '" + tfLastName.getPromptText() + "', ";
            if (!tfPhone.getText().isEmpty())
                sql += " phone = '" + tfPhone.getText() + "', ";
            else
                sql += " phone = '" + tfPhone.getPromptText() + "', ";
            if (!tfEmail.getText().isEmpty())
                sql += " email = '" + tfEmail.getText() + "', ";
            else
                sql += " email = '" + tfEmail.getPromptText() + "', ";
            if (cbDriveCategory.getSelectionModel().isSelected(0) || cbDriveCategory.getSelectionModel().isSelected(1))
                sql += " driver_license_category = null ";
            else
                sql += " driver_license_category = '" + cbDriveCategory.getValue() + "' ";
            sql += " WHERE id_employee = " + employeeID;
            System.out.println(sql);
            handler.updateEmployee(sql);
            btnUpdate.setDisable(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setPromptText(String INN, String dateOfBirth, String firstName, String lastName, String middleName, String phone, String email, String category) {
        tfINN.setPromptText(INN);
        dpDateOfBirth.setPromptText(dateOfBirth);
        tfName.setPromptText(firstName);
        tfLastName.setPromptText(lastName);
        tfMiddleName.setPromptText(middleName);
        tfPhone.setPromptText(phone);
        tfEmail.setPromptText(email);
        cbDriveCategory.getSelectionModel().select(category);
    }

    public void populateComboBox(ObservableList<String> categories) {
        cbDriveCategory.setItems(categories);
    }
}
