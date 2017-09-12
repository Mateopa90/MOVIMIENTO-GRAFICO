/*
PLANTILLA BASE PARA CREACION DE ESCENARIOS.
 */
package Ejercicio0;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private int xrefC = 10;
    private int yrefC = 400;
    private int xrefO = 10;
    private int yrefO = 400;
    private int imagen = 0;
    private final int DELAY = 50;
    private Timer timer;
    
    public Board(){
        timer = new Timer(this.DELAY, this);
        timer.start();
    }
     @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Image fondo = LoadImage("fondo.png");
        g.drawImage(fondo, 0, 0 , null);
        
        g.setColor(Color.red);
        g.fillRect(xrefC+10, yrefC+30, 60, 20);
        
        g.setColor(Color.BLUE);
        int x[] = {xrefC+20, xrefC+30 , xrefC+50 , xrefC+60};
        int y[] = {yrefC+30, yrefC+15 , yrefC+15 , yrefC+30};
        g.fillPolygon(x, y, 4);
        
        g.setColor(Color.BLACK);
        g.fillOval(xrefC+15, yrefC+40 , 15, 15);
        
        g.setColor(Color.BLACK);
        g.fillOval(xrefC+45, yrefC+40 , 15, 15);
        
        g.drawRect(xrefC+10, yrefC+15, 60, 40);
        Rectangle carro = new Rectangle(this.xrefC+10, yrefC+15, 60, 40);
        
        g.setColor(Color.red);
        g.fillOval(xrefO+700, yrefC+10 , 50, 50);
        g.drawRect(xrefO+700, yrefC+10, 50 , 50);
        Rectangle ovalo = new Rectangle(this.xrefO+700, yrefC+10 , 50, 50);
        
        if (carro.intersects(ovalo)){
            //this.timer.stop();
        }
        Image cats = LoadImage("cats.gif");
        g.drawImage(cats, xrefC+20, 320, xrefC+20+132, 420, imagen*132, 0, (imagen*132)+132, 80, null);
        
        
        
        
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {
        this.xrefC += 5;
        this.xrefO -= 5;
        
        if(this.imagen == 6){
            this.imagen = 0;
        } else{
            this.imagen ++;
        }
        
        
        repaint();
    }
    
    public Image LoadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    } 
    
}