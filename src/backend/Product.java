package backend;

// Classes filhas:
//     - ProductOutsourced
//     - ProductHomeMade

public abstract class Product {

    private String name = "";
    private String barCode = "";
    private double sellPrice = 0.0;
    private int stock = 0;

    public Product(String name, String barCode, double sellPrice, int stock) {
        this.setName(name);
        this.setBarCode(barCode);
        this.setSellPrice(sellPrice);
        this.setStock(stock);
    }

    // Getters ----------------------------------------------------------------
    public String getName() {
        return this.name;
    }

    public String getBarCode() {
        return this.barCode;
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

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // ------------------------------------------------------------------------
    public String toString() {
        return String.format("Nome: %6s | Cod.: %3s | P.V.: %5.2f$ | Estoque: %3d",
                this.getName(),
                this.getBarCode(),
                this.getSellPrice(),
                this.getStock());
    }

}
