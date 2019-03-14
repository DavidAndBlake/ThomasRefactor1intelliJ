package com.wintrisstech;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class Thomas

{
    private Image[] thomasSpriteImageArray = new Image[8];
    private Image[] reverseThomasImageArray = new Image[8];
    private AffineTransform thomasTransform = new AffineTransform();
    private Image thomasSpriteImage;
    private Image reverseThomasImage;
    private int thomasSpriteImageCounter;
    private int thomasMaxSpeed = 13;
    private int thomasYOffsetFromGround = 0;
    private Graphics2D g2;

    public Thomas()
    {
        try
        {
            thomasSpriteImageArray[0] = ImageIO.read(new File("src/Thomas1.png"));
            thomasSpriteImageArray[1] = ImageIO.read(new File("src/Thomas2.png"));
            thomasSpriteImageArray[2] = ImageIO.read(new File("src/Thomas3.png"));
            thomasSpriteImageArray[3] = ImageIO.read(new File("src/Thomas4.png"));
            thomasSpriteImageArray[4] = ImageIO.read(new File("src/Thomas5.png"));
            thomasSpriteImageArray[5] = ImageIO.read(new File("src/Thomas6.png"));
            thomasSpriteImageArray[6] = ImageIO.read(new File("src/Thomas7.png"));
            thomasSpriteImageArray[7] = ImageIO.read(new File("src/Thomas8.png"));
            reverseThomasImageArray[0] = ImageIO.read(new File("src/ReversedThomas1.png"));
            reverseThomasImageArray[1] = ImageIO.read(new File("src/ReversedThomas2.png"));
            reverseThomasImageArray[2] = ImageIO.read(new File("src/ReversedThomas3.png"));
            reverseThomasImageArray[3] = ImageIO.read(new File("src/ReversedThomas4.png"));
            reverseThomasImageArray[4] = ImageIO.read(new File("src/ReversedThomas5.png"));
            reverseThomasImageArray[5] = ImageIO.read(new File("src/ReversedThomas6.png"));
            reverseThomasImageArray[6] = ImageIO.read(new File("src/ReversedThomas7.png"));
            reverseThomasImageArray[7] = ImageIO.read(new File("src/ReversedThomas8.png"));
        } catch (IOException e)
        {
            System.out.println("Ln 46 can't read the Thomas image from thomas constructor");
        }
    }

    public Image[] getReverseThomasImageArray()
    {
        return reverseThomasImageArray;
    }

    public Image[] getThomasSpriteImageArray()
    {
        return thomasSpriteImageArray;
    }
}

