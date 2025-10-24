package restaurante;
import Conexion.CreateConection;
import java.sql.SQLException;
// librerias para manipular datos
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainPrincipal {
 public static void main(String[] args) throws SQLException {
    CreateConection  conexionPostgres = new CreateConection();
    Connection con= conexionPostgres.getConection();
      try{
          Statement smt = con.createStatement();
          String qry = "insert into public.empleado(nombre,apellido,salario)" + " values ('Marina','Catalan',7550.25)";
          int filasInsertadas = smt.executeUpdate(qry);
          System.out.println("Total de Registros insertados: "+filasInsertadas);
          smt.close();
          
      } catch (SQLException e){
          e.getMessage();
      }
    }

}
