/**
 * An interface for adding cars
 */
public interface ICarTransporter {
    /**
     * Adds a car
     * @param car The car to be added
     */
    void addCar(Car car);

    /**
     * Removes and returns a car
     * @return The car that was removed
     */
    Car removeCar();
}
