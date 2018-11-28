import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @AfterEach
    void tearDown() {
        board = null;
    }

    @Test
    void raise() {
        board.raise();
        assertEquals(10, board.getAngle());
    }

    @Test
    void lower() {
        board.raise();
        board.raise();
        board.lower();
        assertEquals(10, board.getAngle());
    }

    @Test
    void isDown() {
        assertTrue(board.isDown());
    }
}