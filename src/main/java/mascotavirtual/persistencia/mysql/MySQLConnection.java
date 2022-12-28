
package mascotavirtual.persistencia.mysql;



import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mascotavirtual.modelos.Mascota;


public class MySQLConnection {
  final String URL = "jdbc:mysql://localHost:3306/";
  final String BD = "dukedb";
  final String USER = "root";
  final String PASSWORD = "";
  
  Connection connection;
  
  
  public Connection establecerConexion(){
    //Establecemos conexion con la base de datos
            try{
                connection = DriverManager.getConnection(URL + BD, USER, PASSWORD);
                System.out.println("Conexion con base de datos " + BD + " ha sido abierta.");

            }catch (SQLException e){
                System.out.println("NO se ha podido ESTABLECER la conexion con la base de datos.");
                e.printStackTrace();
            }
        return connection;  
    }  
  
  
  public Connection crearTabla(){
        try{
            //1°declaración SQL para crear tabla
             String sql = "CREATE TABLE infomascota ("
                    + "id INTEGER PRIMARY KEY AUTO_INCREMENT, "
                    + "nombre VARCHAR(255), "
                    + "fechaNacimiento DATE, "
                    + "fechaMuerte DATE, "
                    + "isLive BOOLEAN, "
                    + "nivelEnergia INT, "
                    + "nivelHambre INT, "
                    + "nivelSed INT, "
                    + "nivelCansancio INT, "
                    + "nivelFelicidad INT, "
                    + "nivelAburrimiento INT,"
                    + "propietario VARCHAR(255))";
             
            //2°Creamos un objeto PreparedStatement a partir de la declaración SQL
             PreparedStatement stmt = connection.prepareStatement(sql);
            //3°Ejecutamos la declaración SQL para crear la tabla   
             stmt.executeUpdate();
             stmt.close();
        }catch (SQLException e) {
            System.out.println("ERROR.No se ha podido crear tabla.");
        }
      return null;
    }
  
  
  public void cerrarConexion(Connection connection){
      //Cerramos conexion con la base de datos
            try{
                connection.close();
                System.out.println("Conexion con base de datos " + BD + " ha sido cerrada.");
            }catch (SQLException e){
                System.out.println("NO se ha podido CERRAR la conexión con la base de datos.");
            }
  }
  
  public PreparedStatement enviarConsulta(Connection connection, String consultaSQL){
        //método que se encarga de preparar la consulta SQL(query)    
            try{
                    return connection.prepareStatement(consultaSQL);
            }catch (SQLException e){
                System.out.println("No se ha podido generar el objeto PrepareStatement.");
            }
        return null;    
  }
  
  
}

