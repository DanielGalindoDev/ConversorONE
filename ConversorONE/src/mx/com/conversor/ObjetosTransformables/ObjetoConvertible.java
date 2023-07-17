/**
 *
 *  Esta aplicacion fue creada por Daniel Galindo:
 *      linkedin: https://www.linkedin.com/in/danielgalindoreyes/
 *      github: https://github.com/DanielGalindoDev
 *
 *  @author Daniel Galindo
 *  @version 1.0
 */

package mx.com.conversor.ObjetosTransformables;

//Libreriar requeridas
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;



/**
 * Descripcion general:
 *  Modela el comportamiento generico de
 *  cualquier ObjetoConvertible exitente o por existir.
 * 
 */

public abstract class ObjetoConvertible implements Serializable{
    
    private final String NOMBRE;
    private final String REGION_DE_ORIGEN;
    private final Map<ObjetoConvertible, Object> CONVERSIONES;
    private String codigo;
    private char símbolo;
    //Constructores
    
    /**
     * Contructor, genera el objeto solo inicializando 
     * la variable nombre y region de origen.
     * @param nombreDeLaDivisa
     * @param regionDeOrigen 
     */
    
    public ObjetoConvertible(String nombreDeLaDivisa, String regionDeOrigen) {
        this.codigo = null;
        this.NOMBRE = nombreDeLaDivisa;
        this.símbolo = ' ';
        this.REGION_DE_ORIGEN = regionDeOrigen;
        this.CONVERSIONES = new HashMap<>();
        CONVERSIONES.put((ObjetoConvertible)this,(double)1);
    }
    
    /**
     * Contructor, genera el objeto inicializando 
     * la variable nombre, region de origen y codigo de la divisa.
     * @param nombreDeLaDivisa
     * @param regionDeOrigen 
     * @param codigoDeDivisa 
     */
    public ObjetoConvertible(String nombreDeLaDivisa, String regionDeOrigen, String codigoDeDivisa) {
        this.codigo = codigoDeDivisa;
        this.NOMBRE = nombreDeLaDivisa;
        this.símbolo = ' ';
        this.REGION_DE_ORIGEN = regionDeOrigen;
        this.CONVERSIONES = new HashMap<>();
        CONVERSIONES.put((ObjetoConvertible)this,(double)1);
    }
    
    /**
     * Contructor, genera el objeto inicializando 
     * la variable nombre, region de origen, codigo de la divisa y simbolo Monetario.
     * @param nombreDeLaDivisa
     * @param regionDeOrigen 
     * @param codigoDeDivisa 
     * @param simboloMonetario 
     */
    public ObjetoConvertible(String nombreDeLaDivisa, String regionDeOrigen, String codigoDeDivisa,char simboloMonetario) {
        this.codigo = codigoDeDivisa;
        this.NOMBRE = nombreDeLaDivisa;
        this.símbolo = simboloMonetario;
        this.REGION_DE_ORIGEN = regionDeOrigen;
        this.CONVERSIONES = new HashMap<>();
        CONVERSIONES.put((ObjetoConvertible)this,(double)1);
    }
    /**
     * Determina el tipo de cambio de la convertible con respecto de otra.
     * 
     * @param convertible
     * @param FormulaDeConversion
     */
    
    public void asignaConversion(ObjetoConvertible convertible,Object FormulaDeConversion){
        this.getConversiones().put(convertible,FormulaDeConversion);        
    }
    
