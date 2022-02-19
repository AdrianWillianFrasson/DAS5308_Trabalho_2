package backend;

import java.util.ArrayList;

public class Invoice {

    private String code = "";
    private String date = "";
    private InformationalData info;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Invoice(String code, InformationalData info) {
        this.setCode(code);
        this.setInfo(info);
    }

    public Invoice(String code, String date, InformationalData info) {
        this.setCode(code);
        this.setInfo(info);
        this.setDate(date);
    }

    // Getters ----------------------------------------------------------------
    public String getCode() {
        return this.code;
    }

    public String getDate() {
        return this.date;
    }

    public InformationalData getInfo() {
        return this.info;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    // Setters ----------------------------------------------------------------
    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setInfo(InformationalData info) {
        this.info = info;
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

        for (Item item : this.items) {
            totalPrice += item.getPrice() * item.getQuantity();
        }

        if (this.info instanceof ClientVip) {
            ClientVip clientVip = (ClientVip) this.info;
            totalPrice *= 1 - clientVip.getDiscount() / 100;
        }

        return totalPrice;
    }

}
