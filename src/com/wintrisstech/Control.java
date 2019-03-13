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
public class Control extends JComponent implements ActionListener, Runnable, KeyListener
{
   public Thomas thomas = new Thomas();

    Ground ground = new Ground();
    Track track = new Track();
    BackgroundObject backgroundObject = new BackgroundObject();
    Sky backgroundSky = new Sky();
    int thomasImageIndex = 0;
    Timer ticker = new Timer(10,null);
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

        ticker.start();
        {
//            try
//            {
//                thomas.getThomasSpriteImageArray()[0] = read(getClass().getResource("Thomas1.png"));
//                thomas.getThomasSpriteImageArray()[1] = read(getClass().getResource("Thomas2.png"));
//                thomas.getThomasSpriteImageArray()[2] = read(getClass().getResource("Thomas3.png"));
//                thomas.getThomasSpriteImageArray()[3] = read(getClass().getResource("Thomas4.png"));
//                thomas.getThomasSpriteImageArray()[4] = read(getClass().getResource("Thomas5.png"));
//                thomas.getThomasSpriteImageArray()[5] = read(getClass().getResource("Thomas6.png"));
//                thomas.getThomasSpriteImageArray()[6] = read(getClass().getResource("Thomas7.png"));
//                thomas.getThomasSpriteImageArray()[7] = read(getClass().getResource("Thomas8.png"));
//                thomas.getReverseThomasImageArray()[0] = read(getClass().getResource("Reversed Thomas1.png"));
//                thomas.getReverseThomasImageArray()[1] = read(getClass().getResource("Reversed Thomas2.png"));
//                thomas.getReverseThomasImageArray()[2] = read(getClass().getResource("Reversed Thomas3.png"));
//                thomas.getReverseThomasImageArray()[3] = read(getClass().getResource("Reversed Thomas4.png"));
//                thomas.getReverseThomasImageArray()[4] = read(getClass().getResource("Reversed Thomas5.png"));
//                thomas.getReverseThomasImageArray()[5] = read(getClass().getResource("Reversed Thomas6.png"));
//                thomas.getReverseThomasImageArray()[6] = read(getClass().getResource("Reversed Thomas7.png"));
//                thomas.getReverseThomasImageArray()[7] = read(getClass().getResource("Reversed Thomas8.png"));
//            } catch (IOException e)
//            {
//                e.printStackTrace();
//            }

        }
    }
    public void drawThomas()
    {
     thomas.getThomasSpriteImageArray();
     thomas.getReverseThomasImageArray();
    }

    public void paint(Graphics g)
    {
        if(thomasImageIndex > 7){
            thomasImageIndex = 0;
        }
        Graphics2D g2 = (Graphics2D)g;
        g2.fillOval(100,100,100,100);
        g2.drawImage(thomas.getThomasSpriteImageArray()[thomasImageIndex], 500,500, this);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
//    if (ticker.){
//
//    }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_LEFT && ticker.isRepeats()){
            System.out.println(thomasImageIndex);
    thomasImageIndex++;
    }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }


}

