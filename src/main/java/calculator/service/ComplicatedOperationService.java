package calculator.service;

import calculator.model.Input;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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


    public String isResultPositive (Input input) {

        if (input==null) {
            return "Input cannot be null";
        }

        if (input.getA()==null || input.getB()==null) {
            return "Input values cannot be null";
        }

        Integer result = basicOperationService.subtract(input.getA(), input.getB());

        String answer;

        if (result>0) {
            answer = "Result is positive";
        } else if (result==0) {
            answer = "Result equals 0";
        } else {
            answer = "Result is negative";
        }

        return answer;
    }

    public List<Double> resultList (Input input) {

        if (input==null) {
            return new ArrayList<>();
        }

        if (input.getA()==null || input.getB()==null) {
            return new ArrayList<>();
        }

        Double sumResult = Double.valueOf(basicOperationService.add(input.getA(), input.getB()));

        Double subtractionResult = Double.valueOf(basicOperationService.subtract(input.getA(), input.getB()));

        Double multiplicationResult = Double.valueOf(basicOperationService.multiply(input.getA(), input.getB()));

        Double divisonResult = Double.valueOf(basicOperationService.divide(input.getA(), input.getB()));

        List<Double> result = new ArrayList<>();

        result.add(sumResult);
        result.add(subtractionResult);
        result.add(multiplicationResult);
        result.add(divisonResult);

        return result;
    }
}
