package frontend.GUI;

import java.awt.*;

public abstract class MainWindow_GUI extends Frame {

    // Components -------------------------------------------------------------
    protected Panel panel_pages = new Panel();
    protected Panel panel_info = new Panel();
    protected Panel panel_data = new Panel();
    protected Panel panel_cart = new Panel();

    protected CardLayout card_layout = new CardLayout();

    protected Button btn_menu_info = new Button("Informacoes");
    protected Button btn_menu_data = new Button("Banco de dados");
    protected Button btn_menu_cart = new Button("Carrinho");
    protected Button btn_info_load = new Button("Carregar projeto");
    protected Button btn_info_save = new Button("Salvar projeto");
    protected Button btn_data_add = new Button("Criar produto");
    protected Button btn_data_pop = new Button("Excluir produto selecionado");
    protected Button btn_cart_add = new Button("Adicionar produto ao carrinho");
    protected Button btn_cart_pop = new Button("Remover produto selecionado do carrinho");
    protected Button btn_cart_pay = new Button("Realizar compra");

    protected Label lbl_info_cnpj = new Label("Cnpj:");
    protected Label lbl_info_city = new Label("City:");
    protected Label lbl_info_email = new Label("Email:");
    protected Label lbl_info_address = new Label("Address:");
    protected Label lbl_info_telephone = new Label("Telephone:");
    protected Label lbl_data_search = new Label("Filtrar produtos:");
    protected Label lbl_data_name = new Label("Nome do produto:");
    protected Label lbl_data_price = new Label("Preco do produto [$]:");
    protected Label lbl_data_stock = new Label("Quantidade em estoque:");
    protected Label lbl_cart_name = new Label("Produto:");
    protected Label lbl_cart_price = new Label("Preco unitario [$]:");
    protected Label lbl_cart_stock = new Label("Quantidade em estoque:");
    protected Label lbl_cart_quantity = new Label("Quantidade de compra:");
    protected Label lbl_cart_total = new Label("Total a pagar: $0");

    protected TextField txt_info_cnpj = new TextField();
    protected TextField txt_info_city = new TextField();
    protected TextField txt_info_email = new TextField();
    protected TextField txt_info_address = new TextField();
    protected TextField txt_info_telephone = new TextField();
    protected TextField txt_data_search = new TextField();
    protected TextField txt_data_name = new TextField();
    protected TextField txt_data_price = new TextField();
    protected TextField txt_data_stock = new TextField();
    protected TextField txt_cart_quantity = new TextField();
    protected TextField txt_cart_price = new TextField();
    protected TextField txt_cart_stock = new TextField();

    protected Choice choice_name = new Choice();

    protected List list_data = new List();
    protected List list_cart = new List();

    // Constructor ------------------------------------------------------------
    public MainWindow_GUI() {
        this.setTitle("Janela Principal");
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(246, 246, 246));
        this.setFont(new Font("SansSerif", Font.PLAIN, 16));

