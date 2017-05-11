/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombie;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Estudiante
 */
public class Nivel2 extends JPanel implements ActionListener, MouseListener {

    int x;
    int k;
    int y;
    private Timer timer;
    private int Delay = 20;
    private final Color color;
    private ArrayList<Rectangulo> rectangulos;
    private Zombie roberto = new Zombie(100, 300);
    
    public Nivel2() {
        timer = new Timer(Delay, this);
        this.addMouseListener(this);
        this.color = Color.ANTIQUEWHITE;
        timer.start();
        this.rectangulos = new ArrayList<>();
        llenarRectangulos();
    }

    public void llenarRectangulos() {
        int iniX = 500;
        int iniY = 0;
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            iniX += 60 + Math.abs(r.nextInt() % 71);
            iniY = 250 + Math.abs(r.nextInt() % 130);
            this.rectangulos.add(new Rectangulo(iniX, iniY));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
         
        Image ciudad = cargarImagen("calle.jpg");
        g.drawImage(ciudad, 0, 0, null);
        
        g.drawString("Colisiones", 600, 30);
        g.drawString(": " + roberto.getColisiones(), 670, 30);
        //100,360
        g.drawRect(roberto.getX(), roberto.getY(), roberto.getWidth(), roberto.getHeight());

        for (int i = 0; i < 20; i++) {
            int xr = x + this.rectangulos.get(i).getX();
            int yr = y + this.rectangulos.get(i).getY();
            if (rectangulos.get(i).getVidas() > 0) {
                g.drawRect(xr, yr, 60, 97);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x -= 1;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp = e.getPoint();
        for (Rectangulo rec : this.rectangulos) {
            if (rec.contains(mp, x, y)) {
                rec.setVidas(rec.getVidas() - 1);
            }
        }
    }

    public void DetectarColision() {

        for (Rectangulo rec : this.rectangulos) {
            if (roberto.intersects(rec)) {
                roberto.setColisiones(roberto.getColisiones() + 1);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public Image cargarImagen(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
