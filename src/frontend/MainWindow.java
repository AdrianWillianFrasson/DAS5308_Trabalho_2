package frontend;

import frontend.GUI.MainWindow_GUI;

import java.awt.*;
import java.awt.event.*;

import backend.Backend;
import backend.CartItem;
import backend.Product;

public class MainWindow extends MainWindow_GUI {

    private Backend backend;
    private String textFilter = "";
    private double payableSum = 0.0;

    MainWindow(Backend backend) {
        this.setBackend(backend);
    }

    private void createListeners() {
        Backend backend = this.getBackend();

        // --------------------------------------------------------------------
        this.btn_menu_data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDataList();
                card_layout.show(panel_pages, "data");
            }
        });

        // --------------------------------------------------------------------
        this.btn_menu_cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProductChoices();
                updateCartList();
                card_layout.show(panel_pages, "cart");
            }
        });

        // --------------------------------------------------------------------
        this.txt_data_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTextFilter(txt_data_search.getText());
                updateDataList();
            }
        });

        // --------------------------------------------------------------------
        this.btn_data_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTextFilter(txt_data_search.getText());
                updateDataList();
            }
        });

        // --------------------------------------------------------------------
        this.btn_data_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txt_data_name.getText().replace("|", "-").trim();
                String price = txt_data_price.getText().trim();
                String stock = txt_data_stock.getText().trim();

                if (name.isEmpty()) {
                    System.out.println("Nome invalido");
                    return;
                }

                try {
                    double price_d = Double.parseDouble(price);
                    int stock_i = Integer.parseInt(stock);

                    backend.addProduct(name, price_d, stock_i);

                    txt_data_name.setText("");
                    txt_data_price.setText("");
                    txt_data_stock.setText("");

                } catch (NumberFormatException err) {
                    System.out.println("Preco/Estoque invalido");

                }

                txt_data_search.setText("");
                setTextFilter("");
                updateDataList();
            }
        });

        // --------------------------------------------------------------------
        this.btn_data_pop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = list_data.getSelectedItem();

                if (text == null) {
                    return;
                }

                String name = text.split("\\|")[0].trim();

                backend.popProduct(name);
                updateDataList();
            }
        });

        // --------------------------------------------------------------------
        this.choice_name.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String name = choice_name.getSelectedItem();

                if (name != null) {
                    Product product = backend.getProduct(name);
                    txt_cart_price.setText(String.valueOf(product.getPrice()));
                    txt_cart_stock.setText(String.valueOf(product.getStock()));
                }
            }
        });

        // --------------------------------------------------------------------
        this.btn_cart_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = choice_name.getSelectedItem();

                if (name == null) {
                    return;
                }

                Product product = backend.getProduct(name);

                try {
                    int quantity = Integer.parseInt(txt_cart_quantity.getText().trim());

                    if (quantity > product.getStock()) {
                        quantity = product.getStock();
                        System.out.println("Estoque insuficiente");
                    }

                    backend.addCartItem(name, quantity);

                    txt_cart_quantity.setText("");

                } catch (NumberFormatException err) {
                    System.out.println("Quantidade invalida");

                }

                updateCartList();
            }
        });

        // --------------------------------------------------------------------
        this.btn_cart_pop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = list_cart.getSelectedItem();

                if (text == null) {
                    return;
                }

                String name = text.split("\\|")[0].trim();

                backend.popCartItem(name);
                updateCartList();
            }
        });

        // --------------------------------------------------------------------
        this.btn_cart_pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (CartItem cartItem : backend.getAllCartItems()) {
                    Product product = backend.getProduct(cartItem.getName());

                    int stock = product.getStock();
                    product.setStock(stock - cartItem.getQuantity());
                }

                double payableSum = getPayableSum();

                txt_cart_quantity.setText("");
                backend.removeAllCartItems();
                updateProductChoices();
                updateCartList();

                new MessageDialog(new Frame()).run(String.format("Total pagado: %f", payableSum));
            }
        });

        // --------------------------------------------------------------------
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void run() {
        this.createListeners();
        super.run();
    }

    private void updateDataList() {
        Backend backend = this.getBackend();

        this.list_data.removeAll();

        backend.getAllProducts().forEach(product -> {
            String name = product.getName();
            String price = String.valueOf(product.getPrice());
            String stock = String.valueOf(product.getStock());

            String text = String.format("%s | $: %s | Estoque: %s", name, price, stock);

            if (text.contains(getTextFilter())) {
                this.list_data.add(text);
            }

        });
    }

    private void updateCartList() {
        Backend backend = this.getBackend();

        setPayableSum(0.0);
        this.list_cart.removeAll();

        for (CartItem cartItem : backend.getAllCartItems()) {
            String name = cartItem.getName();
            int quantity = cartItem.getQuantity();

            Product product = backend.getProduct(name);
            double price = product.getPrice();

            setPayableSum(getPayableSum() + price * quantity);

            String text = String.format("%s | $:%f | Quantidade: %d", name, price, quantity);

            this.list_cart.add(text);
        }

        this.lbl_cart_total.setText(String.format("Total a pagar: $%f", getPayableSum()));
    }

    private void updateProductChoices() {
        Backend backend = this.getBackend();

        this.choice_name.removeAll();

        backend.getAllProducts().forEach(product -> {
            this.choice_name.add(product.getName());
        });

        String name = this.choice_name.getSelectedItem();
        this.txt_cart_price.setText("");
        this.txt_cart_stock.setText("");

        if (name != null) {
            Product product = backend.getProduct(name);
            this.txt_cart_price.setText(String.valueOf(product.getPrice()));
            this.txt_cart_stock.setText(String.valueOf(product.getStock()));
        }
    }

    // Setters-----------------------------------------------------------------
    private void setBackend(Backend backend) {
        this.backend = backend;
    }

    private void setTextFilter(String textFilter) {
        this.textFilter = textFilter;
    }

    private void setPayableSum(double payableSum) {
        this.payableSum = payableSum;
    }

    // Getters ----------------------------------------------------------------
    private Backend getBackend() {
        return this.backend;
    }

    private String getTextFilter() {
        return this.textFilter;
    }

    private double getPayableSum() {
        return this.payableSum;
    }

}