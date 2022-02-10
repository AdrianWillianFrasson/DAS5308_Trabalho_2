package frontend.GUI;

import java.awt.*;
import java.awt.event.*;

public class MainWindow_GUI extends Frame {

    // Components -------------------------------------------------------------
    public Panel panel_pages = new Panel();
    public Panel panel_data = new Panel();
    public Panel panel_cart = new Panel();

    public CardLayout card_layout = new CardLayout();

    public Button btn_menu_data = new Button("Banco de dados");
    public Button btn_menu_cart = new Button("Carrinho");
    public Button btn_data_search = new Button("Procurar");
    public Button btn_data_add = new Button("Criar produto");
    public Button btn_cart_add = new Button("Adicionar produto ao carrinho");
    public Button btn_data_pop = new Button("Excluir produto selecionado");
    public Button btn_cart_pop = new Button("Remover produto selecionado do carrinho");

    public Label lbl_data_search = new Label("Filtrar produtos:");
    public Label lbl_data_name = new Label("Nome do produto:");
    public Label lbl_cart_name = new Label("Produto:");
    public Label lbl_data_price = new Label("Preco do produto [$]:");
    public Label lbl_cart_price = new Label("Preco unitario [$]:");
    public Label lbl_cart_quantity = new Label("Quantidade:");
    public Label lbl_cart_total = new Label("Total a pagar: $0");

    public TextField txt_data_search = new TextField();
    public TextField txt_data_name = new TextField();
    public TextField txt_data_price = new TextField();
    public TextField txt_cart_price = new TextField();
    public TextField txt_cart_quantity = new TextField();

    public Choice choice_name = new Choice();

    public List list_data = new List();
    public List list_cart = new List();

    // Constructor ------------------------------------------------------------
    public MainWindow_GUI() {
        this.setTitle("Janela Principal");
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(246, 246, 246));
        this.setFont(new Font("SansSerif", Font.PLAIN, 16));

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 1.0;
        c.weightx = 0.0;
        c.gridy = 0;
        c.gridx = 0;
        c.insets = new Insets(5, 5, 5, 5);
        this.btn_menu_data.setBackground(Color.LIGHT_GRAY);
        this.add(this.btn_menu_data, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 1.0;
        c.weightx = 0.0;
        c.gridy = 1;
        c.gridx = 0;
        this.btn_menu_cart.setBackground(Color.LIGHT_GRAY);
        this.add(this.btn_menu_cart, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 2;
        c.gridwidth = 1;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 1;
        this.panel_pages.setLayout(this.card_layout);
        this.panel_pages.add("data", this.panel_data);
        this.panel_pages.add("cart", this.panel_cart);
        this.add(this.panel_pages, c);

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

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 2;
        this.panel_data.add(this.btn_data_search, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 3;
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
        c.gridwidth = 2;
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
        c.gridwidth = 2;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 3;
        c.gridx = 1;
        this.panel_data.add(this.txt_data_price, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 3;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 4;
        c.gridx = 0;
        this.panel_data.add(this.btn_data_add, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 3;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 5;
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
        this.panel_cart.add(this.lbl_cart_quantity, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 2;
        c.gridx = 1;
        this.panel_cart.add(this.txt_cart_quantity, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 3;
        c.gridx = 0;
        this.panel_cart.add(this.btn_cart_add, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.gridy = 4;
        c.gridx = 0;
        this.panel_cart.add(this.list_cart, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 5;
        c.gridx = 0;
        this.panel_cart.add(this.btn_cart_pop, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 6;
        c.gridx = 0;
        this.lbl_cart_total.setFont(new Font("SansSerif", Font.BOLD, 16));
        this.panel_cart.add(this.lbl_cart_total, c);

        // --------------------------------------------------------------------
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public Dimension getPreferredSize() {
        return new Dimension(1080, 720);
    }

    public void run() {
        this.pack();
        this.setVisible(true);
    }

}
