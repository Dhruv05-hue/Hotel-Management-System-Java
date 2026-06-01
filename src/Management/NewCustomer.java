package Management;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewCustomer extends JFrame implements ActionListener {

    JComboBox<String> combobox;
    JTextField tfNum, tfName, tfCou, tfDep;
    JLabel date, price;
    JRadioButton r1, r2;
    Choice c1;
    JButton add, back;

    // ✅ REQUIRED: store room price
    int currentRoomPrice = 0;

    public NewCustomer() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel labelName = new JLabel("New Customer Form");
        labelName.setBounds(34, 1, 260, 30);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35, 76, 200, 14);
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);

        combobox = new JComboBox<>(new String[]{
                "Passport", "Aadhar Card", "Voter Id", "Driving Licence"
        });
        combobox.setBounds(271, 73, 150, 20);
        combobox.setBackground(new Color(3, 45, 48));
        combobox.setForeground(Color.WHITE);
        panel.add(combobox);

        JLabel labelNum = new JLabel("Number :");
        labelNum.setBounds(35, 111, 200, 14);
        labelNum.setForeground(Color.WHITE);
        panel.add(labelNum);

        tfNum = new JTextField();
        tfNum.setBounds(271, 111, 150, 20);
        panel.add(tfNum);

        JLabel labelname = new JLabel("Name :");
        labelname.setBounds(35, 151, 200, 14);
        labelname.setForeground(Color.WHITE);
        panel.add(labelname);

        tfName = new JTextField();
        tfName.setBounds(271, 151, 150, 20);
        panel.add(tfName);

        JLabel labelGen = new JLabel("Gender :");
        labelGen.setBounds(35, 191, 200, 14);
        labelGen.setForeground(Color.WHITE);
        panel.add(labelGen);

        r1 = new JRadioButton("Male");
        r1.setBounds(271, 191, 80, 20);
        r1.setBackground(new Color(3, 45, 48));
        r1.setForeground(Color.WHITE);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(350, 191, 80, 20);
        r2.setBackground(new Color(3, 45, 48));
        r2.setForeground(Color.WHITE);
        panel.add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel labelCou = new JLabel("Country :");
        labelCou.setBounds(35, 231, 200, 14);
        labelCou.setForeground(Color.WHITE);
        panel.add(labelCou);

        tfCou = new JTextField();
        tfCou.setBounds(271, 231, 150, 20);
        panel.add(tfCou);

        JLabel labelroom = new JLabel("Allocate Room Number :");
        labelroom.setBounds(35, 274, 200, 14);
        labelroom.setForeground(Color.WHITE);
        panel.add(labelroom);

        price = new JLabel("Price : ");
        price.setBounds(430, 274, 200, 20);
        price.setForeground(Color.WHITE);
        panel.add(price);

        // ===== ROOM DROPDOWN =====
        c1 = new Choice();
        try {
            data d = new data();
            ResultSet rs = d.statement.executeQuery(
                    "SELECT room_number FROM room WHERE availability='Available'"
            );
            while (rs.next()) {
                c1.add(rs.getString("room_number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(271, 274, 150, 20);
        panel.add(c1);

        if (c1.getItemCount() > 0) {
            loadRoomPrice();
        }

        c1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                loadRoomPrice();
            }
        });

        JLabel labelcis = new JLabel("Checked-In :");
        labelcis.setBounds(35, 316, 200, 14);
        labelcis.setForeground(Color.WHITE);
        panel.add(labelcis);

        date = new JLabel(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        date.setBounds(271, 316, 200, 14);
        date.setForeground(Color.WHITE);
        panel.add(date);

        JLabel labelDep = new JLabel("Deposit :");
        labelDep.setBounds(35, 359, 200, 19);
        labelDep.setForeground(Color.WHITE);
        panel.add(labelDep);

        tfDep = new JTextField();
        tfDep.setBounds(271, 359, 150, 20);
        panel.add(tfDep);

        add = new JButton("ADD");
        add.setBounds(100, 430, 120, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("Back");
        back.setBounds(260, 430, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        setLayout(null);
        setLocation(500, 150);
        setSize(850, 550);
        setVisible(true);
    }

    // ===== LOAD ROOM PRICE =====
    private void loadRoomPrice() {
        try {
            data d = new data();
            ResultSet rs = d.statement.executeQuery(
                    "SELECT price, bed_type FROM room WHERE room_number='" + c1.getSelectedItem() + "'"
            );
            if (rs.next()) {
                currentRoomPrice = rs.getInt("price"); // ✅ IMPORTANT
                price.setText("Price : " + currentRoomPrice + " " + rs.getString("bed_type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {
        	
        	if (tfName.getText().trim().isEmpty() &&
        		    tfNum.getText().trim().isEmpty() &&
        		    tfCou.getText().trim().isEmpty() &&
        		    tfDep.getText().trim().isEmpty() &&
        		    !r1.isSelected() &&
        		    !r2.isSelected()) {

        		    JOptionPane.showMessageDialog(
        		        null,
        		        "Please fill all the fields",
        		        "Validation Error",
        		        JOptionPane.WARNING_MESSAGE
        		    );
        		    return;
        		}


            if (tfName.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is required");
                return;
            }

            if (!r1.isSelected() && !r2.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please select gender");
                return;
            }

            String number = tfNum.getText().trim();
            if (!number.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(null, "Number must be exactly 10 digits");
                return;
            }

            String depText = tfDep.getText().trim();
            if (!depText.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Deposit must be numeric");
                return;
            }

            int deposit = Integer.parseInt(depText);
            if (deposit > currentRoomPrice) {
                JOptionPane.showMessageDialog(null,
                        "Deposit cannot exceed room price (" + currentRoomPrice + ")");
                return;
            }

            try {
                data d = new data();
                String gender = r1.isSelected() ? "Male" : "Female";

                String q =
                        "INSERT INTO customer(document_type,number,name,gender,country,room_number,checkin_time,deposit) " +
                        "VALUES ('" + combobox.getSelectedItem() + "','" +
                        number + "','" +
                        tfName.getText() + "','" +
                        gender + "','" +
                        tfCou.getText() + "','" +
                        c1.getSelectedItem() + "','" +
                        date.getText() + "','" +
                        deposit + "')";

                String q1 =
                        "UPDATE room SET availability='Occupied' WHERE room_number='" +
                        c1.getSelectedItem() + "'";

                d.statement.executeUpdate(q);
                d.statement.executeUpdate(q1);

                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
