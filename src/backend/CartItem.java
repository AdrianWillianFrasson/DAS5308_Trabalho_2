package backend;

public class CartItem extends Product {

    private int quantity = 0;

    public CartItem(String name, double price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }

    // Setters-----------------------------------------------------------------
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getters ----------------------------------------------------------------
    public int getQuantity() {
        return this.quantity;
    }
}
