package model;

import java.awt.*;

/**
 * A wheeled motor-driven vehicle
 */
public abstract class Car extends Vehicle {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private boolean engineOn = false; // Whether the engine is on or not

    //TODO: add @params
    /**
     * Initiates a car, based on certain physical attributes.
     *
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName, int x, int y, int weight) {
        super(color, modelName, x, y, weight);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        stopEngine();
    }

    /**
     * Returns how many doors the car has
     *
     * @return int
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Returns the engine power in terms of horse power.
     *
     * @return double
     */
    public double maxSpeed() {
        return enginePower * 1000 / getWeight();
    }

    /**
     * Returns the state of the engine, either on or off.
     *
     * @return boolean
     */
    public boolean getEngineOn() {
        return engineOn;
    }

    /**
     * Turns on the engine
     */
    public void startEngine() {
        if (!engineOn) {
            engineOn = true;
            gas(0.5);
        }
    }

    /**
     * Turns off the engine
     */
    public void stopEngine() {
        engineOn = false;
        stop();
    }

    /**
     * Applies the throttle between 0-1
     *
     * @param amount
     */
    public void gas(double amount) {
        if (engineOn && !isLoaded()) {
            super.gas(amount);
        }
    }

    @Override
    public double speedFactor() {
        return maxSpeed() * 0.01;
    }

    /**
     * Presses down the brake by a factor of 0-1
     *
     * @param amount
     */
    public void brake(double amount) {
        super.brake(amount);
    }


    @Override
    public void turnLeft() {
        rotateVehicle(10);
    }

    @Override
    public void turnRight() {
        rotateVehicle(-10);
    }
}
