package backend;

import java.io.Serializable;

public class Product implements Serializable {

    private String name = "";
    private double price = 0.0;
    private int stock = 0;

    public Product(String name, double price, int stock) {
        this.setName(name);
        this.setPrice(price);
        this.setStock(stock);
    }

    // Setters-----------------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Getters ----------------------------------------------------------------
    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getStock() {
        return this.stock;
    }

}
