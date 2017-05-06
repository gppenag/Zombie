/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombie;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javafx.scene.paint.Color;
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

    public Nivel2() {
        timer = new Timer(Delay, this);
        this.addMouseListener(this);
        this.color = Color.ANTIQUEWHITE;
        timer.start();
        this.rectangulos = new ArrayList<>();
        llenarRectangulos();

    }

    public void llenarRectangulos() {
        for (int i = 0; i < 20; i++) {
            this.rectangulos.add(new Rectangulo(x,y));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawString("Colisiones", 600, 30);
        g.drawString(": xxx", 670, 30);
        
        g.drawRect( 100, 360, 80, 100);
        
        for (int i = 0; i < 20; i++) {
            int x = this.rectangulos.get( i ).getX( );
            int y = this.rectangulos.get( i ).getY( );
           
            this.rectangulos.get( i ).setX( this.x );
            g.drawRect(x + 500, y + 360, 60, 100);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x -= 1;
        repaint();
    }

    public Rectangle getBounds() {
        return new Rectangle(x + 10, 320, 120, 60);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp = e.getPoint();
        if (getBounds().contains(mp)) {
            this.timer.stop();
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

}
