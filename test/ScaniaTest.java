import model.Scania;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {
    Scania scania;

    @BeforeEach
    void setUp() {
        scania = new Scania();
    }

    @AfterEach
    void tearDown() {
        scania = null;
    }

    @Test
    void raiseBoard() {
        assertEquals(scania.getBoardAngle(), 0);
        scania.raiseBoard();
        scania.raiseBoard();
        scania.raiseBoard();
        assertEquals(scania.getBoardAngle(), 30);
    }

    @Test
    void lowerBoard() {
        scania.raiseBoard();
        assertEquals(scania.getBoardAngle(), 10);
        scania.lowerBoard();
        assertEquals(scania.getBoardAngle(), 0);
        scania.lowerBoard();
        assertEquals(scania.getBoardAngle(), 0);
    }

    @Test
    void getBoardAngle() {
        scania.raiseBoard();
        scania.raiseBoard();
        scania.raiseBoard();
        scania.raiseBoard();
        assertEquals(scania.getBoardAngle(), 40);
    }

    @Test
    void gas() {
        scania.raiseBoard();
        scania.startEngine();
        scania.gas(1);
        assertEquals(scania.getSpeed(), 0);
        scania.lowerBoard();
        scania.gas(1);
        assertNotEquals(scania.getSpeed(), 0);
    }

    @Test
    void speedFactor() {
        assertEquals(scania.speedFactor(), 4);
    }
}