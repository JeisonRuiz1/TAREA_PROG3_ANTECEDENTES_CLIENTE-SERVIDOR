package client.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JPTablePanel extends JPanel {
    private String[] headersCyclist = {"Identificacion","Nombre Persona","Antecedente"};
    private DefaultTableModel dtmElements;
    private JTable table;
    public JPTablePanel(){
        this.setLayout(new FlowLayout());
        this.setBackground(Color.RED);
        this.setOpaque(true);
        this.setVisible(true);
        initComponents();
    }


    public void initComponents(){
        dtmElements = new DefaultTableModel(){
            public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
        };
        dtmElements.setColumnIdentifiers(headersCyclist);

        Font fontHeader = new Font("Franklin Gothic Deml", Font.ITALIC, 14);

        table = new JTable();
        table.setModel(dtmElements);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setBackground(Color.decode("#282E33"));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(fontHeader);
        table.setBackground(Color.WHITE);
        table.setFillsViewportHeight(true);
        table.setBorder(null);

        JScrollPane jsTable = new JScrollPane(table);
        jsTable.setForeground(Color.WHITE);
        jsTable.setBorder(null);
        jsTable.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(jsTable, BorderLayout.PAGE_END);
        this.setBorder(null);
    }

    public void addInfoToTable(Object[] info){
        dtmElements.addRow(info);
    }
    public void addReportToTable(HashMap<String, LocalTime> datas) {
        for (Map.Entry<String, LocalTime> entry : datas.entrySet()) {
            System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
            String key = entry.getKey();
            Object value = entry.getValue();
            Object[] info = new Object[]{key, value};
            dtmElements.addRow(info);
        }
    }

    public void Clear_Table1(){
        for (int i = 0; i < table.getRowCount(); i++) {
            dtmElements.removeRow(i);
            i-=1;
        }
    }

    public DefaultTableModel getDtmElements() {
        return dtmElements;
    }



    public String[] getHeadersCyclist() {
        return headersCyclist;
    }

}
