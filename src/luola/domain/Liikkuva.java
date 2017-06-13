/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola.domain;

import java.util.List;

/**
 *
 * @author sariannasallinen
 */
public abstract class Liikkuva {
    protected int x;
    protected int y;
    protected int leveys;
    protected int korkeus;

    public Liikkuva(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public boolean tormaa(List<String> muut, String paikka) {
        return muut.contains(paikka);
    }
    
    public String liiku(String suunta) {
        if(suunta.equals("w")) {
            if(this.x>=1) {
                return "" + (x-1) + y;
            }
        }
        
        if(suunta.equals("s")) {
            if(this.x<this.leveys-1) {
                return "" + (x+1) + y;
            }
        }
        
        if(suunta.equals("a")) {
            if(this.y>=1) {
                return "" + x + (y-1);
            }
        }
        
        if(suunta.equals("d")) {
            if(this.y<this.korkeus-1) {
                return "" + x + (y+1);
            }
        }
        
        return this.toString();
    }

    @Override
    public String toString() {
        return "" + x + y;
    }
    
    
    
}
