package frontend;

import backend.*;

import java.awt.event.*;
import java.util.ArrayList;

public class Gui extends MainWindow {

    private Bakery bakery;

    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private ArrayList<Item> items = new ArrayList<Item>();

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

                page_product.supplier.removeAll();
                for (Supplier supplier : bakery.getAllSuppliers()) {
                    page_product.supplier.add(supplier.getName());
                }
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

        // Product Page -------------------------------------------------------
        this.page_product.btn_searchByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = page_product.txt_search.getText().trim();
                Product product = bakery.getProductByName(name);

                if (product != null) {
                    page_product.txtArea.setText("-> Produto com o Nome: " + name +
                            "\n\n" + product.toStringDetailed());

                } else {
                    page_product.txtArea.setText("Nenhum Produto encontrado com o Nome: " + name + "\n");
                }
            }
        });

        this.page_product.btn_searchByBarCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String barCode = page_product.txt_search.getText().trim();
                Product product = bakery.getProductByBarCode(barCode);

                if (product != null) {
                    page_product.txtArea.setText("-> Produto com o Codigo de barra: " + barCode +
                            "\n\n" + product.toStringDetailed());

                } else {
                    page_product.txtArea.setText("Nenhum Produto encontrado com o Codigo de barra: " + barCode + "\n");
                }
            }
        });

        this.page_product.btn_showAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page_product.txtArea.setText(bakery.printAllProducts());
            }
        });

        this.page_product.productType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                switch (page_product.productType.getSelectedItem()) {
                    case "Tercerizado":
                        page_product.ingredients.removeAll();
                        page_product.ingredients.setEnabled(false);
                        page_product.txt_nameIngredient.setEnabled(false);
                        page_product.txt_carbohydrates.setEnabled(false);
                        page_product.txt_saturatedFat.setEnabled(false);
                        page_product.txt_proteins.setEnabled(false);
                        page_product.txt_calories.setEnabled(false);
                        page_product.btn_addIngredient.setEnabled(false);
                        page_product.btn_popIngredient.setEnabled(false);

                        page_product.txt_nameIngredient.setText("");
                        page_product.txt_carbohydrates.setText("");
                        page_product.txt_saturatedFat.setText("");
                        page_product.txt_proteins.setText("");
                        page_product.txt_calories.setText("");

                        page_product.supplier.setEnabled(true);
                        page_product.txt_brand.setEnabled(true);
                        break;

                    case "Proprio":
                        page_product.ingredients.setEnabled(true);
                        page_product.txt_nameIngredient.setEnabled(true);
                        page_product.txt_carbohydrates.setEnabled(true);
                        page_product.txt_saturatedFat.setEnabled(true);
                        page_product.txt_proteins.setEnabled(true);
                        page_product.txt_calories.setEnabled(true);
                        page_product.btn_addIngredient.setEnabled(true);
                        page_product.btn_popIngredient.setEnabled(true);

                        page_product.txt_carbohydrates.setText("0");
                        page_product.txt_saturatedFat.setText("0");
                        page_product.txt_proteins.setText("0");
                        page_product.txt_calories.setText("0");

                        page_product.supplier.setEnabled(false);
                        page_product.txt_brand.setEnabled(false);
                        break;

                    default:
                        break;
                }
            }
        });

        this.page_product.btn_addIngredient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = page_product.txt_nameIngredient.getText().trim();
                String carbohydrates = page_product.txt_carbohydrates.getText().trim();
                String saturatedFat = page_product.txt_saturatedFat.getText().trim();
                String proteins = page_product.txt_proteins.getText().trim();
                String calories = page_product.txt_calories.getText().trim();

                if (name.isBlank()) {
                    page_product.txtArea.setText("Nome do Ingrediente deve ser fornecido!");
                    return;
                }

                try {
                    double carbohydrates_d = Double.parseDouble(carbohydrates);
                    double saturatedFat_d = Double.parseDouble(saturatedFat);
                    double proteins_d = Double.parseDouble(proteins);
                    double calories_d = Double.parseDouble(calories);

                    Ingredient ingredient = new Ingredient(name, carbohydrates_d, saturatedFat_d, proteins_d,
                            calories_d);

                    ingredients.add(ingredient);
                    updateIngredientsList();

                    page_product.txt_nameIngredient.setText("");
                    page_product.txt_carbohydrates.setText("0");
                    page_product.txt_saturatedFat.setText("0");
                    page_product.txt_proteins.setText("0");
                    page_product.txt_calories.setText("0");

                } catch (Exception error) {
                    page_product.txtArea.setText("Valores nutricionais invalidos!");
                }

            }
        });

        this.page_product.btn_popIngredient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingredients.remove(ingredients.size() - 1);
                updateIngredientsList();
            }
        });

        this.page_product.btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = page_product.txt_name.getText().trim();
                String barcode = page_product.txt_barcode.getText().trim();
                String sellPrice = page_product.txt_sellPrice.getText().trim();
                String stock = page_product.txt_stock.getText().trim();

                if (name.isBlank() || barcode.isBlank()) {
                    page_product.txtArea.setText("Nome e Codigo de Barras devem ser fornecidos!");
                    return;
                }

                double sellPrice_double = 0.0;
                int stock_int = 0;

                try {
                    sellPrice_double = Double.parseDouble(sellPrice);
                    stock_int = Integer.parseInt(stock);

                } catch (Exception error) {
                    page_product.txtArea.setText("Alguns dados fornecidos sao invalidos!");
                    return;
                }

                switch (page_product.productType.getSelectedItem()) {
                    case "Tercerizado":
                        Supplier supplier = bakery.getSupplierByName(page_product.supplier.getSelectedItem());
                        String brand = page_product.txt_brand.getText().trim();

                        if (supplier == null) {
                            page_product.txtArea.setText("Algum fornecedor deve ser fornecido!");
                            return;
                        }

                        ProductOutsourced product_o = new ProductOutsourced(name, barcode, sellPrice_double, stock_int,
                                supplier, brand);
                        bakery.addProduct(product_o);
                        break;

                    case "Proprio":
                        ProductHomeMade product_h = new ProductHomeMade(name, barcode, sellPrice_double, stock_int);

                        for (Ingredient ingredient : ingredients) {
                            product_h.addIngredient(ingredient);
                        }

                        bakery.addProduct(product_h);
                        page_product.ingredients.removeAll();
                        break;

                    default:
                        break;
                }

                page_product.txt_name.setText("");
                page_product.txt_barcode.setText("");
                page_product.txt_sellPrice.setText("");
                page_product.txt_stock.setText("");
                page_product.txt_brand.setText("");
            }
        });

        this.page_product.btn_pop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = page_product.txt_namePop.getText().trim();

                bakery.popProductByName(name);
                page_product.txt_namePop.setText("");
            }
        });

        // Invoice Page -------------------------------------------------------
        this.page_invoice.btn_searchByCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = page_invoice.txt_search.getText().trim();
                int code_int = 0;

                try {
                    code_int = Integer.parseInt(code);

                    Invoice invoice = bakery.getInvoiceByCode(code_int);

                    page_invoice.txtArea.setText("-> Nota de Venda com o Codigo: " + code_int +
                            "\n\n" + invoice.toStringDetailed());

                } catch (Exception error) {
                    page_invoice.txtArea.setText("Nenhuma Nota de Venda encontrado com o Codigo: " + code + "\n");
                }
            }
        });

        this.page_invoice.btn_showAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page_invoice.txtArea.setText(bakery.printAllInvoices());
            }
        });

    }

    // ------------------------------------------------------------------------
    private void updateIngredientsList() {
        this.page_product.ingredients.removeAll();

        for (Ingredient ingredient : ingredients) {
            this.page_product.ingredients.add(ingredient.getName());
        }
    }

    private void updateItemsList() {
        this.page_invoice.items.removeAll();

        for (Item item : items) {
            this.page_invoice.items.add(item.getName());
        }
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
