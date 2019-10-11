package Shopping;

public class StockItem {

    private final String name;
    private double price;
    private int quantityStock;
    private int reserved;

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getReserved() {
        return reserved;
    }

    public int getQuantityStock() {
        return quantityStock - reserved;
    }

    public int reserveStock(int quantity) {
        if ((quantity <= getQuantityStock()) && (quantity > 0)) {
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(int quantity) {
        if ((quantity <= reserved) && (quantity > 0)) {
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public int finaliseStock(int quantity) {
        if ((quantity <= reserved) && (quantity > 0)) {
            quantityStock -= quantity;
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 15;
    }

//    @Override
//    public int compareTo(StockItem o) {
//        if (this == o) {
//            return 0;
//        }
//        if (o != null) {
//            return this.name.compareTo(o.getName());
//        }
//        throw new NullPointerException();
//    }

    @Override
    public String toString() {
        return this.name + " : " + this.price + ", Reserved: " + this.reserved;
    }

}



