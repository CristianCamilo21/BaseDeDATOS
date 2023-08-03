package mylibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface CostumerDAO {

    public static void createCostumerDB(CostumerModel cm){
        Conexion bdConnect= new Conexion();

        try(Connection connect = bdConnect.getConnection()){

            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO library (doc_ident, doc_type, name, last_name, email, class)VALUES(?,?,?,?,?,?)";
                ps = connect.prepareStatement(query);
                ps.setInt(1, cm.getIdentityDoc());
                ps.setString(2, cm.getDocType());
                ps.setString(3, cm.getName());
                ps.setString(4, cm.getLastName());
                ps.setString(5, cm.getEmail());
                ps.setString(6, cm.getGroupClass());
                ps.executeUpdate();
                System.out.println("Registro Existoso");

            }catch (SQLException exc){
                System.out.println(exc);

            }

        }catch (SQLException e){
            System.out.println(e);
        }

    }

    public static void getCostumerDB() {

        Conexion bdConnect = new Conexion();

        PreparedStatement ps = null;

        ResultSet resultSet = null;

        try(Connection connect = bdConnect.getConnection()){

            String query = "SELECT * FROM library";

            ps = connect.prepareStatement(query);

            resultSet = ps.executeQuery();

            while (resultSet.next()){

                System.out.println("ID:  " + resultSet.getInt("doc_ident"));
                System.out.println("Tipo documento: " + resultSet.getString("doc_type"));
                System.out.println("Nombre: " + resultSet.getString("name"));
                System.out.println("Apellido: " + resultSet.getString("last_name"));
                System.out.println("Email:  " + resultSet.getString("email"));
                System.out.println("Programa: " + resultSet.getString("class"));
            }



        }catch (SQLException e){
            System.out.println("No se recuperaron los registros");
            System.out.println(e);
        }


        }

    public static void updateCostumerDB(){

    }

    public static void deleteCostumerDB(){

    }

}
