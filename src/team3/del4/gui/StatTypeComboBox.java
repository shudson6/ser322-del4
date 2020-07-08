package team3.del4.gui;

import javax.swing.*;

public class StatTypeComboBox extends JComboBox<String> {
    static final String[] STATTYPES = {"Passing", "Rushing", "Receiving", "Kicking", "Turnover"};
    public StatTypeComboBox() {
        setModel(new DefaultComboBoxModel<>(STATTYPES));
    }
}
