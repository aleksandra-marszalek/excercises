package mocking_excercises.service;

import mocking_excercises.model.Person;

public class PersonService {

    public String checkIfAdult (Person person) {

        AgeService ageService = new AgeService();

        ageService.setIfAdult(person);

        ageService.setIfAdult(person);

        return ageService.printAge(person);
    }
}
