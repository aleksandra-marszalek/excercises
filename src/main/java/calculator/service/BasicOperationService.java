package calculator.service;

public class BasicOperationService {

    public Integer add (Integer a, Integer b) {
        if (a == null){
            a = 0;
        } else if (b == null){
            b = 0;
        }
        return a + b;
    }

    public Integer subtract (Integer a, Integer b) {
        if (a == null){
            a = 0;
        } else if (b == null){
            b = 0;
        }
        return a - b;
    }

    public Integer multiply (Integer a, Integer b) {
        if (a == null){
            a = 0;
        } else if (b == null){
            b = 0;
        }
        return a * b;
    }

    public Integer divide (Integer a, Integer b) {
        if (a == null){
            a = 0;
        } else if (b == null){
            b = 0;
        }

        if (b == 0) {
            throw new IllegalArgumentException("Wrong argument - b cannot be 0");
        }

        return a / b;
    }
}
