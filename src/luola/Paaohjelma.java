package luola;

import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Luola peli = new Luola(5,5,1,5,false);
        peli.run(lukija);
//        new Luola(10, 10, 5, 14, true).run(lukija);
    }
}
