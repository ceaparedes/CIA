package busquedayestados;

import java.util.ArrayList;
import laberintoycasilla.Casilla;
import laberintoycasilla.Laberinto;

public class Busqueda {
    private Estado actual, meta;
    private ArrayList<Estado> abierto, cerrado; 
    private Laberinto labBusqueda;
    
    public Busqueda(Estado actual, Estado meta, Laberinto labBusqueda){
        this.actual = actual;
        this.meta= meta;
        this.labBusqueda = labBusqueda;  
    }

  
    public ArrayList iniciarBusqueda(){
        boolean termino = false;
        ArrayList <String> resultado;
        
        abierto.add(actual);
        System.out.println(""+actual);
        System.out.println("Posición actual = "+abierto.get(0).getPosicion());
     
        while(!abierto.isEmpty() && !termino){
            abierto.add(actual);
            actual= abierto.get(0);
              if (!cerrado.contains(actual)){
                cerrado.add(actual);
                expandir (actual, labBusqueda);
            }
            System.out.println("Actual: "+actual.toString());
            if(actual.getPosicion().equals(meta.getPosicion())){
                actual=meta;
                mostrarSolucion(actual);
                termino=true;
            }
            abierto.remove(0);
         }
        if(!termino) return null;
        
        resultado = new ArrayList<>();
     
         while(actual.getAntecesor()!=null){
         resultado.add(0,actual.toString());
         actual = actual.getAntecesor();

            
        }
        return resultado;
    }
    
    public void expandir(Estado actual, Laberinto labBusqueda){
         Casilla position;
         Estado nuevo;

        if(actual.moverArriba()){
         position = actual.getPosicion();
         position.x =-1;
         nuevo = new Estado(position,actual,"se ha movido hacia Arriba",labBusqueda); 
         System.out.println(""+ nuevo.getMovimiento());
         
         
        }
        
        
        if(actual.moverAbajo()){
         position = actual.getPosicion();
         position.x=+1;
         nuevo = new Estado(position,actual,"se ha movido hacia Abajo",labBusqueda);
         actual= abierto.remove(0);
        }
        
        if(actual.moverIzquierda()){
         position = actual.getPosicion();
         position.y =-1;
         nuevo = new Estado(position,actual,"se ha movido hacia la Izquierda",labBusqueda);
      
        }
        
        if(actual.moverDerecha()){
         position = actual.getPosicion();
         position.y =+1;
         nuevo = new Estado(position,actual,"se ha movido hacia la derecha",labBusqueda);
    
        }
    }      
    
    public void mostrarSolucion(Estado actual){
        
        Estado aux= actual;
        System.out.println(aux);
        ArrayList<String> mov = new ArrayList();
            
        while(aux !=null){
            mov.add(aux.getMovimiento());
            aux=aux.getAntecesor();
            }
        
        mov.remove(0);
        for(int i=0;i<mov.size();i++){
            System.out.println("Movimiento"+(i+1)+"-"+mov.get(i));
            
        }
        
       
        
    }
        }
        
 
    
    
