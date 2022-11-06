package clases;

public class Nodo {

    private String destino;
    private int costo;

    public Nodo(int costo, String destino) {
        this.destino = destino;
        this.costo = costo;
    }

    public String getDestino() {
        return destino;
    }

    public int getCosto() {
        return costo;
    }
}
