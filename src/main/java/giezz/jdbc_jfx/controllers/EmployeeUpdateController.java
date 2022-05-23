package giezz.jdbc_jfx.controllers;

import giezz.jdbc_jfx.dao.DAO;
import giezz.jdbc_jfx.dao.EmployeeDAO;
import giezz.jdbc_jfx.models.Employee;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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

    private final DAO<Employee, Integer> EmployeeDAO = new EmployeeDAO();

    public static int EMPLOYEE_ID;
    public static String INN;
    public static String DATE_OF_BIRTH;
    public static String FIRST_NAME;
    public static String MIDDLE_NAME;
    public static String LAST_NAME;
    public static String PHONE;
    public static String EMAIL;
    public static String CATEGORY;

    @FXML
    void initialize() {
        tfINN.setPromptText(INN);
        dpDateOfBirth.setPromptText(DATE_OF_BIRTH);
        tfName.setPromptText(FIRST_NAME);
        tfLastName.setPromptText(LAST_NAME);
        tfMiddleName.setPromptText(MIDDLE_NAME);
        tfPhone.setPromptText(PHONE);
        tfEmail.setPromptText(EMAIL);
        cbDriveCategory.getSelectionModel().select(CATEGORY);
    }

    @FXML
    void handleButtonAction() {
        try {
            Employee employee = EmployeeDAO.get(EMPLOYEE_ID);

            if (!tfINN.getText().isEmpty())
                employee.setInn(tfINN.getText());
            else
                employee.setInn(tfINN.getPromptText());

            if (dpDateOfBirth.getValue() != null)
                employee.setDate_of_birth(dpDateOfBirth.getValue().toString());
            else
                employee.setDate_of_birth(dpDateOfBirth.getPromptText());

            if (!tfName.getText().isEmpty())
                employee.setFirst_name(tfName.getText());
            else
                employee.setFirst_name(tfName.getPromptText());

            if (!tfLastName.getText().isEmpty())
                employee.setLast_name(tfLastName.getText());
            else
                employee.setLast_name(tfLastName.getPromptText());

            if (!tfMiddleName.getText().isEmpty())
                employee.setMiddle_name(tfMiddleName.getText());
            else
                employee.setMiddle_name(tfMiddleName.getPromptText());

            if (!tfPhone.getText().isEmpty())
                employee.setPhone(tfPhone.getText());
            else
                employee.setPhone(tfPhone.getPromptText());

            if (!tfEmail.getText().isEmpty())
                employee.setEmail(tfEmail.getText());
            else
                employee.setEmail(tfEmail.getPromptText());

            if (cbDriveCategory.getValue() != null)
                employee.setDriver_license_category(cbDriveCategory.getValue());
            else
                employee.setDriver_license_category(cbDriveCategory.getPromptText());

            EmployeeDAO.update(employee);
            btnUpdate.setDisable(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
