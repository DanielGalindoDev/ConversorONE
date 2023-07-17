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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.util.EventListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mx.com.conversor.ObjetosTransformables.ObjetoConvertible;


/**
 * Descripcion general:
 *  Pantalla para convertir de un tipo de objeto a otro objeto del mismo tipo
 */
public class PantallaConvercion extends JFrame implements EventListener {
    private final JLabel ImagenIcono;
    private final JComboBox<String> Selector;
    private final JComboBox<String> Selector1;
    private final JTextField Entrada;
    private final JTextField Salida;
    private final JButton Atras;
    private final JButton Transformar;
    
    protected PantallaConvercion(ArrayList<ObjetoConvertible> TransformacionesDefinidas, ArrayList<Color> PaletaDeColores){
        Color colorFuerte=PaletaDeColores.get(0);
        Color colorClaro1=PaletaDeColores.get(1);
        Color colorClaro2=PaletaDeColores.get(2);
        Color colorContraste1=PaletaDeColores.get(3);
        Color colorContraste2=PaletaDeColores.get(4);
        File file = new File("./src/mx/com/conversor/Fuentes/DarkerGrotesque-Bold.ttf"); // Ruta de archivo de la fuente con extensión    
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(   15f);
        } catch (IOException | FontFormatException e) {
            System.out.println(e);
        }
        
        ImageIcon Logo = new ImageIcon("./src/mx/com/conversor/Imagenes/LogoBlanco_150x150px.png");
        
        this.setSize(410, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(colorClaro2);
        this.setTitle("ConversorONE");
        
        JPanel contentPane = new JPanel();
        contentPane.setBackground(colorFuerte);
        contentPane.setLayout(null);
        
        ImagenIcono = new JLabel(Logo);
        ImagenIcono.setBounds(10,20,150,150);
        contentPane.add(ImagenIcono);
        
        String[] Opciones = new String[TransformacionesDefinidas.size()];
        for(int i=0;i<TransformacionesDefinidas.size();i++){
            Opciones[i]=TransformacionesDefinidas.get(i).getNombre();
        }
        
        Selector = new JComboBox<>(Opciones);
        Selector.setBounds(170, 20, 200, 60);
        Selector.setFont(font);
        contentPane.add(Selector);
        
        Selector1 = new JComboBox<>(Opciones);
        Selector1.setBounds(170, 50, 200, 60);
        Selector1.setFont(font);
        contentPane.add(Selector1);
        
        Entrada=new JFormattedTextField();
        Entrada.setBounds(170, 100, 200, 30);
        Entrada.setForeground(Color.GRAY);
        Entrada.setText("Valor a convertir");
        Entrada.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Entrada.getText().equals("Valor a convertir")) {
                    Entrada.setText("");
                    Entrada.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Entrada.getText().isEmpty()) {
                    Entrada.setForeground(Color.GRAY);
                    Entrada.setText("Valor a convertir");
                }
            }
        });
        contentPane.add(Entrada);
        
        Salida=new JTextField();
        Salida.setBounds(170, 130, 200, 30);
        Salida.setEditable(false);
        contentPane.add(Salida);
        
        Atras =new JButton("Atras");
        Atras.setBounds(30,200,170,40);
        Atras.setBackground(colorClaro1);
        Atras.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            SelectorDeConvercion PantallaInicial= new SelectorDeConvercion(PaletaDeColores);
            PantallaInicial.setVisible(true);

        });
        contentPane.add(Atras);
        
        Transformar =new JButton("Convertir");
        Transformar.setBounds(200,200,170,40);
        Transformar.setBackground(colorClaro1);
        Transformar.addActionListener((ActionEvent e) -> {
            
            int Indice1 = Selector.getSelectedIndex();
            int Indice2 = Selector1.getSelectedIndex();
            try{
                
                int Valor = Integer.parseInt(Entrada.getText());
                double valorConvertido = ObjetoConvertible.convertir(TransformacionesDefinidas.get(Indice1), TransformacionesDefinidas.get(Indice2), Valor);
                Salida.setText(""+valorConvertido);
            }
            catch(NumberFormatException ex){
                
                JOptionPane.showMessageDialog(null,"Introduce solo valores numericos");
            }
            
        });
        contentPane.add(Transformar);
        
        this.setContentPane(contentPane);
    }

}

