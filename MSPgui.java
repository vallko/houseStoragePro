import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.setContentPane(mainPanel);
        this.pack();
        clientBoxList.setToolTipText("Client List");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                System.out.println(newPart.toString());
                partNameField.setText("");
                partCaseField.setText("");
                partQuantity.setText("");
                partPrice.setText("");
            }
        });
    }
}

