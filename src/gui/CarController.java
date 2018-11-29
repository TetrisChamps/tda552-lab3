package gui;

import model.Car;
import model.Saab95;
import model.Scania;
import model.Volvo240;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Volvo240 v = new Volvo240();
        v.setPosition(0, 0);
        cc.cars.add(v);
        Saab95 s = new Saab95();
        s.setPosition(0, 100);
        cc.cars.add(s);
        Scania sc = new Scania();
        sc.setPosition(0, 200);
        cc.cars.add(sc);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void startCars() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopCars() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void brakeCars(double amount) {
        for (Car car : cars) {
            car.brake(amount);
        }
    }

    void turboOn() {
        for (Car car : cars) {
            try {
                ((Saab95) car).setTurboOn();
            } catch (Exception e) {
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            try {
                ((Saab95) car).setTurboOff();
            } catch (Exception e) {
            }
        }
    }

    void liftBed() {
        for (Car car : cars) {
            try {
                ((Scania) car).raiseBoard();
            } catch (Exception e) {
            }
        }
    }

    void lowerBed() {
        for (Car car : cars) {
            try {
                ((Scania) car).lowerBoard();
            } catch (Exception e) {
            }
        }
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                if (frame.drawPanel.isOutOfBounds(car.getClass(), car.getX(), car.getY())) {
                    car.stop();
                    BufferedImage i = frame.drawPanel.getImageFromClass(car.getClass());
                    if (car.getX() < 0) {
                        car.setPosition(0, car.getY());
                    } else {
                        car.setPosition(frame.drawPanel.getWidth() - i.getWidth(), car.getY());
                    }
                    car.invertDirection();
                    car.gas(1.0);
                }
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(car.getClass(), x, y);
                // repaint() calls the paintComponent method of the panel
            }
            frame.drawPanel.repaint();
        }
    }
}