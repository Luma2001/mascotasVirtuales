
package mascotavirtual.persistencia.mysql;
import mascotavirtual.persistencia.IMascotaPersistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mascotavirtual.modelos.Mascota;


public class MascotaPersistenceUseMySQL implements IMascotaPersistence {
    
    MySQLConnection mySQLConnection;
    
    Connection connection;
    
    
    public MascotaPersistenceUseMySQL(){
        this.mySQLConnection = new MySQLConnection();
        this.connection = mySQLConnection.establecerConexion();
    }
   

    @Override//funciona Ok
    public void guardar(Mascota mascota) {
           try {
      String query = "INSERT INTO infomascota ("
          + "nombre, "
          + "fechaNacimiento, "
          + "fechaMuerte, "
          + "isLive, "
          + "nivelEnergia, "
          + "nivelHambre, "
          + "nivelSed, "    
          + "nivelCansancio, "
          + "nivelFelicidad, "
          + "nivelAburrimiento, "
          + "propietario) "
          + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      PreparedStatement stm = mySQLConnection.enviarConsulta(this.connection, query);
   
      stm.setString(1, mascota.getNombre());
      stm.setString(2, mascota.getFechaNacimiento().toString());
      stm.setString(3, mascota.getFechaMuerte() != null ? mascota.getFechaMuerte().toString() : null);
      stm.setBoolean(4, mascota.getIsLive());
      stm.setInt(5, mascota.getNivelEnergia());
      stm.setInt(6, mascota.getNivelHambre());
      stm.setInt(7, mascota.getNivelSed());
      stm.setInt(8, mascota.getNivelCansancio());
      stm.setInt(9, mascota.getNivelFelicidad());
      stm.setInt(10, mascota.getNivelAburrimiento());
      stm.setString(11, mascota.getPropietario());
      stm.executeUpdate();
    } catch (SQLException e) {
      System.out.println("problema para insertar los datos");
    } 
    }

    @Override//Funciona ok
    
    public Mascota getMascota(int id) {
                        
            String query = "SELECT nombre, propietario, fechaNacimiento, isLive FROM infomascota WHERE id = ?";
            // Crear un objeto PreparedStatement
            PreparedStatement stm = mySQLConnection.enviarConsulta(this.connection, query);
            try{
                stm.setInt(1, id);
                
                // Ejecutar la instrucción SQL y obtener el resultado
            ResultSet rs = stm.executeQuery();
                // Verificar si se obtuvo un registro
            if (rs.next()) {
                // Crear un objeto Msacota y establecer sus valores
            Mascota mascota = new Mascota();
                mascota.setNombre(rs.getString("nombre"));
                mascota.setPropietario(rs.getString("propietario"));
                mascota.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate().atTime(LocalTime.ofSecondOfDay(new Random().nextInt(86400))));
                mascota.setIsLive(rs.getBoolean("isLive"));
                // Devolver el objeto Mascota

                 return mascota;}
            
            }catch (SQLException e) {
                System.out.println("Error, no se ha podido mostrar registro");
            }

