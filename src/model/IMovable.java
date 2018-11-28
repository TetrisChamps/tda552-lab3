package model;

/**
 * Reassures the that an object implements move functionality.
 */
public interface IMovable {
    /**
     * Moves the object to a new location based on its direction and speed.
     */
    void move();

    /**
     * Turns the object to the left
     */

    void turnLeft();

    /**
     * Turns the object to the right.
     */

    void turnRight();

}
