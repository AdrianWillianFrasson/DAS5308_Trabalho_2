package frontend;

import java.awt.*;
import java.awt.event.*;

public abstract class MainWindow extends Frame {

    // Components -------------------------------------------------------------
    public Panel panel_pages = new Panel();
    public CardLayout card_layout = new CardLayout();

    public PageSupplier page_supplier = new PageSupplier();
    public PageInvoice page_invoice = new PageInvoice();
    public PageProduct page_product = new PageProduct();
    public PageClient page_client = new PageClient();

    public Button btn_menu_supplier = new Button("Fornecedores");
    public Button btn_menu_invoice = new Button("Notas de Venda");
    public Button btn_menu_product = new Button("Produtos");
    public Button btn_menu_client = new Button("Clientes");

    public MainWindow() {
        this.setTitle("Gerenciador de Padaria");
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(246, 246, 246));
        this.setFont(new Font("SansSerif", Font.PLAIN, 16));

        // --------------------------------------------------------------------
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 4;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 0;
        this.panel_pages.setLayout(this.card_layout);
        this.panel_pages.add("supplier", this.page_supplier);
        this.panel_pages.add("invoice", this.page_invoice);
        this.panel_pages.add("product", this.page_product);
        this.panel_pages.add("client", this.page_client);
        this.add(this.panel_pages, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.gridy = 1;
        c.gridx = 0;
        this.btn_menu_supplier.setBackground(Color.LIGHT_GRAY);
        this.add(this.btn_menu_supplier, c);

        c.gridy = 1;
        c.gridx = 1;
        this.btn_menu_client.setBackground(Color.LIGHT_GRAY);
        this.add(this.btn_menu_client, c);

        c.gridy = 1;
        c.gridx = 2;
        this.btn_menu_product.setBackground(Color.LIGHT_GRAY);
        this.add(this.btn_menu_product, c);

        c.gridy = 1;
        c.gridx = 3;
        this.btn_menu_invoice.setBackground(Color.LIGHT_GRAY);
        this.add(this.btn_menu_invoice, c);

        // --------------------------------------------------------------------
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
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
