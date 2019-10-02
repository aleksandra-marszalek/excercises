import calculator.model.Input;
import calculator.service.BasicOperationService;
import calculator.service.ComplicatedOperationService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.internal.matchers.Null;
import org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComplicatedOperationServiceTest {

    @Mock
    private ComplicatedOperationService cOS;
    private BasicOperationService bOS;

    @Before
    public void setup() {
        Input posAPosB = new Input(1,1);
        Input posANegB = new Input(1, -1);
        Input negAPosB = new Input(-1, 1);
        Input negANegB = new Input(-1, -1);
        Input posAZeroB = new Input(1, 0);
        Input zeroAPosB = new Input(0, 1);
        Input zeroAZeroB = new Input(0, 0);
        Input posANullB = new Input(1, null);
        Input nullAPosA = new Input (null, 1);

        cOS = new ComplicatedOperationService();
        bOS = new BasicOperationService();
    }

    @Test
    public void sumPosPos() {




        /* cOS already made

        Mock this cOS.setBasicOperationService(new BasicOperationService());

        assertThat this complicatedOperationService.division(INPUT) is correct/



    }





}
