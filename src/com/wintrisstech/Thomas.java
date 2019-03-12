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
//            thomasSpriteImageArray[0] = read(getClass().getResource("/Users/davidfrieder/git/ThomasRefactor1/src/Thomas1.png"));
//            thomasSpriteImageArray[1] = read(getClass().getResource("Thomas2.png"));
//            thomasSpriteImageArray[2] = read(getClass().getResource("Thomas3.png"));
            thomasSpriteImageArray[1] = ImageIO.read(new File("/Users/davidfrieder/git/ThomasRefactor1/src/pic1.PNG));
//            thomasSpriteImageArray[3] = read(getClass().getResource("Thomas4.png"));
//            thomasSpriteImageArray[4] = read(getClass().getResource("Thomas5.png"));
//            thomasSpriteImageArray[5] = read(getClass().getResource("Thomas6.png"));
//            thomasSpriteImageArray[6] = read(getClass().getResource("Thomas7.png"));
//            thomasSpriteImageArray[7] = read(getClass().getResource("Thomas8.png"));
//            reverseThomasImageArray[0] = read(getClass().getResource("ReversedThomas1.png"));
//            reverseThomasImageArray[1] = read(getClass().getResource("ReversedThomas2.png"));
//            reverseThomasImageArray[2] = read(getClass().getResource("ReversedThomas3.png"));
//            reverseThomasImageArray[3] = read(getClass().getResource("ReversedThomas4.png"));
//            reverseThomasImageArray[4] = read(getClass().getResource("ReversedThomas5.png"));
//            reverseThomasImageArray[5] = read(getClass().getResource("ReversedThomas6.png"));
//            reverseThomasImageArray[6] = read(getClass().getResource("ReversedThomas7.png"));
//            reverseThomasImageArray[7] = read(getClass().getResource("ReversedThomas8.png"));
        } catch (IOException e)
        {
            System.out.println("can't read the Thomas image");
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

