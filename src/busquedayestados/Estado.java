package busquedayestados;

import laberintoycasilla.Casilla;
import laberintoycasilla.Laberinto;
import java.util.Objects;

public class Estado {

    private Casilla posicion;
    private Estado antecesor;
    private String movimiento;
    private Laberinto lab;

    public Estado(Casilla posicion, Estado antecesor, String movimiento) {
        this.posicion = posicion;
        this.antecesor = antecesor;
        this.movimiento = movimiento;
        lab = new Laberinto();
    }

    public boolean moverArriba() {

        String labe[][];
        labe = lab.construir();
        if ((posicion.x - 1) >= 0) {
            if (labe[posicion.x - 1][posicion.y] == "") {
                return true;
            }
        }
        return false;
    }

    public boolean moverAbajo() {
        String labe[][];
        labe = lab.construir();
        if (posicion.x + 1 < 7) {
            if (labe[posicion.x + 1][posicion.y] == "") {
                return true;
            }
        }
        return false;
    }

    public boolean moverIzquierda() {
        String labe[][];
        labe = lab.construir();
        if (posicion.y - 1 >= 0) {
            if (labe[posicion.x][posicion.y - 1] == "") {

                return true;
            }
        }
        return false;
    }

    public boolean moverDerecha() {
        String labe[][];
        labe = lab.construir();
        if (posicion.y + 1 < 5) {
            if (labe[posicion.x][posicion.y + 1] == "") {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.posicion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.getPosicion1(), other.getPosicion1())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "se ha movido a la Posición= (" + posicion.x + "),(" + posicion.y + ") }";
    }

    public Casilla getPosicion() {
        Casilla position = new Casilla(posicion.x, posicion.y);
        return position;
    }

    public Casilla getPosicion1() {
        return posicion;
    }

    public Estado getAntecesor() {
        return antecesor;
    }

    public String getMovimiento() {
        return movimiento;
    }
}
