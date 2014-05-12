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
        this.abierto= new ArrayList<>();
        this.cerrado = new ArrayList<>();
       
    }

  
    public ArrayList iniciarBusqueda(){
        boolean termino = false;
        ArrayList <String> resultado;
        abierto.add(actual);
        
                  
        while(!abierto.isEmpty() && !termino){
           
            actual= abierto.get(0);
              if (!cerrado.contains(actual)){
                cerrado.add(actual);
                expandir (actual);
                System.out.println("pasa por aca");
                if(actual.getPosicion().equals(meta.getPosicion())){
                    System.out.println("pasa por el equals");
                    meta=actual;
                    mostrarSolucion(meta);
                    termino=true;
                    
            }
            abierto.remove(0);
            }
            
            
         }
        if(!termino) return null;
        
        resultado = new ArrayList<>();
     
         while(actual.getAntecesor()!=null){
         resultado.add(0,actual.toString());
         actual = actual.getAntecesor();

            
        }
        return resultado;
    }
   /* public Casilla getPosicion() {
        Casilla position = new Casilla(position.getX(),position.getY());
        return position;
    }*/
    
    public void expandir(Estado actual){
         Casilla position;
         Estado nuevo;

        if(actual.moverArriba()){
         position = actual.getPosicion();
         position.x -=1;
         System.out.println("Despues de Mover Arriba " +(position.x) +"-"+ (position.y));
         nuevo = new Estado(position,actual,"se ha movido hacia Arriba",labBusqueda); 
         System.out.println(""+ nuevo.getMovimiento());
         abierto.add(nuevo);
         
        }
        
        
        if(actual.moverAbajo()){
         position = actual.getPosicion();
         position.x+=1;
         nuevo = new Estado(position,actual,"se ha movido hacia Abajo",labBusqueda);
         abierto.add(nuevo);
        }
        
        if(actual.moverIzquierda()){
         position = actual.getPosicion();
         position.y -=1;
         nuevo = new Estado(position,actual,"se ha movido hacia la Izquierda",labBusqueda);
         abierto.add(nuevo);
        }
        
        if(actual.moverDerecha()){
         position = actual.getPosicion();
         position.y +=1;
         nuevo = new Estado(position,actual,"se ha movido hacia la derecha",labBusqueda);
         System.out.println("Despues de Mover Derecha " +(position.x)+ "," + (position.y));
         abierto.add(nuevo);
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
        
 
    
    

    
