package backend;

import java.io.Serializable;

public class CartItem implements Serializable {

    private String name = "";
    private int quantity = 0;

    public CartItem(String name, int quantity) {
        this.setName(name);
        this.setQuantity(quantity);
    }

    // Setters-----------------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getters ----------------------------------------------------------------
    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
