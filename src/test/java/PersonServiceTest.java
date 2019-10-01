import mocking_excercises.model.Person;
import mocking_excercises.service.AgeService;
import mocking_excercises.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private AgeService ageService;

    private PersonService person;

    @Test
    public void isAnAdult() {

        person = new PersonService(ageService);

        Person adult = new Person("older", 25);

        Mockito.when(ageService.checkIfAdult(adult)).thenReturn(true);

        Mockito.when(ageService.printAge(adult)).thenReturn("older is an adult");

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
