import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CBoton extends JButton implements ActionListener {
    // Utilizamos el ID para saber más adelante qué tipo de botón es este
    private ID id;


    // Constructor (llamado cuando un objeto de tipo CBoton es creado)
    public CBoton(ID id) {
        // Asignamos las variables privadas a las pasadas por parametro
        this.id = id;

        // Asignamos a este boton su texto
        this.setText(this.asString());

        // Conectamos el evento de boton presionado a nuestra funcion actionPerformed
        this.addActionListener(this::actionPerformed);
    }


    // Tipicos getters y setters para las variables privadas de la clase

    public ID getId() {
        return this.id;
    }

    public void setId(ID id) {
        this.id = id;
    }


    // -> Usamos actionPerformed (de la clase ActionListener) para cuando presionado,
    // llame a la función de esta clase, butonPresionado.
    // -> (Usamos el Override porque hemos heredado esta función de otra clase y queremos cambiar
    // o añadir funcionamentos a ella)
    @Override
    public void actionPerformed(ActionEvent e) {
        butonPresionado();
    }

    private void butonPresionado() {
        if (this.id == ID.Igual) {
            System.out.println("aa");
            solve();
            return;
        }

        Pantalla.contenido.addToTexto(this.asString());
    }

    private String asString() {
        switch (this.id) {
            case _0: return "0";
            case _1: return "1";
            case _2: return "2";
            case _3: return "3";
            case _4: return "4";
            case _5: return "5";
            case _6: return "6";
            case _7: return "7";
            case _8: return "8";
            case _9: return "9";
            case Suma: return " + ";
            case Resta: return " - ";
            case Mult: return " * ";
            case Igual: return " = ";
            default: return " Error: ID not found ";
        }
    }

    private void solve() {
        // i es la posición donde estamos, j será el desplazamiento a la izquierda o derecha respecto a i
        int i, j, start, end;
        // Vamos a desconstruir las operaciones en pares de operaciones
        // int a para el numero a la izquierda del operador y int b para el numero a la derecha del operador
        // a [op] b
        // El signo guardará 1 o -1, dependiendo de cuantos '-' haya a la izquierda del numero
        // Se usará solamente para el operador de la derecha
        float a, b, sgn;
        // StringBuilder nos permite editar las strings de una forma mucho más simple y rápida
        StringBuilder cuenta = new StringBuilder(Pantalla.contenido.getTexto());

        // Quitar los espacios del String
        for (i = 0; i < cuenta.length(); i++)
            // cuenta.charAt(i) == ' ' -> Si hemos encontrado un ' ' en esta posición
            if (cuenta.charAt(i) == ' ')
                // Hay que quitarle 1 a la i, ya que al borrar el char actual, pasamos al siguiente char y nos saltariamos un char al empezar la siguiente iteración
                cuenta.deleteCharAt(i--);

        // Cambiar a-b -> a+-b ( Asi pasa a ser una suma. No existen restas, solo sumas de numeros, que a su vez pueden ser o positivos o negativos )
        for (i = 0; i < cuenta.length(); i++)
            // i-1 >= 0                              -> Si todavia estamos en el string
            // cuenta.charAt(i) == '-'               -> Si hemos encontrado un '-' en esta posición
            // Character.isDigit(cuenta.charAt(i-1)) -> Si el char en la posición anterior al '-' es un numero
            if (i-1 >= 0 && cuenta.charAt(i) == '-' && Character.isDigit(cuenta.charAt(i-1)))
                // Insertamos en la posición anterior al '-', un '+'
                // Hay que añadirle 1 a la i, sino, al haber añadido un char en esta posición, el siguiente seguiría siendo el '-' (Entramos en bucle infinito y nos quedamos sin memoria, se crashea)
                cuenta.insert(i++, '+');

        // Sumar
        for (i = 0; i < cuenta.length(); i++)
            if (i-1 >= 0 && cuenta.charAt(i) == '+') {

                j = 1;
                a = 0;
                b = 0;
                sgn = 1;

                while (i-j >= 0 && Character.isDigit(cuenta.charAt(i-j))) {
                    if (j == 1)
                        a = Character.getNumericValue(cuenta.charAt(i-j));
                    else
                        a += Character.getNumericValue(cuenta.charAt(i-j)) * 10;
                    j++;
                }

                while (i-j >= 0 && cuenta.charAt(i-j) == '-') {
                    a *= -1;
                    j++;
                }

                j = 1;

                while (i+j < cuenta.length() && cuenta.charAt(i+j) == '-') {
                    sgn *= -1;
                    j++;
                }

                while (i+j < cuenta.length() && Character.isDigit(cuenta.charAt(i+j))) {
                    b = b * 10 + Character.getNumericValue(cuenta.charAt(i+j));
                    j++;
                }

                b *= sgn;
                System.out.println(a + b);
            }
    }


    // Los tipos de ID que puede tener un botón
    // (Cada id tiene por defecto una constante asignada a él)
    enum ID {
        _0,
        _1,
        _2,
        _3,
        _4,
        _5,
        _6,
        _7,
        _8,
        _9,
        Suma,
        Resta,
        Mult,
        Igual
    }
}
