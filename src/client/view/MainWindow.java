package client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow  extends JFrame {

    private PrincipalPanel mainPanel;
    public MainWindow(ActionListener ls){
        this.setSize(new Dimension(650,650));
        initComponents(ls);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initComponents(ActionListener ls){
        mainPanel = new PrincipalPanel(ls);
        this.add(mainPanel);
    }

    public PrincipalPanel getMainPanel() {
        return mainPanel;
    }
    
}
