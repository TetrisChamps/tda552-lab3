package model;

import java.awt.*;

/**
 * A representation of a Scania truck.
 */
public class Scania extends Car {
    private Board board = new Board();

    /**
     * Creates a normal Scania truck.
     */
    public Scania() {
        super(2, 400, Color.RED, "Scania", 0, 0, 5000);
    }

    /**
     * Raises the board of the truck, if the truck is not moving.
     */
    public void raiseBoard() {
        if (getSpeed() == 0) {
            board.raise();
        }
    }

    /**
     * Lowers the board of the truck, if the truck is not moving.
     */
    public void lowerBoard() {
        if (getSpeed() == 0) {
            board.lower();
        }
    }


    /**
     * Applies the gas if the board is in it's upright position.
     *
     * @param speed the speed which the truck is going to accelerate.
     */
    @Override
    public void gas(double speed) {
        if (board.isDown()) {
            super.gas(speed);
        }
    }

    /**
     *
     * @return
     */
    public int getBoardAngle(){
        return board.getAngle();
    }
}
