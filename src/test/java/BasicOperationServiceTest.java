import calculator.model.Input;
import calculator.service.BasicOperationService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.internal.matchers.Null;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(JUnit4.class)
public class BasicOperationServiceTest {

    private BasicOperationService bOS;

    @Before
    public void setup() {
        bOS = new BasicOperationService();
    }

    //Add Tests
    @Test
    public void addPosPos() {
        assertThat(bOS.add(1, 1), is(2));
    }

    @Test
    public void addPosNeg() {
        assertThat(bOS.add(2,-1), is(1));
        assertThat(bOS.add(-1,2), is(1));
    }

    @Test
    public void addNegNeg() {
        assertThat(bOS.add(-1,-3), is(-4));
    }

    @Test
    public void addPosNull() {
        assertThat(bOS.add(1, null), is(1));
        assertThat(bOS.add(null,2), is(2));
    }

    //Subtract Tests
    @Test
    public void subPosPos() {
        assertThat(bOS.subtract(2,1), is(1));
    }

    @Test
    public void subPosNeg() {
        assertThat(bOS.subtract(3, -1), is(4));
        assertThat(bOS.subtract(-2,1), is(-3));
    }

    @Test
    public void subNegNeg() {
        assertThat(bOS.subtract(-1,-2), is(1));
    }

    @Test
    public void subPosNull() {
        assertThat(bOS.subtract(1, null), is(1));
        assertThat(bOS.subtract(null, 1), is(-1));
    }

    //Multiply Tests
    @Test
    public void mulPosPos() {
        assertThat(bOS.multiply(2,3), is(6));
    }

    @Test
    public void mulPosNeg() {
        assertThat(bOS.multiply(2, -1), is(-2));
        assertThat(bOS.multiply(-2, 2), is(-4));
    }

    @Test
    public void mulNegNeg() {
        assertThat(bOS.multiply(-2, -3), is(6));
    }

    @Test
    public void mulPosZero() {
        assertThat(bOS.multiply(1,0), is(0));
        assertThat(bOS.multiply(0,2), is(0));
    }

    @Test
    public void mulPosNull() {
        assertThat(bOS.multiply(1, null), is(0));
        assertThat(bOS.multiply(null, 1), is(0));
    }

    //Divide Tests
    @Test
    public void divPosPos() {
        assertThat(bOS.divide(4,2), is(2));
    }

    @Test
    public void divPosNeg() {
        assertThat(bOS.divide(2,-1), is(-2));
        assertThat(bOS.divide(-6, 2), is(-3));
    }

    @Test
    public void divNegNeg() {
        assertThat(bOS.divide(-3, -1), is(3));
    }

    @Test (expected = IllegalArgumentException.class)
    public void divPosZeroException() {
        assertThat(bOS.divide(1,0), is("Wrong argument - b cannot be 0"));
    }

    @Test
    public void divZeroPos() {
        assertThat(bOS.divide(0, 2), is(0));
    }

    @Test (expected = IllegalArgumentException.class)
    public void divPosNullException() {
        assertThat(bOS.divide(2, null), is("Wrong argument - b cannot be 0"));
    }

    @Test
    public void divNullPos() {
        assertThat(bOS.divide(null, 3), is(0));
    }



}

