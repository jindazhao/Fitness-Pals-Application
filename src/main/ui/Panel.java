package ui;

import javax.swing.*;

public class Panel {

    private  BoxLayout boxLayout;
    private JPanel viewPanel;

    // EFFECTS: constructs a new JPanel and constructs it with the boxLayout formatting
    public Panel() {
        viewPanel = new JPanel();
        boxLayout = new BoxLayout(viewPanel, BoxLayout.Y_AXIS);
        viewPanel.setLayout(boxLayout);
    }

    public JPanel getViewPanel() {
        return viewPanel;
    }
}
