import mocking_excercises.model.Person;
import mocking_excercises.service.AgeService;
import mocking_excercises.service.PersonService;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    public static void main(String[] args) {

        Person person = new Person("Ola", 27);

        PersonService personService = new PersonService();

        System.out.println(personService.checkIfAdult(person));
    }
}
