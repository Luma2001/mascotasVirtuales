
package mascotavirtual.modelos;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import mascotavirtual.acciones.Alimentarse;
import mascotavirtual.acciones.Divertirse;
import mascotavirtual.acciones.Dormir;
import mascotavirtual.acciones.HacerPipi;
import mascotavirtual.acciones.HacerPopo;
import mascotavirtual.acciones.Hidratarse;
import mascotavirtual.acciones.Higienizarse;
import mascotavirtual.enumeradores.AlmacenAlimentos;
import mascotavirtual.enumeradores.AlmacenBebidas;
import mascotavirtual.enumeradores.EntretenimientosEnum;

public class Mascota {
    protected int id;                  
    protected String nombre;
    protected LocalDateTime fechaNacimiento;
    protected LocalDateTime fechaMuerte;
    protected boolean isLive;
    protected int nivelEnergia;
    protected int nivelHambre;
    protected int nivelSed;
    protected int nivelCansancio;
    protected int nivelFelicidad;
    protected int nivelAburrimiento;
    protected String propietario;
    protected Alimentarse alimentarse;
    protected Hidratarse hidratarse;
    protected Divertirse divertirse;
    protected Higienizarse limpiarse;
    public static LocalDateTime ultimoDescanso;
    protected Dormir descansar;
    protected int comidasIngeridas;
    protected int bebidasIngeridas;
    protected int juegosRealizados;
    protected HacerPopo popo;
    protected HacerPipi pipi;
    protected ArrayList<String> causaMuerte;
    protected String actaDefuncion;
    protected String actaNacimiento;
    
    //Método constructor vacío
    public Mascota(){
    }
    
    //método constructor que requiere dos datos al momento de la instaciacion: nombre y propietario
     
    public Mascota(String nombre, String propietario) {
        setId(id);            
        setNombre(nombre);
        setPropietario(propietario);
        setIsLive(true);
        setNivelEnergia(50);
        setNivelHambre(99);
        setNivelSed((int) (Math.random() * 100));
        setNivelCansancio((int) (Math.random() * 100));
        setNivelFelicidad((int) (Math.random() * 100));
        setNivelAburrimiento((int) (Math.random() * 100));
        setFechaNacimiento(LocalDateTime.now());
        this.alimentarse = new Alimentarse();
        this.hidratarse = new Hidratarse();
        this.divertirse = new Divertirse();
        this.descansar = new Dormir();
        this.limpiarse = new Higienizarse();
        setComidasIngeridas(0);
        setBebidasIngeridas(0);
        setJuegosRealizados(0);
        this.popo = new HacerPopo();
        this.pipi = new HacerPipi();
        this.causaMuerte = new ArrayList<>();
        setActaDefuncion(actaDefuncion);
        setActaNacimiento(actaNacimiento);    
    }
    
    //Métodos de la instancia__________________________________________________
    public void comer(AlmacenAlimentos alimento){
        alimentarse.ingerirAlimentos(alimento, this);
    }
    
    public void beber(AlmacenBebidas bebida){
        hidratarse.ingerirBebidas(bebida, this);
    }
    
    public void dormir(LocalTime tiempo){
        descansar.hacerDormir(tiempo, this);
    }
    
    public void jugar(EntretenimientosEnum entretenimiento){
        divertirse.entretenerseCon(entretenimiento, this);
    }
    
    public void irAlBaño(){
        popo.evacuar(this);
    }
    
    public void irAOrinar(){
        pipi.orinar(this);
    }
    
