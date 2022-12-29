
package mascotavirtual.persistencia.persistenceCollections;
            
import java.util.List;
import mascotavirtual.modelos.Mascota;
import mascotavirtual.persistencia.IMascotaPersistence;

public class MascotaPersistenceUseList implements IMascotaPersistence{

    @Override
    //add nos permite guardar datos en la base de datos
    public void guardar(Mascota mascota) {
        bdMascotas.add(mascota);        
    }

    @Override
    public Mascota getMascota(int id) {
        return bdMascotas.get(id); 
    }

    @Override
    public Mascota getMascota(String nombre, String propietario) {
        for (Mascota elemento : bdMascotas){
            if(elemento.getNombre().equals(nombre) && elemento.getPropietario().equals(propietario)){
              return elemento;      
            }
        }
        return null;
    }  
  
     @Override
    //recuperamos los datos de la base de datos
    public List<Mascota> getAllMascotas() {
        return bdMascotas;                     
    }

    @Override
    public void updateMascota(int id, Mascota mascota) {
        bdMascotas.set(id, mascota);
    }

    @Override
    public void deleteMascota(int id) {
        bdMascotas.remove(getMascota(id));
    }

   
    
    @Override
    public List<Mascota> getMascota(String propietario, Boolean isLive) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    }
       