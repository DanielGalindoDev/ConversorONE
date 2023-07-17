/**
 *
 *  Esta aplicacion fue creada por Daniel Galindo:
 *      linkedin: https://www.linkedin.com/in/danielgalindoreyes/
 *      github: https://github.com/DanielGalindoDev
 *
 *  @author Daniel Galindo
 *  @version 
 */

package mx.com.conversor.ObjetosTransformables;


/**
 * Descripcion general:
 *  Genera una nueva divisa
 * 
 */
public class Divisa extends ObjetoConvertible{

    public Divisa(String nombreDeLaDivisa, String regionDeOrigen) {
        super(nombreDeLaDivisa, regionDeOrigen);
    }
    public Divisa(String nombreDeLaDivisa, String regionDeOrigen, String codigoDeDivisa) {
        super(nombreDeLaDivisa, regionDeOrigen,codigoDeDivisa);
    }
    public Divisa(String nombreDeLaDivisa, String regionDeOrigen, String codigoDeDivisa,char simboloMonetario) {
        super(nombreDeLaDivisa, regionDeOrigen,codigoDeDivisa, simboloMonetario);
    }
    
    
    @Override
    public void asignaConversion(ObjetoConvertible divisa,Object FactorDeConvercion){
        divisa.getConversiones().put(this, FactorDeConvercion);
        if((double)FactorDeConvercion!=0){            
            this.getConversiones().put(divisa, 1/(double)FactorDeConvercion);
        }else{
            divisa.getConversiones().put(this, FactorDeConvercion);
        }
        this.getConversiones().put((ObjetoConvertible)this,(double)1);
    }
    
    /**
     * Toma una cantidad x en la actual divisa, y regresa su equivalente en la nueva divisa
     * en caso de no estar definido el tipo de cambio, se regresara 0.
     * @param nuevaDivisa
     * @param cantidadAConvertir
     * @return cantidad en la nueva divisa
     */
    @Override
    public double convertirA(ObjetoConvertible nuevaDivisa, Double cantidadAConvertir){
        if(this.getConversiones().containsKey(nuevaDivisa)){
            return (double)this.getConversiones().get(nuevaDivisa)*cantidadAConvertir;
        }        
        return 0;
    }

}

