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
 * 5/5/19
 * Copyright David Frieder 2019
 * Changed the nature of thomas's speed control
 ***********************************************************************************************/

//TODO if the left key is pressed, the speed will increase, and right will decrease
public class Control extends JComponent implements ActionListener, Runnable, KeyListener
{
    public Thomas thomas = new Thomas();
    Ground ground = new Ground();
    Track track = new Track();
    BackgroundObject backgroundObject = new BackgroundObject();
    Sky backgroundSky = new Sky();
    int thomasImageIndex = 0;
    double thomasSpeed = 7;
    double thomasSpeedInverter = 50 - thomasSpeed;
    Timer paintTicker = new Timer(20, this);
    //    Timer thomasSpeedTicker = new Timer(thomasSpeed,this);
    double tickerCounter;
    double temp;
    boolean isThomasMovingLeft = false;
    boolean isThomasMovingRight = false;
    boolean isThomasFacingLeft = true;
    boolean isThomasFacingRight = false;
    boolean isThomasJumping = false;
    double wheelMovementTimeInterval = 0;
    double wheelIncrementor = 50;
    Image thomasFacingForward = thomas.getThomasSpriteImageArray()[thomasImageIndex];
    Image thomasFacingReversed = thomas.getReverseThomasImageArray()[thomasImageIndex];

    public static void main(String[] args)
    {
        System.out.println("ThomasFebruary" + "version 1.1.1, 5/11/19");
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
//        thomasSpeedTicker.start();
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
            g2.scale(.5, .5);
            g2.drawImage(thomas.getArrowImages()[1], 700, 400, this);
            thomasSpeed-=.5;
//            if (thomasSpeed<2){
//                thomasSpeed++;
//            }
        }
        if (isThomasFacingLeft)
        {
            g2.drawImage(thomas.getThomasSpriteImageArray()[thomasImageIndex], 500, 500, this);
        }
        if (isThomasMovingRight)
        {
            g2.drawImage(thomas.getReverseThomasImageArray()[thomasImageIndex], 500, 500, this);
            g2.scale(.5, .5);
            g2.drawImage(thomas.getArrowImages()[0], 700, 400, this);
            thomasSpeed += .5;
        }
        if (isThomasFacingRight)
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
            tickerCounter++;
           if(thomasSpeed > 0){
               temp = tickerCounter % thomasSpeed;
           }

           if (tickerCounter % 2 == 0){
               thomasImageIndex++;
               thomasImageIndex %= 8;
               System.out.println(thomasImageIndex);
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
            isThomasFacingLeft = true;
            isThomasFacingRight = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            isThomasMovingRight = false;
            isThomasFacingRight = true;
            isThomasFacingLeft = false;
        }
    }
}

