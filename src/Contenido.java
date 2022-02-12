import javax.swing.*;
import java.util.LinkedList;

public class Contenido extends JPanel {
    private String texto ;
    private JLabel label;
    private LinkedList<CBoton> botones;
    private CBoton _0, _1, _2, _3, _4, _5, _6, _7, _8, _9, suma, resta, igual;

    public Contenido() {
        this.setSize(Pantalla.WIDTH, Pantalla.HEIGHT);
        this.setLayout(null);

        // Creamos los objetos necesarios para las variables de esta clase
        this.botones = new LinkedList<CBoton>();
        this.label = new JLabel();
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
        igual = new CBoton(CBoton.ID.Igual);

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
        botones.add(igual);

        // Posicionamos cada objeto
        int rows = 4; // N filas de botones
        int cols = 3; // N columnas de botones
        float btnHeight = (float) (Pantalla.HEIGHT/3)/rows; // Altura de los botones
        float btnWidth = (float) (Pantalla.WIDTH/cols); // Anchura de los botones

        // Los botones:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                botones.get(i*cols + j).setBounds((int) (j * btnWidth), (int) (Pantalla.HEIGHT/3 * 2 + i * btnHeight - 40), (int) btnWidth, (int) btnHeight);
            }
        }

        igual.setBounds((int) (1 * btnWidth), 100, (int) btnWidth, (int) btnHeight);

        // El texto donde aparecerán los numeros:
        label.setBounds(Pantalla.WIDTH/2 - 100, Pantalla.HEIGHT/4 - 25, 200, 50);

        // Adicionamos a la pantalla cada objeto creado anteriormente
        this.add(label);
        for (CBoton boton : botones)
            this.add(boton);
    }

    // Funciones setters y getters de las variables privadas de la clase

    public void setTexto(String texto) {
        this.texto = texto;
        this.label.setText(texto);
    }

    public String getTexto() {
        return texto;
    }

    // Funciones para facilitar el manejo del texto

    public void addToTexto(String s) {
        this.texto += s;
        this.label.setText(texto);
    }

    public void clearTexto() {
        this.texto = "";
        this.label.setText(texto);
    }
}
