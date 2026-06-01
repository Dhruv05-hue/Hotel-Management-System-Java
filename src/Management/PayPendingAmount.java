package Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PayPendingAmount extends JFrame implements ActionListener {

    JTextField tfAmount;
    JLabel lblRoom, lblPending;
    JButton payBtn, backBtn;

    String customerId;
    String roomNumber;
    int pendingAmount;

    public PayPendingAmount(String customerId, String roomNumber, int pendingAmount) {

        this.customerId = customerId;
        this.roomNumber = roomNumber;
        this.pendingAmount = pendingAmount;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        panel.setBounds(5, 5, 420, 280);
        add(panel);

        JLabel title = new JLabel("Pending Payment");
        title.setBounds(120, 15, 250, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        panel.add(title);

        JLabel l1 = new JLabel("Room No :");
        l1.setBounds(40, 70, 150, 25);
        l1.setForeground(Color.WHITE);
        panel.add(l1);

        lblRoom = new JLabel(roomNumber);
        lblRoom.setBounds(200, 70, 150, 25);
        lblRoom.setForeground(Color.WHITE);
        panel.add(lblRoom);

        JLabel l2 = new JLabel("Pending Amount :");
        l2.setBounds(40, 110, 150, 25);
        l2.setForeground(Color.WHITE);
        panel.add(l2);

        lblPending = new JLabel("Rs " + pendingAmount);
        lblPending.setBounds(200, 110, 150, 25);
        lblPending.setForeground(Color.WHITE);
        panel.add(lblPending);

        JLabel l3 = new JLabel("Enter Amount :");
        l3.setBounds(40, 150, 150, 25);
        l3.setForeground(Color.WHITE);
        panel.add(l3);

        tfAmount = new JTextField();
        tfAmount.setBounds(200, 150, 150, 25);
        panel.add(tfAmount);

        payBtn = new JButton("Pay & Checkout");
        payBtn.setBounds(60, 210, 140, 30);
        payBtn.setBackground(Color.BLACK);
        payBtn.setForeground(Color.WHITE);
        payBtn.addActionListener(this);
        panel.add(payBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(230, 210, 100, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(e -> setVisible(false));
        panel.add(backBtn);

        setSize(430, 300);
        setLocation(550, 300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == payBtn) {

            String paidText = tfAmount.getText().trim();

            // ❌ Validate numeric
            if (!paidText.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Enter a valid amount");
                return;
            }

            int paid = Integer.parseInt(paidText);

            // ❌ Must pay exact pending amount
            if (paid != pendingAmount) {
                JOptionPane.showMessageDialog(
                        null,
                        "Please pay exact pending amount Rs " + pendingAmount
                );
                return;
            }

            try {
                data d = new data();

                // ✅ 1. INSERT INTO CUSTOMER HISTORY
                String insertHistory =
                        "INSERT INTO customer_history " +
                        "(customer_id, document_type, id_number, name, gender, country, " +
                        "room_number, room_price, deposit, checkin_time, checkout_time) " +
                        "SELECT c.customer_id, c.document_type, c.number, c.name, c.gender, c.country, " +
                        "c.room_number, r.price, r.price, c.checkin_time, NOW() " +
                        "FROM customer c " +
                        "JOIN room r ON c.room_number = r.room_number " +
                        "WHERE c.customer_id='" + customerId + "'";

                d.statement.executeUpdate(insertHistory);

                // ✅ 2. FREE ROOM
                d.statement.executeUpdate(
                        "UPDATE room SET availability='Available' WHERE room_number='" + roomNumber + "'"
                );

                // ✅ 3. DELETE CUSTOMER
                d.statement.executeUpdate(
                        "DELETE FROM customer WHERE customer_id='" + customerId + "'"
                );

                JOptionPane.showMessageDialog(
                        null,
                        "Payment Successful!\nCustomer Checked Out.\nRoom " + roomNumber + " is now available."
                );

                setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database error!");
            }
        }
    }

    // 🔹 For testing
    public static void main(String[] args) {
        new PayPendingAmount("1", "101", 500);
    }
}
