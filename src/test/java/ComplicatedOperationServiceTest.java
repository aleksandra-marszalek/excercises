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
    //Inputs for sum, subtraction, multiplication, and division
    private Input posAPosB;
    private Input posANegB;
    private Input negAPosB;
    private Input negANegB;
    private Input posAZeroB;
    private Input zeroAPosB;
    private Input zeroAZeroB;
    private Input posANullB;
    private Input nullAPosB;


    private Input nullInput;
    private Input nullANullB;


    @Mock
    private BasicOperationService bOS;

    @Before
    public void setup() {
        //Inputs setup
        posAPosB = new Input(1,1);
        posANegB = new Input(1, -1);
        negAPosB = new Input(-1, 1);
        negANegB = new Input(-1, -1);
        posAZeroB = new Input(1, 0);
        zeroAPosB = new Input(0, 1);
        zeroAZeroB = new Input(0, 0);
        posANullB = new Input(1, null);
        nullAPosB = new Input(null, 1);
        nullANullB = new Input(null, null);
        nullInput = null;

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
        Mockito.when(bOS.subtract(negAPosB.getA(), negAPosB.getB())).thenReturn(-2);
        assertThat(cOS.subtraction(negAPosB), is(-2.0));
    }

    @Test
    public void subtractionNegNeg() {
        Mockito.when(bOS.subtract(negANegB.getA(), negANegB.getB())).thenReturn(0);
        assertThat(cOS.subtraction(negANegB), is(0.0));
    }

    @Test
    public void subtractionPosZero() {
        Mockito.when(bOS.subtract(posAZeroB.getA(), posAZeroB.getB())).thenReturn(1);
        assertThat(cOS.subtraction(posAZeroB), is(1.0));
        Mockito.when(bOS.subtract(zeroAPosB.getA(), zeroAPosB.getB())).thenReturn(-1);
        assertThat(cOS.subtraction(zeroAPosB), is(-1.0));
    }

    @Test
    public void subtractionZeroZero() {
        Mockito.when(bOS.subtract(zeroAPosB.getA(), zeroAPosB.getB())).thenReturn(0);
        assertThat(cOS.subtraction(zeroAZeroB), is(0.0));
    }

    @Test
    public void subtractionPosNull() {
        Mockito.when(bOS.subtract(posANullB.getA(), posANullB.getB())).thenReturn(1);
        assertThat(cOS.subtraction(posANullB), is(1.0));
        Mockito.when(bOS.subtract(posANullB.getA(), posANullB.getB())).thenReturn(1);
        assertThat(cOS.subtraction(posANullB), is(1.0));
    }

    //MultiplicationTests
    @Test
    public void multiplicationPosPos() {
        Mockito.when(bOS.multiply(posAPosB.getA(), posAPosB.getB())).thenReturn(1);
        assertThat(cOS.multiplication(posAPosB), is(1.0));
    }

    @Test
    public void multiplicationPosNeg() {
        Mockito.when(bOS.multiply(posANegB.getA(), posANegB.getB())).thenReturn(-1);
        assertThat(cOS.multiplication(posANegB), is(-1.0));
        Mockito.when(bOS.multiply(negAPosB.getA(), negAPosB.getB())).thenReturn(-1);
        assertThat(cOS.multiplication(negAPosB), is(-1.0));
    }

    @Test
    public void multiplicationNegNeg() {
        Mockito.when(bOS.multiply(negANegB.getA(), negANegB.getB())).thenReturn(1);
        assertThat(cOS.multiplication(negANegB), is(1.0));
    }

    @Test
    public void multiplicationPosZero() {
        Mockito.when(bOS.multiply(posAZeroB.getA(), posAZeroB.getB())).thenReturn(0);
        assertThat(cOS.multiplication(posAZeroB), is(0.0));
        Mockito.when(bOS.multiply(zeroAPosB.getA(), zeroAPosB.getB())).thenReturn(0);
        assertThat(cOS.multiplication(zeroAPosB), is(0.0));
    }

    @Test
    public void multiplicationPosNull() {
        Mockito.when(bOS.multiply(posANullB.getA(), posANullB.getB())).thenReturn(0);
        assertThat(cOS.multiplication(posANullB), is(0.0));
        Mockito.when(bOS.multiply(nullAPosB.getA(), nullAPosB.getB())).thenReturn(0);
        assertThat(cOS.multiplication(nullAPosB), is(0.0));
    }

    //Division Tests
    @Test
    public void divisionPosPos() {
        Mockito.when(bOS.divide(posAPosB.getA(), posAPosB.getB())).thenReturn(1);
        assertThat(cOS.division(posAPosB), is(1.0));
    }

    @Test
    public void divisionPosNeg() {
        Mockito.when(bOS.divide(posANegB.getA(), posANegB.getB())).thenReturn(-1);
        assertThat(cOS.division(posANegB), is(-1.0));
        Mockito.when(bOS.divide(negAPosB.getA(), negAPosB.getB())).thenReturn(-1);
        assertThat(cOS.division(negAPosB), is(-1.0));
    }

    @Test
    public void divisionNegNeg() {
        Mockito.when(bOS.divide(negANegB.getA(), negANegB.getB())).thenReturn(1);
        assertThat(cOS.division(negANegB), is(1.0));
    }

    @Test (expected = IllegalArgumentException.class)
    public void divisionPosZero() {
        Mockito.when(bOS.divide(posAZeroB.getA(), posAZeroB.getB())).thenThrow(new IllegalArgumentException());
        assertThat(cOS.division(posAZeroB), is("Wrong argument - b cannot be 0"));
    }

    @Test
    public void divisionZeroPos() {
        Mockito.when(bOS.divide(zeroAPosB.getA(), zeroAPosB.getB())).thenReturn(0);
        assertThat(cOS.division(zeroAPosB), is(0.0));
    }

    @Test (expected = IllegalArgumentException.class)
    public void divisionPosNull() {
        Mockito.when(bOS.divide(posANullB.getA(), posANullB.getB())).thenThrow(new IllegalArgumentException());
        assertThat(cOS.division(posANullB), is("Wrong argument - b cannot be 0"));
    }

    @Test
    public void divisionNullPos() {
        Mockito.when(bOS.divide(nullAPosB.getA(), nullAPosB.getB())).thenReturn(0);
        assertThat(cOS.division(nullAPosB), is(0.0));
    }

    //isResultsPositive Tests
    @Test
    public void isResultPositiveNullInput() {
        assertThat(cOS.isResultPositive(nullInput), is("Input cannot be null"));
    }

    @Test
    public void isResultPositiveNullNull() {
        assertThat(cOS.isResultPositive(nullANullB), is("Input values cannot be null"));
    }

    @Test
    public void isResultPositivePosNull() {
        assertThat(cOS.isResultPositive(posANullB), is("Input values cannot be null"));
        assertThat(cOS.isResultPositive(nullAPosB), is("Input values cannot be null"));
    }

    @Test
    public void isResultPositivePositive() {
        Mockito.when(bOS.subtract(posANegB.getA(), posANegB.getB())).thenReturn(2);
        assertThat(cOS.isResultPositive(posANegB), is("Result is positive"));
    }

    @Test
    public void isResultPositiveNegative() {
        Mockito.when(bOS.subtract(negAPosB.getA(), negAPosB.getB())).thenReturn(-2);
        assertThat(cOS.isResultPositive(negAPosB), is("Result is negative"));
    }

    @Test
    public void isResultPositiveZero() {
        Mockito.when(bOS.subtract(posAPosB.getA(), posAPosB.getB())).thenReturn(0);
        assertThat(cOS.isResultPositive(posAPosB), is("Result equals 0"));
    }








}
