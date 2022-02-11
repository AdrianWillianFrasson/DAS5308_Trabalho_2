package frontend;

import java.awt.event.*;

import frontend.GUI.MainWindow_GUI;
import frontend.GUI.MessageWindow_GUI;

import backend.Backend;
import backend.CartItem;
import backend.Product;

public class MainWindow {

    private Backend backend;
    private MainWindow_GUI gui = new MainWindow_GUI();

    private String textFilter = "";
    private double payableSum = 0.0;

    MainWindow(Backend backend) {
        this.setBackend(backend);
    }

    public void run() {
        this.createConnections();
        this.getGui().run();
    }

    private void createConnections() {
        Backend backend = this.getBackend();
        MainWindow_GUI gui = this.getGui();

        // --------------------------------------------------------------------
        gui.btn_menu_data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDataList();
                gui.card_layout.show(gui.panel_pages, "data");
            }
        });

        // --------------------------------------------------------------------
        gui.btn_menu_cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProductChoices();
                updateCartList();
                gui.card_layout.show(gui.panel_pages, "cart");
            }
        });

        // --------------------------------------------------------------------
        gui.txt_data_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTextFilter(gui.txt_data_search.getText());
                updateDataList();
            }
        });

        // --------------------------------------------------------------------
        gui.btn_data_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTextFilter(gui.txt_data_search.getText());
                updateDataList();
            }
        });

        // --------------------------------------------------------------------
        gui.btn_data_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = gui.txt_data_name.getText().replace("|", "-").trim();
                String price = gui.txt_data_price.getText().trim();
                String stock = gui.txt_data_stock.getText().trim();

                if (name.isEmpty()) {
                    System.out.println("Nome invalido");
                    return;
                }

                try {
                    double price_d = Double.parseDouble(price);
                    int stock_i = Integer.parseInt(stock);

                    backend.addProduct(name, price_d, stock_i);

                    gui.txt_data_name.setText("");
                    gui.txt_data_price.setText("");
                    gui.txt_data_stock.setText("");

                } catch (NumberFormatException err) {
                    System.out.println("Preco/Estoque invalido");

                }

                gui.txt_data_search.setText("");
                setTextFilter("");
                updateDataList();
            }
        });

        // --------------------------------------------------------------------
        gui.btn_data_pop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = gui.list_data.getSelectedItem();

                if (text == null) {
                    return;
                }

                String name = text.split("\\|")[0].trim();

                backend.popProduct(name);
                updateDataList();
            }
        });

        // --------------------------------------------------------------------
        gui.choice_name.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String name = gui.choice_name.getSelectedItem();

                if (name != null) {
                    Product product = backend.getProduct(name);
                    gui.txt_cart_price.setText(String.valueOf(product.getPrice()));
                    gui.txt_cart_stock.setText(String.valueOf(product.getStock()));
                }
            }
        });

        // --------------------------------------------------------------------
        gui.btn_cart_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = gui.choice_name.getSelectedItem();

                if (name == null) {
                    return;
                }

                Product product = backend.getProduct(name);

                try {
                    int quantity = Integer.parseInt(gui.txt_cart_quantity.getText().trim());

                    if (quantity > product.getStock()) {
                        quantity = product.getStock();
                        System.out.println("Estoque insuficiente");
                    }

                    backend.addCartItem(name, quantity);

                    gui.txt_cart_quantity.setText("");

                } catch (NumberFormatException err) {
                    System.out.println("Quantidade invalida");

                }

                updateCartList();
            }
        });

        // --------------------------------------------------------------------
        gui.btn_cart_pop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = gui.list_cart.getSelectedItem();

                if (text == null) {
                    return;
                }

                String name = text.split("\\|")[0].trim();

                backend.popCartItem(name);
                updateCartList();
            }
        });

        // --------------------------------------------------------------------
        gui.btn_cart_pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (CartItem cartItem : backend.getAllCartItems()) {
                    Product product = backend.getProduct(cartItem.getName());

                    int stock = product.getStock();
                    product.setStock(stock - cartItem.getQuantity());
                }

                double payableSum = getPayableSum();

                gui.txt_cart_quantity.setText("");
                backend.removeAllCartItems();
                updateProductChoices();
                updateCartList();

                new MessageWindow_GUI(gui).run(String.format("Total pagado: %f", payableSum));
            }
        });
    }

    private void updateDataList() {
        Backend backend = this.getBackend();
        MainWindow_GUI gui = this.getGui();

        gui.list_data.removeAll();

        backend.getAllProducts().forEach(product -> {
            String name = product.getName();
            String price = String.valueOf(product.getPrice());
            String stock = String.valueOf(product.getStock());

            String text = String.format("%s | $: %s | Estoque: %s", name, price, stock);

            if (text.contains(getTextFilter())) {
                gui.list_data.add(text);
            }

        });
    }

    private void updateCartList() {
        Backend backend = this.getBackend();
        MainWindow_GUI gui = this.getGui();

        setPayableSum(0.0);
        gui.list_cart.removeAll();

        for (CartItem cartItem : backend.getAllCartItems()) {
            String name = cartItem.getName();
            int quantity = cartItem.getQuantity();

            Product product = backend.getProduct(name);
            double price = product.getPrice();

            setPayableSum(getPayableSum() + price * quantity);

            String text = String.format("%s | $:%f | Quantidade: %d", name, price, quantity);

            gui.list_cart.add(text);
        }

        gui.lbl_cart_total.setText(String.format("Total a pagar: $%f", getPayableSum()));
    }

    private void updateProductChoices() {
        Backend backend = this.getBackend();
        MainWindow_GUI gui = this.getGui();

        gui.choice_name.removeAll();

        backend.getAllProducts().forEach(product -> {
            gui.choice_name.add(product.getName());
        });

        String name = gui.choice_name.getSelectedItem();
        gui.txt_cart_price.setText("");
        gui.txt_cart_stock.setText("");

        if (name != null) {
            Product product = backend.getProduct(name);
            gui.txt_cart_price.setText(String.valueOf(product.getPrice()));
            gui.txt_cart_stock.setText(String.valueOf(product.getStock()));
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

    private MainWindow_GUI getGui() {
        return this.gui;
    }

    private String getTextFilter() {
        return this.textFilter;
    }

    private double getPayableSum() {
        return this.payableSum;
    }

}
