import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.LinkedList;
import java.util.Scanner;

public class Contenido extends JPanel {
    private Font font;
    private String texto;
    private JLabel label;
    private LinkedList<CBoton> botones;
    private CBoton _0, _1, _2, _3, _4, _5, _6, _7, _8, _9, suma, resta, mult, igual, reset;

    public Contenido() {
        this.setSize(Pantalla.WIDTH, Pantalla.HEIGHT);
        this.setLayout(null);
        this.setBackground(new Color(54, 54, 54));

        // Creamos los objetos necesarios para las variables de esta clase
        this.botones = new LinkedList<CBoton>();
        this.label = new JLabel();
        this.font = new Font("Tahoma", Font.PLAIN, 40);
        this.label.setFont(this.font);
        this.label.setForeground(Color.white);
        this.texto = new String();

        // Y creamos sus botones
        _0 = new CBoton(CBoton.ID._0);
        _1 = new CBoton(CBoton.ID._1);
        _2 = new CBoton(CBoton.ID._2);
        _3 = new CBoton(CBoton.ID._3);
        _4 = new CBoton(CBoton.ID._4);
        _5 = new CBoton(CBoton.ID._5);
        _6 = new CBoton(CBoton.ID._6);
        _7 = new CBoton(CBoton.ID._7);
        _8 = new CBoton(CBoton.ID._8);
        _9 = new CBoton(CBoton.ID._9);
        suma = new CBoton(CBoton.ID.Suma);
        resta = new CBoton(CBoton.ID.Resta);
        mult = new CBoton(CBoton.ID.Mult);
        igual = new CBoton(CBoton.ID.Igual);
        reset = new CBoton(CBoton.ID.Reset);

        // Añadimos cada boton a una lista, para facilitar su manejo
        // !!! El orden de adición a la lista afecta como se verán los botones !!! (Una fila son tres adiciones)
        botones.add(_1);
        botones.add(_2);
        botones.add(_3);
        botones.add(_4);
        botones.add(_5);
        botones.add(_6);
        botones.add(_7);
        botones.add(_8);
        botones.add(_9);
        botones.add(suma);
        botones.add(_0);
        botones.add(resta);
        botones.add(reset);
        botones.add(igual);
        botones.add(mult);

        System.out.println(botones.size());

        // Posicionamos cada objeto
        int rows = 5; // N filas de botones
        int cols = 3; // N columnas de botones
        float btnHeight = (float) (Pantalla.HEIGHT/3)/rows; // Altura de los botones
        float btnWidth = (float) (Pantalla.WIDTH/cols); // Anchura de los botones

        // Los botones:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                botones.get(i*cols + j).setBounds((int) (j * btnWidth), (int) (Pantalla.HEIGHT - btnHeight * rows + i * btnHeight - 35), (int) btnWidth, (int) btnHeight);
            }
        }

        // Adicionamos a la pantalla cada objeto creado anteriormente
        this.add(label);
        for (CBoton boton : botones)
            this.add(boton);
    }

    // Funciones setters y getters de las variables privadas de la clase

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
        updateText();
    }

    // Funciones para facilitar el manejo del texto

    public void addToTexto(String s) {
        this.texto += s;
        updateText();
    }

    public void clearTexto() {
        this.texto = "";
        updateText();
    }

    private void updateText() {
        this.label.setText(texto);
        this.label.setBounds(Pantalla.WIDTH/2 - getTextoPixelWidth()/2, Pantalla.HEIGHT/4 + getTextoPixelHeight()/2, Pantalla.WIDTH, 50);
    }

    private int getTextoPixelWidth() {
        return (int) this.font.getStringBounds(texto, new FontRenderContext( new AffineTransform(), true, true)).getWidth();
    }

    private int getTextoPixelHeight() {
        return (int) this.font.getStringBounds(texto, new FontRenderContext( new AffineTransform(), true, true)).getHeight();
    }
}
