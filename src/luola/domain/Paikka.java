/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author sariannasallinen
 */
public class Paikka {

    private final int leveys;
    private final int korkeus;
    private final boolean liikkuuko;
    private List<Hirvio> hirviot;
    private final Pelaaja pelaaja;
    private int siirtoja;

    public Paikka(int leveys, int korkeus, int hirvioita, int siirtoja, boolean hirviotLiikkuvat) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.liikkuuko = hirviotLiikkuvat;
        this.siirtoja = siirtoja;
        this.pelaaja = new Pelaaja(leveys, korkeus);
        this.hirviot = new ArrayList();
        for (int i = 1; i <= hirvioita; i++) {
            this.hirviot.add(new Hirvio(leveys, korkeus));
        }
    }
   
    
    public boolean getLiikkuminen() {
        return this.liikkuuko;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }
    
    public void poistaHirvio(String paikka) {
        this.hirviot = this.hirviot
                .stream()
                .filter(h -> !h.toString().equals(paikka))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Hirvio> getHirviot() {
        return hirviot;
    }
    
    public List<String> hirvioidenPaikat() {
        ArrayList<String> paikat = this.hirviot
                .stream()
                .map(h -> h.toString())
                .collect(Collectors.toCollection(ArrayList::new));
        return paikat;
    }

    public int getSiirtoja() {
        return siirtoja;
    }

    public void vahenna() {
        this.siirtoja --;
    }
    
    
    
    

}
