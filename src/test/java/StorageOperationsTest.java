import dao.CarParkDao;
import dao.CarParkDaoImpl;
import model.ParkedCar;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StorageOperationsTest {
    private CarParkDao carParkDao;

    @Before
    public void setUp(){
        carParkDao = new CarParkDaoImpl();
    }

    @After
    public void tearDown(){
        carParkDao = null;
    }

    @Test
    public void testCreateTicket(){
        int ticket1 = carParkDao.createTicket();
        int ticket2 = carParkDao.createTicket();
        Assert.assertEquals(ticket1+1,ticket2);
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testStoreCar()throws ArrayIndexOutOfBoundsException{
        carParkDao.storeCar(50,new ParkedCar(5000,"ASD"));
    }

    @Test
    public void testStoreCar_1(){
        ParkedCar sampleCar = new ParkedCar(5000,"ASD");
        carParkDao.storeCar(0,sampleCar);
        ParkedCar[] parkedCars = carParkDao.getCarPark();
        /*
         * Equals method is overriden in ParkedCar POJO for this operation
         */
        Assert.assertEquals(sampleCar,parkedCars[0]);
    }

    @Test
    public void testGetCarPark_1(){
        ParkedCar[] parkedCars = carParkDao.getCarPark();
        Assert.assertEquals(0,parkedCars.length);
    }
    @Test
    public void testGetCarPark_2(){
        ParkedCar[] carParkSample = generateSampleCarPark();
        /*
         * Equals method is overriden in ParkedCar POJO for this operation
         */
        Assert.assertArrayEquals(carParkSample,carParkDao.getCarPark());
    }

    private ParkedCar[] generateSampleCarPark(){
        ParkedCar[] parkedCars = carParkDao.getCarPark();
        ParkedCar parkedCar1 = new ParkedCar(5000,"ASD");
        ParkedCar parkedCar2 = new ParkedCar(5004,"QWE");
        ParkedCar parkedCar3 = new ParkedCar(5054,"GHJ");
        ParkedCar parkedCar4 = new ParkedCar(5123,"ZXC");
        parkedCars[0] = parkedCar1;
        parkedCars[2] = parkedCar2;
        parkedCars[6] = parkedCar3;
        parkedCars[9] = parkedCar4;
        carParkDao.storeCar(0,parkedCar1);
        carParkDao.storeCar(2,parkedCar2);
        carParkDao.storeCar(6,parkedCar3);
        carParkDao.storeCar(9,parkedCar4);
        return parkedCars;
    }
}
