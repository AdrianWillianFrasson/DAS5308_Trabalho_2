package backend;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Invoice {

    private static int nextCode = 100;

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
    public void addItem(Item item) {
        this.items.add(item);
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

}
