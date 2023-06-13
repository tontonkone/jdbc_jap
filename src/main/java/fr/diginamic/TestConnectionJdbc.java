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
    public static void main(String[] args) throws SQLException {


/*

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);) {
            System.out.println(connection);
        } catch (SQLException e) {
            System.out.println((e.getMessage()));
        }
*/
        try ( Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement()){
            int nb = statement.executeUpdate("INSERT INTO FOURNISSEUR (nom) VALUES ('rotgrts')");

            ResultSet result = statement.executeQuery("select * from ARTICLE");

            while(result.next()){
                System.out.println(result.getInt(1) + " " + result.getString(2) + result.getString(3));
            }
            result.close();

            System.out.println("connection ok ");
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }


    }
}
