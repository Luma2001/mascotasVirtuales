
package mascotavirtual.acciones;

import java.time.LocalDateTime;
import mascotavirtual.modelos.Mascota;


public class Morir {
   
    public static void checkStatusGeneral(Mascota mascota){
        if(mascota.getNivelEnergia() == 0){
            mascota.setIsLive(false);
            mascota.setFechaMuerte(LocalDateTime.now());
            if(mascota.getCausaMuerte().isEmpty()){
                determinarCausaMuerte(mascota);
            }
            System.out.println("Esta mascota ha fallecido en la fecha " + mascota.getFechaMuerte().toLocalDate());
            System.out.println("La causa de su muerte fue: " + (mascota.getCausaMuerte()));
        }
    }
    
    private static void determinarCausaMuerte(Mascota mascota) {
        if(mascota.getNivelAburrimiento() == 100){
            mascota.setCausaMuerte("Aburrimiento");
        }
        
        if(mascota.getNivelHambre() == 100){
            mascota.setCausaMuerte("Hambre");
        }
        
        if(mascota.getNivelCansancio() == 100){
            mascota.setCausaMuerte("Cansancio");
        }
        
        if(mascota.getNivelFelicidad() == 0){
            mascota.setCausaMuerte("Tristeza");
        }
        
        if(mascota.getComidasIngeridas() > 4){
            mascota.setCausaMuerte("Constipado");
        }
        if(mascota.getNivelSed() == 100){
            mascota.setCausaMuerte("Deshidratación");
        }
        
        if(mascota.getBebidasIngeridas() > 4){
            mascota.setCausaMuerte("Fallo Renal");
        }
      
    }
    
}
