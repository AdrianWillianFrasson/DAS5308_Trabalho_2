package backend;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Invoice {

    private static int nextCode = 100;  // UUID

    private int code = 0;
    private String date = "";
    private Client client = new Client("", "");
    private ArrayList<Item> items = new ArrayList<Item>();

    public Invoice(Client client) {
        this.setCode(nextCode++);
        this.setClient(client);
        this.setDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now()));
    }

    public Invoice(Client client, String date) {
        this.setCode(nextCode++);
        this.setClient(client);
        this.setDate(date);
    }

    // Getters ----------------------------------------------------------------
    public int getCode() {
        return this.code;
    }

    public String getDate() {
        return this.date;
    }

    public Client getClient() {
        return this.client;
    }

    public ArrayList<Item> getAllItems() {
        return this.items;
    }

    // Setters ----------------------------------------------------------------
    public void setCode(int code) {
        this.code = code;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // ------------------------------------------------------------------------
    public void addItem(String name, int quantity) {
        Product product = ProductsManager.getProductByName(name);

        // Caso o produto não exista
        if (product == null) {
            return;
        }

        // Caso o cliente tente comprar mais do que existe em estoque
        if (quantity > product.getStock()) {
            quantity = product.getStock();
        }

        if (quantity != 0) {
            Item item = new Item(name, product.getSellPrice(), quantity);
            this.items.add(item);

            product.setStock(product.getStock() - quantity);
        }
    }

    public void popItem(int index) {
        this.items.remove(index);
    }

    // ------------------------------------------------------------------------
    public double totalPrice() {
        double totalPrice = 0.0;

        for (Item item : this.getAllItems()) {
            totalPrice += item.getPrice() * item.getQuantity();
        }

        if (this.client instanceof ClientVip) {
            ClientVip clientVip = (ClientVip) this.client;
            totalPrice *= 1.0 - clientVip.getDiscount() / 100.0;
        }

        return totalPrice;
    }

    // ------------------------------------------------------------------------
    public String toString() {
        return String.format("Cod.: %3d | Data: %s | Preco: %.2f$",
                this.getCode(),
                this.getDate(),
                this.totalPrice());
    }

    public String toStringDetailed() {
        String text = String.format("|Codigo: %d\n", this.getCode())
                + String.format("|Data: %s\n", this.getDate())
                + String.format("|Cliente: %s\n", this.getClient().getName())
                + String.format("|Preco total: %.2f$\n", this.totalPrice());

        if (this.client instanceof ClientVip) {
            ClientVip clientVip = (ClientVip) this.client;
            text += String.format("|Desconto aplicado: %d", clientVip.getDiscount()) + "%\n";
        }

        text += "|Itens comprados:\n";

        for (Item item : this.getAllItems()) {
            text += String.format("| - %7s | P: %.2f$ | Q: %d\n", item.getName(), item.getPrice(), item.getQuantity());
        }

        return text;
    }

}
