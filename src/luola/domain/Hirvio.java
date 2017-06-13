/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola.domain;

/**
 *
 * @author sariannasallinen
 */

import java.util.List;
import java.util.Random;
public class Hirvio extends Liikkuva {
    private Random arpoja;
    
    public Hirvio(int leveys, int korkeus) {
        super(leveys,korkeus);
        this.arpoja = new Random();
        this.x = arpoja.nextInt(this.leveys);
        this.y = arpoja.nextInt(this.korkeus);
    }
    
    public String arvoSuunta() {
        String siirrot = "wsad";
        int valitse = arpoja.nextInt(4);
        return "" + siirrot.charAt(valitse);
    }

    
    

}
