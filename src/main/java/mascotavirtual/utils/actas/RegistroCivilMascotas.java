
package mascotavirtual.utils.actas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import mascotavirtual.modelos.Mascota;


public class RegistroCivilMascotas {
    
    static FileInputStream input;
    static FileOutputStream output;
    private static final String RUTA = "src/mascotaVirtual/utils/actas/";
    
    //Primero creamos el método que diseñará las actas
    
    public static void confeccionarActa(Mascota mascota){
        if(!mascota.getIsLive()){
            String actaDefuncion = "ACTA DE DEFUNCION DE " + mascota.getNombre()
                    +"\nFECHA DE FALLECIMIENTO: " + mascota.getFechaMuerte().toLocalDate()
                    +"\nA LA HORA: " + mascota.getFechaMuerte().toLocalTime().getHour()
                    +" : " + mascota.getFechaMuerte().toLocalTime().getMinute()
                    +"\nCAUSA MUERTE: " + mascota.getCausaMuerte().toString();
            mascota.setActaDefuncion(actaDefuncion);
            
        }else{
        
        String actaNacimiento = "ACTA DE NACIMIENTO DE " + mascota.getNombre()
                + "\nFECHA DE NACIMIENTO: " + mascota.getFechaNacimiento().toLocalDate()
                + "\nA LA HORA: " + mascota.getFechaNacimiento().toLocalTime().getHour()
                + " : " + mascota.getFechaNacimiento().toLocalTime().getMinute()
                +"\nSU FAMILIAR MÁS CERCANO ES:  " + mascota.getPropietario();
        mascota.setActaNacimiento(actaNacimiento);
        }
    }//fin método confeccionar Acta
    
    public static void guardarActa(Mascota mascota) {
        System.out.println();
        if(!mascota.getIsLive() && mascota.getActaDefuncion() !=null){
            try {
                output = new FileOutputStream (RUTA + mascota.getNombre() + "Defuncion" + ".txt");
                output.write(mascota.getActaDefuncion().getBytes());
                System.out.println("Acta de defunción archivada con éxito");
                output.close();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        try {
           output = new FileOutputStream (RUTA + mascota.getNombre() + "Nacimiento" + ".txt");
           output.write(mascota.getActaNacimiento().getBytes());
                System.out.println("Acta de nacimiento archivada con éxito");
                output.close();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
    }
    
    public static void leerActaNacimiento(Mascota mascota){
        try {
            input = new FileInputStream(RUTA + mascota.getNombre() + "Nacimiento" + ".txt");
            int contenido = input.read();
            while (contenido != -1){
                System.out.print((char) contenido);
                contenido = input.read();
              
            }
            input.close();
        }catch (FileNotFoundException e){
            System.out.println("No existe acta de nacimiento de la mascota " +  mascota.getNombre());
            
        }catch (IOException e){
            System.out.println("No se ha podido leer.");
            
        }finally {
            System.out.println("");
        }
        
        
        
    }
    
    public static void leerActaDefuncion(Mascota mascota){
        if (!mascota.getIsLive()){
        try {
            input = new FileInputStream(RUTA + mascota.getNombre() + "Defuncion" + ".txt");
            int contenido = input.read();
            while (contenido != -1){
                System.out.print((char) contenido);
                contenido = input.read();
              
            }
            input.close();
        }catch (FileNotFoundException e){
            System.out.println("No existe acta de defunción de la mascota " +  mascota.getNombre());
            
        }catch (IOException e){
            System.out.println("No se ha podido leer.");
            
        }finally {
            System.out.println("");
        }
        
        }
      
        
        
    }
    
    
    
    
}
