package backend;

import java.io.Serializable;
import java.util.Hashtable;

public class Project implements Serializable {

    private Hashtable<String, Product> products = new Hashtable<String, Product>();
    private Hashtable<String, CartItem> cartItems = new Hashtable<String, CartItem>();

    // Getters ----------------------------------------------------------------
    public Hashtable<String, Product> getProducts() {
        return this.products;
    }

    public Hashtable<String, CartItem> getCartItems() {
        return this.cartItems;
    }

}
