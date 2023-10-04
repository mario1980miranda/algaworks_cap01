package com.code.truck.events.dao;

import com.code.truck.events.model.Event;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class EventDAOTest {

    private static Connection connection;

    @BeforeAll
    public static void startClass() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/cadastroevento?useTimezone=true&serverTimezone=UTC&user=root&password=root");
    }

    @AfterAll
    public static void endClass() throws SQLException {
        connection.close();
    }

    @Test
    public void crud() {

        Event event = new Event(null, "Book", new Date());

        EventDAO dao = new EventDAO(connection);

        Integer id = dao.salvar(event);
        Assertions.assertNotNull(id);

        event.setId(id);

        System.out.println(event.getId());
    }
}
