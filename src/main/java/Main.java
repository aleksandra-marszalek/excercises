import mocking_excercises.model.Person;
import mocking_excercises.service.AgeService;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    public static void main(String[] args) {

        AgeService ageService = new AgeService();

        Person person = new Person("Ola", 27);

        ageService.setIfAdult(person);

        System.out.println(ageService.printAge(person));
    }
}
