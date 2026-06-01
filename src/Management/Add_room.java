package Management;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Add_room extends JFrame implements ActionListener {

    JTextField tfRoom, tfPrice;
    JComboBox<String> cbAvailability, cbClean, cbBed;
    JButton add, back;

    public Add_room() {

        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 500);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

       
        JLabel heading = new JLabel("Add Rooms");
        heading.setBounds(50, 20, 200, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

       
        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(50, 90, 150, 25);
        lblRoom.setForeground(Color.WHITE);
        lblRoom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(lblRoom);

        tfRoom = new JTextField();
        tfRoom.setBounds(220, 90, 150, 25);
        panel.add(tfRoom);

        
        JLabel lblAvail = new JLabel("Availability");
        lblAvail.setBounds(50, 130, 150, 25);
        lblAvail.setForeground(Color.WHITE);
        lblAvail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(lblAvail);

        cbAvailability = new JComboBox<>(new String[]{"Available", "Occupied"});
        cbAvailability.setBounds(220, 130, 150, 25);
        panel.add(cbAvailability);

       
        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(50, 170, 150, 25);
        lblPrice.setForeground(Color.WHITE);
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(lblPrice);

        tfPrice = new JTextField();
        tfPrice.setBounds(220, 170, 150, 25);
        panel.add(tfPrice);

       
        JLabel lblClean = new JLabel("Cleaning Status");
        lblClean.setBounds(50, 210, 150, 25);
        lblClean.setForeground(Color.WHITE);
        lblClean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(lblClean);

        cbClean = new JComboBox<>(new String[]{"Cleaned", "Dirty"});
        cbClean.setBounds(220, 210, 150, 25);
        panel.add(cbClean);

        
        JLabel lblBed = new JLabel("Bed Type");
        lblBed.setBounds(50, 250, 150, 25);
        lblBed.setForeground(Color.WHITE);
        lblBed.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(lblBed);

        cbBed = new JComboBox<>(new String[]{"Single Bed", "Double Bed"});
        cbBed.setBounds(220, 250, 150, 25);
        panel.add(cbBed);

       
        add = new JButton("Add");
        add.setBounds(80, 320, 100, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("Back");
        back.setBounds(220, 320, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Images/roomser.png"));
        Image im = i.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(im);
        JLabel label = new JLabel(i2);
        label.setBounds(500,60,300,300);
        panel.add(label);
        
        setLayout(null);
        setSize(900, 500);
        setLocation(580, 130);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {

        	try {
        		
        		data d = new data();
        		String room = tfRoom.getText();
        		String ava = (String)cbAvailability.getSelectedItem();
        		String status = (String) cbClean.getSelectedItem();
        		String price =  tfPrice.getText();
        		String type = (String)cbBed.getSelectedItem();
        		
        		String q = "insert into room values('"+room+"','"+ava+"','"+price+"','"+status+"','"+type+"')";
        		d.statement.executeUpdate(q);
        		JOptionPane.showMessageDialog(null,"Room Successfully Added");
        		setVisible(false);
        		
        	}catch(Exception E) {
        		
        		E.printStackTrace();
        	}

        	
        } else if (e.getSource() == back) {
        	
            setVisible(false);
            
        }
    }

    public static void main(String[] args) {
        new Add_room();
    }
}

