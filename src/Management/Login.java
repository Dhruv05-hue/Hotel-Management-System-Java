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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

		JTextField tx1;
	    JPasswordField tx2;
	    JButton login,b2;
	    
	 Login(){
		 
		 JLabel l1 = new JLabel("Username :");
		 l1.setBounds(40,20,100,30);
		 l1.setFont(new Font("Tahoma",Font.BOLD,16));
		 l1.setForeground(Color.WHITE);
		 add(l1);
		 
		 tx1 = new JTextField();
		 tx1.setBounds(150,20,150,30);
		 tx1.setForeground(Color.white);
		 tx1.setFont(new Font("Tahoma",Font.PLAIN,15));
		 tx1.setBackground(new Color(26,104,110));
		 add(tx1);
		 
		 JLabel l2 = new JLabel("Password :");
		 l2.setBounds(40,70,100,30);
		 l2.setFont(new Font("Tahoma",Font.BOLD,16));
		 l2.setForeground(Color.WHITE);
		 add(l2);
		 
		 tx2 = new JPasswordField();
		 tx2.setBounds(150,70,150,30);
		 tx2.setForeground(Color.white);
		 tx2.setBackground(new Color(26,104,110));
		 add(tx2);
		 
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/icon3.png"));
		 Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		 ImageIcon i111 = new ImageIcon(i2);
		 JLabel im = new JLabel(i111);
		 im.setBounds(350,-40,300,300);
		 add(im);
		 
		 login = new JButton("Login");
		 login.setBounds(40,180,120,30);
		 login.setFont(new Font("serif",Font.BOLD,15));
		 login.setForeground(Color.white);
		 login.setBackground(Color.black);
		 login.addActionListener(this);
		 add(login);
		 
		 b2 = new JButton("Cancel");
		 b2.setBounds(190,180,120,30);
		 b2.setFont(new Font("serif",Font.BOLD,15));
		 b2.setForeground(Color.white);
		 b2.setBackground(Color.black);
		 b2.addActionListener(this);
		 add(b2);
		 
		 
		 
		 
		 
		 getContentPane().setBackground(new Color(3,45,48));
		 setLayout(null);
		 setLocation(400,270);
		 setSize(650,300);
		 setVisible(true);
	 }
	
	 
	 	@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == login) {
				
				try {
					data d = new data();
					String user = tx1.getText();
					String password = tx2.getText();
					String q = "select * from login where username = '"+user+"' and password = '"+password+"'";
					ResultSet rs = d.statement.executeQuery(q);
					if(rs.next()) {
						new Dashboard();
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Invalid");
					}
					
				}catch(Exception s) {
						
					s.printStackTrace();
				}
			}
			else {
				
				 System.exit(0);
			}
		}
	 
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Login();
	}


	

}
