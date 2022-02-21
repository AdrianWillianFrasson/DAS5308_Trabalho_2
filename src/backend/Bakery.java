package backend;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;

public class Bakery {

    private HashMap<String, Supplier> suppliers = new HashMap<String, Supplier>();
    private HashMap<String, Product> products = new HashMap<String, Product>();
    private HashMap<String, Client> clients = new HashMap<String, Client>();
    private ArrayList<Invoice> invoices = new ArrayList<Invoice>();

    // Adicionar toStringDetalhado
    // Adicionar composição com a classe InformationalData
    // Items adicionados a Invoices deve bater com os produtos

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

    public Supplier getSupplierByCnpj(String cnpj) {
        for (Supplier supplier : this.suppliers.values()) {
            if (supplier.getCnpj() == cnpj) {
                return supplier;
            }
        }
        return null;
    }

    public Product getProductByBarCode(String barCode) {
        for (Product product : this.products.values()) {
            if (product.getBarCode() == barCode) {
                return product;
            }
        }
        return null;
    }

    public Client getClientByCpf(String cpf) {
        for (Client client : this.clients.values()) {
            if (client.getCpf() == cpf) {
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

    // Setters ----------------------------------------------------------------
    // public void setInformationalData(InformationalData informationalData) {
    // this.informationalData = informationalData;
    // }

    // ------------------------------------------------------------------------
    public void addSupplier(Supplier supplier) {
        this.suppliers.put(supplier.getName(), supplier);
    }

    public void addProduct(ProductOutsourced product) {
        this.products.put(product.getName(), product);
    }

    public void addProduct(ProductHomeMade product) {
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
    public double totalProfit() {
        double profit = 0.0;

        for (Invoice invoice : this.getAllInvoices()) {
            profit += invoice.totalPrice();
        }

        return profit;
    }

    // ------------------------------------------------------------------------
    public void printAllSuppliers() {
        int number = 1;
        System.out.println("-----------------Fornecedores---------------------");
        for (Supplier supplier : this.getAllSuppliers()) {
            System.out.println(number++ + " | " + supplier.toString());
        }
        System.out.println("--------------------------------------------------\n");
    }

    public void printAllProducts() {
        int number = 1;
        System.out.println("-------------------Produtos-----------------------");
        for (Product product : this.getAllProducts()) {
            System.out.println(number++ + " | " + product.toString());
        }
        System.out.println("--------------------------------------------------\n");
    }

    public void printAllClients() {
        int number = 1;
        System.out.println("-------------------Clientes-----------------------");
        for (Client client : this.getAllClients()) {
            System.out.println(number++ + " | " + client.toString());
        }
        System.out.println("--------------------------------------------------\n");
    }

    public void printAllInvoices() {
        int number = 1;
        System.out.println("-----------------Notas de Venda-------------------");
        for (Invoice invoice : this.getAllInvoices()) {
            System.out.println(number++ + " | " + invoice.toString());
        }
        System.out.println("--------------------------------------------------");
        System.out.println(String.format("Lucro total: %.2f$\n", this.totalProfit()));
    }

}
