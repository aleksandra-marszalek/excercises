package unit_testing;

public class Car {

    private String name;

    private Integer productionYear;

    public Car(String name, Integer productionYear) {
        this.name = name;
        this.productionYear = productionYear;
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }
}
