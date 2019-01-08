import org.junit.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InputCasesTest {
    private CarParkService carParkService = new CarParkServiceImpl();

    @Before
    public void clean(){
        carParkService.cleanUpEnvironment();
    }

    @Test
    public void testUserInput_1(){
        Assert.assertEquals("XYZ,EFG,,,,,,,,",carParkService.processInput("pABC,pXYZ,pEFG,u5000,c"));
    }
    @Test
    public void testUserInput_2(){
        Assert.assertEquals("ABC,,EFG,,JKL,,IOP,,,",carParkService.processInput("pABC,pXYZ,pEFG,pBNM,pJKL,pTYU,pIOP,u5001,u5003,u5005"));
    }
    @Test
    public void testUserInput_3(){
        Assert.assertEquals("JKL,TYU,IOP,CVB,ZXC,ERT,,,,",carParkService.processInput("pABC,pXYZ,pEFG,pBNM,pJKL,pTYU,pIOP,pCVB,pZXC,pERT,u5000,c,u5001,c,u5002,c,u5003,c"));
    }
}
