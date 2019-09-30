package mocking_excercises.service;

import mocking_excercises.model.Person;

public class AgeService {

    public void setIfAdult(Person person) {

        Integer age = person.getAge();

        if (age>=18) {
            person.setAdult(true);
        }
    }

    public String printAge (Person person) {

        String result;

        if (person.isAdult()) {
            result = person.getName() + " is an adult";
        } else {
            result = person.getName() + " is underage";
        }

        return result;
    }

}
