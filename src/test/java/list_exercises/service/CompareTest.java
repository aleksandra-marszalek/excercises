package list_exercises.service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(JUnit4.class)
public class CompareTest {

    private Compare compare;

    @Before
    public void setup() {
    compare = new Compare();
    }

    private ArrayList<String> arrayMakerFive(String a, String b, String c, String d, String e){
        ArrayList<String> lister = new ArrayList<String>();
        lister.add(a);
        lister.add(b);
        lister.add(c);
        lister.add(d);
        lister.add(e);
        return lister;
    }

    private ArrayList<String> arrayMakerTen(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j){
        ArrayList<String> lister = new ArrayList<String>();
        lister.add(a);
        lister.add(b);
        lister.add(c);
        lister.add(d);
        lister.add(e);
        lister.add(f);
        lister.add(g);
        lister.add(h);
        lister.add(i);
        lister.add(j);
        return lister;
    }

    private ArrayList<String> arrayMakerZero(){
        ArrayList<String> lister = new ArrayList<String>();
        return lister;
    }

    @Test
    public void comparissonTestNormalInput() {
        ArrayList<String> a = arrayMakerFive("a", "b", "c", "d", "e");
        ArrayList<String> b = arrayMakerFive("a", "b", "c", "y", "z");
        double percentage = compare.comparisson(a, b);
        assertThat(percentage, is(60.0));
    }

    @Test
    public void comparissonTestALongerThanB() {
        ArrayList<String> a = arrayMakerTen("a", "y", "c", "d", "e", "f", "g", "h", "i", "j");
        ArrayList<String> b = arrayMakerFive("a", "b", "c", "d", "e");
        double percentage = compare.comparisson(a, b);
        assertThat(percentage, is(40.0));
    }

    @Test
    public void comparissonTestBLongerThanA() {
        ArrayList<String> a = arrayMakerFive("a", "b", "z", "d", "e");
        ArrayList<String> b = arrayMakerTen("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
        double percentage = compare.comparisson(a, b);
        assertThat(percentage, is(40.0));
    }

    @Test
    public void comparissonTestAHasZeroLength() {
        ArrayList<String> a = arrayMakerZero();
        ArrayList<String> b = arrayMakerFive("a", "b", "c", "d", "e");
        double percentage = compare.comparisson(a, b);
        assertThat(percentage, is(0.0));
    }

    @Test
    public void comparissonTestBHasZeroLength() {
        ArrayList<String> a = arrayMakerFive("a", "b", "c", "d", "e");
        ArrayList<String> b = arrayMakerZero();
        double percentage = compare.comparisson(a, b);
        assertThat(percentage, is(0.0));
    }

    @Test
    public void comparissonTestAAndBHaveZeroLength() {
        ArrayList<String> a = arrayMakerZero();
        ArrayList<String> b = arrayMakerZero();
        double percentage = compare.comparisson(a, b);
        assertThat(percentage, is(0.0));
    }

    @Test (expected = NullPointerException.class)
    public void comparissonTestAIsNull() {
        ArrayList<String> a = null;
        ArrayList<String> b = arrayMakerFive("a", "b", "c", "d", "e");
        double percentage = compare.comparisson(a, b);
    }

    @Test (expected = NullPointerException.class)
    public void comparissonTestBIsNull() {
        ArrayList<String> a = arrayMakerFive("a", "b", "c", "d", "e");
        ArrayList<String> b = null;
        double percentage = compare.comparisson(a, b);
    }

    @Test (expected = NullPointerException.class)
    public void comparissonTestAAndBAreNull() {
        ArrayList<String> a = null;
        ArrayList<String> b = null;
        double percentage = compare.comparisson(a, b);
    }
}
