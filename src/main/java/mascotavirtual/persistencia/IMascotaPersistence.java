
package mascotavirtual.persistencia;

import java.util.ArrayList;
import java.util.List;
import mascotavirtual.modelos.Mascota;


public interface IMascotaPersistence {
    
    //Declaramos una variable de nombre bdMascotas de tipo List
    
    List<Mascota> bdMascotas = new ArrayList<>();              
                         
    //Métodos abstratos: se define solo la firma del método, no tienen cuerpo
    //Las interfaces sólo pueden tener métodos abstratos y constantes.
    void guardar(Mascota mascota);
    Mascota getMascota(int id);
    Mascota getMascota(String nombre);
    /*Mascota getMascota(String propietario*/
    List<Mascota> getAllMascotas();
    void updateMascota(int id, Mascota mascota);
    void deleteMascota(int id);
    
}
