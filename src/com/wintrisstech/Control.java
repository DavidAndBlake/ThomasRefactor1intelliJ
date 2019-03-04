package com.wintrisstech;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/***********************************************************************************************
 * Main Contrtol Class
 ***********************************************************************************************/
public class Control extends JComponent implements ActionListener, Runnable, KeyListener
{
   public Thomas thomas = new Thomas();
    Ground ground = new Ground();
    Track track = new Track();
    BackgroundObject backgroundObject = new BackgroundObject();
    Sky backgroundSky = new Sky();
    public static void main(String[] args)
    {
        System.out.println("ThomasFebruary" + "version 0.0, 1/25/19");
        SwingUtilities.invokeLater(new Control());

    }

    @Override
    public void run()
    {
        initializeGameWindow();
    }

    /***********************************************************************************************
     * Set up main JFrame
     ***********************************************************************************************/
    private void initializeGameWindow()
    {
        JFrame gameWindow = new JFrame("SuperGame");
        gameWindow.setTitle("Thomas the tank");
        gameWindow.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        gameWindow.add(this);// Adds the paint method to the JFrame
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setBackground(new Color(200, 235, 255));
        gameWindow.addKeyListener(this);
        gameWindow.setVisible(true);

    }
    public void drawThomas()
    {
     thomas.getThomasSpriteImageArray();
     thomas.getReverseThomasImageArray();
    }

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.fillOval(100,100,100,100);
//        g2.drawImage(thomas.getThomasSpriteImageArray()[0], 500,500, this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }


}

