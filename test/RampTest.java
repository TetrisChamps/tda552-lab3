import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RampTest {
    Ramp ramp;

    @BeforeEach
    void setUp() {
        ramp = new Ramp();
    }

    @AfterEach
    void tearDown() {
        ramp = null;
    }

    @Test
    void raise() {
        ramp.raise();
        assertEquals(ramp.getAngle(), 90);
    }

    @Test
    void lower() {
        ramp.lower();
        assertEquals(ramp.getAngle(), 0);
    }

    @Test
    void isDown() {
        ramp.raise();
        assertEquals(ramp.isDown(), false);
        ramp.lower();
        assertEquals(ramp.isDown(), true);
    }
}