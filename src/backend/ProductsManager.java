package backend;

import java.util.Collection;
import java.util.HashMap;

public class ProductsManager {

    private static HashMap<String, Product> products = new HashMap<String, Product>();

    // Getters ----------------------------------------------------------------
    public static Collection<Product> getAllProducts() {
        return products.values();
    }

    public static Product getProductByName(String name) {
        return products.get(name);
    }

    public static Product getProductByBarCode(String barCode) {
        for (Product product : products.values()) {
            if (product.getBarCode().equals(barCode)) {
                return product;
            }
        }
        return null;
    }

    // ------------------------------------------------------------------------
    public static void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    public static void popProductByName(String name) {
        products.remove(name);
    }

}
