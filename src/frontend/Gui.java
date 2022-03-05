package frontend;

import backend.Bakery;

import java.awt.event.*;

public class Gui extends MainWindow {

    private Bakery bakery;

    public Gui(Bakery bakery) {
        this.setBakery(bakery);
    }

    // ------------------------------------------------------------------------
    public void run() {
        this.createListeners();
        super.run();
    }

    private void createListeners() {
        Bakery bakery = this.getBakery();

        // Menu ---------------------------------------------------------------
        this.btn_menu_supplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card_layout.show(panel_pages, "supplier");
            }
        });

        this.btn_menu_invoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card_layout.show(panel_pages, "invoice");
            }
        });

        this.btn_menu_product.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card_layout.show(panel_pages, "product");
            }
        });

        this.btn_menu_client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card_layout.show(panel_pages, "client");
            }
        });
    }

    // Setters ----------------------------------------------------------------
    private void setBakery(Bakery bakery) {
        this.bakery = bakery;
    }

    // Getters ----------------------------------------------------------------
    private Bakery getBakery() {
        return this.bakery;
    }

}
