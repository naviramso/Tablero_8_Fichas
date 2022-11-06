public class Main {
    public static void main(String[] args) {
        char [][] tabla = {{'x','1','3'},
                           {'4','2','5'},
                           {'7','8','6'}};

        Tablero tablero = new Tablero(tabla);
        System.out.println(tablero);
        System.out.println("--------");
        Juego juego = new Juego(tablero);
        System.out.print(juego.buscar().toString());
    
    }
}
