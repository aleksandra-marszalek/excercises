import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FirstMethodTest {


    @Test
    public void helloName() {

        System.out.println(FirstMethod.helloName("Oddschecker"));
    }
}
