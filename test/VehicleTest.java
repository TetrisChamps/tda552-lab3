import model.Vehicle;
import model.Volvo240;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        vehicle = new Volvo240();
    }

    @AfterEach
    void tearDown() {
        vehicle = null;
    }

    @Test
    void applyDeltaToAngle() {
        assertEquals(300, Vehicle.applyDeltaToAngle(0, -60));
    }

    @Test
    void getModelName() {
        assertEquals("model.Volvo240", vehicle.getModelName());
    }

    @Test
    void getColor() {
        assertEquals(Color.BLACK, vehicle.getColor());
    }

    @Test
    void move() {
        vehicle.move();
        assertEquals(0, vehicle.getX());
        assertEquals(0, vehicle.getY());
        ((Volvo240) vehicle).startEngine();
        vehicle.gas(1);
        vehicle.move();
        assertEquals(1.25, vehicle.getX());
        assertEquals(0, vehicle.getY());
    }

    @Test
    void speedFactor() {
        assertEquals(1.25, vehicle.speedFactor());
    }

    @Test
    void gas() {
        ((Volvo240) vehicle).startEngine();
        vehicle.gas(1);
        assertEquals(1.25, vehicle.getSpeed());
    }

    @Test
    void brake() {
        ((Volvo240) vehicle).startEngine();
        vehicle.gas(1);
        vehicle.gas(1);
        vehicle.brake(1);
        assertEquals(1.25, vehicle.getSpeed());
    }

    @Test
    void maxSpeed() {
        assertEquals(100, vehicle.maxSpeed());
    }

    @Test
    void getSpeed() {
        assertEquals(0, vehicle.getSpeed());
    }

    @Test
    void getRotation() {
        assertEquals(0, vehicle.getRotation());
    }

    @Test
    void rotateVehicle() {
        vehicle.rotateVehicle(10);
        assertEquals(10, vehicle.getRotation());
    }

    @Test
    void getX() {
        assertEquals(0, vehicle.getX());
    }

    @Test
    void getY() {
        assertEquals(0, vehicle.getY());
    }

    @Test
    void setPosition() {
        vehicle.setPosition(10, 15);
        assertEquals(10, vehicle.getX());
        assertEquals(15, vehicle.getY());
    }

    @Test
    void load() {
        vehicle.load();
        assertTrue(vehicle.isLoaded());
    }

    @Test
    void unload() {
        vehicle.unload();
        assertFalse(vehicle.isLoaded());
    }

    @Test
    void isLoaded() {
        assertFalse(vehicle.isLoaded());
    }

    @Test
    void getWeight() {
        assertEquals(1200, vehicle.getWeight());
    }
}