package clases;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        char[][] tabla = {{'x', '1', '3'},
        {'4', '2', '5'},
        {'7', '8', '6'}};

        Tablero tablero = new Tablero(tabla, null);
        System.out.println(tablero);
        System.out.println("--------");
        Juego juego = new Juego(tablero);
        Tablero resultado = juego.buscar();
        System.out.println(resultado);
        System.out.println("Recorrido");
        ArrayList<Tablero> recorrido = new ArrayList<>();
        Tablero aux = resultado;
        while (aux != null) {
            recorrido.add(aux);
            aux = aux.getPadre();
        }
        for (int i = recorrido.size() - 1; i >= 0; i--) {
            System.out.println(recorrido.get(i));

        }

    }
}
