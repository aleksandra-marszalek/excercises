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

        Input numbers = new Input(-1,1);

        ComplicatedOperationService complicatedOperationService = new ComplicatedOperationService();

        complicatedOperationService.setBasicOperationService(new BasicOperationService());

        //System.out.println(complicatedOperationService.multiplication(numbers));


        Input nullInput = new Input(0, 0);

        //System.out.println(complicatedOperationService.isResultPositive(null));
        //System.out.println(complicatedOperationService.isResultPositive(nullInput));

        System.out.println(complicatedOperationService.division(nullInput));

    }
}
