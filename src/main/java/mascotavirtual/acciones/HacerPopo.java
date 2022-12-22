
package mascotavirtual.acciones;

import mascotavirtual.modelos.Mascota;


public class HacerPopo {

    public boolean tieneQueEvacuar(Mascota mascota){
        return mascota.getComidasIngeridas() > 2;
    }
    
    public void evacuar(Mascota mascota) {
        if(tieneQueEvacuar(mascota)){
            mascota.setComidasIngeridas(mascota.getComidasIngeridas() - 1);
            mascota.setNivelEnergia(mascota.getNivelEnergia() + 15);
            mascota.setNivelFelicidad(mascota.getNivelFelicidad() + 5);
        }else{
            System.out.println("Esta mascota no necesita evacuar.");
        }
    }
}
