package com.wintrisstech;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static javax.imageio.ImageIO.read;

/***********************************************************************************************
 * Main Contrtol Class
 *
 * 4/1/19
 * Having problems with wheel timing, need to make Thomas' wheels time with speedTicker. SpeedTicker is commented out right now
 * Copyright David Frieder
 ***********************************************************************************************/
public class Control extends JComponent implements ActionListener, Runnable, KeyListener
{
    public Thomas thomas = new Thomas();
    Ground ground = new Ground();
    Track track = new Track();
    BackgroundObject backgroundObject = new BackgroundObject();
    Sky backgroundSky = new Sky();
    int thomasImageIndex = 0;
//    int thomasSpeed = 800;
//    Timer speedTicker = new Timer(thomasSpeed, this);
    Timer paintTicker = new Timer(50, this);
    boolean isThomasMovingLeft = false;
    boolean isThomasMovingRight = false;

    public static void main(String[] args)
    {
        System.out.println("ThomasFebruary" + "version 1.0, 3/17/19");
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
        JFrame gameWindow = new JFrame("Thomas the tank");
        gameWindow.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        gameWindow.add(this);// Adds the paint method to the JFrame
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setBackground(new Color(200, 235, 255));
        gameWindow.addKeyListener(this);
        gameWindow.setVisible(true);
        paintTicker.start();
//        speedTicker.start();
    }

    public void drawThomas()
    {
        thomas.getThomasSpriteImageArray();
        thomas.getReverseThomasImageArray();
    }

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if (isThomasMovingLeft)
        {
            g2.drawImage(thomas.getThomasSpriteImageArray()[thomasImageIndex], 500, 500, this);
        }
        if (isThomasMovingRight)
        {
            g2.drawImage(thomas.getReverseThomasImageArray()[thomasImageIndex], 500, 500, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == paintTicker)
        {
            repaint();
        }
        if (isThomasMovingLeft == true){
//            if (e.getSource() == speedTicker);
            {
                thomasImageIndex++;
                if (thomasImageIndex > 7)
                {
                    thomasImageIndex = 0;
                }
            }
        }
        if (isThomasMovingRight == true){
//            if (e.getSource() == speedTicker);
            {
                thomasImageIndex++;
                if (thomasImageIndex > 7)
                {
                    thomasImageIndex = 0;
                }
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            isThomasMovingLeft = true;
            isThomasMovingRight = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            isThomasMovingRight = true;
            isThomasMovingLeft = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            isThomasMovingLeft = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            isThomasMovingRight = false;
        }
    }
}

