

package laberintoycasilla;


public class Laberinto {
    
    private String laberinto [][];
    
    public Laberinto(){
       laberinto = new String [7][5];
       laberinto= construir(); 
       
    }
    public String [][] construir(){
       String Lab1[][]= {{"#","#","#","#","#"},
                         {"-","-","#","-","-"},
                         {"#","-","#","-","#"},
                         {"#","-","#","-","#"},
                         {"#","-","#","-","#"},
                         {"#","-","-","-","#"},
                         {"#","#","#","#","#"}};
       return Lab1;
  
    }
    
}