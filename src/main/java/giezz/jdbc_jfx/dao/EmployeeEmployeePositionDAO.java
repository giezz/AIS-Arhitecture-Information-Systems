package giezz.jdbc_jfx.dao;

import giezz.jdbc_jfx.models.EmployeeEmployeePosition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeEmployeePositionDAO implements DAO<EmployeeEmployeePosition, Integer> {

    @Override
    public void create(EmployeeEmployeePosition model) {

    }

    @Override
    public ObservableList<EmployeeEmployeePosition> getAll() {
        try(Statement statement = DataSource.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY.GET_EMPLOYEE_POSITIONS.QUERY);
            ObservableList<EmployeeEmployeePosition> employeePositions = FXCollections.observableArrayList();
            while (resultSet.next()) {
                employeePositions.add(
                        new EmployeeEmployeePosition(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5)
                        )
                );
            }
            return employeePositions;
        } catch (SQLException e) {
            e.printStackTrace();
            return FXCollections.emptyObservableList();
        }
    }

    @Override
    public EmployeeEmployeePosition get(Integer integer) {
        return null;
    }

    @Override
    public void update(EmployeeEmployeePosition eep) {

    }

    @Override
    public void delete(Integer integer) {

    }

    private enum QUERY {
        GET_EMPLOYEE_POSITIONS("SELECT e.id_employee, e.first_name, e.last_name, ep.name, ep.salary FROM employees AS e " +
                "JOIN employees_employees_positions eep ON e.id_employee = eep.id_employee " +
                "JOIN employees_positions ep ON ep.id_position = eep.id_position " +
                "ORDER BY e.id_employee DESC");

        String QUERY;
        QUERY(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
