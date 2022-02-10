package frontend;

import backend.Backend;
import backend.CartItem;
import backend.Product;
import frontend.GUI.MainWindow_GUI;

import java.awt.event.*;

public class MainWindow {

    private Backend backend;
    private MainWindow_GUI gui = new MainWindow_GUI();

    private String text_filter = "";

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
                gui.card_layout.show(gui.panel_pages, "data");
            }
        });

        // --------------------------------------------------------------------
        gui.btn_menu_cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.choice_name.removeAll();

                backend.getAllProducts().forEach(product -> {
                    gui.choice_name.add(product.getName());
                });

                String name = gui.choice_name.getSelectedItem();
                gui.txt_cart_price.setText("");

                if (name != null) {
                    String price = String.valueOf(backend.getProduct(name).getPrice());
                    gui.txt_cart_price.setText(price);
                }

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
                String price = gui.txt_data_price.getText();

                if (name.isEmpty()) {
                    System.out.println("Nome invalido");
                    return;
                }

                try {
                    double price_d = Double.parseDouble(price);
                    backend.addProduct(name, price_d);

                } catch (NumberFormatException err) {
                    System.out.println("Preco invalido");

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
                backend.popCartItem(name);
                updateDataList();
            }
        });

        // --------------------------------------------------------------------
        gui.choice_name.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String name = gui.choice_name.getSelectedItem();

                if (name != null) {
                    String price = String.valueOf(backend.getProduct(name).getPrice());
                    gui.txt_cart_price.setText(price);
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

                try {
                    int quantity = Integer.parseInt(gui.txt_cart_quantity.getText());
                    backend.addCartItem(name, quantity);

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
    }

    private void updateDataList() {
        Backend backend = this.getBackend();
        MainWindow_GUI gui = this.getGui();

        gui.list_data.removeAll();

        backend.getAllProducts().forEach(product -> {
            String name = product.getName();
            String price = String.valueOf(product.getPrice());

            String text = String.format("%s | $:%s", name, price);

            if (text.contains(getTextFilter())) {
                gui.list_data.add(text);
            }

        });
    }

    private void updateCartList() {
        Backend backend = this.getBackend();
        MainWindow_GUI gui = this.getGui();
        double sum = 0.0;

        gui.list_cart.removeAll();

        for (CartItem cartItem : backend.getAllCartItems()) {
            String name = cartItem.getName();
            int quantity = cartItem.getQuantity();

            Product product = backend.getProduct(name);
            double price = product.getPrice();

            sum += price * quantity;

            String text = String.format("%s | $:%f | Quantidade: %d", name, price, quantity);

            gui.list_cart.add(text);
        }

        gui.lbl_cart_total.setText(String.format("Total a pagar: $%f", sum));
    }

    // Setters-----------------------------------------------------------------
    private void setBackend(Backend backend) {
        this.backend = backend;
    }

    private void setTextFilter(String textFilter) {
        this.text_filter = textFilter;
    }

    // Getters ----------------------------------------------------------------
    private Backend getBackend() {
        return this.backend;
    }

    private MainWindow_GUI getGui() {
        return this.gui;
    }

    private String getTextFilter() {
        return this.text_filter;
    }

}
