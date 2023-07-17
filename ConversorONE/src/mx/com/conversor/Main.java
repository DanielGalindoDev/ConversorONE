/**
 *
 *  Esta aplicacion fue creada por Daniel Galindo:
 *      linkedin: https://www.linkedin.com/in/danielgalindoreyes/
 *      github: https://github.com/DanielGalindoDev
 *
 *  @author Daniel Galindo
 *  @version 1.0
 */
package mx.com.conversor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import mx.com.conversor.ObjetosTransformables.Temperatura;
import mx.com.conversor.graficas.SelectorDeConvercion;


/**
 * Descripcion general:
 *  Ejecuta la interfaz principal del conversor.
 * 
 */

public class Main {
    public static void main(String[] args){
        ArrayList <Color> PaletaDeColores=new ArrayList<>();
        
        PaletaDeColores.add(new Color(0x1B2021));
        PaletaDeColores.add(new Color(0x4CE0D2));
        PaletaDeColores.add(new Color(0x22AAA1));
        PaletaDeColores.add(new Color(0xB56576));
        PaletaDeColores.add(new Color(0xE56B6F));
        
        SelectorDeConvercion interfaz = new SelectorDeConvercion(PaletaDeColores);
        interfaz.setVisible(true);
    }

}

