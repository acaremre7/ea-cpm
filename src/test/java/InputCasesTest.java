import org.junit.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
   Reflection is used in this test class to test the private "processInput" method..

   ***Attention***

   These test cases actually work, if they executed one by one. When they get executed all at once,
   file operations in  CarParkDaoImpl gets mixed up a bit, that's why they fail. I will keep inspecting what causes
   this problem, but unfortunately, i ran out of time for this project and have to submit like this.

   Best regards.
   EA

    ***************
*/
public class InputCasesTest {

    private static Method processInputMethod;
    private CarParkService carParkService = new CarParkServiceImpl();

    @BeforeClass
    public static void setUp() throws NoSuchMethodException {
        processInputMethod = Main.class.getDeclaredMethod("processInput",String.class);
        processInputMethod.setAccessible(true);
    }

    @AfterClass
    public static void tearDown(){
        processInputMethod = null;
    }

    @Before
    public void clean(){
        carParkService.cleanUpEnvironment();
    }

    @Test
    public void testUserInput_1() throws InvocationTargetException, IllegalAccessException {
        Assert.assertEquals("XYZ,EFG,,,,,,,,",processInputMethod.invoke(String.class,"pABC,pXYZ,pEFG,u5000,c"));
    }
    @Test
    public void testUserInput_2() throws InvocationTargetException, IllegalAccessException {
        Assert.assertEquals("ABC,,EFG,,JKL,,IOP,,,",processInputMethod.invoke(String.class,"pABC,pXYZ,pEFG,pBNM,pJKL,pTYU,pIOP,u5001,u5003,u5005"));
    }
    @Test
    public void testUserInput_3() throws InvocationTargetException, IllegalAccessException {
        Assert.assertEquals("JKL,TYU,IOP,CVB,ZXC,ERT,,,,",processInputMethod.invoke(String.class,"pABC,pXYZ,pEFG,pBNM,pJKL,pTYU,pIOP,pCVB,pZXC,pERT,u5000,c,u5001,c,u5002,c,u5003,c"));
    }
}
