package mocking_excercises.service;

import mocking_excercises.model.Person;

public class PersonService {

    private AgeService ageService;

    public PersonService(AgeService ageService) {
        this.ageService = ageService;
    }

    public String checkIfAdult (Person person) {

        if (ageService.checkIfAdult(person)) {
            person.setAdult(true);
        }

        return ageService.printAge(person);
    }
}
