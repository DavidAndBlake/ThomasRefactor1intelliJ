package com.wintrisstech;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

/***********************************************************************************************
 * Main Contrtol Class
 ***********************************************************************************************/
public class Control extends JComponent implements ActionListener, Runnable, KeyListener {
    public Thomas thomas = new Thomas();

    Ground ground = new Ground();
    Track track = new Track();
    int thomasAnimationSpeed = 80;
    BackgroundObject backgroundObject = new BackgroundObject();
    Sky backgroundSky = new Sky();
    int thomasImageIndex = 0;
    Timer thomasSpeedTicker = new Timer(50, this);
    Timer animationTicker = new Timer(thomasAnimationSpeed,this);
    boolean isThomasMovingLeft = false;
    boolean isThomasMovingRight = false;

    public static void main(String[] args) {
        System.out.println("ThomasFebruary" + "version 0.0, 1/25/19");
        SwingUtilities.invokeLater(new Control());
    }
    @Override
    public void run() {
        initializeGameWindow();
    }

    /***********************************************************************************************
     * Set up main JFrame
     ***********************************************************************************************/
    private void initializeGameWindow() {
        JFrame gameWindow = new JFrame("SuperGame");
        gameWindow.setTitle("Thomas the tank");
        gameWindow.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        gameWindow.add(this);// Adds the paint method to the JFrame
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setBackground(new Color(200, 235, 255));
        gameWindow.addKeyListener(this);
        gameWindow.setVisible(true);
        animationTicker.start();
    }

    public void drawThomas() {
        thomas.getThomasSpriteImageArray();
        thomas.getReverseThomasImageArray();
    }

    public void paint(Graphics g) {
        if (thomasImageIndex > 7) {
            thomasImageIndex = 0;
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.fillOval(100, 100, 100, 100);
        g2.drawImage(thomas.getThomasSpriteImageArray()[thomasImageIndex], 500, 500, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
//        if(e.getSource() == (animationTicker)){
//            thomasImageIndex++;
//        }
        if(isThomasMovingLeft == true){
            System.out.println(thomasImageIndex);
            thomasImageIndex++;
        }
        if(isThomasMovingRight == true){
            System.out.println(thomasImageIndex);
            thomasImageIndex++;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            isThomasMovingLeft = true;
            isThomasMovingRight = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            isThomasMovingRight = true;
            isThomasMovingLeft = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            isThomasMovingLeft = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            isThomasMovingLeft = false;
        }
    }
}

