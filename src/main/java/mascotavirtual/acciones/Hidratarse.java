
package mascotavirtual.acciones;

import mascotavirtual.enumeradores.AlmacenBebidas;
import mascotavirtual.modelos.Mascota;


public class Hidratarse {
   private AlmacenBebidas bebida;
   
   public void ingerirBebidas(AlmacenBebidas bebida, Mascota mascota){
        if(mascota.getIsLive()) {
                int nivelOriginal = mascota.getNivelSed();
                if(nivelOriginal==0){
                    System.out.println("Esta mascota no tiene sed.");
                }else{
                    mascota.setNivelSed(mascota.getNivelSed()- bebida.getHidratacionAportada());
                    contabilizarBebida(mascota);
                    mascota.setNivelFelicidad(mascota.getNivelFelicidad() + 10);
                    
                    if(mascota.getPipi().tieneQueOrinar(mascota)){
                        mascota.setNivelEnergia(mascota.getNivelEnergia()-10);
                        System.out.println("Se siente mal su energía desciende a " + mascota.getNivelEnergia());
                        mascota.setNivelFelicidad(mascota.getNivelFelicidad() - 10);
                        Morir.checkStatusGeneral(mascota);
                        if(mascota.getIsLive()){
                            System.out.println("Esta mascota necesita ir al baño.");
                            
                        }
                        
                    }else{
                        Morir.checkStatusGeneral(mascota);
                        System.out.println("Esta mascota no necesita ir al baño.");
                        
                                
                    }
                    
                    System.out.println("Mascota bebe " + bebida + " y su sed baja a " + mascota.getNivelSed());   
                }    
                
        }else{
                Morir.checkStatusGeneral(mascota);
                System.out.println("Lo siento, esta mascota no se encuentra operativa desde " + mascota.getFechaMuerte());
        }    
    }//fin metodo IngerirBebidas
  
   private void contabilizarBebida(Mascota mascota){
        mascota.setBebidasIngeridas(mascota.getBebidasIngeridas() + 1);
    }
    
   
}
