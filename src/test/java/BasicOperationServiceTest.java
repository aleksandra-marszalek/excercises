import calculator.model.Input;
import calculator.service.BasicOperationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;




@RunWith(JUnit4.class)
public class BasicOperationServiceTest {

    @Before
    public void setup() {
        /*Input posAPosB = new Input(1,1);
        Input posANegB = new Input(1, -1);
        Input negAPosB = new Input(-1, 1);
        Input negANegB = new Input(-1, -1);
        Input posAZeroB = new Input(1, 0);
        Input zeroAPosB = new Input(0, 1);
        Input zeroAZeroB = new Input(0, 0);
        Input posANullB = new Input(1, null);
        Input nullAposA = new Input (null, 1); */

        BasicOperationService bOS = new BasicOperationService();
        int x = bOS.add(1,1);
    }

    @Test
    public void addPosPos() {
        assertEquals(2, bOS.add(1, 1));
    }




}
