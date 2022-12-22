

package com.becreative.mascotasvirtuales;

import java.time.LocalTime;
import mascotavirtual.enumeradores.AlmacenAlimentos;
import mascotavirtual.enumeradores.AlmacenBebidas;
import mascotavirtual.enumeradores.EntretenimientosEnum;
import mascotavirtual.modelos.DukeMascot;
import mascotavirtual.modelos.Mascota;
import mascotavirtual.persistencia.mysql.MySQLConnection;
import mascotavirtual.persistencia.persistenceCollections.MascotaPersistenceUseList;
import mascotavirtual.utils.actas.RegistroCivilMascotas;
import java.sql.Connection;


public class MascotasVirtuales {

    public static void main(String[] args) {
        MySQLConnection conexion = new MySQLConnection();
        
        Connection connection = conexion.establecerConexion();
        conexion.cerrarConexion(connection);
        
        
        
        /*
        MascotaPersistenceUseList persistence = new MascotaPersistenceUseList();

        DukeMascot duke01= new DukeMascot("Duke-Merlina", "Semper");
        DukeMascot duke02 = new DukeMascot("Moro","Luma");
        DukeMascot duke03 = new DukeMascot("Laika", "Luna");
        DukeMascot duke04 = new DukeMascot("Teo", "Marce");
                                
        //guardamos los datos de los objetos creados
        persistence.guardar(duke01);
        persistence.guardar(duke02);
        persistence.guardar(duke03);
        persistence.guardar(duke04);
        
                                                                        
        //Recorremos lista para verificar que los datos se hayan guardado correctamente.
        
        for(Mascota mascota : persistence.getAllMascotas()){
            System.out.println(mascota);
        }
        
        //Recorremos lista, pero solo accedemos a los nombres de las mascotas
        
        System.out.println("Lista completa de nombres de las mascotas:");
        for(Mascota mascota : persistence.getAllMascotas()){
            System.out.println(mascota.getNombre());
        }
        
          RegistroCivilMascotas.confeccionarActa(duke01);
          RegistroCivilMascotas.confeccionarActa(duke02);
          RegistroCivilMascotas.confeccionarActa(duke03);
          RegistroCivilMascotas.confeccionarActa(duke04);
          
          RegistroCivilMascotas.guardarActa(duke01);
          RegistroCivilMascotas.guardarActa(duke02);
          RegistroCivilMascotas.guardarActa(duke03);
          RegistroCivilMascotas.guardarActa(duke04);
          
          
        
        //Enviamos el mensaje de comer a una de las mascotas
        System.out.println("Veamos el nivel de energía de " + duke01.getNombre());
        System.out.println("Antes de comer " + duke01.getNivelEnergia());
        System.out.println(duke01.getNombre() + "a comer.");
        duke01.comer(AlmacenAlimentos.ASADO);
        duke01.comer(AlmacenAlimentos.PORORO);
        duke01.comer(AlmacenAlimentos.PORORO);
        duke01.comer(AlmacenAlimentos.PORORO);
        duke01.comer(AlmacenAlimentos.PORORO);
        
        
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

    }
}
