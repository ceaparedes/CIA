package busquedayestados;

import java.util.ArrayList;
import laberintoycasilla.Casilla;
import laberintoycasilla.Laberinto;

public class Busqueda {
    private Estado actual, meta;
    private ArrayList<Estado> abierto, cerrado; 

    
    public Busqueda(Estado actual, Estado meta){
        this.actual = actual;
        this.meta= meta;
        this.abierto = new ArrayList<>();
        this.cerrado = new ArrayList<>();
        
    }
    
     public String obtenerResultado(){
        StringBuilder str;
        ArrayList<String> resultado = iniciarBusqueda();
        int tam;
        
        if(resultado ==null)return null;
        
        str = new StringBuilder();
        tam = resultado.size();
        
        for(int contador =0; contador<tam;contador++){
            str.append("Paso ").append(contador +1).append(", ")
                    .append(resultado.get(contador)).append("\n");
        }
        
        return str.toString();
    }

  
    public ArrayList iniciarBusqueda(){
        boolean termino = false;
        ArrayList <String> resultado;
        ArrayList <Casilla> posicion;
        abierto.add(actual);
       
        while(!abierto.isEmpty() && !termino){
            actual= abierto.get(0);
            if (!cerrado.contains(actual)){
                cerrado.add(actual);
                expandir (actual);
            }
            if(actual.getPosicion1().equals(meta.getPosicion1())){
                termino=true;
            }
                abierto.remove(0);
         }
        if(!termino) return null;
        
        resultado = new ArrayList<>();
        posicion = new ArrayList<>();
     
         while(actual.getAntecesor()!=null){
         resultado.add(0,actual.toString());
         posicion.add(0,actual.getPosicion());
         actual = actual.getAntecesor();
         }
         System.out.println(posicion.get(0).x);
        return resultado;
    }
    
    public void expandir(Estado actual){
         Casilla position;
         Estado nuevo;
         
        if(actual.moverArriba()){   
         position = actual.getPosicion();
         position.x -=1;
         nuevo = new Estado(position,actual,"se ha movido hacia Arriba"); 
         abierto.add(nuevo);
     
        }
        
        
        if(actual.moverAbajo()){
         position = actual.getPosicion();
         position.x +=1;
         nuevo = new Estado(position,actual,"se ha movido hacia Abajo");
         abierto.add(nuevo);

        }
        
        if(actual.moverIzquierda()){
         position = actual.getPosicion();
         position.y -=1;
         nuevo = new Estado(position,actual,"se ha movido hacia la Izquierda");
         abierto.add(nuevo);
       
        }
        
        if(actual.moverDerecha()){
         position = actual.getPosicion();
         position.y +=1;
         nuevo = new Estado(position,actual,"se ha movido hacia la derecha");
         abierto.add(nuevo);
      
        }
    }
    }  
