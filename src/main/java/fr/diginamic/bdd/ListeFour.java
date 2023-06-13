package fr.diginamic.bdd;

import java.sql.*;
import java.util.ResourceBundle;

public class ListeFour {

    private static final String URL ;
    private static final String USER ;
    private static final String PASSWORD ;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        URL = bundle.getString("db.url");
        USER = bundle.getString("db.user");
        PASSWORD = bundle.getString("db.pwd");
    }

    public static void listerFournisseurs() {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM FOURNISSEUR")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " - " + rs.getString("NOM"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
