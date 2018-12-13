import org.junit.*;

public class BasicParkingOperationsTest{
    private static CarParkService carParkService;

    @BeforeClass
    public static void setUp(){
        carParkService = new CarParkServiceImpl();
    }

    @Before
    public void clean(){
        carParkService.cleanUpEnvironment();
    }

    @AfterClass
    public static void tearDown(){
        carParkService = null;
    }

    @Test
    public void testPark(){
        carParkService.park("QWE1-BO");
        Assert.assertTrue(carParkService.getCurrentParkingOrder().contains("QWE1-BO"));
    }

    @Test
    public void testUnpark(){
        Integer ticket1 = carParkService.park("QWE2-BO");
        carParkService.park("ASD1-BO");
        carParkService.unpark(ticket1);
        Assert.assertFalse(carParkService.getCurrentParkingOrder().contains("QWE2-BO"));
    }

    @Test
    public void testCompact(){
        carParkService.park("ZXC1-BO");
        Integer ticket1 = carParkService.park("QWE3-BO");
        Integer ticket2 = carParkService.park("QWE4-BO");
        Integer ticket3 = carParkService.park("QWE5-BO");
        carParkService.park("ASD2-BO");
        carParkService.park("ASD3-BO");
        carParkService.park("ASD5-BO");
        Integer ticket4 = carParkService.park("ZXC2-BO");
        carParkService.park("ZXC3-BO");
        carParkService.unpark(ticket3);
        carParkService.unpark(ticket1);
        carParkService.unpark(ticket2);
        carParkService.unpark(ticket4);
        carParkService.compact();
        Assert.assertTrue(carParkService.getCurrentParkingOrder().contains("ZXC1-BO,ASD2-BO,ASD3-BO,ASD5-BO,ZXC3-BO"));
    }
}
