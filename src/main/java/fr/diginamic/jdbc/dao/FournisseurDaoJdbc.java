package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDaoJdbc implements FournisseurDao{

    private static final String URL ;
    private static final String USER ;
    private static final String PASSWORD ;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        URL = bundle.getString("db.url");
        USER = bundle.getString("db.user");
        PASSWORD = bundle.getString("db.pwd");
    }
    @Override
    public List<Fournisseur> extraire() {
        ArrayList<Fournisseur> arrayFournisseur = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM FOURNISSEUR")) {

            while (rs.next()) {

                int id = rs.getInt(1);
                String nom = rs.getString("NOM");

                Fournisseur newFournisseur = new Fournisseur(id,nom);
                arrayFournisseur.add(newFournisseur);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return arrayFournisseur;
    }

    @Override
    public void insert(String fournisseur) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = connection.createStatement()) {

            int nb = st.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES ('"+fournisseur+"')");
            System.out.println(nb);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public int update(String ancienNom, String nouveauNom) {
        try (Connection connection =  DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = connection.createStatement()) {
            int nb = st.executeUpdate("UPDATE FOURNISSEUR SET NOM = '"+ ancienNom + "' WHERE NOM = '" + nouveauNom + "'");
            System.out.println(nb);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 1;
    }



    @Override
    public void  delete(String nom) {
        try (Connection connection =  DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = connection.createStatement()) {
            int nb = st.executeUpdate("DELETE FROM FOURNISSEUR WHERE NOM ='"+nom+"'");
            System.out.println(nb);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("fournisseur sup");

    }
}
