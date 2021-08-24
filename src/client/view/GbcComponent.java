package client.view;

import java.awt.*;

public class GbcComponent {

    public static void addComponent(GridBagConstraints gbc, int xPosition, int yPosition, int widht, int height){
        gbc.gridx = xPosition;
        gbc.gridy = yPosition;
        gbc.gridwidth = widht;
        gbc.gridheight = height;
    }
}
