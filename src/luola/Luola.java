/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola;

import java.util.List;
import java.util.Scanner;
import luola.domain.Paikka;
import luola.toiminta.Tulosta;

/**
 *
 * @author sariannasallinen
 */
public class Luola {
    private Paikka luola;
    private Tulosta tulostus;

    public Luola (int leveys, int korkeus, int hirvioita, int siirtoja, boolean hirviotLiikkuvat) {
        this.luola = new Paikka(leveys,korkeus,hirvioita,siirtoja,hirviotLiikkuvat);
        this.tulostus = new Tulosta(luola);
    }

    public void run(Scanner lukija) {

        while (true) {
            if (this.luola.getSiirtoja() == 0) {
                System.out.println("HÄVISIT");
                break;
            }
            
            if(this.luola.getHirviot().isEmpty()) {
                System.out.println("VOITIT");
                break;
            }

            this.tulostus.tulosta();

            String komento = lukija.nextLine();
            this.siirraPelaaja(komento);
            if(this.luola.getLiikkuminen()) {
                this.siirraHirviot();
            }
            
            this.luola.vahenna();
        }

    }

    public void siirraHirviot() {
        this.luola.getHirviot().stream().forEach(h -> {
            String siirto = h.arvoSuunta();
            String uusiPaikka = h.liiku(siirto);
            List<String> muidenPaikat = this.luola.hirvioidenPaikat();
            muidenPaikat.remove(h.toString());
            if(!h.tormaa(muidenPaikat, uusiPaikka)) {
                int uusiX = Integer.parseInt(uusiPaikka.charAt(0) + "");
                int uusiY = Integer.parseInt(uusiPaikka.charAt(1) + "");
                h.setX(uusiX);
                h.setY(uusiY);
            }
        });
    }

    public void siirraPelaaja(String komento) {
        for (int i = 0; i < komento.length(); i++) {
            String uusiPaikka = this.luola.getPelaaja().liiku(komento.charAt(i) + "");
            this.luola.poistaHirvio(uusiPaikka);
            int uusiX = Integer.parseInt(uusiPaikka.charAt(0) + "");
            this.luola.getPelaaja().setX(uusiX);
            
            int uusiY = Integer.parseInt(uusiPaikka.charAt(1) + "");
            this.luola.getPelaaja().setY(uusiY);
        }
    }

}
