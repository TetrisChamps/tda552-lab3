import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    Saab95 saab95;

    @BeforeEach
    void setUp()
    {
        saab95 = new Saab95();
    }

    @Test
    void isTurboOn(){
        saab95.setTurboOn();
        assertEquals(true, saab95.isTurboOn(), "default is true, got false" );
    }

    @Test
    void setTurboOn() {
        saab95.setTurboOn();
        assertEquals(true, saab95.isTurboOn(), "Gives false");
    }

    @Test
    void setTurboOff() {
        saab95.setTurboOff();
        assertEquals(false, saab95.isTurboOn(), "Gives true");
    }

    @Test
    void speedFactor() {
        saab95.setTurboOff();
        assertEquals(125*0.01*1, saab95.speedFactor(), "Not accurate");
        saab95.setTurboOn();
        assertEquals(125*0.01*1.3, saab95.speedFactor(), "Not accurate");
    }
}