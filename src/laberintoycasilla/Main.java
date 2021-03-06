package laberintoycasilla;

import busquedayestados.Busqueda;
import busquedayestados.Estado;

public class Main {

    public static void main(String[] args) {

        //Declaración e inicialización de los puntos de origen y destino
        Casilla puntoInicial, puntoFinal;
        puntoInicial = new Casilla(1, 0);
        puntoFinal = new Casilla(1, 4);

        //Desclaración del laberinto
        Laberinto labMain;
        labMain = new Laberinto();
        labMain.printLaberinto();

        //Declaración e inicializacion del Estado Incial y Final
        Estado inicio, fin;
        inicio = new Estado(puntoInicial, null, null);
        fin = new Estado(puntoFinal, null, null);

        //Inicializacion busqueda. 
        Busqueda actual1;
        actual1 = new Busqueda(inicio, fin);
        System.out.println(actual1.obtenerResultado());

    }

}
