
package mascotavirtual.modelos;


public class DukeMascot extends Mascota {
    
    private static int count=0;
    
    

    public DukeMascot(String nombre, String propietario) {
        super(nombre, propietario);
        this.id=++count;
    }
    
    @Override
    
    public String toString() {
        return "La Mascota de nombre: " + nombre +'\n'
                + "nació el día " + fechaNacimiento.getDayOfWeek() + ","
                                  + fechaNacimiento.getDayOfMonth() + " de "
                                  + fechaNacimiento.getMonth() + " del año "
                                  + fechaNacimiento.getYear() + '\n'
                + "a la hora: "   + fechaNacimiento.getHour() + ":"
                                  + fechaNacimiento.getMinute() + "." + '\n' 
                + "Actualmente se encuentra " + ((isLive) ? "vivo\n" : "muerto\n")
                + "Su nivel de energía se encuentra en: " + nivelEnergia + "%\n"
                + "el nivel de hambre en: " + nivelHambre + '\n'
                + "el nivel de cansancio: " + nivelCansancio + '\n'
                + "el nivel de felicidad: " + nivelFelicidad + '\n'
                + "el nivel de aburrimiento: " + nivelAburrimiento + '\n'
                + "y su actual propietario es: " + propietario + '\n';
                
                
                
                }
    
 
    
    
}
