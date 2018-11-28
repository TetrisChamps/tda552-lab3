import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathsTest {

    @Test
    void clamp() {
        assertEquals(1, Maths.clamp(200, 0, 1));
    }
}