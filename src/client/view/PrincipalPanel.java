package client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PrincipalPanel extends JPanel {

    private GridBagConstraints gbc;
    private SeachButton searchButton;
    private TextFieldComponent dataText;
    private JPTablePanel tablle;
    public static final String[] nameColumns={"Identificacion","Nombre Persona","Antecedente"};



    public PrincipalPanel(ActionListener ls){
        this.setOpaque(true);
        this.setLayout(new GridBagLayout());
        initComponents(ls);
    }

    public void initComponents(ActionListener ls){
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(20,20,20,20);
        GbcComponent.addComponent(gbc, 3, 1, 2, 1  );
        dataText = new TextFieldComponent("","Numero de identificaion",new Dimension(200,70));
        dataText.setSize(new Dimension(100, 30));
        this.add(dataText, gbc);

        GbcComponent.addComponent(gbc, 9, 1, 2, 1  );
        searchButton = new SeachButton(ls);
        this.add(searchButton, gbc);

        GbcComponent.addComponent(gbc, 1, 6, 12, 8);
        tablle = new JPTablePanel();
        this.add(tablle, gbc);
    }

    public TextFieldComponent getDataText() {
        return dataText;
    }

    public JPTablePanel getTablle() {
        return tablle;
    }
}
