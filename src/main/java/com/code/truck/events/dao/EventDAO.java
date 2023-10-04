package com.code.truck.events.dao;

import com.code.truck.events.model.Event;

import java.sql.*;

public class EventDAO {

    private final Connection connection;

    public EventDAO(Connection connection) {
        this.connection = connection;
    }

    public Integer salvar(Event event) {
        String sql = "insert into evento (id, nome, data) values (null, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, event.getName());
            preparedStatement.setDate(2, new Date(event.getDate().getTime()));

            preparedStatement.executeUpdate();

            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                resultSet.next();

                return resultSet.getInt(1);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
