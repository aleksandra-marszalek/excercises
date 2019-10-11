package Shopping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(JUnit4.class)
public class StockItemTest {

    StockItem stockItem1 = new StockItem("Item1", 10.0, 10);
    StockItem stockItem2 = new StockItem("Item2", 5.0, 20);
    StockItem stockItem3 = new StockItem("Item3", 25.0, 4);

    StockItem stockItem4 = new StockItem("Item4", 100.0);


    @Test
    public void reserveStockTest() {
        int quantity = stockItem1.reserveStock(3);
        assertThat(quantity, is(3));
        assertThat(stockItem1.getReserved(), is(3));
        assertThat(stockItem1.getQuantityStock(), is(7));
    }

    @Test
    public void reserveStockTestTooMany() {
        int quantity = stockItem4.reserveStock(1);
        assertThat(quantity, is(0));
        assertThat(stockItem4.getReserved(), is(0));
        assertThat(stockItem4.getQuantityStock(), is(0));
    }

    @Test
    public void reserveStockTestNegative() {
        int quantity = stockItem4.reserveStock(-3);
        assertThat(quantity, is(0));
        assertThat(stockItem4.getReserved(), is(0));
        assertThat(stockItem4.getQuantityStock(), is(0));
    }

//    @Test
//    public void reserveStockTestNull() {
//        int quantity = stockItem3.reserveStock(null);
//        assertThat(quantity, is(0));
//        assertThat(stockItem3.getReserved(), is(0));
//        assertThat(stockItem3.getQuantityStock(), is(0));
//    }

    @Test
    public void unreserveStockTest() {
        int reserved = stockItem2.reserveStock(10);
        int quantity = stockItem2.unreserveStock(4);
        assertThat(quantity, is(4));
        assertThat(stockItem2.getReserved(), is(6));
        assertThat(stockItem2.getQuantityStock(), is(14));
    }

    @Test
    public void unreserveStockTestTooMany() {
        int reserved = stockItem2.reserveStock(9);
        int quantity = stockItem2.unreserveStock(15);
        assertThat(quantity, is(0));
        assertThat(stockItem2.getReserved(), is(9));
        assertThat(stockItem2.getQuantityStock(), is(11));
    }

    @Test
    public void unreserveStockTestNegative() {
        int reserved = stockItem2.reserveStock(8);
        int quantity = stockItem2.unreserveStock(-6);
        assertThat(quantity, is(0));
        assertThat(stockItem2.getReserved(), is(8));
        assertThat(stockItem2.getQuantityStock(), is(12));
    }

    @Test
    public void finaliseStockTest() {
        int reserved = stockItem1.reserveStock(4);
        int quantity = stockItem1.finaliseStock(3);
        assertThat(quantity, is(3));
        assertThat(stockItem1.getReserved(), is(1));
        assertThat(stockItem1.getQuantityStock(), is(6));
    }

    @Test
    public void finaliseStockTooMany() {
        int reserved = stockItem2.reserveStock(14);
        int quantity = stockItem2.finaliseStock(19);
        assertThat(quantity, is(0));
        assertThat(stockItem2.getReserved(), is(14));
        assertThat(stockItem2.getQuantityStock(), is(6));
    }

    @Test
    public void finaliseStockNegative() {
        int reserved = stockItem2.reserveStock(8);
        int quantity = stockItem2.finaliseStock(-4);
        assertThat(quantity, is(0));
        assertThat(stockItem2.getReserved(), is(8));
        assertThat(stockItem2.getQuantityStock(), is(12));
    }

    @Test
    public void setPriceTest() {
        stockItem4.setPrice(15.0);
        double price = stockItem4.getPrice();
        assertThat(price, is(15.0));
    }

    @Test
    public void setPriceTestNegative() {
        stockItem3.setPrice(-10.0);
        double price = stockItem3.getPrice();
        assertThat(price, is(25.0));
    }

    @Test
    public void adjustStockTest() {
        stockItem4.adjustStock(30);
        int stock = stockItem4.getQuantityStock();
        assertThat(stock, is(30));
    }

    @Test
    public void adjustStockTestReduceToZero() {
        stockItem1.adjustStock(-10);
        int stock = stockItem1.getQuantityStock();
        assertThat(stock, is(0));
    }

    @Test
    public void adjustStockTestReduceTooMany() {
        stockItem1.adjustStock(-15);
        int stock = stockItem1.getQuantityStock();
        assertThat(stock, is(10));
    }

    @Test
    public void equalsTestMatch() {
        ArrayList<String> arrTest = new ArrayList<>();
        boolean match = arrTest.equals(arrTest);
        assertThat(match, is(true));
    }

    @Test
    public void equalsTestNull() {
        boolean match = stockItem1.equals(null);
        assertThat(match, is(false));
    }

    @Test
    public void equalsTestDifferentClass() {
        ArrayList<String> arrTest = new ArrayList<>();
        boolean match = stockItem1.equals(arrTest);
        assertThat(match, is(false));
    }

    @Test
    public void equalsTestIdenticalStockItemClass() {
        boolean match = stockItem1.equals(stockItem1);
        assertThat(match, is(true));
    }

    @Test
    public void equalsTestDifferentStockItemClass() {
        boolean match = stockItem1.equals(stockItem2);
        assertThat(match, is(false));
    }

    @Test
    public void toStringTestNoneReserved() {
        String expectedOutput = "Item1 : 10.0, Reserved: 0";
        String actualOutput = stockItem1.toString();
        assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void toStringTestReserved() {
        int quantity = stockItem1.reserveStock(3);
        String expectedOutput = "Item1 : 10.0, Reserved: 3";
        String actualOutput = stockItem1.toString();
        assertThat(actualOutput, is(expectedOutput));
    }

}
