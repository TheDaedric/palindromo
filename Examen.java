package examen;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Examen extends JFrame implements ActionListener{
    private JButton puchar;
    private JLabel palindromo,repeticion,inversa,longitud,palabras;
    private JTextField palabra;
    private JLabel inversaR= new JLabel();
    private JLabel longitudR = new JLabel();
    private JLabel palindromoR = new JLabel();
    private JLabel repeticionR = new JLabel();
    
    public Examen(){
        super();
        ventana();
        componentes();
    }
    public void ventana(){
        this.setTitle("Examen :P");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void componentes(){
        puchar = new JButton();
        puchar.setText("Pucha para calcular");
        puchar.setBounds(200, 100, 150, 25);
        puchar.addActionListener(this);
        this.add(puchar);
        palabras = new JLabel();
        palabras.setText("Palabras");
        palabras.setBounds(125, 75, 100, 25);
        this.add(palabras);
        palabra = new JTextField();
        palabra.setBounds(200, 75, 150, 25);
        this.add(palabra);
        palindromo = new JLabel();
        palindromo.setText("Palindromo");
        palindromo.setBounds(125, 150, 100, 25);
        this.add(palindromo);
        longitud = new JLabel();
        longitud.setText("Longitud");
        longitud.setBounds(125, 175, 100, 25);
        this.add(longitud);
        inversa = new JLabel();
        inversa.setText("Inversa");
        inversa.setBounds(125, 200, 100, 25);
        this.add(inversa);
        repeticion = new JLabel();
        repeticion.setText("Repeticion");
        repeticion.setBounds(125, 225, 100, 25);
        this.add(repeticion);
        this.add(inversaR);
        this.add(longitudR);
        this.add(palindromoR);
        this.add(repeticionR);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int contador=0;
        String palabraObtenida = palabra.getText();
        char[] palabraArreglo=palabraObtenida.toCharArray();
        char[] palabraInversa= new char[palabraObtenida.length()];
        int y=palabraObtenida.length()-1;
        for(int x=0;x<palabraObtenida.length();x++){
            palabraInversa[x]=palabraArreglo[y];
            y--;
        }
        for(int x=0;x<palabraObtenida.length();x++){
            if(palabraArreglo[x]==palabraInversa[x]){
                contador++;
            }
        }
        String palindromoObtenido;
        if(contador==palabraObtenida.length()){
            palindromoObtenido="si";
        }else{
            palindromoObtenido="no";
        }
        String longitudObtenida=Integer.toString(palabraObtenida.length());
        String inversaObtenida = new String(palabraInversa);
        char[] auxiliar = new char[palabraObtenida.length()];
        y=0;
        for(int x=0;x<palabraObtenida.length();x++){
            contador=0;
            for(int i=0;i<palabraObtenida.length();i++){
                if(palabraArreglo[x]==palabraArreglo[i]){
                    contador++;
                }
            }
            if(contador>1){
                auxiliar[y]=palabraArreglo[x];
            }
            y++;
        }
        String repeticionObtenida = new String(auxiliar);
        repeticionR.setText(repeticionObtenida);
        repeticionR.setBounds(225, 225, 100, 25);
        inversaR.setText(inversaObtenida);
        inversaR.setBounds(225, 200, 100, 25);
        longitudR.setText(longitudObtenida);
        longitudR.setBounds(225, 175, 100, 25);
        palindromoR.setText(palindromoObtenido);
        palindromoR.setBounds(225,150,100,25);
    }
    public static void main(String[] args){
        Examen ventana = new Examen();
        ventana.setVisible(true);
    }
}
