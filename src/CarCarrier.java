import java.util.LinkedList;
import java.util.List;

/**
 * A class that can hold cars.
 */
public class CarCarrier {
    private LinkedList<Car> cars = new LinkedList<>();
    private int capacity;
    private int maxWeight;

    /**
     * Sets the position of all the loaded cars
     *
     * @param x
     * @param y
     */
    public void move(double x, double y) {
        for (Car car : cars) {
            car.setPosition(x, y);
        }
    }

    /**
     * Creates the CarCarrier object.
     *
     * @param capacity  The amount of cars that the ferry can hold.
     * @param maxWeight The maximum weight for a car that can be carried
     */
    public CarCarrier(int capacity, int maxWeight) {
        this.capacity = capacity;
        this.maxWeight = maxWeight;
    }

    /**
     * Adds a car to the trailer if there is still enough room left and the ramp is down.
     *
     * @param car The car to be added.
     */
    //TODO this could just return a boolean, perhaps its harder to test functionality then?
    public void addCar(Car car, Vehicle vehicle) {
        if (vehicle == car) {
            throw new IllegalArgumentException("Cannot add itself to the transport carrier");
        }
        // TODO: dont allow cars above a certain weight to be added
        if (cars.size() < capacity) {
            if (!cars.contains(car)) {
                if (car.getWeight() < maxWeight) {
                    cars.addLast(car);
                    car.load();
                    car.setPosition(vehicle.getX(), vehicle.getY());
                    return;
                }
                throw new IllegalStateException("Car is too heavy");
            }
            throw new IllegalStateException("Cannot add a car that is already being transported!");
        }
        throw new IllegalStateException("Transport is full");
    }

    /**
     * Removes the car specified by the first parameter. If the first parameter is true,
     * then the first car in gets removed first, and if the first parameter is false, the
     * last car in gets removed first.
     * The removed car is set to the position of the carrier + 1 on the y axis.
     * If there are no cars on the trailer null is returned.
     *
     * @param first Specifies whether the first or last car in gets removed first
     * @return the removed car.
     */
    public Car removeCar(boolean first, Vehicle vehicle) {
        Car car = null;
        if (cars.size() > 0) {
            if (first) {
                car = cars.removeFirst();
            } else {
                car = cars.removeLast();
            }
            car.setPosition(vehicle.getX() + 1, vehicle.getY() + 1);
            car.unload();
        }
        return car;
    }

    /**
     * returns the list of cars
     * @return list of carried cars
     */
    public List<Car> getCars() {
        System.out.println("Car size: " + cars.size());
        System.out.println("Cloned car size" + (List<Car>)cars.clone() );
        return (List<Car>)cars.clone();
    }
}
