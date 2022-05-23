package giezz.jdbc_jfx.dao;

import giezz.jdbc_jfx.models.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAO implements DAO<Employee, Integer>  {

    @Override
    public void create(Employee employee) {
        try(PreparedStatement statement = DataSource.getConnection().prepareStatement(QUERY.INSERT.QUERY)) {
            statement.setString(1, employee.getInn());
            statement.setString(2, employee.getDate_of_birth());
            statement.setString(3, employee.getFirst_name());
            statement.setString(4, employee.getMiddle_name());
            statement.setString(5, employee.getLast_name());
            statement.setString(6, employee.getPhone());
            statement.setString(7, employee.getEmail());
            statement.setString(8, employee.getDriver_license_category());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<Employee> getAll() {
        try(Statement statement = DataSource.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY.GET_ALL.QUERY)) {
            ObservableList<Employee> employeesObservableList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                employeesObservableList.add(
                        new Employee(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getString(7),
                                resultSet.getString(8),
                                resultSet.getString(9)
                        )
                );
            }
            return employeesObservableList;
        } catch (SQLException e) {
            e.printStackTrace();
            return FXCollections.emptyObservableList();
        }
    }

    @Override
    public Employee get(Integer key) {
        Employee employee = new Employee();
        try (PreparedStatement statement = DataSource.getConnection().prepareStatement(QUERY.GET_BY_ID.QUERY)) {
            statement.setInt(1, key);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setId_employee(resultSet.getInt(1));
                employee.setInn(resultSet.getString(2));
                employee.setDate_of_birth(resultSet.getObject(3).toString());
                employee.setFirst_name(resultSet.getString(4));
                employee.setMiddle_name(resultSet.getString(5));
                employee.setPhone(resultSet.getString(6));
                employee.setEmail(resultSet.getString(7));
                employee.setDriver_license_category(resultSet.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void update(Employee employee) {
        try(PreparedStatement statement = DataSource.getConnection().prepareStatement(QUERY.UPDATE.QUERY)) {
            statement.setString(1, employee.getInn());
            statement.setString(2, employee.getDate_of_birth());
            statement.setString(3, employee.getFirst_name());
            statement.setString(4, employee.getMiddle_name());
            statement.setString(5, employee.getLast_name());
            statement.setString(6, employee.getPhone());
            statement.setString(7, employee.getEmail());
            statement.setString(8, employee.getDriver_license_category());
            statement.setInt(9, employee.getId_employee());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer key) {
        try (PreparedStatement statement = DataSource.getConnection().prepareStatement(QUERY.DELETE.QUERY)){
            statement.setInt(1, key);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private enum QUERY {
        INSERT("INSERT INTO employees (inn, date_of_birth, first_name, middle_name, last_name, phone, email, driver_license_category) " +
                "VALUES (?, ?::date, ?, ?, ?, ?, ?, ?)"),
        UPDATE("UPDATE employees " +
                "SET inn = ?, " +
                "date_of_birth = ?::date, " +
                "first_name = ?, " +
                "middle_name = ?, " +
                "last_name = ?, " +
                "phone = ?, " +
                "email = ? ," +
                "driver_license_category = ? " +
                "WHERE id_employee = ?"),
        GET_ALL("SELECT id_employee, inn, date_of_birth, first_name, middle_name, last_name, phone, email, driver_license_category from employees" +
                " ORDER BY id_employee DESC"),
        GET_BY_ID("SELECT id_employee, inn, date_of_birth, first_name, middle_name, last_name, phone, email, driver_license_category from employees" +
                " WHERE id_employee = ?"),

        DELETE("DELETE FROM employees WHERE id_employee = ?");

        String QUERY;
        QUERY(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
