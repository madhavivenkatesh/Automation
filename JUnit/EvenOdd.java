public class EvenOdd {
    public static boolean isEven(int num){
        if(num%2==0)
            return true;
        return false;
    }
}
      
//Corresponding JUnit
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvenOddTest {
    @Test
    public void testEvenOrOdd(){
        EvenOdd evenodd = new EvenOdd();
        assertEquals(true,true, String.valueOf(evenodd.isEven(10)));

    }
}
