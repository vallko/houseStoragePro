import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;


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
    private JButton excelButton;
    ArrayList<Part> partslist = new ArrayList<>();

    public MSPgui(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] columnNames = {"id", "Name", "Case", "TotalQuantity", "Price"};

        table1.setBounds(30, 40, 200, 300);
        table1.setVisible(true);
        table1.setAutoCreateRowSorter(true);
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
            int itemID = 0;
            Object[] row = {itemID, partName, partCase, quantity, price};
            Part newPart = new Part(itemID, partName, partCase, quantity, price);
            partslist.add(newPart);
            model.addRow(row);
            partNameField.setText("");
            partCaseField.setText("");
            partQuantity.setText("");
            partPrice.setText("");
        });

        searchButton.addActionListener(e -> {                                   //Find matching element in List by word ItemName
            String searchPartName = searchField.getText();
            for (Part part : partslist) {
                String listSearchWord = part.getPartName();
                if (listSearchWord.equals(searchPartName)) {
                    System.out.println("found");
                    searchField.setText("");
                    break;
                }
            }
        });

        deleteButton.addActionListener(e -> {                                              //Delete row
            if (table1.getSelectedRow() != -1) {
                model.removeRow(table1.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Deleted");
            }
        });

        searchField.addKeyListener(new KeyAdapter() {                               //Dynamic Row filter by search word
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table1.getModel());
                table1.setRowSorter(sorter);
                table1.getSelectionModel().addListSelectionListener(
                        event -> {
                            int viewRow = table1.getSelectedRow();
                            if (viewRow < 0) {
                                //Selection got filtered away.
                                searchField.setText("");
                            } else {
                                int modelRow = table1.convertRowIndexToModel(viewRow);
                                searchField.setText(String.format("Selected Row in view: %d. " +
                                        "Selected Row in model: %d.", viewRow, modelRow));
                            }
                        }
                );
            }
        });

        excelButton.addActionListener(e -> {                                         //Export Table to Excel
            if (e.getSource() == excelButton) {
                JFileChooser fchoose = new JFileChooser();
                int option = fchoose.showSaveDialog(new JFileChooser());
                if (option == JFileChooser.APPROVE_OPTION) {
                    String name = fchoose.getSelectedFile().getName();
                    String path = fchoose.getSelectedFile().getParentFile().getPath();
                    String file = path + "\\" + name + ".xls";
                    JTableToExcel.export(table1, new File(file));
                }
            }
        });
    }
}


