package client.view;


import javax.swing.*;
import java.awt.*;

public class SeachButton extends JButton {
    public static final String ICON_PATH = "src/resources/img/Buscar.png";
    public static final Dimension DIMENSION = new Dimension(18,18);
    public static final String TEXT = "Buscar";
    public static final Font TEXT_FONT = new Font("Rubik", 1,16);

    private Color borderColor;
    public SeachButton(){
        super(TEXT);
        this.setContentAreaFilled(false);
        this.setPreferredSize(new Dimension(122,45));
        this.setBorderPainted(false);
        this.setBorder(BorderFactory.createEmptyBorder(0,7,0,0));
        this.setFocusable(true);
        this.setBackground(Color.blue);
        this.setIcon(new ImageIcon(new ImageIcon(ICON_PATH).getImage().getScaledInstance(DIMENSION.width,DIMENSION.height, Image.SCALE_DEFAULT)));
        this.setOpaque(false);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.RIGHT);
        this.setForeground(Color.white);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setFont(TEXT_FONT);
        this.borderColor = borderColor;
    }



    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)(g);

            g2.drawRoundRect(0,0,this.getWidth()-1, this.getHeight()-1, 45,45);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(this.borderColor);
            g2.setColor(this.getBackground());
            g2.fillRoundRect(0, 0, this.getWidth()-1, this.getHeight()-1, 45, 45);

        super.paintComponent(g2);
    }
}
