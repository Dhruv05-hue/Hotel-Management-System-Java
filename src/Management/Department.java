package Management;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Department extends JFrame {

    JTable table;
    JButton back;

    Department() {

        JPanel panel = new JPanel();
        panel.setBackground(new Color(3, 45, 48));
        panel.setBounds(5, 5, 900, 600);
        panel.setLayout(null);
        add(panel);

        
        JLabel title = new JLabel("Department");
        title.setBounds(190, 10, 200, 30);
        title.setFont(new Font("Tahoma", Font.ITALIC, 20));
        title.setForeground(Color.WHITE);
        panel.add(title);
        
        JLabel title2 = new JLabel("Budget");
        title2.setBounds(600, 10, 200, 30);
        title2.setFont(new Font("Tahoma", Font.ITALIC, 20));
        title2.setForeground(Color.WHITE);
        panel.add(title2);

        table = new JTable();
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
        table.setRowHeight(30);
        table.setShowGrid(true);
        table.setGridColor(Color.GRAY);
        table.setTableHeader(null); // ❌ no column header (like image)

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 60, 850, 450);
        sp.getViewport().setBackground(new Color(3, 45, 48));
        panel.add(sp);

        
        try {
            data d = new data();
            ResultSet rs = d.statement.executeQuery(
                "SELECT dept_name, budget FROM department"
            );
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        back = new JButton("BACK");
        back.setBounds(390, 520, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

        back.addActionListener(e -> setVisible(false));

       
        setLayout(null);
        setSize(900, 600);
        setLocation(550, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Department();
    }
}
