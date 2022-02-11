package frontend.GUI;

import java.awt.*;

public abstract class MessageDialog_GUI extends Dialog {

    // Components -------------------------------------------------------------
    protected Button btn_ok = new Button("Ok");
    protected Label lbl_msg = new Label("xampsom...");

    // Constructor ------------------------------------------------------------
    public MessageDialog_GUI(Frame frame) {
        super(frame, "Mensagem", true);

        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(246, 246, 246));
        this.setFont(new Font("SansSerif", Font.PLAIN, 16));

        // --------------------------------------------------------------------
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.CENTER;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 0;
        c.insets = new Insets(5, 5, 5, 5);
        this.add(this.lbl_msg, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 0.0;
        c.gridy = 1;
        c.gridx = 0;
        this.add(this.btn_ok, c);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(320, 160);
    }

    public void run() {
        this.pack();
        this.setVisible(true);
    }

}
