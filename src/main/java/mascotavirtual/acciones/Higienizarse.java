
package mascotavirtual.acciones;

import mascotavirtual.modelos.Mascota;


public class Higienizarse {
    
    public boolean tieneQueHigienizarse(Mascota mascota){
        return mascota.getJuegosRealizados() > 2;
    }
    
    public void higienizarse(Mascota mascota) {
        if(tieneQueHigienizarse(mascota)){
            mascota.setJuegosRealizados(mascota.getJuegosRealizados() - 2);
            mascota.setNivelFelicidad(mascota.getNivelFelicidad() + 5);
        }else{
            System.out.println("Esta mascota no necesita higienizarse.");
        }
    }

    
    
    
}
