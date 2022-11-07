package clases;

import java.util.LinkedList;
import java.util.Queue;

public class Juego {

    private Tablero tablero;

    public Juego(Tablero tab) {
        this.tablero = tab;
    }

    public Tablero buscar() {
        boolean bb = false;
        Queue<Tablero> cola = new LinkedList<Tablero>();
        cola.add(tablero);
        Tablero tabAux = null;

        while (!bb) {
            tabAux = cola.poll();
            if (tabAux.esMeta()) {
                bb = true;
            } else {
                for (Tablero t : tabAux.getHijos()) {
                    cola.add(t);
                }
            }
        }
        return tabAux;
    }
}
