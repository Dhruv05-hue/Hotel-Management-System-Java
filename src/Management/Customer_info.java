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

public class Customer_info extends JFrame {

	    JTable table;
	    JButton back;
	
	Customer_info(){
		
	       JPanel panel = new JPanel();
	        panel.setBounds(5, 5, 890, 590);
	        panel.setBackground(new Color(3, 45, 48));
	        panel.setLayout(null);
	        add(panel);
	       
	        
	        JLabel l2 = new JLabel(" Current Customers");
	        l2.setBounds(350,10,200,30);
	        l2.setForeground(Color.white);
	        l2.setFont(new Font("Tahoma",Font.BOLD,20));
	        panel.add(l2);

	        // Table
	        table = new JTable();
	        table.setBackground(new Color(3, 45, 48));
	        table.setForeground(Color.WHITE);
	        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        table.setRowHeight(25); // does NOT change table size
	        table.setGridColor(Color.LIGHT_GRAY);
	        table.setSelectionBackground(new Color(0, 120, 215));

	        // Table Header styling
	        JTableHeader header = table.getTableHeader();
	        header.setBackground(new Color(0, 102, 102));
	        header.setForeground(Color.WHITE);
	        header.setFont(new Font("Tahoma", Font.BOLD, 14));

	        // ScrollPane (required for headers)
	        JScrollPane sp = new JScrollPane(table);
	        sp.setBounds(5, 50, 870,450); // SAME size as before
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
	        
	        try {
	            data d = new data();
	            String q = "select * from customer";
	            ResultSet rs = d.statement.executeQuery(q);
	            table.setModel(DbUtils.resultSetToTableModel(rs));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	     
	        JButton print = new JButton("Print");
	        print.setBounds(120, 510, 90, 30);
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

	        setLayout(null);
	        setLocation(500, 100);
	        setSize(900, 600);
	        setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
             new Customer_info();
	}

}
