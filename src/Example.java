// UFSC - DAS5308 - Trabalho Java
// Adrian Willian Frasson (20100659)

/*
 * - Cadastro de fornecedores
 *    - Informações basicas
 * 
 * - Cadastro de produtos
 *    - ProdutoTercerizado (Marca e fornecedor)
 *    - ProdutoPróprio (Igredientes)
 * 
 * - Cadastro de clientes
 *    - ClienteNormal
 *    - ClienteVip (Tem desconto)
 * 
 * - Cadastro de notas de venda
 *    - Vinculada a um cliente
 *    - Mostra o lucro total
 */

import backend.*;

public class Example {

    public static void main(String[] args) throws Exception {
        System.out.println("Inicio");

        Bakery bakery = new Bakery();

        // Cadastro de Fornecedores -------------------------------------------
        Supplier supplier1 = new Supplier("Fornecedor 1", "03.778.130/0001-48");
        Supplier supplier2 = new Supplier("Fornecedor 2", "18.236.120/0001-58");

        supplier1.setEmail("fornecedor1@gmail.com");

        bakery.addSupplier(supplier1);
        bakery.addSupplier(supplier2);

        bakery.printAllSuppliers();

        System.out.println("-> Fornecedor com CNPJ: 03.778.130/0001-48");
        System.out.println(bakery.getSupplierByCnpj("03.778.130/0001-48").toStringDetailed());

        // Cadastro de Produtos -----------------------------------------------
        ProductOutsourced product1 = new ProductOutsourced("7belo", "159", 0.25, 100, supplier1, "Arcor");
        ProductOutsourced product2 = new ProductOutsourced("Nescau", "696", 13.0, 4, supplier2, "Nestle");
        ProductHomeMade product3 = new ProductHomeMade("Bolo", "753", 25.0, 3);

        product3.addIngredient(new Ingredient("Farinha", 76.0, 0.2, 10.0, 364.0));
        product3.addIngredient(new Ingredient("Leite", 5.0, 0.6, 3.4, 42.0));
        product3.addIngredient(new Ingredient("Ovo", 0.7, 3.3, 13.0, 155.0));

        bakery.addProduct(product1);
        bakery.addProduct(product2);
        bakery.addProduct(product3);

        bakery.printAllProducts();

        System.out.println("-> Produto com codigo de barras: 696");
        System.out.println(bakery.getProductByBarCode("696").toStringDetailed());

        System.out.println("-> Produto com codigo de barras: 753");
        System.out.println(bakery.getProductByBarCode("753").toStringDetailed());

        // Cadastro de Clientes -----------------------------------------------
        Client client1 = new Client("Pedro", "453.178.287-91");
        Client client2 = new Client("Joao", "296.539.278-50");
        ClientVip clientVip = new ClientVip("Jesus", "382.443.358-31", 20);

        bakery.addClient(client1);
        bakery.addClient(client2);
        bakery.addClient(clientVip);

        bakery.popClientByName("Pedro");

        bakery.printAllClients();

        System.out.println("-> Cliente com CPF: 382.443.358-31");
        System.out.println(bakery.getClientByCpf("382.443.358-31").toStringDetailed());

        // Cadastro de Notas de Venda -----------------------------------------
        Invoice invoice1 = new Invoice(client2);
        Invoice invoice2 = new Invoice(clientVip);

        invoice1.addItem("7belo", 10);
        invoice1.addItem("Bolo", 2);

        invoice2.addItem("Nescau", 1);
        invoice2.addItem("Bolo", 3);

        bakery.addInvoice(invoice1);
        bakery.addInvoice(invoice2);

        bakery.printAllInvoices();

        System.out.println("-> Nota com codigo: 101");
        System.out.println(bakery.getInvoiceByCode(101).toStringDetailed());

        bakery.printAllProducts();

        // --------------------------------------------------------------------
        System.out.println("Fim");
    }

}
