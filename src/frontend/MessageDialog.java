package frontend;

import frontend.GUI.MessageDialog_GUI;

import java.awt.*;
import java.awt.event.*;

public class MessageDialog extends MessageDialog_GUI {

    MessageDialog(Frame frame) {
        super(frame);
    }

    private void createListeners() {
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

    public void run(String message) {
        this.lbl_msg.setText(message);

        this.createListeners();
        super.run();
    }

}
