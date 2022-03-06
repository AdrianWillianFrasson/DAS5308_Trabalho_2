package backend;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;

public class Bakery {

    private HashMap<String, Supplier> suppliers = new HashMap<String, Supplier>();
    private HashMap<String, Client> clients = new HashMap<String, Client>();
    private ArrayList<Invoice> invoices = new ArrayList<Invoice>();

    // Getters ----------------------------------------------------------------
    public Collection<Product> getAllProducts() {
        return ProductsManager.getAllProducts();
    }

    public Collection<Supplier> getAllSuppliers() {
        return this.suppliers.values();
    }

    public Collection<Client> getAllClients() {
        return this.clients.values();
    }

    public ArrayList<Invoice> getAllInvoices() {
        return this.invoices;
    }

    public Product getProductByName(String name) {
        return ProductsManager.getProductByName(name);
    }

    public Supplier getSupplierByName(String name) {
        return this.suppliers.get(name);
    }

    public Client getClientByName(String name) {
        return this.clients.get(name);
    }

    public Supplier getSupplierByCnpj(String cnpj) {
        for (Supplier supplier : this.suppliers.values()) {
            if (supplier.getCnpj().equals(cnpj)) {
                return supplier;
            }
        }
        return null;
    }

    public Product getProductByBarCode(String barCode) {
        return ProductsManager.getProductByBarCode(barCode);
    }

    public Client getClientByCpf(String cpf) {
        for (Client client : this.clients.values()) {
            if (client.getCpf().equals(cpf)) {
                return client;
            }
        }
        return null;
    }

    public Invoice getInvoiceByCode(int code) {
        for (Invoice invoice : this.invoices) {
            if (invoice.getCode() == code) {
                return invoice;
            }
        }
        return null;
    }

    // ------------------------------------------------------------------------
    public void addSupplier(Supplier supplier) {
        this.suppliers.put(supplier.getName(), supplier);
    }

    public void addProduct(Product product) {
        ProductsManager.addProduct(product);
    }

    public void addClient(Client client) {
        this.clients.put(client.getName(), client);
    }

    public void addInvoice(Invoice invoice) {
        this.invoices.add(invoice);
    }

    public void popSupplierByName(String name) {
        this.suppliers.remove(name);
    }

    public void popProductByName(String name) {
        ProductsManager.popProductByName(name);
    }

    public void popClientByName(String name) {
        this.clients.remove(name);
    }

    // ------------------------------------------------------------------------
    public double totalProfit() {
        double profit = 0.0;

        for (Invoice invoice : this.getAllInvoices()) {
            profit += invoice.totalPrice();
        }

        return profit;
    }

    // ------------------------------------------------------------------------
    public String printAllSuppliers() {
        String text = "";
        int number = 1;

        text += "-----------------Fornecedores---------------------\n";
        for (Supplier supplier : this.getAllSuppliers()) {
            text += number++ + " | " + supplier.toString() + "\n";
        }
        text += "--------------------------------------------------\n";

        return text;
    }

    public String printAllProducts() {
        String text = "";
        int number = 1;

        text += "-------------------Produtos-----------------------\n";
        for (Product product : this.getAllProducts()) {
            text += number++ + " | " + product.toString() + "\n";
        }
        text += "--------------------------------------------------\n";

        return text;
    }

    public String printAllClients() {
        String text = "";
        int number = 1;

        text += "-------------------Clientes-----------------------\n";
        for (Client client : this.getAllClients()) {
            text += number++ + " | " + client.toString() + "\n";
        }
        text += "--------------------------------------------------\n";

        return text;
    }

    public String printAllInvoices() {
        String text = "";
        int number = 1;

        System.out.println("-----------------Notas de Venda-------------------\n");
        for (Invoice invoice : this.getAllInvoices()) {
            System.out.println(number++ + " | " + invoice.toString());
        }
        System.out.println("--------------------------------------------------\n");
        System.out.println(String.format("Lucro total: %.2f$\n", this.totalProfit()));

        return text;
    }

}