    /**
     * Toma una cantidad x en el objeto actual, y regresa su equivalente en la nueva
     * @param nueva
     * @param cantidadAConvertir
     * @return cantidad en la nueva divisa
     */
    public double convertirA(ObjetoConvertible nueva, Double cantidadAConvertir) {
        Object[] Formula = (Object[])this.getConversiones().get(nueva);
        Object[] Actual = new Object[Formula.length]; 
        System.arraycopy(Formula, 0, Actual, 0, Formula.length);
        Object[] Nueva;
        int contador=0;
        
        for(int i=0; i<Actual.length; i++){

            boolean Bandera=false;
            
            if(Actual.length-2>0){
                Nueva = new Object[Actual.length-2];
            }else{
                break;
            }
            System.out.println(Actual[i]+"     "+Actual[i+1]);
            if(Actual[i].getClass().equals(Double.class) && Actual[i+1].getClass().equals(Double.class)){
                if(Actual[i+2].getClass().equals(Double.class)){
                    continue;
                }
                if(Actual[i+2].equals("+")){     
                    Bandera=true;
                    Actual[i+1] = (Double)Actual[i]+(Double)Actual[i+1];
                    
                }else if(Actual[i+2].equals("-")){
                    Bandera=true;
                    Actual[i+1] = (Double)Actual[i]-(Double)Actual[i+1];
                    
                }else if(Actual[i+2].equals("*")){
                    Bandera=true;
                    Actual[i+1] = (Double)Actual[i]*(Double)Actual[i+1];                    
                }else if(Actual[i+2].equals("/")){
                    Bandera=true;
                    Actual[i+1] = (Double)Actual[i]/(Double)Actual[i+1];
                }else{
                    Actual[i+2]=cantidadAConvertir;
                    i=-1;
                }
            }
            if(Actual[i] != "+" && Actual[i] != "-" && Actual[i] != "*"&&Actual[i] != "/" && !Actual[i].getClass().equals(Double.class)){
                Actual[i]=cantidadAConvertir;
                i=-1;
            }
            if(Bandera){
                Actual[i]=(Double)0.0;
                Actual[i+2]=(Double)0.0;
                ReduccionDeFormula(Actual,Nueva);
                Actual=Nueva;
                i=-1;
            }
        }
        
        return (Double)Actual[0];    
    }
    
    /**
     * Toma una cantidad x en otro ObjetoCOnvertible, y regresa su equivalente en la actual
     * en caso de no estar definido el tipo de cambio, se regresara 0.
     * 
     * @param actual
     * @param cantidadAConvertir
     * @return cantidad en el actual objeto
     */
    public double convertirDe(ObjetoConvertible actual,double cantidadAConvertir){
        return actual.convertirA(this, cantidadAConvertir);
    }
    
    /**
     * Metodo de la clase, este metodo toma dos ObjetosTrasformables (actual, destino),
     * transforma de una a otra, si el tipo de cambio no esta definido se regresa 0.
     * 
     * @param actual
     * @param nueva
     * @param cantidadAConvertir
     * @return cantidad convertida
     */
    public static double convertir(ObjetoConvertible actual, ObjetoConvertible nueva, double cantidadAConvertir){
        return actual.convertirA(nueva,cantidadAConvertir);
    }
    
    private static void ReduccionDeFormula(Object[] actual,Object[] nuevo){
        int j=-1;
        for(int i=0;i<nuevo.length;i++){
            j++;
            if(actual[j].getClass()==Double.class){
                if((Double)actual[j]==0.0){
                    nuevo[i]=actual[j+1];
                    j+=2;
                    continue;
                }
            }
            nuevo[i]=actual[j];   
            
        }       
    }
    
    //Metodos getters
    
    public Map<ObjetoConvertible, Object> getConversiones() {
        return CONVERSIONES;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return NOMBRE;
    }

    public char getSímbolo() {
        return símbolo;
    }

    public String getRegionDeOrigen() {
        return REGION_DE_ORIGEN;
    }    
    
    //Metodos setter
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setSímbolo(char símbolo) {
        this.símbolo = símbolo;
    }
    
    //Sobreescritura de metodos

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        String divisa ="Tipo: " + this.getClass().getSimpleName()+ 
                      ", Nombre: " +this.getNombre()+ 
                      ", Lugar de origen: "+this.getRegionDeOrigen();
        return divisa;
    }

    /**
     *
     * @param convertible
     * @return
     */
    @Override
    public boolean equals(Object convertible){
        try{
            ObjetoConvertible divisa1 = (ObjetoConvertible) convertible;
            return divisa1.getNombre().equals(this.getNombre())&&
                    divisa1.getRegionDeOrigen().equals(this.getRegionDeOrigen())&&
                    divisa1.getClass().equals(this.getClass());
        }catch(Exception e){
            return false;            
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.getClass());
        hash = 59 * hash + Objects.hashCode(this.NOMBRE);
        hash = 59 * hash + Objects.hashCode(this.REGION_DE_ORIGEN);
        return hash;
    }

}

