package frontend.GUI;

import java.awt.*;
import java.awt.event.*;

public class MessageWindow_GUI extends Dialog {

    // Components -------------------------------------------------------------
    public Button btn_ok = new Button("Ok");
    public Label lbl_msg = new Label("Solve et coagula");

    // Constructor ------------------------------------------------------------
    public MessageWindow_GUI(Frame frame) {
        super(frame, "Mensagem", true);

        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(246, 246, 246));
        this.setFont(new Font("SansSerif", Font.PLAIN, 16));

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.CENTER;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.gridy = 0;
        c.gridx = 0;
        c.insets = new Insets(5, 5, 5, 5);
        this.add(lbl_msg, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weighty = 0.0;
        c.weightx = 0.0;
        c.gridy = 1;
        c.gridx = 0;
        this.add(btn_ok, c);

        // --------------------------------------------------------------------
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        this.btn_ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public Dimension getPreferredSize() {
        return new Dimension(320, 160);
    }

    public void run(String message) {
        this.lbl_msg.setText(message);

        this.pack();
        this.setVisible(true);
    }

}
