package Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Admin extends JFrame implements ActionListener {
	
	JButton add_Emp,add_Room,add_Driver,Reports,logout,back;
	
	Admin(){
		
	   add_Emp = new JButton("Add Employee");	
	   add_Emp.setBounds(290,130,200,30);
	   add_Emp.setBackground(Color.WHITE);
	   add_Emp.setForeground(Color.BLACK);
	   add_Emp.setFont(new Font("Tahoma",Font.BOLD,15));
	   add_Emp.addActionListener(this);
	   add(add_Emp);
	   
	   add_Room = new JButton("Add Room");	
	   add_Room.setBounds(290,290,200,30);
	   add_Room.setBackground(Color.WHITE);
	   add_Room.setForeground(Color.BLACK);
	   add_Room.setFont(new Font("Tahoma",Font.BOLD,15));
	   add_Room.addActionListener(this);
	   add(add_Room);
		
	   
	   add_Driver = new JButton("Add Driver");	
	   add_Driver.setBounds(290,450,200,30);
	   add_Driver.setBackground(Color.WHITE);
	   add_Driver.setForeground(Color.BLACK);
	   add_Driver.setFont(new Font("Tahoma",Font.BOLD,15));
	   add_Driver.addActionListener(this);
	   add(add_Driver);
	   
	   
	   Reports = new JButton("Reports");	
	   Reports.setBounds(290,620,200,30);
	   Reports.setBackground(Color.WHITE);
	   Reports.setForeground(Color.BLACK);
	   Reports.setFont(new Font("Tahoma",Font.BOLD,15));
	   Reports.addActionListener(this);
	   add(Reports );
	   
	   
	   
	   logout = new JButton("Log Out");	
	   logout.setBounds(1140,725,95,30);
	   logout.setBackground(Color.BLACK);
	   logout.setForeground(Color.WHITE);
	   logout.setFont(new Font("Tahoma",Font.BOLD,15));
	   logout.addActionListener(this);
	   add(logout);
	   
	   back = new JButton("Back");	
	   back.setBounds(1280,725,95,30);
	   back.setBackground(Color.BLACK);
	   back.setForeground(Color.WHITE);
	   back.setFont(new Font("Tahoma",Font.BOLD,15));
	   back.addActionListener(this);
	   add(back);
	   
	   ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("Images/employee.jpg"));
	   Image l11 = l1.getImage().getScaledInstance(200, 120, Image.SCALE_DEFAULT);
	   ImageIcon imageicon=new ImageIcon(l11);
	   JLabel label = new JLabel(imageicon);
	   label.setBounds(70,80,200,120);
	   add(label);
	   
	   ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("Images/room_admin.jpg"));
	   Image image = imageIcon1.getImage().getScaledInstance(200, 120, Image.SCALE_DEFAULT);
	   ImageIcon imageicon11=new ImageIcon(image);
	   JLabel label1 = new JLabel(imageicon11);
	   label1.setBounds(70,245,200,120);
	   add(label1);
		
	   ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("Images/Driver_admin.jpg"));
	   Image image1 = imageIcon2.getImage().getScaledInstance(200, 120, Image.SCALE_DEFAULT);
	   ImageIcon imageicon12=new ImageIcon(image1);
	   JLabel label2 = new JLabel(imageicon12);
	   label2.setBounds(70,420,200,120);
	   add(label2);
	   
	   ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("Images/icon3.png"));
	   Image image2 = imageIcon3.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
	   ImageIcon imageicon13=new ImageIcon(image2);
	   JLabel label3 = new JLabel(imageicon13);
	   label3.setBounds(900,70,600,600);
	   add(label3);
	   
	   ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("Images/Report.jpg"));
	   Image image4 = imageIcon4.getImage().getScaledInstance(200, 120, Image.SCALE_DEFAULT);
	   ImageIcon imageicon14=new ImageIcon(image4);
	   JLabel label4 = new JLabel(imageicon14);
	   label4.setBounds(70,580,200,120);
	   add(label4);
	   
	   
	   
	   	getContentPane().setBackground(new Color(3,45,48));
		setLayout(null);
		setSize(1950,1090);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==add_Emp) {
			new AddEmployee();
		}
		else if(e.getSource()==add_Room) {
			new Add_room();
		}
		else if(e.getSource()==add_Driver) {
			new Driver();
		}
		else if(e.getSource()==Reports) {
			new Hotel_Report();
		}
		else if(e.getSource()==logout) {
			System.exit(400);
		}
		else if(e.getSource()==back) {
			new Dashboard();
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Admin();
	}

}