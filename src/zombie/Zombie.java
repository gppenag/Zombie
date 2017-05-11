/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombie;

/**
 *
 * @author gipao
 */
public class Zombie {
   private int colisiones = 0;
   private int x;
   private int y;
   private int height=108;
   private int width=90;

    public Zombie(int x, int y) {
        this.x = x;
        this.y = y;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
   
   
   public int getColisiones() {
        return colisiones;
   }

    public void setColisiones(int colisiones) {
        this.colisiones = colisiones;
    }
    
    public boolean intersects(Rectangulo r){
       return false;
        
    }
    
   
}
