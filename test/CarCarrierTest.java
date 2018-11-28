import model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarCarrierTest {

    private CarCarrier carrier;

    @BeforeEach
    void setUp() {
        carrier = new CarCarrier(10, 2000);
    }

    @AfterEach
    void tearDown() {
        carrier = null;
    }

    @Test
    void move() {
        CarTransporter transporter = new CarTransporter();
        carrier.addCar(new Volvo240(), transporter);
        carrier.addCar(new Volvo240(), transporter);
        carrier.move(10, 5);
        assertEquals(10, carrier.getCars().get(0).getX());
        assertEquals(5, carrier.getCars().get(0).getY());
        assertEquals(10, carrier.getCars().get(1).getX());
        assertEquals(5, carrier.getCars().get(1).getY());
    }

    @Test
    void addCar() {
        CarTransporter transporter = new CarTransporter();
        assertThrows(IllegalArgumentException.class, () -> carrier.addCar(transporter, transporter), "Cannot add itself to itself");
        Car c = new Saab95();
        carrier.addCar(c, transporter);
        Scania scania = new Scania();
        assertThrows(IllegalStateException.class, () -> carrier.addCar(scania, transporter), "model.Car is too heave");
        assertThrows(IllegalStateException.class, () -> carrier.addCar(c, transporter), "model.Car is already loaded");
        carrier = new CarCarrier(5, 2000);
        for (int i = 0; i < 5; i++) {
            carrier.addCar(new Saab95(), transporter);
        }
        assertThrows(IllegalStateException.class, () -> carrier.addCar(new Saab95(), transporter));
    }

    @Test
    void removeCar() {
        Car transporter = new Volvo240();
        assertEquals(null, carrier.removeCar(true, transporter));
        Car c = new Saab95();
        carrier.addCar(c, transporter);
        assertEquals(c, carrier.removeCar(false, transporter));
    }

    @Test
    void getCars() {
        assertEquals(carrier.getCars().size(), 0);
        Car transporter = new Volvo240();
        Car c1 = new Saab95();
        carrier.addCar(c1, transporter);
        Car c2 = new Saab95();
        carrier.addCar(c2, transporter);
        assertEquals(carrier.getCars().size(), 2);
    }
}