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

import java.util.ArrayList;


/**
 * Descripcion general:
 *  Aqui se crearan las definiciones de convericon
 *  este archivo es el unico que se debe editar de ser nesesario
 *  modificar o agragar opciones de convercion
 * 
 */
public class DefinicionDeLasTransformaciones {
    
    public static ArrayList<ObjetoConvertible> DefinicionDeDivisas(){
        ArrayList<ObjetoConvertible> Divisas = new ArrayList<>();
        
            //Creamos monedas con su nacionalidad
            Divisa PesoMx = new Divisa("Peso","Mexico");
            Divisa DolarEU = new Divisa("Dolar","Estados Unidos");
            Divisa Euro =new Divisa("Euro","Union Europea");
            Divisa Libra = new Divisa("Libra Esterlina","Reino Unido");
            Divisa Yen = new Divisa("Yen","Japon");
            Divisa Won = new Divisa("Won","Sur corea");
            
            //Definimos los tipos de cambio
            //Peso Mexico
            PesoMx.asignaConversion(DolarEU, 16.85);
            PesoMx.asignaConversion(Euro, 18.92);
            PesoMx.asignaConversion(Libra, 22.11);
            PesoMx.asignaConversion(Yen, 0.12);
            PesoMx.asignaConversion(Won, 0.013);
            //Dolar Estadounidense
            DolarEU.asignaConversion(Euro, 1.12);
            DolarEU.asignaConversion(Libra, 1.31);
            DolarEU.asignaConversion(Yen, 0.0073);
            DolarEU.asignaConversion(Won, 0.00079);
            //Euro 
            Euro.asignaConversion(Libra, 1.17);
            Euro.asignaConversion(Yen, 0.0065);
            Euro.asignaConversion(Won, 0.00070);
            //Libra Esterlina
            Libra.asignaConversion(Yen, 0.0055);
            Libra.asignaConversion(Libra, 0.00060);
            //Yen Japones
            Yen.asignaConversion(Won, 0.11);
            
            Divisas.add(PesoMx);
            Divisas.add(DolarEU);
            Divisas.add(Euro);
            Divisas.add(Libra);
            Divisas.add(Yen);
            Divisas.add(Won);
            
        return Divisas;            
    }
    
    public static ArrayList<ObjetoConvertible> DefinicionDeTemperaturas(){
        ArrayList<ObjetoConvertible> Temperaturas = new ArrayList<>();
        
            //Creamos los tipos de temperaturas
            Temperatura Celsius=new Temperatura("°Celsius","");
            Temperatura Fahrenheit = new Temperatura("°Fahrenheit","");
            Temperatura Kelvin = new Temperatura("°Kelvin","");
            
            //Definimos las formulas de convercion en polish notation, dadas en forma de arreglo de objetos
            Object[] FahFah={"F",1.0,"*"};
            Object[] FahCel={"F",32.0,"-",1.8,"/"};
            Object[] FahKel={"F",459.67,"+",1.8,"/"};
            
            Object[] CelCel={"C",1.0,"*"};
            Object[] CelFah={"C",1.8,"*",32.0,"+"};
            Object[] CelKel={"C",273.15,"+"};
            
            Object[] KelKel={"K",1.0,"*"};
            Object[] KelCel={"K",459.67,"-"};
            Object[] KelFah={"K",1.8,"*",459.67,"-"};
            
            
            //asignamos convercion
            Fahrenheit.asignaConversion(Fahrenheit, FahFah);
            Fahrenheit.asignaConversion(Celsius, FahCel);
            Fahrenheit.asignaConversion(Kelvin, FahKel);
            
            Celsius.asignaConversion(Celsius, CelCel);
            Celsius.asignaConversion(Fahrenheit,CelFah);
            Celsius.asignaConversion(Kelvin, CelKel);
            
            Kelvin.asignaConversion(Kelvin,KelKel);
            Kelvin.asignaConversion(Celsius, KelCel);
            Kelvin.asignaConversion(Fahrenheit,KelFah);
            
            
            Temperaturas.add(Celsius);
            Temperaturas.add(Fahrenheit);
            Temperaturas.add(Kelvin);
            
        return Temperaturas;            
    }

}

