import mocking_excercises.model.Person;
import mocking_excercises.service.AgeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class AgeServiceTest {


    AgeService age = new AgeService();

    @Test
    public void testUnderage() {
        Person under = new Person("testName1", 15);
        assertEquals("testName1 is underage", age.printAge(under));
    }

    @Test
    public void testAnAdult() {
        Person over = new Person("testName2", 23);
        over.setAdult(true);
        assertEquals("testName2 is an adult", age.printAge(over));
    }

    @Test
    public void testNegativeAge() {
        Person negAgeTest = new Person("Name", -4);
        assertEquals("Invalid Age", age.printAge(negAgeTest));
    }

}
