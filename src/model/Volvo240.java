package model;

import java.awt.*;

/**
    A representation of a Volvo 240 car.
 */
public class Volvo240 extends Car{

    /**
     * The trim factor of the car, directly affects the acceleration of the car.
     */
    public final static double trimFactor = 1.25;

    /**
     * Initiates a standard volvo240
     */
    public Volvo240(){
        super(4,100,Color.black,"Volvo240", 0, 0, 1200);
    }

    /**
     * Gets the Volvo240 maximum acceleration, is based of the maxSpeed and the trimFactor of the car
     * @return Max acceleration
     */
    public double speedFactor(){
        return maxSpeed() * 0.01 * trimFactor;
    }
}
