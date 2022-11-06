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
       tabla[0][0] = '2';
       tabla[0][1] = '5';
       tabla[0][2] = '6';
       tabla[1][0] = '3';
       tabla[1][1] = '1';
       tabla[1][2] = '4';
       tabla[2][0] = '7';
       tabla[2][1] = '8';
       tabla[2][2] = 'x';
    }

    public Tablero(char[][] cs){
        this.tabla = cs;
    }

    public ArrayList<Tablero> getHijos(){
        int [] vacio = getVacio();
        ArrayList<Tablero> hijos = new ArrayList<>();
        if(vacio[1]  > 0){
            char [][] tableroCopia1 = clonar();
            char aux = tableroCopia1[vacio[0]][vacio[1]-1];
            tableroCopia1[vacio[0]][(vacio[1])] = aux;
            tableroCopia1[vacio[0]][vacio[1]-1] = 'x';
            hijos.add(new Tablero(tableroCopia1));
        } 

        if(vacio[1] < 2){
            char [][] tableroCopia2 = clonar();
            char aux = tableroCopia2[vacio[0]][vacio[1]+1];
            tableroCopia2[vacio[0]][(vacio[1])] = aux;
            tableroCopia2[vacio[0]][vacio[1]+1] = 'x';
            hijos.add(new Tablero(tableroCopia2));
        }

        if(vacio[0] > 0){
            char [][] tableroCopia3 = clonar();
            char aux = tableroCopia3[vacio[0]-1][vacio[1]];
            tableroCopia3[vacio[0]][(vacio[1])] = aux;
            tableroCopia3[vacio[0]-1][vacio[1]] = 'x';
            hijos.add(new Tablero(tableroCopia3));
        }

        if(vacio[0] < 2){
            char [][] tableroCopia4 = clonar();
            char aux = tableroCopia4[vacio[0]+1][vacio[1]];
            tableroCopia4[vacio[0]][(vacio[1])] = aux;
            tableroCopia4[vacio[0]+1][vacio[1]] = 'x';
            hijos.add(new Tablero(tableroCopia4));
        }
        return hijos;
    }

    public char[][] clonar(){
        char [][] clon = new char[3][3];
        for(int i = 0; i< this.tabla.length; i++){
            for(int j = 0 ; j< this.tabla[i].length ; j++){
                clon[i][j] = this.tabla[i][j];
            }
        }
        return clon;
    }

    public int[] getVacio(){
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