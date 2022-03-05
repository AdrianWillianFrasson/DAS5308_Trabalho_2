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
                    return;
                }

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
        });

        this.page_supplier.btn_pop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = page_supplier.txt_namePop.getText().trim();

                bakery.popSupplierByName(name);
                page_supplier.txt_namePop.setText("");
            }
        });

        // Client Page --------------------------------------------------------
        this.page_client.btn_searchByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = page_client.txt_search.getText().trim();
                Client client = bakery.getClientByName(name);

                if (client != null) {
                    page_client.txtArea.setText("-> Cliente com o Nome: " + name +
                            "\n\n" + client.toStringDetailed());

                } else {
                    page_client.txtArea.setText("Nenhum Cliente encontrado com o Nome: " + name + "\n");
                }
            }
        });

        this.page_client.btn_searchByCPF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = page_client.txt_search.getText().trim();
                Client client = bakery.getClientByCpf(cpf);

                if (client != null) {
                    page_client.txtArea.setText("-> Cliente com o CPF: " + cpf +
                            "\n\n" + client.toStringDetailed());

                } else {
                    page_client.txtArea.setText("Nenhum Cliente encontrado com o CPF: " + cpf + "\n");
                }
            }
        });

        this.page_client.btn_showAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page_client.txtArea.setText(bakery.printAllClients());
            }
        });

        this.page_client.clientType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                switch (page_client.clientType.getSelectedItem()) {
                    case "Normal":
                        page_client.txt_discount.setEnabled(false);
                        page_client.txt_discount.setText("");
                        break;

                    case "Vip":
                        page_client.txt_discount.setEnabled(true);
                        page_client.txt_discount.setText("0");
                        break;

                    default:
                        break;
                }
            }
        });

        this.page_client.btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = page_client.txt_name.getText().trim();
                String cpf = page_client.txt_cpf.getText().trim();
                String city = page_client.txt_city.getText().trim();
                String email = page_client.txt_email.getText().trim();
                String address = page_client.txt_address.getText().trim();
                String telephone = page_client.txt_telephone.getText().trim();
                String discount = page_client.txt_discount.getText().trim();

                if (name.isBlank() || cpf.isBlank()) {
                    page_client.txtArea.setText("Nome e CPF devem ser fornecidos!");
                    return;
                }

                Client client;

                switch (page_client.clientType.getSelectedItem()) {
                    case "Normal":
                        client = new Client(name, cpf);
                        break;

                    case "Vip":
                        try {
                            int discount_int = Integer.parseInt(discount);
                            client = new ClientVip(name, cpf, discount_int);

                        } catch (Exception error) {
                            page_client.txtArea.setText("Desconto invalido!");
                            return;
                        }
                        break;

                    default:
                        client = new Client(name, cpf);
                        break;
                }

                client.setCity(city);
                client.setEmail(email);
                client.setAddress(address);
                client.setTelephone(telephone);

                bakery.addClient(client);

                page_client.txt_name.setText("");
                page_client.txt_cpf.setText("");
                page_client.txt_city.setText("");
                page_client.txt_email.setText("");
                page_client.txt_address.setText("");
                page_client.txt_telephone.setText("");
                page_client.txt_discount.setText("");
            }
        });

        this.page_client.btn_pop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = page_client.txt_namePop.getText().trim();

                bakery.popClientByName(name);
                page_client.txt_namePop.setText("");
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
