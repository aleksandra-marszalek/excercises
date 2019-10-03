import calculator.model.Input;
import calculator.service.BasicOperationService;
import calculator.service.ComplicatedOperationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.internal.matchers.Null;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class ComplicatedOperationServiceTest {


    private ComplicatedOperationService cOS;


    @Mock
    private BasicOperationService bOS;

    private Input posAPosB;
    private Input posANegB;
    private Input negAPosB;
    private Input negANegB;
    private Input posAZeroB;
    private Input zeroAPosB;
    private Input zeroAZeroB;
    private Input posANullB;
    private Input nullAPosB;

    @Before
    public void setup() {
        posAPosB = new Input(1,1);
        posANegB = new Input(1, -1);
        negAPosB = new Input(-1, 1);
        negANegB = new Input(-1, -1);
        posAZeroB = new Input(1, 0);
        zeroAPosB = new Input(0, 1);
        zeroAZeroB = new Input(0, 0);
        posANullB = new Input(1, null);
        nullAPosB = new Input (null, 1);

        cOS = new ComplicatedOperationService();
        cOS.setBasicOperationService(bOS);

    }

    //Sum Tests
    @Test
    public void sumPosPos() {
        Mockito.when(bOS.add(posAPosB.getA(), posAPosB.getB())).thenReturn(2);
        assertThat(cOS.sum(posAPosB), is(2.0));
    }

    @Test
    public void sumPosNeg() {
        Mockito.when(bOS.add(posANegB.getA(), posANegB.getB())).thenReturn(0);
        assertThat(cOS.sum(posANegB), is(0.0));
        Mockito.when(bOS.add(negAPosB.getA(), negAPosB.getB())).thenReturn(0);
        assertThat(cOS.sum(negANegB), is(0.0));
    }

    @Test
    public void sumNegNeg() {
        Mockito.when(bOS.add(negANegB.getA(),negANegB.getB())).thenReturn(-2);
        assertThat(cOS.sum(negANegB), is(-2.0));
    }

    @Test
    public void sumPosZero() {
        Mockito.when(bOS.add(posAZeroB.getA(), posAZeroB.getB())).thenReturn(1);
        assertThat(cOS.sum(posAZeroB), is(1.0));
        Mockito.when(bOS.add(zeroAPosB.getA(), zeroAPosB.getB())).thenReturn(1);
        assertThat(cOS.sum(zeroAPosB), is(1.0));
    }

    @Test
    public void sumZeroZero() {
        Mockito.when(bOS.add(zeroAZeroB.getA(), zeroAZeroB.getB())).thenReturn(0);
        assertThat(cOS.sum(zeroAZeroB), is(0.0));
    }

    @Test
    public void sumPosNull() {
        Mockito.when(bOS.add(posANullB.getA(), posANullB.getB())).thenReturn(1);
        assertThat(cOS.sum(posANullB), is(1.0));
        Mockito.when(bOS.add(nullAPosB.getA(), nullAPosB.getB())).thenReturn(1);
        assertThat(cOS.sum(nullAPosB), is(1.0));
    }

    //Subtraction Tests
    @Test
    public void subtractionPosPos() {
        Mockito.when(bOS.subtract(posAPosB.getA(), posAPosB.getB())).thenReturn(0);
        assertThat(cOS.sum(posAPosB), is(0.0));
    }

    @Test
    public void subtractionPosNeg() {
        Mockito.when(bOS.subtract(posANegB.getA(), posANegB.getB())).thenReturn(2);
        assertThat(cOS.subtraction(posANegB), is(2.0));
        Mockito.when(bOS.subtract(negAPosB.getA(), negAPosB.getB())).thenReturn(2);
        assertThat(cOS.subtraction(negAPosB), is(2.0));
    }

    @Test
    public void subtractionNegNeg() {
        Mockito.when(bOS.subtract(negANegB.getA(), negANegB.getB())).thenReturn(0);
        assertThat(cOS.subtraction(negANegB), is(0.0));
    }

    @Test
    public void subPosZero() {
        Mockito.when(bOS.subtract(posAZeroB.getA(), posAZeroB.getB())).thenReturn(1);
        assertThat(cOS.subtraction(posAZeroB), is(1.0));
        Mockito.when(bOS.subtract(zeroAPosB.getA(), zeroAPosB.getB())).thenReturn(1);
        assertThat(cOS.subtraction(zeroAPosB), is(1.0));
    }


}