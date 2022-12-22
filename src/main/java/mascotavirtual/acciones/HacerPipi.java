
package mascotavirtual.acciones;

import mascotavirtual.modelos.Mascota;


public class HacerPipi {
  public boolean tieneQueOrinar(Mascota mascota){
        return mascota.getBebidasIngeridas() > 2;
    }
    
    public void orinar(Mascota mascota) {
        if(tieneQueOrinar(mascota)){
            mascota.setBebidasIngeridas(mascota.getBebidasIngeridas() - 1);
            mascota.setNivelEnergia(mascota.getNivelEnergia() + 10);
            mascota.setNivelFelicidad(mascota.getNivelFelicidad() + 5);
        }else{
            System.out.println("Esta mascota no necesita orinar.");
        }
        
    }
    
    
    
}
