package unit_testing;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CarPrinterTest {

    CarPrinter carPrinter = new CarPrinter();


    @Test
    public void testNullCar() {

        assertEquals("Car cannot be null", carPrinter.carPrinterMethod(null));
    }

    @Test
    public void testCarNullName() {

        assertEquals("Car must have a valid name", carPrinter.carPrinterMethod(new Car()));
    }

    @Test
    public void testCarEmptyName() {

        Car car = new Car();
        car.setName("");

        assertEquals("Car must have a valid name", carPrinter.carPrinterMethod(car));
    }

    @Test
    public void testCarNullAge() {

        Car car = new Car();
        car.setName("valid Name");

        assertEquals("Car must have valid production year", carPrinter.carPrinterMethod(car));
    }

    @Test
    public void testCarInvalidAge() {

        Car car = new Car();
        car.setName("valid Name");
        car.setProductionYear(1);

        assertEquals("Car must have valid production year", carPrinter.carPrinterMethod(car));
    }

    @Test
    public void testValidCar() {

        Car car = new Car();
        car.setName("valid Name");
        car.setProductionYear(1991);

        assertEquals("Car's name is: valid Name, produced in: 1991", carPrinter.carPrinterMethod(car));
    }
}