        // --------------------------------------------------------------------
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 1.0;
        c.weightx = 0.0;
        c.gridy = 0;
        c.gridx = 0;
        c.insets = new Insets(5, 5, 5, 5);
        this.btn_menu_info.setBackground(Color.LIGHT_GRAY);
        this.add(this.btn_menu_info, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 1.0;
        c.weightx = 0.0;
        c.gridy = 1;
        c.gridx = 0;
        this.btn_menu_data.setBackground(Color.LIGHT_GRAY);
        this.add(this.btn_menu_data, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 1.0;
        c.weightx = 0.0;
        c.gridy = 2;
        c.gridx = 0;
        this.btn_menu_cart.setBackground(Color.LIGHT_GRAY);
        this.add(this.btn_menu_cart, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 3;
        c.gridwidth = 1;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 1;
        this.panel_pages.setLayout(this.card_layout);
        this.panel_pages.add("info", this.panel_info);
        this.panel_pages.add("data", this.panel_data);
        this.panel_pages.add("cart", this.panel_cart);
        this.add(this.panel_pages, c);

        // --------------------------------------------------------------------
        this.panel_info.setLayout(new GridBagLayout());

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 0;
        this.panel_info.add(this.btn_info_load, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 1;
        this.panel_info.add(this.btn_info_save, c);

        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 0.0;
        c.gridy = 1;
        c.gridx = 0;
        this.panel_info.add(this.lbl_info_cnpj, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 1;
        c.gridx = 1;
        this.panel_info.add(this.txt_info_cnpj, c);

        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 0.0;
        c.gridy = 2;
        c.gridx = 0;
        this.panel_info.add(this.lbl_info_city, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 2;
        c.gridx = 1;
        this.panel_info.add(this.txt_info_city, c);

        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 0.0;
        c.gridy = 3;
        c.gridx = 0;
        this.panel_info.add(this.lbl_info_email, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 3;
        c.gridx = 1;
        this.panel_info.add(this.txt_info_email, c);

        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 0.0;
        c.gridy = 4;
        c.gridx = 0;
        this.panel_info.add(this.lbl_info_address, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 4;
        c.gridx = 1;
        this.panel_info.add(this.txt_info_address, c);

        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 0.0;
        c.gridy = 5;
        c.gridx = 0;
        this.panel_info.add(this.lbl_info_telephone, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 5;
        c.gridx = 1;
        this.panel_info.add(this.txt_info_telephone, c);

        // --------------------------------------------------------------------
        this.panel_data.setLayout(new GridBagLayout());

        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 0.0;
        c.gridy = 0;
        c.gridx = 0;
        this.panel_data.add(this.lbl_data_search, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 1;
        this.panel_data.add(this.txt_data_search, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.gridy = 1;
        c.gridx = 0;
        this.panel_data.add(this.list_data, c);

        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 2;
        c.gridx = 0;
        this.panel_data.add(this.lbl_data_name, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 2;
        c.gridx = 1;
        this.panel_data.add(this.txt_data_name, c);

        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 3;
        c.gridx = 0;
        this.panel_data.add(this.lbl_data_price, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 3;
        c.gridx = 1;
        this.panel_data.add(this.txt_data_price, c);

        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 4;
        c.gridx = 0;
        this.panel_data.add(this.lbl_data_stock, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 4;
        c.gridx = 1;
        this.panel_data.add(this.txt_data_stock, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 5;
        c.gridx = 0;
        this.panel_data.add(this.btn_data_add, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 6;
        c.gridx = 0;
        this.panel_data.add(this.btn_data_pop, c);

        // --------------------------------------------------------------------
        this.panel_cart.setLayout(new GridBagLayout());

        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 0;
        this.panel_cart.add(this.lbl_cart_name, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 1;
        this.panel_cart.add(this.choice_name, c);

        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 1;
        c.gridx = 0;
        this.panel_cart.add(this.lbl_cart_price, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 1;
        c.gridx = 1;
        this.txt_cart_price.setEditable(false);
        this.panel_cart.add(this.txt_cart_price, c);

        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 2;
        c.gridx = 0;
        this.panel_cart.add(this.lbl_cart_stock, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 2;
        c.gridx = 1;
        this.txt_cart_stock.setEditable(false);
        this.panel_cart.add(this.txt_cart_stock, c);

        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 3;
        c.gridx = 0;
        this.panel_cart.add(this.lbl_cart_quantity, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 3;
        c.gridx = 1;
        this.panel_cart.add(this.txt_cart_quantity, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 4;
        c.gridx = 0;
        this.panel_cart.add(this.btn_cart_add, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.gridy = 5;
        c.gridx = 0;
        this.panel_cart.add(this.list_cart, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 6;
        c.gridx = 0;
        this.panel_cart.add(this.btn_cart_pop, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 7;
        c.gridx = 0;
        this.panel_cart.add(this.btn_cart_pay, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 8;
        c.gridx = 0;
        this.lbl_cart_total.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.panel_cart.add(this.lbl_cart_total, c);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1080, 720);
    }

    public void run() {
        this.pack();
        this.setVisible(true);
    }

}
