

package com.becreative.mascotasvirtuales;

import java.time.LocalTime;
import mascotavirtual.enumeradores.AlmacenBebidas;
import mascotavirtual.enumeradores.EntretenimientosEnum;
import mascotavirtual.modelos.DukeMascot;
import mascotavirtual.modelos.Mascota;
import mascotavirtual.persistencia.mysql.MySQLConnection;
import mascotavirtual.persistencia.persistenceCollections.MascotaPersistenceUseList;
import mascotavirtual.utils.actas.RegistroCivilMascotas;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import mascotavirtual.enumeradores.AlmacenAlimentos;
import mascotavirtual.persistencia.mysql.MascotaPersistenceUseMySQL;


public class MascotasVirtuales {

    public static void main(String[] args) {
       
        MySQLConnection conexion = new MySQLConnection();
        
        Connection connection = conexion.establecerConexion();
      //conexion.crearTabla(); //funciona ok
        
        
        
        
        /*
        
       //Creamos mascotas Duke
        DukeMascot duke01 = new DukeMascot("Merlina", "Semper");
        DukeMascot duke02 = new DukeMascot("Moro","Luma");
        DukeMascot duke03 = new DukeMascot("Laika", "Luna");
        DukeMascot duke08 = new DukeMascot("Teo", "Marce");
        DukeMascot duke09 = new DukeMascot("Aurelio", "Omar");
        DukeMascot duke10 = new DukeMascot("Belle", "Javier");
        DukeMascot duke11 = new DukeMascot("Luca","Javier");
        
        
        //Creamos objeto de MascotaPersistenceUseList*/
        
        //MascotaPersistenceUseList persistence = new MascotaPersistenceUseList();
                                       
        //guardamos los datos de los objetos creados
        
        /*
        persistence.guardar(duke02);
        persistence.guardar(duke03);
        persistence.guardar(duke08);
        persistence.guardar(duke09);
        persistence.guardar(duke10);
        persistence.guardar(duke11);
        */
        //Creamos objeto de MascotaPersistenceUseMySQL
        MascotaPersistenceUseMySQL persistenceUseBDMySQL = new MascotaPersistenceUseMySQL();
        //Guardamos registros en la tabla creada en línea 27
        //persistenceUseBDMySQL.guardar(duke01);
        //persistenceUseBDMySQL.guardar(duke02);
        //persistenceUseBDMySQL.guardar(duke03);
        //persistenceUseBDMySQL.guardar(duke08);
        //persistenceUseBDMySQL.guardar(duke09);
        //persistenceUseBDMySQL.guardar(duke10);
        //persistenceUseBDMySQL.guardar(duke11);
      
        
        /*
        //Leemos un registro(funciona ok)
        Mascota mascota = persistenceUseBDMySQL.getMascota(4);
        
        System.out.println("Consulta datos de Mascota"
                + "\n Nombre: " +mascota.getNombre()
                + "\n Fecha de Nacimiento: " + mascota.getFechaNacimiento()
                + "\n Propietario: " + mascota.getPropietario()
                + "\n Está vivo?: " + mascota.getIsLive());
        */
        
        
        
        
        //Leemos niveles de una mascota. (Funciona ok)
        Mascota elegida = persistenceUseBDMySQL.getMascota("Moro", "Luma");
        System.out.println("Los niveles de la mascota " + elegida.getNombre() + ", cuyo dueño es " + elegida.getPropietario() + ", son:"
                + "\n Nivel de Energia: " + elegida.getNivelEnergia()
                + "\n Nivel de Hambre: " + elegida.getNivelHambre()
                + "\n Nivel de Sed: " + elegida.getNivelSed()
                + "\n Nivel de Cansancio: " + elegida.getNivelCansancio() 
                + "\n Nivel de Felicidad: " + elegida.getNivelFelicidad()
                + "\n Nivel de Aburrimiento: " + elegida.getNivelAburrimiento()
                + "\n Está viva?: " + elegida.getIsLive()
                + "\n ID N° " + elegida.getId()
                + "\n");
         
        DukeMascot mascota = new DukeMascot(elegida.getNombre(),elegida.getPropietario());
        mascota.setId(elegida.getId());
        mascota.setNivelEnergia(elegida.getNivelEnergia());
        mascota.setNivelHambre(elegida.getNivelHambre());
        mascota.setNivelSed(elegida.getNivelSed());
        mascota.setNivelCansancio(elegida.getNivelCansancio());
        mascota.setNivelFelicidad(elegida.getNivelFelicidad());
        mascota.setNivelAburrimiento(elegida.getNivelAburrimiento());
        mascota.setIsLive(elegida.getIsLive());
        
        
        
        mascota.comer(AlmacenAlimentos.ASADO);
        mascota.jugar(EntretenimientosEnum.ADIVINAR);
        mascota.comer(AlmacenAlimentos.ASADO);
        mascota.comer(AlmacenAlimentos.PORORO);
        mascota.beber(AlmacenBebidas.AGUA);
        mascota.irAOrinar();
        
        
        System.out.println("Los niveles de la mascota " + mascota.getNombre() + ", cuyo dueño es " + mascota.getPropietario() + ", son:"
                + "\n Nivel de Energia: " + mascota.getNivelEnergia()
                + "\n Nivel de Hambre: " + mascota.getNivelHambre()
                + "\n Nivel de Sed: " + mascota.getNivelSed()
                + "\n Nivel de Cansancio: " + mascota.getNivelCansancio() 
                + "\n Nivel de Felicidad: " + mascota.getNivelFelicidad()
                + "\n Nivel de Aburrimiento: " + mascota.getNivelAburrimiento()
                + "\n Está viva?: " + mascota.getIsLive()
                + "\n ID N° " + mascota.getId()
                + "\n");
        
        
        
        
        //Actualizando Registro. (Funciona Ok)
        persistenceUseBDMySQL.updateMascota(4, mascota);
        
       
               
        
     /*   (funciona ok)    
    //Lectura Nivel de Felicidad de mascotas pertenecientes a un propietario
    List listaMascotas = persistenceUseBDMySQL.getMascota("Luna", true);
    for (Object dato : listaMascotas) {
      System.out.println(dato);
    }
        
        
    //Solicitamos lista completa de la base de datos_(funciona ok)
    List <Mascota> mascotasDeBD = persistenceUseBDMySQL.getAllMascotas();
    for (Mascota mascota : mascotasDeBD) {
        System.out.println("Los datos de " + mascota.getNombre() + ", son:"
                        + "\n Id: " + mascota.getId()+", "
                        + "\n Fecha de Nacimiento: " + mascota.getFechaNacimiento()
                        + "\n Propietario: " + mascota.getPropietario() 
                        + "\n Está vivo?: " + mascota.getIsLive() 
                        + "\n Nivel de Energia: " + mascota.getNivelEnergia()
                        + "\n Nivel de Hambre: " + mascota.getNivelHambre()
                        + "\n Nivel de Sed: " + mascota.getNivelSed()
                        + "\n Nivel de Cansancio: " + mascota.getNivelCansancio() 
                        + "\n Nivel de Felicidad: " + mascota.getNivelFelicidad()
                        + "\n Nivel de Aburrimiento: " + mascota.getNivelAburrimiento()
                        + "\n");
        
    }
    
    
      */  
        
        
        
         //Borramos un registro de la tabla(funciona ok)
        //persistenceUseBDMySQL.deleteMascota(2);
        
        
         /*                                                               
        //Recorremos lista para verificar que los datos se hayan guardado correctamente.Funciona ok
        
        for(Mascota mascota : persistence.getAllMascotas()){
            System.out.println(mascota);
        }
        */
        
       
        //Recorremos lista, pero solo accedemos a los nombres de las mascotas. funciona ok
        /*
        System.out.println("Lista completa de nombres de las mascotas:");
        for(Mascota mascota : persistence.getAllMascotas()){
            System.out.println(mascota.getNombre());
        }
        
        
        //Creamos actas de las mascotas.Funciona OK
          RegistroCivilMascotas.confeccionarActa(duke01);
          RegistroCivilMascotas.confeccionarActa(duke02);
          RegistroCivilMascotas.confeccionarActa(duke03);
          RegistroCivilMascotas.confeccionarActa(duke04);
          
          RegistroCivilMascotas.guardarActa(duke01);
          RegistroCivilMascotas.guardarActa(duke02);
          RegistroCivilMascotas.guardarActa(duke03);
          RegistroCivilMascotas.guardarActa(duke04);
          
          
        
        
        //Enviamos el mensaje de comer a una de las mascotas
        System.out.println("Veamos el nivel de energía de " + duke11.getNombre());
        System.out.println("Antes de comer " + duke11.getNivelEnergia());
        System.out.println(duke11.getNombre() + " a comer.");
        
        duke11.comer(AlmacenAlimentos.ASADO);
        duke11.comer(AlmacenAlimentos.PORORO);
        duke11.comer(AlmacenAlimentos.PORORO);
        duke11.comer(AlmacenAlimentos.PORORO);
        duke11.comer(AlmacenAlimentos.PORORO);
        */
        
        
        /*
        duke02.jugar(EntretenimientosEnum.ADIVINAR);
        duke02.jugar(EntretenimientosEnum.BAILAR);
        duke02.jugar(EntretenimientosEnum.CAZAR);
        duke02.jugar(EntretenimientosEnum.FUTBOL);
        duke02.jugar(EntretenimientosEnum.NADAR);
        duke02.jugar(EntretenimientosEnum.ADIVINAR);
        duke02.jugar(EntretenimientosEnum.PASEAR);
        
        
        RegistroCivilMascotas.guardarActa(duke01);
        System.out.println("Su nivel actual de energía es: " + duke01.getNivelEnergia());
        RegistroCivilMascotas.leerActaNacimiento(duke01);
        RegistroCivilMascotas.leerActaDefuncion(duke01);
        
        //Enviamos el mensaje de jugar a una de las mascotas
        System.out.println("Veamos el nivel de aburrimiento de " + duke02.getNombre() + ":");
        System.out.println("Antes de jugar: " + duke02.getNivelAburrimiento());
        duke02.jugar(EntretenimientosEnum.FUTBOL);
        System.out.println("Despues de jugar: " + duke02.getNivelAburrimiento());
        
        //hacemos descansar alguna de las mascotas
        System.out.println("Veamos el nivel de energía de una de las mascotas");
        System.out.println("Antes de dormir " +duke03.getNombre() + " tenía "+ duke03.getNivelEnergia());
        duke03.dormir(LocalTime.of(0,25));
        System.out.println("Después de dormir " + duke03.getNombre() + "tiene " + duke03.getNivelEnergia());
        
       
       //Chequeamos nivel de sed, lo hacemos beber e ir al baño
        System.out.println("Veamos el nivel de sed de " + duke01.getNombre());
        System.out.println("Su nivel de sed actual es: " + duke01.getNivelSed());
        System.out.println(duke01.getNombre() + "a beber.");
        duke01.beber(AlmacenBebidas.AGUA);
        duke01.beber(AlmacenBebidas.MATE);
        duke01.beber(AlmacenBebidas.GASEOSA);
      
        duke01.irAOrinar();
        duke01.irAOrinar();
        duke01.irAOrinar();
        duke01.irAOrinar();
        
        */
        
        
        /*
        //Mostramos datos por consola
        System.out.println(duke04);
        System.out.println(duke03);
        System.out.println(duke02);
        System.out.println(duke01);
        */

        
        
        conexion.cerrarConexion(connection);
    }
}
