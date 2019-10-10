package list_exercises.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(JUnit4.class)
public class ShuffleTest {

    private Shuffle shuf;

    @Before
    public void setup() {
        shuf = new Shuffle();
    }

    @Test
    public void shuffleArrayTestWithProperInput(){
        ArrayList<String> input = new ArrayList<String>();
        input.add("a");
        input.add("b");
        input.add("c");
        ArrayList<String> output = new ArrayList<String>();
        output = shuf.shuffleArray(input);

        int posA = output.indexOf("a");
        int posB = output.indexOf("b");
        int posC = output.indexOf("c");
        int lenIn = input.size();
        int lenOut = output.size();

        assertThat(posA, is(not(-1)));
        assertThat(posB, is(not(-1)));
        assertThat(posC, is(not(-1))); //Checks all elements still in list
        assertThat(lenIn, is(lenOut)); //Checks length of list hasn't changed
    }

    @Test
    public void shuffleArrayTestWithOneElement() {
        ArrayList<String> input = new ArrayList<String>();
        input.add("a");
        ArrayList<String> output = new ArrayList<String>();
        output = shuf.shuffleArray(input);
        assertThat(input, is(output));
    }

    @Test
    public void shuffleArrayTestWithNoElements() {
        ArrayList<String> input = new ArrayList<String>();
        ArrayList<String> output = new ArrayList<String>();
        output = shuf.shuffleArray(input);
        assertThat(input, is(output));
    }

    @Test (expected = NullPointerException.class)
    public void shuffleArrayTestWithNullInput() {
        ArrayList<String> input = null;
        ArrayList<String> output = new ArrayList<String>();
        output = shuf.shuffleArray(input);

    }


}
