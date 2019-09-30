package unit_testing;

public class CarPrinter {

    public String carPrinterMethod(Car car) {

        if (car == null) {

            return "Car cannot be null";
        }

        if (car.getName() == null || car.getName().isEmpty()) {

            return "Car must have a valid name";
        }

        if (car.getProductionYear() == null || car.getProductionYear() < 1900) {

            return "Car must have valid production year";
        }

        return "Car's name is: " + car.getName() + ", produced in: " + car.getProductionYear();

    }
}
