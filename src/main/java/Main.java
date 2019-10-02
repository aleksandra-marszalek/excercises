import calculator.model.Input;
import calculator.service.BasicOperationService;
import calculator.service.ComplicatedOperationService;
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

        ComplicatedOperationService complicatedOperationService = new ComplicatedOperationService();

        complicatedOperationService.setBasicOperationService(new BasicOperationService());

        System.out.println(complicatedOperationService.sum(new Input(13, 1)));
    }
}
