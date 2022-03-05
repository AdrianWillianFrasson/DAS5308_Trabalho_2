package frontend;

import backend.*;

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

        // Supplier Page ------------------------------------------------------
        this.page_supplier.btn_searchByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = page_supplier.txt_search.getText().trim();
                Supplier supplier = bakery.getSupplierByName(name);

                if (supplier != null) {
                    page_supplier.txtArea.setText("-> Fornecedor com o Nome: " + name +
                            "\n\n" + supplier.toStringDetailed());

                } else {
                    page_supplier.txtArea.setText("Nenhum Fornecedor encontrado com o Nome: " + name + "\n");
                }
            }
        });

        this.page_supplier.btn_searchByCNPJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cnpj = page_supplier.txt_search.getText().trim();
                Supplier supplier = bakery.getSupplierByCnpj(cnpj);

                if (supplier != null) {
                    page_supplier.txtArea.setText("-> Fornecedor com o CNPJ: " + cnpj +
                            "\n\n" + supplier.toStringDetailed());

                } else {
                    page_supplier.txtArea.setText("Nenhum Fornecedor encontrado com o CNPJ: " + cnpj + "\n");
                }
            }
        });

        this.page_supplier.btn_showAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page_supplier.txtArea.setText(bakery.printAllSuppliers());
            }
        });

        this.page_supplier.btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = page_supplier.txt_name.getText().trim();
                String cnpj = page_supplier.txt_cnpj.getText().trim();
                String city = page_supplier.txt_city.getText().trim();
                String email = page_supplier.txt_email.getText().trim();
                String address = page_supplier.txt_address.getText().trim();
                String telephone = page_supplier.txt_telephone.getText().trim();

                if (name.isBlank() || cnpj.isBlank()) {
                    page_supplier.txtArea.setText("Nome e CNPJ devem ser fornecidos!");

                } else {
                    Supplier supplier = new Supplier(name, cnpj);

                    supplier.setCity(city);
                    supplier.setEmail(email);
                    supplier.setAddress(address);
                    supplier.setTelephone(telephone);

                    bakery.addSupplier(supplier);

                    page_supplier.txt_name.setText("");
                    page_supplier.txt_cnpj.setText("");
                    page_supplier.txt_city.setText("");
                    page_supplier.txt_email.setText("");
                    page_supplier.txt_address.setText("");
                    page_supplier.txt_telephone.setText("");
                }
            }
        });

        this.page_supplier.btn_pop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = page_supplier.txt_namePop.getText().trim();

                bakery.popSupplierByName(name);
                page_supplier.txt_namePop.setText("");
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
