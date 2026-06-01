package Management;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Manager extends JFrame {

	JTable table;
    JButton back;
	
	Manager(){
		
		 JPanel panel = new JPanel();
	        panel.setBounds(0, 0, 1000, 550);
	        panel.setLayout(null);
	        panel.setBackground(new Color(3, 45, 48));
	        add(panel);
	        
	        JLabel l1 = new JLabel("Managers");
	        l1.setBounds(420,10,200,30);
	        l1.setFont(new Font("Tahoma",Font.BOLD,21));
	        l1.setForeground(Color.white);
	        panel.add(l1);

	        // ===== TABLE =====
	        table = new JTable();
	        table.setBackground(new Color(3, 45, 48));
	        table.setForeground(Color.WHITE);
	        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        table.setRowHeight(28);
	        table.setGridColor(Color.GRAY);
	        table.setSelectionBackground(new Color(0, 120, 215));

	        JScrollPane sp = new JScrollPane(table);
	        sp.setBounds(20, 50, 950, 400);
	        sp.getViewport().setBackground(new Color(3, 45, 48));
	        panel.add(sp);

	        
	        try {
	            data d = new data();
	            ResultSet rs = d.statement.executeQuery(
	                "SELECT name, age, gender, job, salary, phone, email, aadhar FROM employee where job ='Manager'"
	            );
	            table.setModel(DbUtils.resultSetToTableModel(rs));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        
	        back = new JButton("BACK");
	        back.setBounds(420, 470, 100, 30);
	        back.setBackground(Color.BLACK);
	        back.setForeground(Color.WHITE);
	        panel.add(back);

	        back.addActionListener(e -> setVisible(false));
	        
	     // Print Button
	        JButton print = new JButton("Print");
	        print.setBounds(550, 470, 100, 30);   // aligned nicely beside BACK
	        print.setForeground(Color.white);
	        print.setBackground(Color.black);
	        print.setFocusPainted(false);
	        print.setFont(new Font("Arial", Font.BOLD, 13));

	        print.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    table.print();   // prints JTable
	                } catch (Exception v) {
	                    v.printStackTrace();
	                }
	            }
	        });

	        panel.add(print);

	        // ===== FRAME SETTINGS =====
	        setLayout(null);
	        setSize(1000, 550);
	        setLocation(350, 150);
	        setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Manager();
	}

}
