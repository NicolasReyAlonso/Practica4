package com.mycompany.practica4;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Nicolas, Ayoze
 */
public class lienzo extends JPanel {
    public Color colorB = Color.WHITE;
    public Color colorP = Color.BLACK;

    public void setColorB(Color colorB) {
        this.colorB = colorB;
    }

    public void setColorP(Color colorP) {
        this.colorP = colorP;
    }
    
    private MousePosition fifo[] = new MousePosition[5];
    private int iter = 0;
    {
        for (int i = 0; i<5; i++){
            fifo[i] = new MousePosition(0,0);
        }
    }
    
    @Override
    public void paintComponent(Graphics G){
        super.paintComponent(G);
        this.setBackground(colorB);
        this.setForeground(colorP);
        
        G.fillOval(fifo[0].getX(), fifo[0].getY(), 10, 10);
        G.fillOval(fifo[1].getX(), fifo[1].getY(), 10, 10);
        G.fillOval(fifo[2].getX(), fifo[2].getY(), 10, 10);
        G.fillOval(fifo[3].getX(), fifo[3].getY(), 10, 10);
        G.fillOval(fifo[4].getX(), fifo[4].getY(), 10, 10);    
    }
    public void add(MousePosition a) throws InterruptedException{
        if (iter == 5){iter = 0;}
        fifo[iter] = a;
        iter++;
    }

}