            return null;
          }
    
    
     @Override//Funciona ok
    
    public Mascota getMascota(String nombre, String propietario) {
                        
            String query = "SELECT * FROM infomascota WHERE nombre = ? AND propietario = ?";
            
            // Crear un objeto PreparedStatement
            PreparedStatement stm = mySQLConnection.enviarConsulta(this.connection, query);
            try{
                stm.setString(1, nombre);
                stm.setString(2, propietario);
                
                // Ejecutar la instrucción SQL y obtener el resultado
            ResultSet rs = stm.executeQuery();
                // Verificar si se obtuvo un registro
            if (rs.next()) {
                // Crear un objeto Msacota y establecer sus valores
            Mascota mascota = new Mascota();
                mascota.setId(rs.getInt("id"));
                mascota.setNombre(rs.getString("nombre"));
                mascota.setPropietario(rs.getString("propietario"));                               
                mascota.setIsLive(rs.getBoolean("isLive"));
                mascota.setNivelEnergia(rs.getInt("nivelEnergia"));          
                mascota.setNivelHambre(rs.getInt("nivelHambre"));
                mascota.setNivelSed(rs.getInt("nivelSed"));
                mascota.setNivelCansancio(rs.getInt("nivelCansancio"));
                mascota.setNivelFelicidad(rs.getInt("nivelFelicidad"));
                mascota.setNivelAburrimiento(rs.getInt("nivelAburrimiento"));
                // Devolver el objeto Mascota

                 return mascota;}
            
            }catch (SQLException e) {
                System.out.println("Error, no se ha podido mostrar registro");
            }

            return null;
          }
    
    
    
    @Override//funciona ok
    public List<Mascota> getMascota(String propietario, Boolean isLive) {
       
                
      String query = "SELECT nombre, nivelFelicidad FROM infomascota WHERE propietario = ? AND isLive=?";
            
                // Crear un objeto PreparedStatement
      PreparedStatement stm = mySQLConnection.enviarConsulta(this.connection, query);
      List listaMascotas = new ArrayList<>();
      try{

        stm.setString(1, propietario);
        stm.setBoolean(2, isLive);
                
        // Ejecutar la instrucción SQL y obtener el resultado
        ResultSet rs = stm.executeQuery();
        // Verificar si se obtuvo un registro

        while (rs.next()) {
          listaMascotas.add(rs.getInt("nivelFelicidad"));
          listaMascotas.add(rs.getString("nombre"));
        }

      }catch (SQLException e) {
        System.out.println("Error, no se han podido mostrar registros");
      }

      return listaMascotas;
     
    }         

    
    /*
    @Override //funciona ok
    public Mascota getMascota(String nombre, String propietario) {
    String query = "SELECT nivelEnergia, nivelHambre, nivelSed, nivelCansancio, nivelFelicidad, nivelAburrimiento  FROM infomascota WHERE nombre = ? && propietario=?";
            // Crear un objeto PreparedStatement
            PreparedStatement stm = mySQLConnection.enviarConsulta(this.connection, query);
            try{
                stm.setString(1, nombre);
                stm.setString(2, propietario);
                
                // Ejecutar la instrucción SQL y obtener el resultado
            ResultSet rs = stm.executeQuery();
                // Verificar si se obtuvo un registro
            if (rs.next()) {
                // Crear un objeto Msacota y establecer sus valores
            Mascota mascota = new Mascota();
                
                mascota.setNivelEnergia(rs.getInt("nivelEnergia"));
                mascota.setNivelHambre(rs.getInt("nivelHambre"));
                mascota.setNivelSed(rs.getInt("nivelSed"));
                mascota.setNivelCansancio(rs.getInt("nivelCansancio"));
                mascota.setNivelFelicidad(rs.getInt("nivelFelicidad"));
                mascota.setNivelAburrimiento(rs.getInt("nivelAburrimiento"));
      
                // Devolver el objeto Mascota

                 return mascota;}
            
            }catch (SQLException e) {
                System.out.println("Error, no se ha podido mostrar registro");
            }

            return null;
    }*/

    
    
    @Override//Funciona Ok
    public List<Mascota> getAllMascotas() {
        String query = "SELECT * FROM infomascota";
        List<Mascota> listaCompleta = new ArrayList<>(); 
                // Crear un objeto PreparedStatement
      PreparedStatement stm = mySQLConnection.enviarConsulta(this.connection, query);
      
      
      try{
    
        // Ejecutar la instrucción SQL y obtener el resultado
        //ResultSet nos permite contener toda la información que traemos de la base de datos
        ResultSet rs = stm.executeQuery();
        // Verificar si se obtuvo un registro

        while (rs.next()) {
          Mascota mascota = new Mascota();
          mascota.setId(rs.getInt("id"));
          mascota.setNombre(rs.getString("nombre"));
          mascota.setPropietario(rs.getString("propietario"));
          mascota.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate().atTime(LocalTime.ofSecondOfDay(new Random().nextInt(86400))));
          mascota.setIsLive(rs.getBoolean("isLive"));
          mascota.setNivelEnergia(rs.getInt("nivelEnergia"));          
          mascota.setNivelHambre(rs.getInt("nivelHambre"));
          mascota.setNivelSed(rs.getInt("nivelSed"));
          mascota.setNivelCansancio(rs.getInt("nivelCansancio"));
          mascota.setNivelFelicidad(rs.getInt("nivelFelicidad"));
          mascota.setNivelAburrimiento(rs.getInt("nivelAburrimiento"));
          
          listaCompleta.add(mascota);
         
        }
        stm.close();
    
      }catch (SQLException e) {
        System.out.println("Error, no se han podido mostrar registros");
      }

      return listaCompleta;
    }
    

    
    @Override//escribimos el método,
    //La idea de que después de comer, divertirse, etc llamar al método para actualizar los valores
    public void updateMascota(int id, Mascota mascota) {
        // Crear una instrucción SQL UPDATE
            String sql = "UPDATE infomascota SET  isLive = ?, nivelEnergia = ?, nivelHambre = ?, nivelSed = ?, nivelCansancio = ?, nivelFelicidad = ?, nivelAburrimiento = ? WHERE id = ?";
            // Crear un objeto PreparedStatement
            PreparedStatement stm = mySQLConnection.enviarConsulta(this.connection, sql);
            
            try {
            stm.setInt(1, id);
            
            // Establecer los valores de los parámetros
            //stm.setString(1, elegida.getFechaMuerte() != null ? elegida.getFechaMuerte().toString() : null);
            stm.setBoolean(2, mascota.getIsLive());
            stm.setInt(3, mascota.getNivelEnergia());
            stm.setInt(4, mascota.getNivelHambre());
            stm.setInt(5, mascota.getNivelSed());
            stm.setInt(6, mascota.getNivelCansancio());
            stm.setInt(7, mascota.getNivelFelicidad());
            stm.setInt(8, mascota.getNivelAburrimiento());
           
            // Ejecutar la instrucción SQL
            stm.executeUpdate();
            stm.close();//cerramos conexión
                System.out.println("Registro actualizado correctamente.");
            
            
            } catch (SQLException e) {
            System.out.println("Error, no se ha podido actualizar el Registro.");
            }
          }

    
    @Override //funciona ok
    public void deleteMascota(int id) {
        try {
        //Crear una instrucción SQL DELETE. 
        //Nota: en un trabajo nunca borrar un registro. 
        //Se debe ocultar de la base de datos para que no sea visible.
        String sql = "DELETE FROM infomascota WHERE id = ?";
        
        // Crear un objeto PreparedStatement
        PreparedStatement stm = mySQLConnection.enviarConsulta(this.connection, sql);
        // Establecer el valor del parámetro
        stm.setInt(1, id);
        // Ejecutar la instrucción SQL
        stm.executeUpdate();
        } catch (SQLException e) {
        System.out.println("Error, no se ha podido borrar Registro");
        }
    
    }

    
}
