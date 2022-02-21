package backend;

public class ClientVip extends Client {

    private int discount = 0; // Em %

    public ClientVip(String name, String cpf, int discount) {
        super(name, cpf);
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

    // ------------------------------------------------------------------------
    public String toString() {
        return String.format(super.toString() + " | Client VIP | Disc.: %d", this.getDiscount()) + "%";
    }

}
