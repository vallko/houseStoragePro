import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.*;
import javax.swing.table.*;

public class MSPgui extends JFrame {
    public JPanel mainPanel;
    private JTextField partNameField;
    private JButton createButton;
    public JTextField partCaseField;
    private JCheckBox isSMDCheckBox;
    private JTextField partPrice;
    public JTextField partQuantity;
    private JButton editButton;
    private JButton sellPart;
    private JComboBox clientNames;
    private JTextField searchField;
    private JButton searchButton;
    private JButton deleteButton;
    private JLabel clientLabel;
    private JTable table1;
    ArrayList<Object> partslist = new ArrayList<>();

    public MSPgui(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] columnNames = {"id","Name", "Case", "TotalQuantity", "Price"};

        table1.setBounds(30, 40, 200, 300);
        table1.setVisible(true);
        this.setContentPane(mainPanel);
        this.pack();

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setColumnCount(5);
        model.addRow(columnNames);

        createButton.addActionListener(e -> {
            String partName = partNameField.getText();
            String partCase = partCaseField.getText();
            int quantity = Integer.parseInt(partQuantity.getText());
            double price = Double.parseDouble(partPrice.getText());
            Object itemID = 0;
            Object[] row = {itemID,partName, partCase, quantity, price};
            Object newPart = new Part(itemID,partName, partCase, quantity, price);
            partslist.add(newPart);
            model.addRow(row);
            partNameField.setText("");
            partCaseField.setText("");
            partQuantity.setText("");
            partPrice.setText("");
        });

        searchButton.addActionListener(e -> {
            String searchPartName = searchField.getText();
            for (int i = 0; i < partslist.size(); i++) {
                String listWord = Part.getPartName(partslist.get(i));
                if (listWord.equals(searchPartName)) {
                    System.out.println("Found");
                    break;
                } else {
                    System.out.println("Not Found");
                }
            }

        });


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedRow() != -1) {
                    model.removeRow(table1.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
                }
            }
        });
    }
}

