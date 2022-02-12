import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Pantalla extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 650;

    public static Contenido contenido;

    public Pantalla() {
        contenido = new Contenido();
        this.add(contenido);

        // Inicializamos esta clase
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
    }
}
