
package mascotavirtual.enumeradores;


public enum EntretenimientosEnum {
    
    PASEAR(20), FUTBOL(15), NADAR(20), POKER(5), ADIVINAR(15), BAILAR(10), CAZAR(10);
    
    
    private int desaburrimiento;
    
    EntretenimientosEnum(int desaburrimiento){
        this.desaburrimiento = desaburrimiento;
    }
    
    public int getDesaburrimiento(){
    return this.desaburrimiento;
    }
}
