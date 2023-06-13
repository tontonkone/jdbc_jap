package fr.diginamic.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DeleteFour {

    private static final String URL ;
    private static final String USER ;
    private static final String PASSWORD ;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        URL = bundle.getString("db.url");
        USER = bundle.getString("db.user");
        PASSWORD = bundle.getString("db.pwd");
    }

    public static void deleteFournisseur(String nomFour) {

        try (Connection connection =  DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = connection.createStatement()) {
            int nb = st.executeUpdate("DELETE FROM FOURNISSEUR WHERE NOM ='"+nomFour+"'");
            System.out.println(nb);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
