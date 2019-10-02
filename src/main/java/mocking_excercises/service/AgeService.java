package mocking_excercises.service;

import mocking_excercises.model.Person;

public class AgeService {

    public boolean checkIfAdult(Person person) {

        Integer age = person.getAge();

        if (age>=18) {
            return true;
            }
        return false;
        }


    public String printAge(Person person) {

        String result;

        if (person.getAge() < 0) {
            result = "Invalid Age";
        } else if (!person.isAdult()) {
            result = person.getName() + " is underage";
        } else {
            result = person.getName() + " is an adult";
        }

        return result;
    }

}
