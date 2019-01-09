import org.junit.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InputCasesTest {

    private static Method processInputMethod;
    private static CarParkService carParkService = new CarParkServiceImpl();

    @BeforeClass
    public static void setUp() throws NoSuchMethodException {
        carParkService.cleanUpEnvironment();
        processInputMethod = Main.class.getDeclaredMethod("processInput",String.class);
        processInputMethod.setAccessible(true);
    }

    @AfterClass
    public static void tearDown(){
        processInputMethod = null;
    }

    @Test
    public void testUserInput_1() throws InvocationTargetException, IllegalAccessException {
        Assert.assertEquals("XYZ,EFG,,,,,,,,",processInputMethod.invoke(String.class,"pABC,pXYZ,pEFG,u5000,c"));
    }
    @Test
    public void testUserInput_2() throws InvocationTargetException, IllegalAccessException {
        Assert.assertEquals(",EFG,,TRE,,BNM,JKL,TYU,IOP,",processInputMethod.invoke(String.class,"pABC,pTRE,pDHT,pBNM,pJKL,pTYU,pIOP,u5001,u5003,u5005"));
    }
    @Test
    public void testUserInput_3() throws InvocationTargetException, IllegalAccessException {
        Assert.assertEquals("UVE,,HVG,,DFR,,JKL,,IOP,BNM",processInputMethod.invoke(String.class,"pUVE,pHVG,pDFR,pBNM,u5002,u5004,u5006,u5008"));
    }
}
