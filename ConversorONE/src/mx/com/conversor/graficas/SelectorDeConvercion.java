/**
 *
 *  Esta aplicacion fue creada por Daniel Galindo:
 *      linkedin: https://www.linkedin.com/in/danielgalindoreyes/
 *      github: https://github.com/DanielGalindoDev
 *
 *  @author Daniel Galindo
 *  @version 1.0
 */

package mx.com.conversor.graficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static mx.com.conversor.ObjetosTransformables.DefinicionDeLasTransformaciones.DefinicionDeDivisas;
import static mx.com.conversor.ObjetosTransformables.DefinicionDeLasTransformaciones.DefinicionDeTemperaturas;
import mx.com.conversor.ObjetosTransformables.ObjetoConvertible;


public class SelectorDeConvercion extends JFrame implements EventListener{
    private final JLabel Seleccion;
    private final JLabel ImagenIcono;
    private final JButton ElegirTemperatura;
    private final JButton ElegirDivisa;
    private final Color colorFuerte;
    private final Color colorClaro1;
    private final Color colorClaro2;
    private final Color colorContraste1;
    private final Color colorContraste2;
    
    
    public SelectorDeConvercion(ArrayList<Color> PaletaDeColores){
        
        colorFuerte=PaletaDeColores.get(0);
        colorClaro1=PaletaDeColores.get(1);
        colorClaro2=PaletaDeColores.get(2);
        colorContraste1=PaletaDeColores.get(3);
        colorContraste2=PaletaDeColores.get(4);
        
        File file = new File("./src/mx/com/conversor/Fuentes/DarkerGrotesque-Bold.ttf"); // Ruta de archivo de la fuente con extensión    
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(20f);
        } catch (IOException | FontFormatException e) {
            System.out.println(e);
        }
        
        ImageIcon Logo = new ImageIcon("./src/mx/com/conversor/Imagenes/LogoBlanco_150x150px.png");
        
        this.setSize(410, 200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(colorClaro2);
        this.setTitle("ConversorONE");
        
        JPanel contentPane = new JPanel();
        contentPane.setBackground(colorFuerte);
        contentPane.setLayout(null);
        
        Seleccion = new JLabel("Tipo de conversor");
        Seleccion.setForeground(colorClaro1);
        Seleccion.setBounds(190,20,200,40);
        Seleccion.setFont(font);
        contentPane.add(Seleccion);
        
        
        ImagenIcono = new JLabel(Logo);
        ImagenIcono.setBounds(10,10,150,150);
        contentPane.add(ImagenIcono);
        
        ElegirDivisa =new JButton("Divisas");
        ElegirDivisa.setBounds(190,70,150,35);
        ElegirDivisa.setBackground(colorClaro1);
        ElegirDivisa.addActionListener((ActionEvent e) -> {           
            PantallaConvercion Pantalla = new PantallaConvercion(DefinicionDeDivisas(), PaletaDeColores);
            Pantalla.setVisible(true);
            this.setVisible(false);            
        });
        contentPane.add(ElegirDivisa);
        
        ElegirTemperatura =new JButton("Temperaturas");
        ElegirTemperatura.setBounds(190,110,150,35);
        ElegirTemperatura.setBackground(colorClaro1);
        ElegirTemperatura.addActionListener((ActionEvent e) -> {
            PantallaConvercion Pantalla = new PantallaConvercion(DefinicionDeTemperaturas(), PaletaDeColores);
            Pantalla.setVisible(true);
            this.setVisible(false);            
        });
        
        contentPane.add(ElegirTemperatura);       
        this.setContentPane(contentPane);
    }

}

