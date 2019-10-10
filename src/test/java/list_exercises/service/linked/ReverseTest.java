package list_exercises.service.linked;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.LinkedList;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(JUnit4.class)
public class ReverseTest {

    private Reverse reverses;

    @Before
    public void setup() {
        reverses = new Reverse();
    }

    private LinkedList<String> makerFive(String a, String b, String c, String d, String e) {
        LinkedList<String> lister = new LinkedList<String>();
        lister.add(a);
        lister.add(b);
        lister.add(c);
        lister.add(d);
        lister.add(e);
        return lister;
    }

    private LinkedList<String> makerOne(String a) {
        LinkedList<String> lister = new LinkedList<String>();
        lister.add(a);
        return lister;
    }

    private LinkedList<String> makerZero() {
        LinkedList<String> lister = new LinkedList<String>();
        return lister;
    }


    @Test
    public void reversalTestRegularInput() {
        LinkedList<String> input = makerFive("a", "b", "c", "d", "e");
        LinkedList<String> expectedOutput = makerFive("e", "d", "c", "b", "a");
        LinkedList<String> actualOutput = reverses.reversal(input);
        assertThat(actualOutput, equalTo(expectedOutput));
    }

    @Test
    public void reversalTestOneLengthInput() {
        LinkedList<String> input = makerOne("a");
        LinkedList<String> output = reverses.reversal(input);
        assertThat(output, equalTo(input));
    }

    @Test
    public void reversalTestZeroLengthInput() {
        LinkedList<String> input = makerZero();
        LinkedList<String> output = reverses.reversal(input);
        assertThat(output, equalTo(input));
    }

    @Test (expected = NullPointerException.class)
    public void reversalTestNullInput() {
        LinkedList<String> input = null;
        LinkedList<String> output = reverses.reversal(input);
        assertThat(output, equalTo(input));
    }
}
