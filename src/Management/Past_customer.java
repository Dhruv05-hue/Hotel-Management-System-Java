package Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

public class Past_customer extends JFrame{

	JTable table;
    JButton back;
	
	Past_customer(){
		
		 JPanel panel = new JPanel();
	        panel.setBounds(5, 5, 1180, 590);
	        panel.setBackground(new Color(3, 45, 48));
	        panel.setLayout(null);
	        add(panel);
	        
	        JLabel l2 = new JLabel("Past Customers");
	        l2.setBounds(550,10,200,30);
	        l2.setForeground(Color.white);
	        l2.setFont(new Font("Tahoma",Font.BOLD,20));
	        panel.add(l2);

	        // Table
	        table = new JTable();
	        table.setBackground(new Color(3, 45, 48));
	        table.setForeground(Color.WHITE);
	        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        table.setRowHeight(25); 
	        table.setGridColor(Color.LIGHT_GRAY);
	        table.setSelectionBackground(new Color(0, 120, 215));

	        // Table Header styling
	        JTableHeader header = table.getTableHeader();
	        header.setBackground(new Color(0, 102, 102));
	        header.setForeground(Color.WHITE);
	        header.setFont(new Font("Tahoma", Font.BOLD, 14));

	        // ScrollPane (required for headers)
	        JScrollPane sp = new JScrollPane(table);
	        sp.setBounds(10, 50, 1160,450); // SAME size as before
	        sp.getViewport().setBackground(new Color(3, 45, 48));
	        panel.add(sp);
	        
	        back = new JButton("Back");
	        back.setBounds(10,510,90,30);
	        back.setBackground(Color.black);
	        back.setForeground(Color.white);
	        back.addActionListener(new ActionListener() {
		    	@Override
		    	public void actionPerformed(ActionEvent e) {
		    		
		    		setVisible(false);
		    	}
		    });
	        panel.add(back);
	        
	     // Print Button
	        JButton print = new JButton("Print");
	        print.setBounds(120, 510, 90, 30);   // next to Back button
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
	        
	        

	        // Database data
	        try {
	            data d = new data();
	            String q = "select * from customer_history";
	            ResultSet rs = d.statement.executeQuery(q);
	            table.setModel(DbUtils.resultSetToTableModel(rs));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        setLayout(null);
	        setLocation(300, 100);
	        setSize(1200, 600);
	        setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Past_customer();
	}

}
