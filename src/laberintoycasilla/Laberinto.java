package laberintoycasilla;

public class Laberinto {

    private String laberinto[][];

    public Laberinto() {
        laberinto = new String[7][5];
        laberinto = construir();

    }

    public String[][] construir() {
        String Lab1[][] = {
        {"#", "#", "#", "#", "#"},
        {"", "", "#", "", ""},
        {"#", "", "#", "", "#"},
        {"#", "", "#", "", "#"},
        {"#", "", "#", "", "#"},
        {"#", "", "", "", "#"},
        {"#", "#", "#", "#", "#"}};

        return Lab1;

    }

    public void printLaberinto() {
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 4; j++) {
                System.out.print(laberinto[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");

        }
    }

}
