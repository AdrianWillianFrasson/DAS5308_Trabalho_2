// UFSC - DAS5308 - Trabalho Java
// Adrian Willian Frasson (20100659)

import backend.Bakery;
import frontend.Frontend;

public class App {

    public static void main(String[] args) throws Exception {
        Bakery bakery = new Bakery();

        // Frontend frontend = new Frontend(bakery);
        // frontend.run();
    }

}

/*
 * - Cadastro de fornecedores
 * - informações basicas
 * 
 * - Cadastro de produtos
 * - ProdutoTercerizado (Marca e fornecedor), ProdutoHomemade (igredientes)
 * - Preço de aquisição e venda
 * 
 * - Cadastro de clientes
 * - ClienteNormal, ClienteVip (tem desconto)
 * 
 * - Cadastro de notas de compra/venda
 * - mostra um balanço
 * 
 */