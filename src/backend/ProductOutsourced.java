package backend;

public class ProductOutsourced extends Product {

    private String brand = "";
    private Supplier supplier = new Supplier("", "");

    public ProductOutsourced(String name, String barCode, double sellPrice, int stock, Supplier supplier,
            String brand) {
        super(name, barCode, sellPrice, stock);
        this.setSupplier(supplier);
        this.setBrand(brand);
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

    // ------------------------------------------------------------------------
    public String toString() {
        return String.format(super.toString() + " | Tipo: Tercerizado | Fornecedor: %s",
                this.getSupplier().getName());
    }

}
