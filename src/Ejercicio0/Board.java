/*
PLANTILLA BASE PARA CREACION DE ESCENARIOS.
 */
package Ejercicio0;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private int xref = 10;
    private final int DELAY = 25;
    private Timer timer;
    
    public Board(){
        timer = new Timer(this.DELAY, this);
        timer.start();
    }
     @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(xref+10, 30, 60, 20);
        
        g.setColor(Color.BLUE);
        int x[] = {xref+20, xref+30 , xref+50 , xref+60};
        int y[] = {30, 15 , 15 , 30};
        g.fillPolygon(x, y, 4);
        
        g.setColor(Color.BLACK);
        g.fillOval(xref+15, 40 , 15, 15);
        
        g.setColor(Color.BLACK);
        g.fillOval(xref+45, 40 , 15, 15);
    }
   
    /*  private void dibujarEscenario(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        //the first two parameters are the position (x,y) and after comes the width and the height
        g2d.fillOval(0, 0, 30, 30);
        g2d.drawOval(0, 50, 30, 30);
               
        g2d.fillRect(50, 0, 30, 30); 
        g2d.drawRect(50, 50, 30, 30);
        
        g2d.drawString("Puntaje del Juego", 100, 100);
        
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        this.xref += 1;
        repaint();
    }
}