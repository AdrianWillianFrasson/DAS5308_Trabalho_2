package frontend;

import java.awt.*;

public class PageSupplier extends Panel {

    public Button btn_searchByName = new Button("Procurar por Nome");
    public Button btn_searchByCNPJ = new Button("Procurar por CNPJ");
    public Button btn_showAll = new Button("Mostrar Todos");
    public Button btn_add = new Button("Cadastrar Fornecedor");
    public Button btn_pop = new Button("Remover Fornecedor por Nome");

    public TextField txt_search = new TextField();
    public TextField txt_name = new TextField();
    public TextField txt_cnpj = new TextField();
    public TextField txt_city = new TextField();
    public TextField txt_email = new TextField();
    public TextField txt_address = new TextField();
    public TextField txt_telephone = new TextField();
    public TextField txt_namePop = new TextField();

    public Label lbl_name = new Label("Nome:");
    public Label lbl_cnpj = new Label("CNPJ:");
    public Label lbl_city = new Label("Cidade:");
    public Label lbl_email = new Label("Email:");
    public Label lbl_address = new Label("Endereco:");
    public Label lbl_telephone = new Label("Telefone:");

    public TextArea txtArea = new TextArea();

    public PageSupplier() {
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(246, 246, 246));
        this.setFont(new Font("SansSerif", Font.PLAIN, 16));

        // --------------------------------------------------------------------
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 0;
        this.add(this.txt_search, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 1;
        this.add(this.btn_searchByName, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 2;
        this.add(this.btn_searchByCNPJ, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 3;
        this.add(this.btn_showAll, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 4;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.gridy = 1;
        c.gridx = 0;
        this.txtArea.setEditable(false);
        this.add(this.txtArea, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 2;
        c.gridx = 0;
        this.add(this.lbl_name, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 2;
        c.gridx = 1;
        this.add(this.txt_name, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 2;
        c.gridx = 2;
        this.add(this.lbl_address, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 2;
        c.gridx = 3;
        this.add(this.txt_address, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 3;
        c.gridx = 0;
        this.add(this.lbl_cnpj, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 3;
        c.gridx = 1;
        this.add(this.txt_cnpj, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 3;
        c.gridx = 2;
        this.add(this.lbl_city, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 3;
        c.gridx = 3;
        this.add(this.txt_city, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 4;
        c.gridx = 0;
        this.add(this.lbl_email, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 4;
        c.gridx = 1;
        this.add(this.txt_email, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 4;
        c.gridx = 2;
        this.add(this.lbl_telephone, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 4;
        c.gridx = 3;
        this.add(this.txt_telephone, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 4;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 5;
        c.gridx = 0;
        this.add(this.btn_add, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 6;
        c.gridx = 0;
        this.add(this.txt_namePop, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.gridy = 6;
        c.gridx = 2;
        this.add(this.btn_pop, c);
    }

}
