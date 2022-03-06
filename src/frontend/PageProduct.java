package frontend;

import java.awt.*;

public class PageProduct extends Panel {

    public Button btn_searchByName = new Button("Procurar por Nome");
    public Button btn_searchByBarCode = new Button("Procurar por Codigo de Barra");
    public Button btn_showAll = new Button("Mostrar Todos");
    public Button btn_addIngredient = new Button("Adicionar Ingrediente");
    public Button btn_popIngredient = new Button("Remover Ingrediente");
    public Button btn_add = new Button("Cadastrar Produto");
    public Button btn_pop = new Button("Remover Produto por Nome");

    public TextField txt_search = new TextField();
    public TextField txt_name = new TextField();
    public TextField txt_namePop = new TextField();
    public TextField txt_nameIngredient = new TextField();
    public TextField txt_barcode = new TextField();
    public TextField txt_sellPrice = new TextField();
    public TextField txt_stock = new TextField();
    public TextField txt_brand = new TextField();
    public TextField txt_carbohydrates = new TextField();
    public TextField txt_saturatedFat = new TextField();
    public TextField txt_proteins = new TextField();
    public TextField txt_calories = new TextField();

    public Label lbl_name = new Label("Nome:");
    public Label lbl_nameIngredient = new Label("Nome:");
    public Label lbl_barcode = new Label("Codigo de Barra:");
    public Label lbl_sellPrice = new Label("Preco de venda [$]:");
    public Label lbl_stock = new Label("Quantidade em Estoque:");
    public Label lbl_productType = new Label("Tipo de Produto:");
    public Label lbl_supplier = new Label("Fornecedor:");
    public Label lbl_brand = new Label("Marca:");
    public Label lbl_carbohydrates = new Label("Carboidratos  [100g]:");
    public Label lbl_saturatedFat = new Label("Gorduras S.  [100g]:");
    public Label lbl_proteins = new Label("Proteinas  [100g]:");
    public Label lbl_calories = new Label("Calorias [100g]:");

    public TextArea txtArea = new TextArea();

    public List ingredients = new List();

    public Choice productType = new Choice();
    public Choice supplier = new Choice();

    public PageProduct() {
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(246, 246, 246));
        this.setFont(new Font("SansSerif", Font.PLAIN, 16));

        // --------------------------------------------------------------------
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 0;
        this.add(this.txt_search, c);

        c.gridwidth = 1;
        c.gridy = 0;
        c.gridx = 3;
        this.add(this.btn_searchByName, c);

        c.gridy = 0;
        c.gridx = 4;
        this.add(this.btn_searchByBarCode, c);

        c.gridy = 0;
        c.gridx = 5;
        this.add(this.btn_showAll, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 6;
        c.weighty = 1.0;
        c.gridy = 1;
        c.gridx = 0;
        this.txtArea.setEditable(false);
        this.txtArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        this.add(this.txtArea, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.gridy = 2;
        c.gridx = 0;
        this.add(this.lbl_name, c);

        c.gridy = 2;
        c.gridx = 1;
        this.add(this.txt_name, c);

        c.gridy = 3;
        c.gridx = 0;
        this.add(this.lbl_barcode, c);

        c.gridy = 3;
        c.gridx = 1;
        this.add(this.txt_barcode, c);

        c.gridy = 4;
        c.gridx = 0;
        this.add(this.lbl_sellPrice, c);

        c.gridy = 4;
        c.gridx = 1;
        this.add(this.txt_sellPrice, c);

        c.gridy = 5;
        c.gridx = 0;
        this.add(this.lbl_stock, c);

        c.gridy = 5;
        c.gridx = 1;
        this.add(this.txt_stock, c);

        c.gridy = 6;
        c.gridx = 0;
        this.add(this.lbl_productType, c);

        c.gridy = 6;
        c.gridx = 1;
        this.productType.add("Tercerizado");
        this.productType.add("Proprio");
        this.add(this.productType, c);

        c.gridy = 7;
        c.gridx = 0;
        this.add(this.lbl_supplier, c);

        c.gridy = 7;
        c.gridx = 1;
        this.add(this.supplier, c);

        c.gridy = 8;
        c.gridx = 0;
        this.add(this.lbl_brand, c);

        c.gridy = 8;
        c.gridx = 1;
        this.add(this.txt_brand, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 3;
        c.gridwidth = 4;
        c.gridy = 2;
        c.gridx = 2;
        this.ingredients.setEnabled(false);
        this.add(this.ingredients, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridy = 5;
        c.gridx = 2;
        this.add(this.lbl_nameIngredient, c);

        c.gridwidth = 3;
        c.gridy = 5;
        c.gridx = 3;
        this.txt_nameIngredient.setEnabled(false);
        this.add(this.txt_nameIngredient, c);

        c.gridwidth = 1;
        c.gridy = 6;
        c.gridx = 2;
        this.add(this.lbl_carbohydrates, c);

        c.gridy = 6;
        c.gridx = 3;
        this.txt_carbohydrates.setEnabled(false);
        this.add(this.txt_carbohydrates, c);

        c.gridy = 7;
        c.gridx = 2;
        this.add(this.lbl_saturatedFat, c);

        c.gridy = 7;
        c.gridx = 3;
        this.txt_saturatedFat.setEnabled(false);
        this.add(this.txt_saturatedFat, c);

        c.gridy = 6;
        c.gridx = 4;
        this.add(this.lbl_proteins, c);

        c.gridy = 6;
        c.gridx = 5;
        this.txt_proteins.setEnabled(false);
        this.add(this.txt_proteins, c);

        c.gridy = 7;
        c.gridx = 4;
        this.add(this.lbl_calories, c);

        c.gridy = 7;
        c.gridx = 5;
        this.txt_calories.setEnabled(false);
        this.add(this.txt_calories, c);

        c.gridwidth = 2;
        c.gridy = 8;
        c.gridx = 2;
        this.btn_addIngredient.setEnabled(false);
        this.add(this.btn_addIngredient, c);

        c.gridy = 8;
        c.gridx = 4;
        this.btn_popIngredient.setEnabled(false);
        this.add(this.btn_popIngredient, c);

        c.gridwidth = 6;
        c.gridy = 9;
        c.gridx = 0;
        this.add(this.btn_add, c);

        c.gridwidth = 3;
        c.gridy = 10;
        c.gridx = 0;
        this.add(this.txt_namePop, c);

        c.gridy = 10;
        c.gridx = 3;
        this.add(this.btn_pop, c);
    }

}
