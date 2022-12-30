
package mascotavirtual.acciones;

import mascotavirtual.enumeradores.EntretenimientosEnum;
import mascotavirtual.modelos.Mascota;


public class Divertirse {
    
    public void entretenerseCon(EntretenimientosEnum entretenimiento, Mascota mascota){
        if(mascota.getIsLive()){
            int nivelOriginal = mascota.getNivelAburrimiento();
            if(nivelOriginal!=0){
                mascota.setNivelAburrimiento (mascota.getNivelAburrimiento() - entretenimiento.getDesaburrimiento());
                aumentarHambre(mascota);
                disminuirEnergia(mascota);
                aumentarCansancio(mascota);
                contabilizarJuegos(mascota);
                mascota.setNivelSed(mascota.getNivelSed() + entretenimiento.getDesaburrimiento() );
                
                int nivelNuevo = mascota.getNivelAburrimiento();
                if (nivelNuevo<0){
                    mascota.setNivelAburrimiento(0);
                }
                
                System.out.println("Mascota acaba de entretenerse con "
                        + entretenimiento
                        + " su nivel de Aburrimiento que estaba en " + nivelOriginal 
                        + " descendió a " + mascota.getNivelAburrimiento()
                        + " y su nivel de Felicidad ha aumentado a " + mascota.getNivelFelicidad());
                
                if(mascota.getLimpiarse().tieneQueHigienizarse(mascota)){
                        mascota.setNivelEnergia(mascota.getNivelEnergia()-5);
                        mascota.setNivelFelicidad(mascota.getNivelFelicidad() - 5);
                        System.out.println("la mascota se siente sucia, su nivel energía desciende a " + mascota.getNivelEnergia());
                        Morir.checkStatusGeneral(mascota);
                        if(mascota.getIsLive()){
                            System.out.println("Esta mascota necesita Higienizarse.");
                            
                        }
                }
                
            }else{
                System.out.println("Esta mascota no tiene necesidad de entretenerse, su nivel de aburrimiento es cero.");
            }
            
        }else{
            System.out.println("Lo siento, esta mascota no se encuentra operativa desde " + mascota.getFechaMuerte());
        }
    }//Fin metodo entretenerse
    
    private void aumentarHambre(Mascota mascota){
        mascota.setNivelHambre(mascota.getNivelHambre() + 25);
    }
    private void disminuirEnergia(Mascota mascota){
        mascota.setNivelEnergia(mascota.getNivelEnergia()-15);
    }
    
    private void aumentarCansancio(Mascota mascota){
        mascota.setNivelCansancio(mascota.getNivelCansancio() - 20);
    }
    
    private void contabilizarJuegos(Mascota mascota){
        mascota.setJuegosRealizados(mascota.getJuegosRealizados() + 1);
    }
    
    
}
