package model;

import java.awt.Color;
import java.util.List;

/**
 * A Ferry that transports cars
 */

public class CarFerry extends Vehicle implements ICarTransporter {

    private boolean inDock;
    private CarCarrier transporter;
    private double enginePower;

    /**
     * Initiates an instances of a model.CarFerry
     *
     * @param x           The start x coordinate of the ferry
     * @param y           The start y coordinate
     */
    public CarFerry(double x, double y) {
        super(Color.RED, "model.Car Ferry 101", x, y, 30000000);
        this.enginePower = 3000;
        transporter = new CarCarrier(300, 2000);
    }

    /**
     * Loads a car onto the ferry, if the car is already loaded it will throw an exception
     *
     * @param car The car to be loaded
     */
    @Override
    public void addCar(Car car) {
        if (inDock) {
            transporter.addCar(car, this);
        } else {
            throw new IllegalStateException("The ferry is not in a harbour");
        }
    }

    /**
     * Unloads a car from the ferry and returns a reference to the car, if the ferry is empty it will return null
     *
     * @return The unloaded car
     */

    @Override
    public Car removeCar() {
        Car car = null;
        if (inDock) {
            car = transporter.removeCar(true, this);
        }
        return car;
    }

    /**
     * Docks the ferry and enables it to load cars
     */
    public void dock() {
        if (getSpeed() == 0) {
            inDock = true;
        }
    }

    /**
     * Undocks the ferry, disables the ability to load cars
     */
    public void unDock() {
        if (getSpeed() == 0) {
            inDock = false;
        }
    }

    @Override
    public double speedFactor() {
        return maxSpeed() * 0.01;
    }

    @Override
    public double maxSpeed() {
        return enginePower * 0.01;
    }

    @Override
    public void turnLeft() {
        super.rotateVehicle(10);
    }

    @Override
    public void turnRight() {
        super.rotateVehicle(-10);
    }

    public List<Car> getCars(){
        return transporter.getCars();
    }

    public boolean docked(){
        return inDock;
    }
}
