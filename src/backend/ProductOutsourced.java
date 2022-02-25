package backend;

public class ProductOutsourced extends Product {

    private Supplier supplier = new Supplier("", "");
    private String brand = "";

    public ProductOutsourced(String name, String barCode, double sellPrice, int stock, Supplier supplier,
            String brand) {
        super(name, barCode, sellPrice, stock);
        this.setSupplier(supplier);
        this.setBrand(brand);
    }

    // Getters ----------------------------------------------------------------
    public Supplier getSupplier() {
        return this.supplier;
    }

    public String getBrand() {
        return this.brand;
    }

    // Setters ----------------------------------------------------------------
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // ------------------------------------------------------------------------
    public String toString() {
        return String.format(super.toString() + " | Tipo: Tercerizado | Fornecedor: %s",
                this.getSupplier().getName());
    }

    public String toStringDetailed() {
        String text = super.toStringDetailed()
                + String.format("|Fornecedor: %s\n", this.getSupplier().getName())
                + String.format("|Marca: %s\n", this.getBrand());

        return text;
    }

}
