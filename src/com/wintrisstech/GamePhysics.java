package com.wintrisstech;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GamePhysics
{
    boolean isGoingLeft;                                         //This is a copy of the boolean in the Control class
    boolean isGoingRight;                                        //This is a copy of the boolean in the Control class
    boolean isAcceleratingDueToGravity;
    int thomasSpeed = 0;                                         //An integer value that sets Thomas' speed to 0
    int thomasStaringVerticalSpeed = 0;
    int thomasCurrentVerticalSpeed = thomasStaringVerticalSpeed;
    int gravityAcceleration = 1;
    int thomasJumpingSpeed = 8;


    void thomasAcceleration(ActionEvent e)
    {
        if (isGoingLeft && thomasSpeed > -100) //negativeSpeed makes Thomas move left
        {              //Boolean that checks whether Thomas is moving left
            thomasSpeed--;            //Change in Thomas' speed
        }
        if (isGoingRight && thomasSpeed < 100) //positiveSpeed makes Thomas move right
        {             //Boolean that checks if Thomas is moving right
            thomasSpeed++;            //Changes Thomas' speed
        }
    }

    public int getThomasSpeed()
    {
        int thomasSpeed = this.thomasSpeed;
        return thomasSpeed;
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

//    @Override
//    public void actionPerformed(ActionEvent e)
//    {
//        thomasAcceleration(e);
//    }
}
