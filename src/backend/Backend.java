package backend;

import java.util.Collection;

public class Backend {

    private Project project = new Project();

    public void addProduct(String name, double price, int stock) {
        Product product = new Product(name, price, stock);
        this.getProject().getProducts().put(name, product);
    }

    public void addCartItem(String name, int quantity) {
        CartItem cartItem = new CartItem(name, quantity);
        this.getProject().getCartItems().put(name, cartItem);
    }

    public void popProduct(String name) {
        this.getProject().getProducts().remove(name);
        this.popCartItem(name);
    }

    public void popCartItem(String name) {
        this.getProject().getCartItems().remove(name);
    }

    public Product getProduct(String name) {
        return this.getProject().getProducts().get(name);
    }

    public CartItem getCartItem(String name) {
        return this.getProject().getCartItems().get(name);
    }

    public Collection<Product> getAllProducts() {
        return this.getProject().getProducts().values();
    }

    public Collection<CartItem> getAllCartItems() {
        return this.getProject().getCartItems().values();
    }

    public void removeAllCartItems() {
        this.getProject().getCartItems().clear();
    }

    public void saveProject(String path) {
        ProjectDAO.saveProject(path, this.getProject());
    }

    public void loadProject(String path) {
        this.setProject(ProjectDAO.loadProject(path));
    }

    // Setters-----------------------------------------------------------------
    public void setProject(Project project) {
        this.project = project;
    }

    // Getters ----------------------------------------------------------------
    public Project getProject() {
        return this.project;
    }

}
