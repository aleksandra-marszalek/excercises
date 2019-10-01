import mocking_excercises.model.Person;
import mocking_excercises.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class PersonServiceTest {
    PersonService person = new PersonService();

    @Test
    public void isAnAdult() {
        Person adult = new Person("older", 25);
        assertEquals("older is an adult" ,person.checkIfAdult(adult));
    }

    @Test
    public void isChild() {
        Person child = new Person("younger", 10);
        assertEquals("younger is underage", person.checkIfAdult(child));
    }

    @Test
    public void negativeAge() {
        Person negAge = new Person("under", -5);
        assertEquals("Invalid Age", person.checkIfAdult(negAge));
    }








}
