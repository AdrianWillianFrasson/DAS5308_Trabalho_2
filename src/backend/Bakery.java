package backend;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;

public class Bakery {

    private HashMap<String, Supplier> suppliers = new HashMap<String, Supplier>();
    private HashMap<String, Product> products = new HashMap<String, Product>();
    private HashMap<String, Client> clients = new HashMap<String, Client>();
    private ArrayList<Invoice> invoices = new ArrayList<Invoice>();

    // Adicionar os metodos de consulta, getByCPF, getByCnpj

    // Getters ----------------------------------------------------------------
    // public InformationalData getInformationalData() {
    // return this.informationalData;
    // }

    public Collection<Supplier> getAllSuppliers() {
        return this.suppliers.values();
    }

    public Collection<Product> getAllProducts() {
        return this.products.values();
    }

    public Collection<Client> getAllClients() {
        return this.clients.values();
    }

    public ArrayList<Invoice> getAllInvoices() {
        return this.invoices;
    }

    public Supplier getSupplierByName(String name) {
        return this.suppliers.get(name);
    }

    public Product getProductByName(String name) {
        return this.products.get(name);
    }

    public Client getClientByName(String name) {
        return this.clients.get(name);
    }

    // Setters ----------------------------------------------------------------
    // public void setInformationalData(InformationalData informationalData) {
    // this.informationalData = informationalData;
    // }

    // ------------------------------------------------------------------------
    public void addSupplier(Supplier supplier) {
        this.suppliers.put(supplier.getName(), supplier);
    }

    public void addProduct(Product product) {
        this.products.put(product.getName(), product);
    }

    public void addClient(Client client) {
        this.clients.put(client.getName(), client);
    }

    public void addInvoice(Invoice invoice) {
        this.invoices.add(invoice);
    }

    public void popSupplier(String name) {
        this.suppliers.remove(name);
    }

    public void popProduct(String name) {
        this.products.remove(name);
    }

    public void popClient(String name) {
        this.clients.remove(name);
    }

    // ------------------------------------------------------------------------
    public double totalPrice() {
        double totalPrice = 0.0;

        for (Invoice invoice : this.invoices) {
            totalPrice += invoice.totalPrice();
        }

        return totalPrice;
    }

}
