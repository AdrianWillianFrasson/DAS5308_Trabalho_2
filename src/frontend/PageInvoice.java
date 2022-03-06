package frontend;

import java.awt.*;

public class PageInvoice extends Panel {

    public Button btn_searchByCode = new Button("Procurar por Codigo");
    public Button btn_showAll = new Button("Mostrar Todos");
    public Button btn_add = new Button("Cadastrar Nota de Venda");
    public Button btn_addItem = new Button("Adicionar Item");
    public Button btn_popItem = new Button("Remover Item");

    public TextField txt_search = new TextField();
    public TextField txt_quantity = new TextField();

    public Label lbl_client = new Label("Cliente:");
    public Label lbl_item = new Label("Item:");
    public Label lbl_quantity = new Label("Quantidade:");

    public TextArea txtArea = new TextArea();

    public List items = new List();

    public Choice products = new Choice();
    public Choice clients = new Choice();

    public PageInvoice() {
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(246, 246, 246));
        this.setFont(new Font("SansSerif", Font.PLAIN, 16));

        // --------------------------------------------------------------------
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 0;
        this.add(this.txt_search, c);

        c.gridwidth = 1;
        c.gridy = 0;
        c.gridx = 2;
        this.add(this.btn_searchByCode, c);

        c.gridy = 0;
        c.gridx = 3;
        this.add(this.btn_showAll, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 4;
        c.weighty = 1.0;
        c.gridy = 1;
        c.gridx = 0;
        this.txtArea.setEditable(false);
        this.txtArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        this.add(this.txtArea, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.weighty = 0.0;
        c.gridy = 2;
        c.gridx = 0;
        this.add(this.lbl_client, c);

        c.gridy = 2;
        c.gridx = 2;
        this.add(this.clients, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 4;
        c.gridy = 3;
        c.gridx = 0;
        this.add(this.items, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridy = 4;
        c.gridx = 0;
        this.add(this.lbl_item, c);

        c.gridy = 4;
        c.gridx = 1;
        this.add(this.products, c);

        c.gridy = 4;
        c.gridx = 2;
        this.add(this.lbl_quantity, c);

        c.gridy = 4;
        c.gridx = 3;
        this.add(this.txt_quantity, c);

        c.gridwidth = 2;
        c.gridy = 5;
        c.gridx = 0;
        this.add(this.btn_addItem, c);

        c.gridy = 5;
        c.gridx = 2;
        this.add(this.btn_popItem, c);

        c.gridwidth = 4;
        c.gridy = 6;
        c.gridx = 0;
        this.add(this.btn_add, c);
    }

}
