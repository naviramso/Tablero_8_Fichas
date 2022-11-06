/**
 * Ficha
 */
import java.util.ArrayList;

public class Tablero {

    private char [][] tabla;
    private final char [][] tableroMeta = {{'1','2','3'},
                                           {'4','5','6'},
                                           {'7','8','x'}};

    public Tablero(){
       this.tabla = new char[3][3];
       tabla[0][0] = '1';
       tabla[0][1] = '2';
       tabla[0][2] = '6';
       tabla[1][0] = '3';
       tabla[1][1] = 'x';
       tabla[1][2] = '4';
       tabla[2][0] = '7';
       tabla[2][1] = '8';
       tabla[2][2] = '5';
    }

    public Tablero(char[][] cs){
        this.tabla = cs;
    }

    public ArrayList<Tablero> getHijos(){
        int [] vacio = getVacio();
        ArrayList<Tablero> hijos = new ArrayList<>();
        if(vacio[1] -1 > 0){
            char [][] tableroCopia = tabla.clone();
            char aux = tableroCopia[vacio[0]][vacio[1]-1];
            tableroCopia[vacio[0]][(vacio[1])] = aux;
            tableroCopia[vacio[0]][vacio[1]-1] = 'x';
            hijos.add(new Tablero(tableroCopia));
        } 

        if(vacio[1] +1 < 3){
            char [][] tableroCopia = tabla.clone();
            char aux = tableroCopia[vacio[0]][vacio[1]+1];
            tableroCopia[vacio[0]][(vacio[1])] = aux;
            tableroCopia[vacio[0]][vacio[1]+1] = 'x';
            hijos.add(new Tablero(tableroCopia));
        }

        if(vacio[0] -1 > 0){
            char [][] tableroCopia = tabla.clone();
            char aux = tableroCopia[vacio[0]-1][vacio[1]];
            tableroCopia[vacio[0]][(vacio[1])] = aux;
            tableroCopia[vacio[0]-1][vacio[1]] = 'x';
            hijos.add(new Tablero(tableroCopia));
        }

        if(vacio[0]+1 < 3){
            char [][] tableroCopia = tabla.clone();
            char aux = tableroCopia[vacio[0]+1][vacio[1]];
            tableroCopia[vacio[0]][(vacio[1])] = aux;
            tableroCopia[vacio[0]+1][vacio[1]] = 'x';
            hijos.add(new Tablero(tableroCopia));
        }
        return hijos;
    }

    private int[] getVacio(){
        int [] indice = new int[2];
        for(int i = 0; i < this.tabla.length ; i++){
            for(int j = 0; j < this.tabla[i].length; j++){
                if(this.tabla[i][j] == 'x'){
                    indice[0] = i;
                    indice[1] = j;
                }
            }
        }
        return indice;
    }

    public boolean esMeta(){
        for(int i = 0; i < this.tabla.length;i++){
            for(int j=0; j <this.tabla[i].length ; j++){
                if(tabla[i][j] != tableroMeta[i][j] ){
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] getTablero() {
        return tabla;
    }

    public void setTablero(char[][] tablero) {
        this.tabla = tablero;
    }    

    public String toString(){
        String imprimir = "";
        for(int i = 0; i < this.tabla.length;i++){
            for(int j=0; j <this.tabla[i].length ; j++){
                imprimir += tabla[i][j] + " ";
            }
            imprimir += "\n";
        }
        return imprimir;
    }

    public static void main(String[] args) {
        Tablero tab = new Tablero();
        System.out.println(tab.toString());
        System.out.println("******");
        for( Tablero t :  tab.getHijos()){
            System.out.println(t.toString());
        }

       
        
    }
}