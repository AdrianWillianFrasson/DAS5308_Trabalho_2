package backend;

public class ProductOutsourced extends Product {

    private String brand = "";
    private Supplier supplier = new Supplier("");

    public ProductOutsourced(String name, double buyPrice, double sellPrice, Supplier supplier) {
        super(name, buyPrice, sellPrice);
        this.setSupplier(supplier);
    }

    // Getters ----------------------------------------------------------------
    public String getBrand() {
        return this.brand;
    }

    public Supplier getSupplier() {
        return this.supplier;
    }

    // Setters ----------------------------------------------------------------
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

}
