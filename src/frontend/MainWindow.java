package frontend;

import backend.Backend;
import frontend.GUI.MainWindow_GUI;

import java.awt.event.*;

public class MainWindow {

    private Backend backend;
    private MainWindow_GUI gui;

    MainWindow(Backend backend) {
        this.setBackend(backend);
        this.setGui(new MainWindow_GUI());
    }

    void run() {
        this.createConnections();
        this.getGui().run();
    }

    private void createConnections() {
        Backend backend = this.getBackend();
        MainWindow_GUI gui = this.getGui();

        gui.btn_menu_data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backend.getProject();
                gui.card_layout.show(gui.panel_pages, "data");
            }
        });

        gui.btn_menu_cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backend.getProject();
                gui.card_layout.show(gui.panel_pages, "cart");
            }
        });

    }

    // Setters-----------------------------------------------------------------
    private void setBackend(Backend backend) {
        this.backend = backend;
    }

    private void setGui(MainWindow_GUI gui) {
        this.gui = gui;
    }

    // Getters ----------------------------------------------------------------
    private Backend getBackend() {
        return this.backend;
    }

    private MainWindow_GUI getGui() {
        return this.gui;
    }

}
