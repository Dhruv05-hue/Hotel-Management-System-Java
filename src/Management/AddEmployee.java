package Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener {

	JTextField name,age,job,salary,phone,aadhar,email;
	JRadioButton m,f;
	JComboBox cb;
	JButton back,add;
	
	AddEmployee(){
		
		JPanel panel = new JPanel();
		panel.setBounds(-5,5,890,490);
		panel.setLayout(null);
		panel.setBackground(new Color(3,45,48));
		add(panel);
		
		JLabel n = new JLabel("Name :");
		n.setBounds(60,30,150,27);
		n.setFont(new Font("serif",Font.BOLD,17));
		n.setForeground(Color.white);
		panel.add(n);
		
		name = new JTextField();
		name.setBounds(200,30,150,27);
		name.setBackground(new Color(16,108,115));
		name.setFont(new Font("Tahoma",Font.BOLD,14));
		name.setForeground(Color.white);
		panel.add(name);
		
		JLabel a = new JLabel("Age :");
		a.setBounds(60,80,150,27);
		a.setFont(new Font("serif",Font.BOLD,17));
		a.setForeground(Color.white);
		panel.add(a);
		
		age = new JTextField();
		age.setBounds(200,80,150,27);
		age.setBackground(new Color(16,108,115));
		age.setFont(new Font("Tahoma",Font.BOLD,14));
		age.setForeground(Color.white);
		panel.add(age);
		
		JLabel g = new JLabel("Gender :");
		g.setBounds(60,120,150,27);
		g.setFont(new Font("serif",Font.BOLD,17));
		g.setForeground(Color.white);
		panel.add(g);
		
		m = new JRadioButton("Male");
		m.setBounds(200,120,70,27);
		m.setBackground(new Color(3,45,48));
		m.setFont(new Font("Tahoma",Font.BOLD,14));
		m.setForeground(Color.white);
		panel.add(m);
		
		f = new JRadioButton("Female");
		f.setBounds(300,120,100,27);
		f.setBackground(new Color(3,45,48));
		f.setFont(new Font("Tahoma",Font.BOLD,14));
		f.setForeground(Color.white);
		panel.add(f);
		
		JLabel j = new JLabel("Job :");
		j.setBounds(60,170,150,27);
		j.setFont(new Font("serif",Font.BOLD,17));
		j.setForeground(Color.white);
		panel.add(j);
		
		cb = new JComboBox(new String [] {"Front Desk","Housekeeping","Kitchen Staff","Room Service","Manager","Accountant"});
		cb.setBounds(200,170,150,27);
		cb.setBackground(new Color(16,108,115));
		cb.setFont(new Font("Tahoma",Font.BOLD,14));
		cb.setForeground(Color.white);
		panel.add(cb);
		
		JLabel s = new JLabel("Salary :");
		s.setBounds(60,220,150,27);
		s.setFont(new Font("serif",Font.BOLD,17));
		s.setForeground(Color.white);
		panel.add(s);
		
		salary = new JTextField();
		salary.setBounds(200,220,150,27);
		salary.setBackground(new Color(16,108,115));
		salary.setFont(new Font("Tahoma",Font.BOLD,14));
		salary.setForeground(Color.white);
		panel.add(salary);
		
		JLabel p = new JLabel("Phone :");
		p.setBounds(60,270,150,27);
		p.setFont(new Font("serif",Font.BOLD,17));
		p.setForeground(Color.white);
		panel.add(p);
		
		phone = new JTextField();
		phone.setBounds(200,270,150,27);
		phone.setBackground(new Color(16,108,115));
		phone.setFont(new Font("Tahoma",Font.BOLD,14));
		phone.setForeground(Color.white);
		panel.add(phone);
		
		JLabel aa = new JLabel("Aadhar :");
		aa.setBounds(60,320,150,27);
		aa.setFont(new Font("serif",Font.BOLD,17));
		aa.setForeground(Color.white);
		panel.add(aa);
		
		aadhar = new JTextField();
		aadhar.setBounds(200,320,150,27);
		aadhar.setBackground(new Color(16,108,115));
		aadhar.setFont(new Font("Tahoma",Font.BOLD,14));
		aadhar.setForeground(Color.white);
		panel.add(aadhar);
		
		JLabel e = new JLabel("Email :");
		e.setBounds(60,370,150,27);
		e.setFont(new Font("serif",Font.BOLD,17));
		e.setForeground(Color.white);
		panel.add(e);
		
		email = new JTextField();
		email.setBounds(200,370,150,27);
		email.setBackground(new Color(16,108,115));
		email.setFont(new Font("Tahoma",Font.BOLD,14));
		email.setForeground(Color.white);
		panel.add(email);
		
		JLabel h = new JLabel("ADD EMPLOYEE DETAILS ");
		h.setBounds(450,24,445,39);
		h.setFont(new Font("serif",Font.BOLD,31));
		h.setForeground(Color.white);
		panel.add(h);
		
		add = new JButton("Add");
		add.setBounds(80,420,100,30);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.addActionListener(this);
		panel.add(add);
		
		back = new JButton("Back");
		back.setBounds(200,420,100,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		panel.add(back);
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Images/addemp.png"));
		Image i2 = i.getImage().getScaledInstance(300, 300, Image.SCALE_AREA_AVERAGING);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l2 = new JLabel(i3);
		l2.setBounds(500,100,300,300);
		panel.add(l2);
		
		
		setLayout(null);
        setSize(900, 500);
        setLocation(580, 130);
        setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		 if (e.getSource() == back) {
			setVisible(false);
			return;
		}

		
		
		if (name.getText().trim().isEmpty() &&
			    age.getText().trim().isEmpty() &&
			    salary.getText().trim().isEmpty() &&
			    phone.getText().trim().isEmpty() &&
			    aadhar.getText().trim().isEmpty() &&
			    email.getText().trim().isEmpty() &&
			    !m.isSelected() &&
			    !f.isSelected()) {

			    JOptionPane.showMessageDialog(
			        null,
			        "Please fill all the fields",
			        "Validation Error",
			        JOptionPane.WARNING_MESSAGE
			    );
			    return;
			}
		
		 if (name.getText().trim().isEmpty()) {
             JOptionPane.showMessageDialog(null, "Name is required");
             return;
         }

         
         if (!age.getText().matches("\\d+") || Integer.parseInt(age.getText()) < 18) {
             JOptionPane.showMessageDialog(null, "Age must be numeric and >= 18");
             return;
         }

         
         if (!m.isSelected() && !f.isSelected()) {
             JOptionPane.showMessageDialog(null, "Please select gender");
             return;
         }

         
         if (!salary.getText().matches("\\d+") || Integer.parseInt(salary.getText()) <= 0) {
             JOptionPane.showMessageDialog(null, "Invalid salary");
             return;
         }

       
         if (!phone.getText().matches("\\d{10}")) {
             JOptionPane.showMessageDialog(null, "Phone must be exactly 10 digits");
             return;
         }

        
         if (!aadhar.getText().matches("\\d{12}")) {
             JOptionPane.showMessageDialog(null, "Aadhar must be exactly 12 digits");
             return;
         }

         
         if (!email.getText().trim()
        	        .matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

        	    JOptionPane.showMessageDialog(null, "Please enter a valid email address");
        	    email.requestFocus();
        	    return;
        	}

		if(e.getSource() == add) {
			try {
			String sname = name.getText();
			String sage = age.getText();
			String sgender = "";
			String sphone = phone.getText();
			String semail = email.getText();
			String sAdhar = aadhar.getText();
			String ssalary = salary.getText();
			String sjob = (String)cb.getSelectedItem();
			if(m.isSelected()) {
				
				sgender = "Male";
			}
			else if(f.isSelected()) {
				
				sgender = "Female";
			}
			else {
				JOptionPane.showMessageDialog(null,"Please select gender");
				return;
			}
			
		  data d = new data();
		  
		  String query =
				    "INSERT INTO employee (name, age, gender, job, salary, phone, email, aadhar) " +
				    "VALUES ('" + sname + "', " + sage + ", '" + sgender + "', '" + sjob + "', " +
				            ssalary + ", '" + sphone + "', '" + semail + "', '" + sAdhar + "')";
		  
		  d.statement.executeUpdate(query);
		  
		  JOptionPane.showMessageDialog(null, "Employee Details are added");
		  setVisible(false);
		  
			}catch(Exception E) {
				
				E.printStackTrace();
			}
		}
			}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new AddEmployee();
	}

	

}
