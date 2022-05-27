import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.ArrayList;
import java.util.Arrays;

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
    private JComboBox clientBoxList;
    private JTextField searchField;
    private JButton searchButton;
    private JButton deleteButton;
    private JLabel clientLabel;
    private JTable table1;
    ArrayList<Object> partslist = new ArrayList<>();

    public MSPgui(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] columnNames = {"Name", "Case", "Price"};
//        String[] columnName1 = {"Case"};
//        String[] columnName2 = {"Price"};


        table1.setBounds(30, 40, 200, 300);
        table1.setVisible(true);
        // table1.
        // JScrollPane sp = new JScrollPane(table1);
//table1.set
//
//        String data[][] = {{"101", "Amit", "670000"},
//                {"102", "Jai", "780000"},
//                {"101", "Sachin", "700000"}};
//        String column[] = {"ID", "NAME", "SALARY"};
        // table1 = new JTable(data, column);
        //  table1.setBounds(30, 40, 200, 300);
        // JScrollPane sp = new JScrollPane(table1);
        //   sp1 = sp;
        // sp.setSize(10, 10);

//        table1.addColumn(new TableColumn(2));
        this.setContentPane(mainPanel);
        this.pack();

        Object[] row = {partNameField, partCaseField, partPrice};
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setColumnCount(3);
        model.addRow(columnNames);

        createButton.addActionListener(e -> {
            String partName = partNameField.getText();
            String partCase = partCaseField.getText();
            int quantity = Integer.parseInt(partQuantity.getText());
            double price = Double.parseDouble(partPrice.getText());
            Object newPart = new Part(partName, partCase, quantity, price);
            partslist.add(newPart);
            System.out.println(partName);
            System.out.println(partCase);
            System.out.println(quantity);
            System.out.println(price);
            System.out.println(newPart);

            model.addRow(row);
            System.out.println(model.getColumnCount());
            partNameField.setText("");
            partCaseField.setText("");
            partQuantity.setText("");
            partPrice.setText("");

        });

    }

}

