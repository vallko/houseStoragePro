import javax.swing.*;

public class TableExample{
    JFrame f;
    JScrollPane sp1;
    TableExample() {

       // f = new JFrame();

        String data[][] = {{"101", "Amit", "670000"},
                {"102", "Jai", "780000"},
                {"101", "Sachin", "700000"}};
        String column[] = {"ID", "NAME", "SALARY"};
        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        sp1 = sp;
        sp.setSize(10,10);

//        f.add(sp);
//        f.setSize(300, 400);
//        f.setVisible(true);
    }
}
