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

import backend.Bakery;
import frontend.Gui;

public class App {

    public static void main(String[] args) throws Exception {

        Bakery bakery = new Bakery();
        Gui gui = new Gui(bakery);
        gui.run();

    }

}
