package client.view;



import javax.swing.*;
import java.awt.*;

public class TextFieldComponent extends JPanel {
    private int arcw=20;
    private int arch=20;
    public static final Dimension DEFAULT_ICON_DIMENSION = new Dimension(24,24);

    public TextFieldComponent(String iconPath, String text, Dimension dimension){
        this.setLayout(new FlowLayout());
        this.setOpaque(false);
        this.setMaximumSize(dimension);
        initComponentes(iconPath, text, new Dimension((int)dimension.getWidth()-24, (int) dimension.getHeight()-24));
    }


    public void initComponentes(String iconPath, String text, Dimension dimension){
        JButton button = new JButton();
        button.setIcon(new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance((int)DEFAULT_ICON_DIMENSION.getWidth(),
                (int)DEFAULT_ICON_DIMENSION.getHeight(),Image.SCALE_AREA_AVERAGING)));
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(0,2,0,2));
        button.setOpaque(false);
        this.add(button);

        JTextField casilla = new JTextField(text);
        casilla.setForeground(Color.decode("#444444"));
        casilla.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        casilla.setFont(new Font("Arial", Font.ITALIC, 14));
        casilla.setForeground(Color.gray);
        casilla.setPreferredSize(dimension);
        this.add(casilla);
    }


    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)(g);
        g2.drawRoundRect(0,0,this.getWidth()-1, this.getHeight()-1, 20,20);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.gray);
        super.paintComponent(g2);
    }

    public int getArcw() {
        return arcw;
    }

    public int getArch() {
        return arch;
    }
}
