import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BasicParkingOperationsTest{
    private CarParkService carParkService;

    @Before
    public void setUp(){
        carParkService = new CarParkServiceImpl();
    }
    @After
    public void tearDown(){
        carParkService = null;
    }

    @Test
    public void testPark(){
        carParkService.park("QWE");
        Assert.assertEquals("QWE,,,,,,,,,", carParkService.getCurrentParkingOrder());
    }

    @Test
    public void testUnpark(){
        carParkService.park("QWE");
        carParkService.park("ASD");
        carParkService.unpark(5000);
        Assert.assertEquals(",ASD,,,,,,,,", carParkService.getCurrentParkingOrder());
    }

    @Test
    public void testCompact(){
        carParkService.park("QWE");
        carParkService.park("ASD");
        carParkService.unpark(5000);
        carParkService.compact();
        Assert.assertEquals("ASD,,,,,,,,,", carParkService.getCurrentParkingOrder());
    }
}
