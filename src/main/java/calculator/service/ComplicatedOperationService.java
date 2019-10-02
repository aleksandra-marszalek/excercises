package calculator.service;

import calculator.model.Input;

public class ComplicatedOperationService {

    private BasicOperationService basicOperationService;

    public BasicOperationService getBasicOperationService() {
        return basicOperationService;
    }

    public void setBasicOperationService(BasicOperationService basicOperationService) {
        this.basicOperationService = basicOperationService;
    }

    public Double sum (Input input) {
        return Double.valueOf(basicOperationService.add(input.getA(), input.getB()));
    }

    public Double subtraction (Input input) {
        return Double.valueOf(basicOperationService.subtract(input.getA(), input.getB()));
    }

    public Double muliplication (Input input) {
        return Double.valueOf(basicOperationService.multiply(input.getA(), input.getB()));
    }

    public Double division (Input input) {
        return Double.valueOf(basicOperationService.divide(input.getA(), input.getB()));
    }
}
