public interface CarParkService{

    /**
     * Parks a car in the closest spot to the entrance
     * @param licencePlate Plate of the car which is being parked
     */
    void park(String licencePlate);

    /**
     * Unparks the car with the following ticket number
     * @param ticketNumber The ticket number of the car which is being unparked
     */
    void unpark(int ticketNumber);

    /**
     * Compacts the CarPark to the entrance
     */
    void compact();

    /**
     * Prepares the current parking order of the CarPark by reading it from cache, not the file.
     * @return Current order of cars
     */
    String getCurrentParkingOrder();
}