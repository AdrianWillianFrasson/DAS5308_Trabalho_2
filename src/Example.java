// UFSC - DAS5308 - Trabalho Java
// Adrian Willian Frasson (20100659)

/*
 * - Cadastro de fornecedores
 *    - Informações basicas
 * 
 * - Cadastro de produtos
 *    - ProdutoTercerizado (Marca e fornecedor)
 *    - ProdutoPróprio (igredientes)
 * 
 * - Cadastro de clientes
 *    - ClienteNormal
 *    - ClienteVip (tem desconto)
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

        // Cadastro de fornecedores -------------------------------------------
        Supplier supplier1 = new Supplier("Fornecedor 1", "03.778.130/0001-48");
        Supplier supplier2 = new Supplier("Fornecedor 2", "18.236.120/0001-58");

        bakery.addSupplier(supplier1);
        bakery.addSupplier(supplier2);

        bakery.printAllSuppliers();

        System.out.println("Fornecedor com CNPJ: 03.778.130/0001-48");
        System.out.println(bakery.getSupplierByCnpj("03.778.130/0001-48").toString() + "\n");

        // Cadastro de Produtos -----------------------------------------------
        ProductOutsourced product1 = new ProductOutsourced("7belo", "159", 7.0, 100, supplier1, "Arcor");
        ProductOutsourced product2 = new ProductOutsourced("Nescau", "696", 13.0, 4, supplier2, "Nestlé");
        ProductHomeMade product3 = new ProductHomeMade("Bolo", "753", 25.0, 3);

        product3.addIngredient(new Ingredient("Farinha", 76.0, 0.2, 10.0, 364.0));
        product3.addIngredient(new Ingredient("Leite", 5.0, 0.6, 3.4, 42.0));
        product3.addIngredient(new Ingredient("Ovo", 0.7, 3.3, 13.0, 155.0));

        bakery.addProduct(product1);
        bakery.addProduct(product2);
        bakery.addProduct(product3);

        bakery.printAllProducts();

        System.out.println("Produto com codigo: 753");
        System.out.println(bakery.getProductByBarCode("753").toString() + "\n");

        // Cadastro de Clientes -----------------------------------------------
        Client client1 = new Client("Pedro", "453.178.287-91");
        Client client2 = new Client("Joao", "296.539.278-50");
        ClientVip clientVip = new ClientVip("Jesus", "382.443.358-31", 20);

        bakery.addClient(client1);
        bakery.addClient(client2);
        bakery.addClient(clientVip);

        bakery.popClient("Pedro");

        bakery.printAllClients();

        System.out.println("Cliente com CPF: 296.539.278-50");
        System.out.println(bakery.getClientByCpf("296.539.278-50").toString() + "\n");

        // Cadastro de Faturas ------------------------------------------------
        Invoice invoice1 = new Invoice(client1);
        Invoice invoice2 = new Invoice(clientVip);

        invoice1.addItem(new Item("Bolo", 2.0, 3));
        invoice1.addItem(new Item("Pao", 1.0, 2));

        invoice2.addItem(new Item("Pao", 1.0, 2));

        bakery.addInvoice(invoice1);
        bakery.addInvoice(invoice2);

        bakery.printAllInvoices();

        // --------------------------------------------------------------------
        System.out.println("Fim");
    }

}
