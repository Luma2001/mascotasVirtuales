
package mascotavirtual.persistencia.mysql;
import mascotavirtual.persistencia.IMascotaPersistence;
import java.sql.Connection;
import java.util.List;
import mascotavirtual.modelos.Mascota;


public class MascotaPersistenceUseMySQL implements IMascotaPersistence {
    
    MySQLConnection mySQLConnection;
    
    Connection connection;
    
    public MascotaPersistenceUseMySQL(){
        this.mySQLConnection = new MySQLConnection();
        this.connection = mySQLConnection.establecerConexion();
    }

    @Override
    public void guardar(Mascota mascota) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Mascota getMascota(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Mascota getMascota(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Mascota> getAllMascotas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateMascota(int id, Mascota mascota) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteMascota(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
