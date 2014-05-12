package busquedayestados;
import laberintoycasilla.Casilla;
import laberintoycasilla.Laberinto;
import java.util.Objects;

public class Estado {
    private Casilla posicion;
    private Estado antecesor;
    private String movimiento;
    private Laberinto lab;
    
    public Estado(Casilla posicion, Estado antecesor, String movimiento, Laberinto lab){ 
       this.posicion= posicion;
       this.antecesor= antecesor;
       this.movimiento = movimiento;
       this.lab = lab;
  
    }
    public boolean moverArriba(){
        String labe[][];
        labe= lab.construir();
        if (posicion.x-1>=0){
        if ("-".equals(labe[posicion.x-1][posicion.y])){
            System.out.println("Se Puede Mover Hacia Arriba");
            return true;
        }
        }
        return false;
    }
     public boolean moverAbajo(){
        String labe[][];
        labe= lab.construir();
        if (posicion.x+1<7){
        if ("-".equals(labe[posicion.x+1][posicion.y])){
            System.out.println("se movio hacia abajo");
            return true;
        }
        }
        return false;
    }
      public boolean moverIzquierda(){
        String labe[][];
        labe= lab.construir();
        if (posicion.y-1>=0){
        if ("-".equals(labe[posicion.x][posicion.y-1])){
            System.out.println("se movio hacia la izquierda");
          
            
            return true;
        }
        }
        return false;
    }
      
       public boolean moverDerecha(){
        String labe[][];
        labe= lab.construir();
        if (posicion.y+1<5){
        if ("-".equals(labe[posicion.x][posicion.y+1])){   
            System.out.println("se movio a la derecha");
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
		        if(!(obj instanceof Estado)) return false;
		        return ((Estado)obj).getPosicion() == this.getPosicion();
		    }

    @Override
    public String toString() {
        return "Estado{" + "posicion=" + posicion + '}';
    }

    public Casilla getPosicion() {
        return posicion;
    }

    public Estado getAntecesor() {
        return antecesor;
    }

    public String getMovimiento() {
        return movimiento;
    }
}
