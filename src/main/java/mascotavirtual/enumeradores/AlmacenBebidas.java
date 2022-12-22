
package mascotavirtual.enumeradores;


public enum AlmacenBebidas {
    
    AGUA(15), MATE(10),JUGO(10),GASEOSA(5),VINO(1);
    
    private int hidratacionAportada;
    
    AlmacenBebidas(int hidratacion){
        this.hidratacionAportada=hidratacion;
    }
    
    public int getHidratacionAportada(){
        return hidratacionAportada;
    }
    
    
}
