package com.wintrisstech;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class GamePhysics implements ActionListener
{
    Timer accelerationTicker = new Timer(50, this); //This will control the rate of change in Thomas' acceleration
    boolean isGoingLeft;                                         //This is a copy of the boolean in the Control class
    boolean isGoingRight;                                        //This is a copy of the boolean in the Control class
    boolean isAcceleratingDueToGravity;
    int thomasSpeed = 0;                                         //An integer value that sets Thomas' speed to 0
    int thomasStaringVerticalSpeed = 0;
    int thomasCurrentVerticalSpeed = thomasStaringVerticalSpeed;
    int gravityAcceleration = 1;
    int thomasJumpingSpeed = 8;

    GamePhysics()
    {                  //This is the constructor
        accelerationTicker.start(); //This starts the acceleration Ticker
    }

    void ThomasAcceleration(ActionEvent e)
    {
        if (isGoingLeft)
        {              //Boolean that checks whether Thomas is moving left
            thomasSpeed--;            //Change in Thomas' speed
        }
        if (isGoingRight)
        {             //Boolean that checks if Thomas is moving right
            thomasSpeed++;            //Changes Thomas' speed
        }
    }

    public void getThomasSpeed()
    {
        int thomasSpeed = this.thomasSpeed;
    }

    void GravityAcceleration()
    {
        if (isAcceleratingDueToGravity)
        {
            thomasCurrentVerticalSpeed += gravityAcceleration;
        }
    }

    void getThomasVerticalSpeed()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        ThomasAcceleration(e);
    }
}
