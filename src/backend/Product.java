package backend;

// Classes filhas:
//     - ProductOutsourced
//     - ProductHomeMade

public abstract class Product {

    private String name = "";
    private String barCode = "";
    private double buyPrice = 0.0;
    private double sellPrice = 0.0;
    private int stock = 0;

    public Product(String name, double buyPrice, double sellPrice) {
        this.setName(name);
        this.setBuyPrice(buyPrice);
        this.setSellPrice(sellPrice);
    }

    // Getters ----------------------------------------------------------------
    public String getName() {
        return this.name;
    }

    public String getBarCode() {
        return this.barCode;
    }

    public double getBuyPrice() {
        return this.buyPrice;
    }

    public double getSellPrice() {
        return this.sellPrice;
    }

    public int getStock() {
        return this.stock;
    }

    // Setters ----------------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
