package backend;

public class ClientVip extends Client {

    private int discount = 0; // Em porcentagem [%]

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
        if (discount > 100) {
            discount = 100;
        }

        this.discount = discount;
    }

    // ------------------------------------------------------------------------
    public String toString() {
        return String.format(super.toString() + " | Client VIP | Desc.: %d", this.getDiscount()) + "%";
    }

    public String toStringDetailed() {
        String text = super.toStringDetailed()
                + String.format("|Desconto: %d", this.getDiscount()) + "%\n";

        return text;
    }
}
