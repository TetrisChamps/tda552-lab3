import model.Car;
import model.CarFerry;
import model.Saab95;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFerryTest {

    CarFerry carFerry;

    @BeforeEach
    void setUp() {
        carFerry = new CarFerry(0, 0);
    }

    @AfterEach
    void tearDown() {
        carFerry = null;
    }

    @Test
    void addCar() {
        Car car = new Saab95();
        try {
            carFerry.addCar(car);
            assertEquals(true, false);
        } catch (Exception e) {
            assertEquals(true, true);
        }
        carFerry.dock();
        carFerry.addCar(car);
        assertEquals(carFerry.getCars().size(), 1);
    }

    @Test
    void removeCar() {
        Car car = new Saab95();
        carFerry.dock();
        carFerry.addCar(car);
        carFerry.unDock();
        assertEquals(null, carFerry.removeCar());
        carFerry.dock();
        assertEquals(car, carFerry.removeCar());
    }

    @Test
    void dock() {
        carFerry.dock();
        assertEquals(carFerry.docked(), true);
    }

    @Test
    void unDock() {
        carFerry.unDock();
        assertEquals(carFerry.docked(), false);
    }

    @Test
    void speedFactor() {
        assertEquals(carFerry.speedFactor(), 0.3);
    }

    @Test
    void maxSpeed() {
        assertEquals(carFerry.maxSpeed(), 30);
    }

    @Test
    void turnLeft() {
        carFerry.turnLeft();
        assertEquals(carFerry.getRotation(), 10);
    }

    @Test
    void turnRight() {
        carFerry.turnRight();
        assertEquals(carFerry.getRotation(), 350);
    }
}