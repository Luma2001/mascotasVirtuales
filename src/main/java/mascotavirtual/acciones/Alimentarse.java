
package mascotavirtual.acciones;

import mascotavirtual.enumeradores.AlmacenAlimentos;
import mascotavirtual.modelos.Mascota;


public class Alimentarse {
    
    private AlmacenAlimentos comida;//variable para poder acceder a la comida disponible
    
    public void ingerirAlimentos(AlmacenAlimentos comida, Mascota mascota){
        if(mascota.getIsLive()) {
                int nivelOriginal = mascota.getNivelEnergia();
                if(nivelOriginal==100){
                    System.out.println("Esta mascota no tiene hambre.");
                }else{
                    mascota.setNivelEnergia(mascota.getNivelEnergia()+ comida.getEnergiaAportada());
                    contabilizarComida(mascota);
                    disminuirHambre(mascota);
                    mascota.setNivelFelicidad(mascota.getNivelFelicidad() + 10);
                    
                    if(mascota.getPopo().tieneQueEvacuar(mascota)){
                        mascota.setNivelEnergia(mascota.getNivelEnergia()-15);
                        mascota.setNivelFelicidad(mascota.getNivelFelicidad() - 10);
                        System.out.println("Se siente mal, su energía desciende a " + mascota.getNivelEnergia());
                        Morir.checkStatusGeneral(mascota);
                        if(mascota.getIsLive()){
                            System.out.println("Esta mascota necesita ir al baño.");
                            
                        }
                        
                    }else{
                        Morir.checkStatusGeneral(mascota);
                        System.out.println("Esta mascota no necesita ir al baño.");
                        
                                
                    }
                    int nivelNuevo=mascota.getNivelEnergia();
                        if(nivelNuevo>=100){
                            mascota.setNivelHambre(0);
                        }
                    System.out.println("Mascota come " + comida + " y su energía sube a " + mascota.getNivelEnergia());   
                }    
                
        }else{
                Morir.checkStatusGeneral(mascota);
                System.out.println("Lo siento, esta mascota no se encuentra operativa desde " + mascota.getFechaMuerte());
        }    
    }//fin metodo IngerirAlimentos
  
    
    private void contabilizarComida(Mascota mascota){
        mascota.setComidasIngeridas(mascota.getComidasIngeridas() + 1);
    }
    
    private void disminuirHambre(Mascota mascota){
        mascota.setNivelHambre(mascota.getNivelHambre()-25);
    }
}  
    
    

