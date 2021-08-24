package client.view;

import javax.swing.*;
import java.awt.*;

public class MainWindow  extends JFrame {

    private PrincipalPanel mainPanel;
    public MainWindow(){
        this.setSize(new Dimension(500,500));
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initComponents(){
        mainPanel = new PrincipalPanel();
        this.add(mainPanel);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
