package fr.diginamic.bdd;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
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

        ArrayList<Fournisseur> arrayFournisseur = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM FOURNISSEUR")) {


            while (rs.next()) {

                int id = rs.getInt(1);
                String nom = rs.getString("NOM");

                Fournisseur newFournisseur = new Fournisseur(id,nom);
                arrayFournisseur.add(newFournisseur);
                System.out.println(newFournisseur.getId() + newFournisseur.getNom());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
