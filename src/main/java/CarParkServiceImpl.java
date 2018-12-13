import dao.CarParkDao;
import dao.CarParkDaoImpl;
import model.ParkedCar;

import java.util.LinkedList;
import java.util.Queue;

public class CarParkServiceImpl implements CarParkService{
    private ParkedCar[] parkedCars;
    private CarParkDao carParkDao;

    CarParkServiceImpl(){
        carParkDao = new CarParkDaoImpl();
        parkedCars = carParkDao.getCarPark();
    }

    @Override
    public Integer park(String licencePlate){
        Integer ticketNumber = null;
        boolean parkSuccessful = false;
        for(int i = 0;i<10 && !parkSuccessful;i++){
            if(parkedCars[i] == null){
                ticketNumber = carParkDao.createTicket();
                parkedCars[i] = new ParkedCar(ticketNumber,licencePlate);
                carParkDao.storeCarPark(parkedCars);
                parkSuccessful = true;
            }
        }
        if(!parkSuccessful){
            System.err.println("There is no empty place in car park !");
        }
        return ticketNumber;
    }

    @Override
    public void unpark(int ticketNumber){
        boolean unparkSuccessful = false;
        for(int i = 0; i<10 && !unparkSuccessful; i++){
            if(parkedCars[i] != null && parkedCars[i].getTicketNumber() == ticketNumber){
                parkedCars[i] = null;
                carParkDao.storeCarPark(parkedCars);
                unparkSuccessful = true;
            }
        }
        if(!unparkSuccessful){
            System.err.println("Requested ticket number is not present in car park !");
        }
    }

    @Override
    public void compact(){
        Queue<Integer> emptyParkingSpotQueue = new LinkedList<>();
        ParkedCar[] compactedCarPark = new ParkedCar[10];

        for(int i = 0; i<10;i++){
            if(parkedCars[i] == null){
                emptyParkingSpotQueue.add(i);
            }else{
                if(emptyParkingSpotQueue.isEmpty()){
                    compactedCarPark[i] = parkedCars[i];
                }else{
                    compactedCarPark[emptyParkingSpotQueue.poll()] = parkedCars[i];
                    emptyParkingSpotQueue.add(i);
                }
            }
        }
        parkedCars = compactedCarPark;
        carParkDao.storeCarPark(compactedCarPark);
    }

    @Override
    public String getCurrentParkingOrder() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<10;i++){
            if(parkedCars[i] != null){
                result.append(parkedCars[i].getLicencePlate());
            }
            if(i != 9) {
                result.append(",");
            }
        }
        return result.toString();
    }

    @Override
    public void cleanUpEnvironment(){
        parkedCars = new ParkedCar[10];
        carParkDao.cleanUpEnvironment();
    }
}
