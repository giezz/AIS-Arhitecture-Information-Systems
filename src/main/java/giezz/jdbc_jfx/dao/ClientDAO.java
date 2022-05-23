package giezz.jdbc_jfx.dao;

import giezz.jdbc_jfx.models.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientDAO implements DAO<Client, Integer> {

    @Override
    public void create(Client client) {
        try(PreparedStatement statement = DataSource.getConnection().prepareStatement(QUERY.INSERT.QUERY)) {
            statement.setString(1, client.getLast_name());
            statement.setString(2, client.getFirst_name());
            statement.setString(3, client.getMiddle_name());
            statement.setString(4, client.getCompany_name());
            statement.setString(5, client.getPhone());
            statement.setString(6, client.getAddress());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<Client> getAll() {
        try(Statement statement = DataSource.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY.GET_ALL.QUERY)) {
            ObservableList<Client> clientsObservableList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                clientsObservableList.add(
                        new Client(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getString(7)
                        )
                );
            }
            return clientsObservableList;
        } catch (SQLException e) {
            e.printStackTrace();
            return FXCollections.emptyObservableList();
        }
    }

    @Override
    public Client get(Integer integer) {
        return null;
    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(Integer integer) {

    }

    private enum QUERY {
        INSERT("INSERT INTO client (client_id, last_name, first_name, middle_name, company_name, phone, address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)"),
        //переделать под таблицу client
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
        GET_ALL("SELECT client_id, last_name, first_name, middle_name, company_name, phone, address from client" +
                " ORDER BY client_id DESC"),
        GET_BY_ID("SELECT client_id, last_name, first_name, middle_name, company_name, phone, address from client " +
                " WHERE client_id = ?"),

        DELETE("DELETE FROM client WHERE client_id = ?");

        String QUERY;
        QUERY(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
