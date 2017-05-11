/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombie;

import java.awt.Point;

/**
 *
 * @author gipao
 */
public class Rectangulo {
    private int x;
    private int y;
    private int height=97;
    private int width=60;
    private int vidas=3;

    public Rectangulo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
   
    public boolean contains(Point mp,int offsetx,int offsety){
        if(((mp.x>=this.x+offsetx)&&(mp.x<= this.x+width+offsetx))&&
            (mp.y>=this.y+offsety)&&(mp.y<=this.y+height+offsety)){
         return true;   
        }
        return false;
    }
    
}
