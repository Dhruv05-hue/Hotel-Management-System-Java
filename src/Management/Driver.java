package Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Driver extends JFrame implements ActionListener {

    JTextField tfName, tfAge, tfCompany, tfCarName, tfLocation,phone;
    JComboBox<String> cbGender, cbAvailable;
    JButton add, back;

    public Driver() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 500);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        
        JLabel heading = new JLabel("ADD DRIVERS");
        heading.setBounds(60, 20, 300, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        
        JLabel lblName = new JLabel("NAME");
        lblName.setBounds(60, 90, 150, 25);
        lblName.setForeground(Color.WHITE);
        panel.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(230, 90, 150, 25);
        panel.add(tfName);

        
        JLabel lblAge = new JLabel("AGE");
        lblAge.setBounds(60, 130, 150, 25);
        lblAge.setForeground(Color.WHITE);
        panel.add(lblAge);

        tfAge = new JTextField();
        tfAge.setBounds(230, 130, 150, 25);
        panel.add(tfAge);

        
        JLabel lblGender = new JLabel("GENDER");
        lblGender.setBounds(60, 170, 150, 25);
        lblGender.setForeground(Color.WHITE);
        panel.add(lblGender);

        cbGender = new JComboBox<>(new String[]{"Male", "Female"});
        cbGender.setBounds(230, 170, 150, 25);
        panel.add(cbGender);

        
        JLabel lblCompany = new JLabel("CAR COMPANY");
        lblCompany.setBounds(60, 210, 150, 25);
        lblCompany.setForeground(Color.WHITE);
        panel.add(lblCompany);

        tfCompany = new JTextField();
        tfCompany.setBounds(230, 210, 150, 25);
        panel.add(tfCompany);

        
        JLabel lblCarName = new JLabel("CAR NAME");
        lblCarName.setBounds(60, 250, 150, 25);
        lblCarName.setForeground(Color.WHITE);
        panel.add(lblCarName);

        tfCarName = new JTextField();
        tfCarName.setBounds(230, 250, 150, 25);
        panel.add(tfCarName);

        
        JLabel lblAvailable = new JLabel("AVAILABLE");
        lblAvailable.setBounds(60, 290, 150, 25);
        lblAvailable.setForeground(Color.WHITE);
        panel.add(lblAvailable);

        cbAvailable = new JComboBox<>(new String[]{"YES", "NO"});
        cbAvailable.setBounds(230, 290, 150, 25);
        panel.add(cbAvailable);

        
        JLabel lblLocation = new JLabel("LOCATION");
        lblLocation.setBounds(60, 330, 150, 25);
        lblLocation.setForeground(Color.WHITE);
        panel.add(lblLocation);

        tfLocation = new JTextField();
        tfLocation.setBounds(230, 330, 150, 25);
        panel.add(tfLocation);
        
        JLabel phonel = new JLabel("PHONE");
        phonel.setBounds(60, 370, 150, 25);
        phonel.setForeground(Color.WHITE);
        panel.add(phonel);

        phone = new JTextField();
        phone.setBounds(230, 370, 150, 25);
        panel.add(phone);

       
        add = new JButton("ADD");
        add.setBounds(90, 430, 100, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(230, 430, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Images/license.png"));
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

        try {
        	
        	 if (e.getSource() == add) {

        	        String name = tfName.getText();
        	        String ageText = tfAge.getText();
        	        String gender = (String) cbGender.getSelectedItem();
        	        String company = tfCompany.getText();
        	        String carname = tfCarName.getText();
        	        String available = (String) cbAvailable.getSelectedItem();
        	        String location = tfLocation.getText();
        	        String sPhone = phone.getText();

        	        if (name.isEmpty() || ageText.isEmpty() || company.isEmpty() ||
        	            carname.isEmpty() || location.isEmpty()) {

        	            JOptionPane.showMessageDialog(null, "All fields are required");
        	            return;
        	        }
        	        
        	        data d = new data();
        	        String q = "INSERT INTO driver (name, age, gender, company, carname, available,Phone,location) values ('"+name+"','"+ageText+"','"+gender+"','"+company+"','"+carname+"','"+available+"','"+sPhone+"','"+location+"')";
        	        d.statement.executeUpdate(q);
        	        JOptionPane.showMessageDialog(null,"Driver details added");
        	        setVisible(false);
        	 }
        	 else {
        		 
        		 setVisible(false);
        	 }
        }catch(Exception E) {
        	E.printStackTrace();
        	
        }
    }

    public static void main(String[] args) {
        new Driver();
    }
}
