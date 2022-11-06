package clases;

import java.util.ArrayList;
import java.util.HashMap;

public class Ejecucion {

    public static void main(String[] args) {

        HashMap<String, Integer> tablaDistancias = new HashMap<>();
        tablaDistancias.put("Arad", 366);
        tablaDistancias.put("Timisoara", 329);
        tablaDistancias.put("Zerind", 374);
        tablaDistancias.put("Oradea", 380);
        tablaDistancias.put("Sibiu", 253);
        tablaDistancias.put("Rimnicu Vilcea", 193);
        tablaDistancias.put("Fagaras", 176);
        tablaDistancias.put("Craiova", 160);
        tablaDistancias.put("Pitesti", 100);
        tablaDistancias.put("Bucarest", 0);

        GrafoMapa mapa = new GrafoMapa(10, true, tablaDistancias);

        mapa.agregarNodo("Arad");
        mapa.agregarNodo("Timisoara");
        mapa.agregarNodo("Zerind");
        mapa.agregarNodo("Oradea");
        mapa.agregarNodo("Sibiu");
        mapa.agregarNodo("Rimnicu Vilcea");
        mapa.agregarNodo("Fagaras");
        mapa.agregarNodo("Craiova");
        mapa.agregarNodo("Pitesti");
        mapa.agregarNodo("Bucarest");

        mapa.agregarArista("Arad", "Zerind", 75);
        mapa.agregarArista("Arad", "Sibiu", 140);
        mapa.agregarArista("Arad", "Timisoara", 115);
        mapa.agregarArista("Zerind", "Oradea", 71);
        mapa.agregarArista("Oradea", "Sibiu", 151);
        mapa.agregarArista("Sibiu", "Fagaras", 99);
        mapa.agregarArista("Sibiu", "Rimnicu Vilcea", 80);
        mapa.agregarArista("Fagaras", "Bucarest", 211);
        mapa.agregarArista("Rimnicu Vilcea", "Pitesti", 97);
        mapa.agregarArista("Rimnicu Vilcea", "Craiova", 146);
        mapa.agregarArista("Craiova", "Pitesti", 138);
        mapa.agregarArista("Pitesti", "Bucarest", 101);

        System.out.println("Recorrido: " + mapa.viajero("Arad", "Bucarest").toString());

    }
}
