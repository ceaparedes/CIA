
package laberintoycasilla;
import busquedayestados.Busqueda;
import busquedayestados.Estado;


public class Main {

    public static void main(String[] args) {

        //Declaración e inicialización de los puntos de origen y destino
        Casilla puntoInicial, puntoFinal;
        puntoInicial = new Casilla(1,0);
        puntoFinal = new Casilla(1,4);
        
        //Desclaración del laberinto
        Laberinto labMain;
        labMain = new Laberinto();
        labMain.printLaberinto();
        
        
        //Declaración e inicializacion del Estado Incial y Final
        Estado inicio, fin;
        inicio = new Estado(puntoInicial,null,null,labMain);
        fin = new Estado(puntoFinal,null,null,labMain);
        
       //Inicializacion busqueda. 
        Busqueda actual1;
        actual1 = new Busqueda(inicio,fin,labMain);
        actual1.iniciarBusqueda();
        actual1.mostrarSolucion(fin);
        
    }
    
}
