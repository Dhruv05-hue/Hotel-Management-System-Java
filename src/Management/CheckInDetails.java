package Management;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckInDetails extends JFrame implements ActionListener {

    Choice cbId;
    JTextField tfRoom, tfName, tfPaid, tfPending;
    JButton update, back, check;
    JLabel nametext,tfCheckin;
    String oldRoom;

    public CheckInDetails() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 880, 520);
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel heading = new JLabel("Check-In Details");
        heading.setBounds(60, 20, 300, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        // ID
        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(60, 90, 150, 25);
        lblId.setFont(new Font("Tahoma",Font.BOLD,14));
        lblId.setForeground(Color.WHITE);
        panel.add(lblId);

        cbId = new Choice();
        cbId.setBounds(230, 90, 200, 25);
        panel.add(cbId);
        
        try {
        	data d = new data();
        	ResultSet rs = d.statement.executeQuery("select * from customer");
        	while(rs.next()) {
        		
        		cbId.add(rs.getString("customer_id"));
        	}
        }catch(Exception e) {
        	
        	e.printStackTrace();
        	
        }

        // Room Number
        JLabel lblRoom = new JLabel("Room Number :");
        lblRoom.setBounds(60, 130, 150, 25);
        lblRoom.setForeground(Color.WHITE);
        lblRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblRoom);

        tfRoom = new JTextField();
        tfRoom.setBounds(230, 130, 200, 25);
        panel.add(tfRoom);

        // Name
        JLabel lblName = new JLabel("Name :");
        lblName.setBounds(60, 170, 150, 25);
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblName);

        nametext = new JLabel();
        nametext.setBounds(230, 170, 200, 25);
        nametext.setFont(new Font("Tahoma",Font.BOLD,14));
        nametext.setForeground(Color.WHITE);
        panel.add(nametext);

        // Checked-in
        JLabel lblCheckin = new JLabel("Checked-in :");
        lblCheckin.setBounds(60, 210, 150, 25);
        lblCheckin.setForeground(Color.WHITE);
        lblCheckin.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblCheckin);

        tfCheckin = new JLabel();
        tfCheckin.setBounds(230, 210, 200, 25);
        tfCheckin.setForeground(Color.WHITE);
        tfCheckin.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(tfCheckin);

        // Amount Paid
        JLabel lblPaid = new JLabel("Amount Paid (Rs) :");
        lblPaid.setBounds(60, 250, 150, 25);
        lblPaid.setForeground(Color.WHITE);
        lblPaid.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblPaid);

        tfPaid = new JTextField();
        tfPaid.setBounds(230, 250, 200, 25);
        panel.add(tfPaid);

        // Pending Amount
        JLabel lblPending = new JLabel("Pending Amount (Rs) :");
        lblPending.setBounds(60, 290, 170, 25);
        lblPending.setForeground(Color.WHITE);
        lblPending.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblPending);

        tfPending = new JTextField();
        tfPending.setBounds(230, 290, 200, 25);
        panel.add(tfPending);

        // Buttons
        update = new JButton("Update");
        update.setBounds(80, 360, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        panel.add(update);

        back = new JButton("Back");
        back.setBounds(200, 360, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        check = new JButton("Check");
        check.setBounds(320, 360, 100, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        panel.add(check);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Images/checku.png"));
        Image im = ic.getImage().getScaledInstance(260, 220, Image.SCALE_SMOOTH);
        JLabel l = new JLabel(new ImageIcon(im));
        l.setBounds(550, 100, 260, 220);
        panel.add(l);

        setLayout(null);
        setLocation(450, 150);
        setSize(900, 550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    	data d = new data();
    	try {
        if (e.getSource() == check) {
            
        	String id = cbId.getSelectedItem();
        	
        	 String q =
                     "SELECT c.name, c.room_number, c.checkin_time, c.deposit, r.price " +
                     "FROM customer c JOIN room r ON c.room_number = r.room_number " +
                     "WHERE c.customer_id='" + id + "'";
        	 
        	 ResultSet rs = d.statement.executeQuery(q);
        	 if (rs.next()) {
        		    nametext.setText(rs.getString("name"));
        		    tfRoom.setText(rs.getString("room_number"));
        		    tfCheckin.setText(rs.getString("checkin_time"));
        		    tfPaid.setText(rs.getString("deposit"));

        		    oldRoom = rs.getString("room_number");

        		    int price = rs.getInt("price");
        		    int paid = rs.getInt("deposit");
        		    tfPending.setText(String.valueOf(price - paid));
        		}

        }
        else if (e.getSource() == update) {

            String id = cbId.getSelectedItem();
            String newRoom = tfRoom.getText();
            String paid = tfPaid.getText();

            String q1 =
                "UPDATE customer SET deposit='" + paid + "' WHERE customer_id='" + id + "'";
            d.statement.executeUpdate(q1);

           
            if (!newRoom.equals(oldRoom)) {
                String q2 =
                    "UPDATE room SET availability='Available' WHERE room_number='" + oldRoom + "'";
                d.statement.executeUpdate(q2);

                String q3 =
                    "UPDATE room SET availability='Occupied' WHERE room_number='" + newRoom + "'";
                d.statement.executeUpdate(q3);

                String q4 =
                    "UPDATE customer SET room_number='" + newRoom + "' WHERE customer_id='" + id + "'";
                d.statement.executeUpdate(q4);

                oldRoom = newRoom; 
            }

            String q5 =
                "SELECT r.price, c.deposit FROM customer c " +
                "JOIN room r ON c.room_number = r.room_number " +
                "WHERE c.customer_id='" + id + "'";

            ResultSet rs2 = d.statement.executeQuery(q5);
            if (rs2.next()) {
                int price = rs2.getInt("price");
                int deposit = rs2.getInt("deposit");
                tfPending.setText(String.valueOf(price - deposit));
            }

            JOptionPane.showMessageDialog(null, "Updated Successfully");
        }

        else if (e.getSource() == back) {
            setVisible(false);
        }
    	}catch(Exception E) {
    		
    		E.printStackTrace();
    		
    	}
    }

    public static void main(String[] args) {
        new CheckInDetails();
    }
}
