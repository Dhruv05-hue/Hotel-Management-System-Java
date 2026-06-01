package Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

public class Room extends JFrame {

    JTable table;
    JButton back;

    Room() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(3, 45, 48));
        panel.setLayout(null);
        add(panel);

        // Image
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Images/room2.png"));
        Image im = ic.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
        JLabel l = new JLabel(new ImageIcon(im));
        l.setBounds(650, 190, 220, 220);
        panel.add(l);
        
        JLabel l2 = new JLabel("ROOM STATUS");
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
        sp.setBounds(10, 50, 620,450); // SAME size as before
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

        // Database data
        try {
            data d = new data();
            String q = "select * from room";
            ResultSet rs = d.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(null);
        setLocation(500, 100);
        setSize(900, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
