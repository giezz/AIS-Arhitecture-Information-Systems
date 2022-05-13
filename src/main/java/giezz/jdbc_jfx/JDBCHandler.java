package giezz.jdbc_jfx;

import giezz.jdbc_jfx.models.EEP;
import giezz.jdbc_jfx.models.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.postgresql.Driver;

import java.sql.*;
import java.time.LocalDate;

public class JDBCHandler {

    private static final String URL = "jdbc:postgresql://localhost:5432/proekt";
    private static final String USER = "postgres";
    private static final String PASS = "admin";
    private static JDBCHandler instance = null;
    private final Connection connection;

    public static synchronized JDBCHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new JDBCHandler();
        return instance;
    }

    private  JDBCHandler() throws SQLException {
        DriverManager.registerDriver(new Driver());
        this.connection = DriverManager.getConnection(URL, USER, PASS);
    }

    public ObservableList<EEP> getEEP() {
        String selectSQL = """
                SELECT employees.id_employee, employees.first_name, employees.last_name, ep.name, ep.salary FROM employees
                                                                                   JOIN employees_employees_positions eep ON employees.id_employee = eep.id_employee
                                                                                   JOIN employees_positions ep ON ep.id_position = eep.id_position""";
        try (Statement statement = this.connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)){

            ObservableList<EEP> eepObservableList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                eepObservableList.add(new EEP(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)));
            }
            FXCollections.reverse(eepObservableList);
            return eepObservableList;

        } catch (SQLException e) {
            e.printStackTrace();
            return FXCollections.emptyObservableList();
        }
    }

    public ObservableList<Employee> getEmployees() {
        String selectSQL = "SELECT id_employee, inn, date_of_birth, first_name, middle_name, last_name, phone, email, driver_license_category from employees ORDER BY id_employee";
        return handleQuery(selectSQL);
    }

    public ObservableList<Employee> getFilteredEmployee(String sql) {
        return handleQuery(sql);
    }

    private ObservableList<Employee> handleQuery(String sql) {
        try (Statement statement = this.connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            ObservableList<Employee> employeeFilteredObservableList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                employeeFilteredObservableList.add(new Employee(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9)));
            }
            FXCollections.reverse(employeeFilteredObservableList);
            return employeeFilteredObservableList;
        } catch (SQLException e) {
            e.printStackTrace();
            return FXCollections.emptyObservableList();
        }
    }

    public void addEmployee(String inn, LocalDate dob, String first_name, String last_name, String middle_name, String phone, String email, String drv_category) {
        String insertSQL = "INSERT INTO employees (inn, date_of_birth, first_name, middle_name, last_name, phone, email, driver_license_category) VALUES (?, ?::date, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, inn);
            preparedStatement.setObject(2, dob);
            preparedStatement.setString(3, first_name);
            preparedStatement.setString(4, middle_name);
            preparedStatement.setString(5, last_name);
            preparedStatement.setString(6, phone);
            preparedStatement.setString(7, email);
            preparedStatement.setString(8, drv_category);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int employeeID) {
        String deleteSQL = "DELETE FROM employees WHERE id_employee = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(deleteSQL)){
            preparedStatement.setInt(1, employeeID);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(String sql) {
        try (Statement statement = this.connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
