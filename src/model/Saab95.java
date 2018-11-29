package model;

import java.awt.*;

/**
 * A representation of a SAAB 95 car
 */

public class Saab95 extends Car {

    private boolean turboOn;

    /**
     * Initiates a standard Saab95
     */
    public Saab95() {
        super(2, 125, Color.red, "Saab95", 0, 0, 1500);
        setTurboOff();
    }

    /**
     * Turns on the turbo, making the car accelerate faster
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Turn the turbo off
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Returns the true if the turbo is enabled, else returns false
     * @return boolean
     */
    public boolean isTurboOn() {
        return turboOn;
    }


    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return maxSpeed() * 0.01 * turbo;
    }
}
