package com.dataart.retman;

import com.dataart.retman.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.*;

public class Test {
    private static final Log LOG = LogFactory.getLog(Test.class);
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/test";
    private static final String DB_USER = "SA";
    private static final String DB_PASS = "";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        User user = selectRecordsFromDB();
        System.out.println(user);
    }

    public static User selectRecordsFromDB() {
        User user = null;
        Connection connection = null;
        Statement statement = null;
        String sql = "SELECT USERID, USERNAME, SURNAME FROM USERS";

        try {
            connection = getConnection();
            statement = connection.createStatement();

            LOG.info("SQL query to process : [" + sql + "]");

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int userId = resultSet.getInt("USERID");
                String username = resultSet.getString("USERNAME");
                String surname = resultSet.getString("SURNAME");

                user = new User(userId, username, surname);

            }

        } catch (SQLException e) {
            LOG.error("Error while process SQL query", e);
        }

        return user;
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            LOG.error("Check DB Driver ERROR", e);
        }

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASS);
        } catch (SQLException e) {
            LOG.error("Error while getting DB connection", e);
        }

        return connection;
    }
}
