package fr.diginamic;
import java.sql.*;
import java.util.ResourceBundle;

public class TestConnectionJdbc {
    private static final String URL ;
    private static final String USER ;
    private static final String PASSWORD ;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        URL = bundle.getString("db.url");
        USER = bundle.getString("db.user");
        PASSWORD = bundle.getString("db.pwd");
    }

    public Connection getCon() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return connection;
    }

}
