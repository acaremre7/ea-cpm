package dao;

import model.ParkedCar;

public interface CarParkDao {

    /**
     * This method creates new ticket for the car park and stores it in "/resources/Ticket"
     * If the file is empty, initializes it by putting "5000"
     * Otherwise, increments the previous ticket by 1
     * @return new ticket number
     */
    int createTicket();

    /**
     * Returns current parking order for the car park.
     * @return an array of parked cars, sorted by their place in park. 0 is the closest parking spot to the entrance.
     */
    ParkedCar[] getCarPark();

    /**
     * Stores a car at the specified parking place in the file "/resources/CarPark"
     * @param parkingSpot Where car is parking
     * @param parkedCar Details of the parking car
     */
    void storeCar(int parkingSpot, ParkedCar parkedCar);
}
