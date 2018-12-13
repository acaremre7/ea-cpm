package dao;

import model.ParkedCar;

public interface CarParkDao {

    /**
     * This method creates new ticket for the car park and stores it at "/resources/Ticket"
     * If the file is empty, initializes it by putting "5000"
     * Otherwise, increments the previous ticket by 1
     * @return new ticket number
     */
    int createTicket();

    /**
     * Returns current parking order for the car park.
     * @return an array of parked cars, sorted by their place at park. 0 is the closest parking spot to the entrance.
     */
    ParkedCar[] getCarPark();

    /**
     * Stores car park at the specified parking place in the file "/resources/CarPark"
     * @param parkedCars Current parking order of the carpark
     */
    void storeCarPark(ParkedCar[] parkedCars);

    /**
     * Deletes both CarPark and Ticket files for testing purposes.
     */
    void cleanUpEnvironment();
}
