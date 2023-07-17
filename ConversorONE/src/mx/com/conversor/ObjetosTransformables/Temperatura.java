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
 *  //Descripcion
 *  //Descripcion
 *  //Descripcion
 *  //Descripcion
 * 
 */
public class Temperatura extends ObjetoConvertible {
    
    public Temperatura(String nombreDeLaDivisa, String regionDeOrigen) {
        super(nombreDeLaDivisa, regionDeOrigen);
    }
    public Temperatura(String nombreDeLaDivisa, String regionDeOrigen, String codigoDeDivisa) {
        super(nombreDeLaDivisa, regionDeOrigen,codigoDeDivisa);
    }
    public Temperatura(String nombreDeLaDivisa, String regionDeOrigen, String codigoDeDivisa,char simboloMonetario) {
        super(nombreDeLaDivisa, regionDeOrigen,codigoDeDivisa, simboloMonetario);
    }
}

