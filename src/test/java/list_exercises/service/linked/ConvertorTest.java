package list_exercises.service.linked;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(JUnit4.class)
public class ConvertorTest {

    private Convertor convertor;

    @Before
    public void setup() {
        convertor = new Convertor();
    }

    private ArrayList<String> arrMakerFive(String a, String b, String c, String d, String e) {
        ArrayList<String> lister = new ArrayList<String >();
        lister.add(a);
        lister.add(b);
        lister.add(c);
        lister.add(d);
        lister.add(e);
        return lister;
    }

    private LinkedList<String> linkMakerFiver(String a, String b, String c, String d, String e) {
        LinkedList<String> lister = new LinkedList<String>();
        lister.add(a);
        lister.add(b);
        lister.add(c);
        lister.add(d);
        lister.add(e);
        return lister;
    }

    private ArrayList<String> arrMakerZero() {
        ArrayList<String> lister = new ArrayList<String >();
        return lister;
    }

    private LinkedList<String> linkMakerZero() {
        LinkedList<String> lister = new LinkedList<String>();
        return lister;
    }

    @Test
    public void convertorTestRegularInput() {
        ArrayList<String> input = arrMakerFive("a", "b", "c", "d", "e");
        LinkedList<String> expectedOutput = linkMakerFiver("a", "b", "c", "d", "e");
        LinkedList<String> output = convertor.converts(input);
        assertThat(output, equalTo(expectedOutput));
    }

    @Test
    public void convertorTestZeroInput() {
        ArrayList<String> input = arrMakerZero();
        LinkedList<String> expectedOutput = linkMakerZero();
        LinkedList<String> output = convertor.converts(input);
        assertThat(output, equalTo(expectedOutput));
    }

    @Test (expected = NullPointerException.class)
    public void convertorTestNullInput() {
        ArrayList<String> input = null;
        LinkedList<String> expectedOutput = null;
        LinkedList<String> output = convertor.converts(input);
        assertThat(output, equalTo(expectedOutput));
    }

}
