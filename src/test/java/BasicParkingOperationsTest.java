import org.junit.*;

public class BasicParkingOperationsTest{
    private CarParkService carParkService;

    @Before
    public void setUp(){
        carParkService = new CarParkService();
    }
    @After
    public void tearDown(){
        carParkService = null;
    }

    @Test
    public void testParking(){
        carParkService.park("QWE");
        Assert.assertEquals("QWE,,,,,,,,,", carParkService.getCurrentParkingOrder());
    }

    @Test
    public void testUnparking(){
        carParkService.park("QWE");
        carParkService.park("ASD");
        carParkService.unpark(5000);
        Assert.assertEquals(",ASD,,,,,,,,", carParkService.getCurrentParkingOrder());
    }

    @Test
    public void testCompacting(){
        carParkService.park("QWE");
        carParkService.park("ASD");
        carParkService.unpark(5000);
        carParkService.compact();
        Assert.assertEquals("ASD,,,,,,,,,", carParkService.getCurrentParkingOrder());
    }
}
