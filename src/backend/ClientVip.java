package backend;

public class ClientVip extends Client {

    private int discount = 0; // Em %

    public ClientVip(String name, int discount) {
        super(name);
        this.setDiscount(discount);
    }

    // Getters ----------------------------------------------------------------
    public int getDiscount() {
        return this.discount;
    }

    // Setters ----------------------------------------------------------------
    public void setDiscount(int discount) {
        this.discount = discount;
    }

}
