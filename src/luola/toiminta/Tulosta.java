/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola.toiminta;

import luola.domain.*;

/**
 *
 * @author sariannasallinen
 */
public class Tulosta {

    private Paikka luola;

    public Tulosta(Paikka luola) {
        this.luola = luola;
    }
    
    public void tulosta() {
        System.out.println(this.luola.getSiirtoja());
        System.out.println("");
        this.tulostaPaikat();
        System.out.println("");
        this.piirraLuola();
        System.out.println("");
        
    }
    
    private void tulostaPaikat() {
        System.out.println("@ " + this.luola.getPelaaja().getX() + " " + this.luola.getPelaaja().getY());
        this.hirvioidenPaikat();
    }
    
    private void hirvioidenPaikat() {
        this.luola.getHirviot().stream().forEach(h -> {
            int x = h.getX();
            int y = h.getY();
            System.out.println("h " + x + " " + y);
        });
    }

    public void piirraLuola() {
        String[][] piirrettava = this.asetaLuola();
        for (int i = 0; i < this.luola.getLeveys(); i++) {
            for (int j = 0; j < this.luola.getKorkeus(); j++) {
                System.out.print(piirrettava[i][j]);
            }
            System.out.print("\n");
        } 
    }
    
    private String[][] asetaLuola() {
        String[][] pohja = this.pisteet();
        pohja[this.luola.getPelaaja().getX()][this.luola.getPelaaja().getY()] = "@";

        this.luola.getHirviot().stream().forEach(h -> {
            int x = h.getX();
            int y = h.getY();
            pohja[x][y] = "h";
        });
        
        return pohja;
    }

    private String[][] pisteet() {
        String[][] tulos = new String[this.luola.getLeveys()][this.luola.getKorkeus()];
        for (int i = 0; i < this.luola.getLeveys(); i++) {
            for (int j = 0; j < this.luola.getKorkeus(); j++) {
                tulos[i][j] = ".";
            }
        }
        return tulos;
    }
}