    public void tieneQueHigienizar(){
        limpiarse.higienizarse(this);
    }
    
    
    
    
    //get____________________________________________________________________
    public int getId() {
        return id;                         
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public LocalDateTime getFechaMuerte() {
        return fechaMuerte;
    }
    
    public boolean getIsLive() {
        return isLive;
    }
    
    public int getNivelEnergia() {
        return nivelEnergia;
    }
    
    public int getNivelHambre() {
        return nivelHambre;
    }
    
    public int getNivelSed(){
        return nivelSed;
    }
    
    public int getComidasIngeridas(){
        return comidasIngeridas;
    }
    
    public int getBebidasIngeridas(){
        return bebidasIngeridas;
    }
    
    public int getJuegosRealizados(){
        return juegosRealizados;
    }
    
    public HacerPopo getPopo(){
        return popo;
    }
    
    public HacerPipi getPipi(){
        return pipi;
    }
    
    public Higienizarse getLimpiarse(){
        return limpiarse;
    }
    
    public int getNivelCansancio() {
        return nivelCansancio;
    }
    public int getNivelFelicidad() {
        return nivelFelicidad;
    }
    public int getNivelAburrimiento() {
        return nivelAburrimiento;
    }
    
    public String getPropietario() {
        return propietario;
    }
    
    public ArrayList<String> getCausaMuerte(){
        return causaMuerte;
    }
    
    public String getActaDefuncion(){
        return actaDefuncion;
    }

    public String getActaNacimiento(){
        return actaNacimiento;
    }
    
    
    //private setters, lo cambiamos a public__________________________________
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFechaMuerte(LocalDateTime fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public void setIsLive(boolean isLive) {
        this.isLive = isLive;
    }

    public void setNivelEnergia(int nivelEnergia) {
        
        
        if(nivelEnergia>100){
            this.nivelEnergia=Math.min(100,nivelEnergia);
            
        }else{
            this.nivelEnergia = nivelEnergia;
        }
        
        if(nivelEnergia<0){
            this.nivelEnergia=Math.max(nivelEnergia,0);
        }
        
    }
    

    public void setNivelHambre(int nivelHambre) {
        if(nivelHambre>100){
            this.nivelHambre=Math.min(100,nivelHambre);
        }else{
            this.nivelHambre = nivelHambre;
        }
        if(nivelHambre<0){
            this.nivelHambre=Math.max(nivelHambre,0);
        } 
    }
    
    public void setNivelSed(int nivelSed) {
        if(nivelSed>100){
            this.nivelSed=Math.min(100,nivelSed);
        }else{
            this.nivelSed = nivelSed;
        }
        if(nivelSed<0){
            this.nivelSed=Math.max(nivelSed,0);
        } 
    }
    
    
    public void setComidasIngeridas(int comidasIngeridas) {
        this.comidasIngeridas = comidasIngeridas;
    }
    
    public void setBebidasIngeridas(int bebidasIngeridas) {
        this.bebidasIngeridas = bebidasIngeridas;
    }
    
    public void setJuegosRealizados(int juegosRealizados) {
        this.juegosRealizados = juegosRealizados;
    }

    public void setNivelCansancio(int nivelCansancio) {
       if(nivelCansancio>100){
            this.nivelCansancio=Math.min(100,nivelCansancio);
        }else{
            this.nivelCansancio = nivelCansancio;
        }
        if(nivelCansancio<0){
            this.nivelCansancio=Math.max(nivelCansancio,0);
        } 
    }

    public void setNivelFelicidad(int nivelFelicidad) {
        if(nivelFelicidad>100){
            this.nivelFelicidad=Math.min(100,nivelFelicidad);
        }else{
            this.nivelFelicidad = nivelFelicidad;
        }
        if(nivelFelicidad<0){
            this.nivelFelicidad=Math.max(nivelFelicidad,0);
        } 
    }

    public void setNivelAburrimiento(int nivelAburrimiento) {
        
        if(nivelAburrimiento>100){
            this.nivelAburrimiento=Math.min(100,nivelAburrimiento);
            
        }else{
            this.nivelAburrimiento = nivelAburrimiento;
        }
        
        if(nivelAburrimiento<0){
            this.nivelAburrimiento=Math.max(nivelAburrimiento,0);
        }
    }  

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    
    public void setPopo(HacerPopo popo){
        this.popo=popo;
    }
    
    public void setPipi(HacerPipi pipi){
        this.pipi=pipi;
    }
    
    public void setLimpiarse(Higienizarse limpiarse){
        this.limpiarse=limpiarse;
    }
    
    public void setCausaMuerte(String causaMuerte) {
        this.causaMuerte.add(causaMuerte);
    }

    public void setActaDefuncion(String actaDefuncion){
        this.actaDefuncion = actaDefuncion;
    }
    
    public void setActaNacimiento(String actaNacimiento){
        this.actaNacimiento = actaNacimiento;
    }
       
    
    
}
