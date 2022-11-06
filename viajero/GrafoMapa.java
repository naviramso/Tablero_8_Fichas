package clases;

import java.util.ArrayList;
import java.util.HashMap;

public class GrafoMapa {

    private ArrayList<Nodo>[] listaAd;
    private String[] indices;
    private HashMap<String, Integer> tablaDistancias;
    private boolean dirigido;
    private int numNodos;

    public GrafoMapa(int n, boolean dirigido, HashMap<String, Integer> tablaDistancias) {
        this.listaAd = new ArrayList[n];
        this.indices = new String[n];
        this.dirigido = dirigido;
        this.tablaDistancias = tablaDistancias;
        this.numNodos = 0;
        inicializar();
    }

    private void inicializar() {
        for (int i = 0; i < listaAd.length; i++) {
            listaAd[i] = new ArrayList<Nodo>();
        }
    }

    public void agregarNodo(String no) {
        if (numNodos < listaAd.length) {
            indices[numNodos] = no;
            numNodos++;
        }
    }

    public void agregarArista(String o, String d, int costo) {
        int idOri = posNodo(o);
        int idDes = posNodo(d);
        if ((idOri != -1) && (idDes != -1)) {
            listaAd[idOri].add(new Nodo(costo, d));
            if (!dirigido) {
                listaAd[idDes].add(new Nodo(costo, o));
            }
        }
    }

    private int posNodo(String no) {
        int pos = -1;
        boolean salir = false;
        for (int i = 0; i < numNodos && !salir; i++) {
            if (indices[i].equals(no)) {
                pos = i;
                salir = true;
            }
        }
        return pos;
    }

    private ArrayList<Nodo> getVecinos(String nodo) {
        ArrayList<Nodo> res = new ArrayList<>();
        int pos = posNodo(nodo);
        if (pos != -1) {
            res = listaAd[pos];
        }
        return res;
    }

    public ArrayList<String> viajero(String nodoOrigen, String nodoDestino) {
        ArrayList<String> recorrido = new ArrayList<>();
        recorrido.add(nodoOrigen);
        int costoRuta = 0;
        viajero(nodoOrigen, nodoDestino, recorrido, costoRuta);
        return recorrido;
    }

    private void viajero(String nodoOrigen, String nodoDestino, ArrayList<String> recorrido, int costoRuta) {
        if (!nodoOrigen.equals(nodoDestino)) {
            ArrayList<Nodo> vecinos = getVecinos(nodoOrigen);
            Nodo sig = buscar(vecinos, costoRuta);
            if (sig != null) {
                recorrido.add(sig.getDestino());
                viajero(sig.getDestino(), nodoDestino, recorrido, costoRuta + sig.getCosto());
            }

        } else {
            System.out.println("Costo ruta: " + costoRuta);
        }
    }

    private Nodo buscar(ArrayList<Nodo> vecinos, int costoRuta) {
        Nodo res = null;
        if (!vecinos.isEmpty()) {
            Nodo min = vecinos.get(0);
            int minNodo = min.getCosto() + costoRuta + tablaDistancias.get(min.getDestino()).intValue();
            Nodo aux = null;
            int minAux = 0;
            for (int i = 1; i < vecinos.size(); i++) {
                aux = vecinos.get(i);
                minAux = aux.getCosto() + costoRuta + tablaDistancias.get(aux.getDestino()).intValue();
                if (minAux < minNodo) {
                    min = aux;
                    minNodo = minAux;
                }
            }
            res = min;
        }
        return res;
    }

}
