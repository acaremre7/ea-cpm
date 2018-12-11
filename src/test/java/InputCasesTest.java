import org.junit.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
   Reflection is used in this test class to test the private "processInput" method..
*/
public class InputCasesTest {
    private static Method processInputMethod;
    @BeforeClass
    public static void setUp() throws NoSuchMethodException {
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
        Assert.assertEquals("ABC,,EFG,,JKL,,IOP,,,",processInputMethod.invoke(String.class,"pABC,pXYZ,pEFG,pBNM,pJKL,pTYU,pIOP,u5001,u5003,u5005"));
    }
    @Test
    public void testUserInput_3() throws InvocationTargetException, IllegalAccessException {
        Assert.assertEquals("JKL,TYU,IOP,CVB,ZXC,ERT,,,,",processInputMethod.invoke(String.class,"pABC,pXYZ,pEFG,pBNM,pJKL,pTYU,pIOP,pCVB,pZXC,pERT,u5000,c,u5001,c,u5002,c,u5003,c"));
    }
}
