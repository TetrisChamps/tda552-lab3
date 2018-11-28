import model.Car;
import model.Scania;
import model.Volvo240;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Volvo240();
    }

    @Test
    void getNrDoors() {
        assertEquals(4, car.getNrDoors());
    }

    @Test
    void maxSpeed() {
        assertEquals(100, car.maxSpeed());
    }

    @Test
    void getEngineOn() {
        assertFalse(car.getEngineOn());
    }

    @Test
    void startEngine() {
        car.startEngine();
        assertTrue(car.getEngineOn());
    }

    @Test
    void stopEngine() {
        car.startEngine();
        car.stopEngine();
        assertFalse(car.getEngineOn());
    }

    @Test
    void gas() {
        car.gas(1);
        assertEquals(0, car.getSpeed());
        car.startEngine();
        car.gas(1);
        assertEquals(car.maxSpeed() * 0.01 * 1.25, car.getSpeed());
    }

    @Test
    void speedFactor() {
        car = new Scania();
        assertEquals(4.0, car.speedFactor());
    }

    @Test
    void brake() {
        car.brake(1);
        assertEquals(0, car.getSpeed());
        car.startEngine();
        car.gas(1);
        car.brake(1);
        assertEquals(0, car.getSpeed());
    }

    @Test
    void turnLeft() {
        car.turnLeft();
        assertEquals(10, car.getRotation());
    }

    @Test
    void turnRight() {
        car.turnRight();
        assertEquals(350, car.getRotation());
    }
}