package laberintoycasilla;


public class Casilla {
    public int x;
    public int y;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.x;
        hash = 43 * hash + this.y;
        return hash;
    }
    
    public Casilla(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    @Override
    public boolean equals(Object obj) {
    if(!(obj instanceof Casilla)) return false;
    return ((Casilla)obj).getX() == this.getX() &&
    ((Casilla)obj).getY() == this.getY();
    }
}
