package fr.diginamic.bdd;

import java.sql.*;
import java.util.ResourceBundle;

public class InsertFour {

    private static final String URL ;
    private static final String USER ;
    private static final String PASSWORD ;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        URL = bundle.getString("db.url");
        USER = bundle.getString("db.user");
        PASSWORD = bundle.getString("db.pwd");
    }

    public static void main(String[] args) {

    }
    public static void creerFournisseur(String nomFournisseur) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = connection.createStatement()) {

            int nb = st.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES ('"+nomFournisseur+"')");
            System.out.println(nb);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }



}
