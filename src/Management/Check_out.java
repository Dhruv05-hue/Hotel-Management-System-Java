package Management;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Check_out extends JFrame {

    Choice customerId;
    JLabel lblRoom, lblCheckIn, lblCheckOut, lblPending;
    JButton check, checkout, back;

    int pendingAmount = -1;   
    String roomNumber = "";

    public Check_out() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 880, 420);
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel heading = new JLabel("Check-Out");
        heading.setBounds(60, 20, 200, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        
        JLabel lblId = new JLabel("Customer ID");
        lblId.setBounds(60, 90, 150, 25);
        lblId.setForeground(Color.WHITE);
        panel.add(lblId);

        customerId = new Choice();
        customerId.setBounds(230, 90, 200, 25);
        panel.add(customerId);

        try {
            data d = new data();
            ResultSet rs = d.statement.executeQuery(
                "SELECT customer_id FROM customer"
            );
            while (rs.next()) {
                customerId.add(rs.getString("customer_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        JLabel lblRoomText = new JLabel("Room Number");
        lblRoomText.setBounds(60, 140, 150, 25);
        lblRoomText.setForeground(Color.WHITE);
        panel.add(lblRoomText);

        lblRoom = new JLabel();
        lblRoom.setBounds(230, 140, 200, 25);
        lblRoom.setForeground(Color.WHITE);
        panel.add(lblRoom);

        
        JLabel lblCheckInText = new JLabel("Check-In Time");
        lblCheckInText.setBounds(60, 180, 150, 25);
        lblCheckInText.setForeground(Color.WHITE);
        panel.add(lblCheckInText);

        lblCheckIn = new JLabel();
        lblCheckIn.setBounds(230, 180, 300, 25);
        lblCheckIn.setForeground(Color.WHITE);
        panel.add(lblCheckIn);

        
        JLabel lblCheckOutText = new JLabel("Check-Out Time");
        lblCheckOutText.setBounds(60, 220, 150, 25);
        lblCheckOutText.setForeground(Color.WHITE);
        panel.add(lblCheckOutText);

        lblCheckOut = new JLabel(
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
        );
        lblCheckOut.setBounds(230, 220, 300, 25);
        lblCheckOut.setForeground(Color.WHITE);
        panel.add(lblCheckOut);

        
        JLabel lblPendingText = new JLabel("Pending Amount (Rs)");
        lblPendingText.setBounds(60, 260, 180, 25);
        lblPendingText.setForeground(Color.WHITE);
        panel.add(lblPendingText);

        lblPending = new JLabel();
        lblPending.setBounds(230, 260, 200, 25);
        lblPending.setForeground(Color.WHITE);
        panel.add(lblPending);

        
        check = new JButton("Check");
        check.setBounds(320, 320, 100, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);

        checkout = new JButton("Check-Out");
        checkout.setBounds(80, 320, 100, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        panel.add(checkout);

        back = new JButton("Back");
        back.setBounds(200, 320, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

        
        check.addActionListener(e -> loadDetails());
        checkout.addActionListener(e -> doCheckout());
        back.addActionListener(e -> setVisible(false));

        setLayout(null);
        setLocation(450, 200);
        setSize(900, 420);
        setVisible(true);
    }

    
    private void loadDetails() {
        try {
            data d = new data();

            String q =
                "SELECT c.room_number, c.checkin_time, c.deposit, r.price " +
                "FROM customer c JOIN room r ON c.room_number = r.room_number " +
                "WHERE c.customer_id='" + customerId.getSelectedItem() + "'";

            ResultSet rs = d.statement.executeQuery(q);

            if (rs.next()) {
                roomNumber = rs.getString("room_number");
                lblRoom.setText(roomNumber);
                lblCheckIn.setText(rs.getString("checkin_time"));

                int price = rs.getInt("price");
                int deposit = rs.getInt("deposit");
                pendingAmount = price - deposit;

                lblPending.setText(String.valueOf(pendingAmount));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= SAFE CHECKOUT =================
    private void doCheckout() {
        try {

            
            if (pendingAmount == -1) {
                JOptionPane.showMessageDialog(null, "Please click CHECK first");
                return;
            }

            
            if (pendingAmount > 0) {
                new PayPendingAmount(
                    customerId.getSelectedItem(),
                    roomNumber,
                    pendingAmount
                );
                return;
            }

            data d = new data();
            String cid = customerId.getSelectedItem();

                        String insertHistory =
            	    "INSERT INTO customer_history " +
            	    "(customer_id, document_type, id_number, name, gender, country, " +
            	    "room_number, room_price, deposit, checkin_time, checkout_time) " +
            	    "SELECT c.customer_id, c.document_type, c.number, c.name, c.gender, c.country, " +
            	    "c.room_number, r.price, c.deposit, c.checkin_time, NOW() " +
            	    "FROM customer c " +
            	    "JOIN room r ON c.room_number = r.room_number " +
            	    "WHERE c.customer_id='" + customerId.getSelectedItem() + "'";

            d.statement.executeUpdate(insertHistory);

            d.statement.executeUpdate(
                "UPDATE room SET availability='Available' WHERE room_number='" + roomNumber + "'"
            );

            d.statement.executeUpdate(
                "DELETE FROM customer WHERE customer_id='" + cid + "'"
            );

            JOptionPane.showMessageDialog(null, "Checked Out Successfully");
            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Check_out();
    }
}
