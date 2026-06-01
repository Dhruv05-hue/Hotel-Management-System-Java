package Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Dashboard extends JFrame implements ActionListener{
    
	JButton add,rec;
	Dashboard(){
		super("Hotel Management System");
		
		rec = new JButton("RECEPTION");
		rec.setBounds(425,510,140,30);
		rec.setFont(new Font("Tahoma",Font.BOLD,15));
		rec.setBackground(new Color(255,98,0));
		rec.setForeground(Color.white);
		rec.addActionListener(this);
		add(rec);
		
		add = new JButton("ADMIN");
		add.setBounds(925,510,140,30);
		add.setFont(new Font("Tahoma",Font.BOLD,15));
		add.setBackground(new Color(255,98,0));
		add.setForeground(Color.white);
		add.addActionListener(this);
		add(add);
		
		ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("Images/final_admin.png"));
		Image i11 = im1.getImage().getScaledInstance(250,200, Image.SCALE_DEFAULT);
		ImageIcon i33 = new ImageIcon(i11);
		JLabel label1 = new JLabel(i33);
		label1.setBounds(870,300,250,200);
		add(label1);
		
		
		ImageIcon im12 = new ImageIcon(ClassLoader.getSystemResource("Images/reception_f.jpg"));
		Image i112 = im12.getImage().getScaledInstance(250,200, Image.SCALE_DEFAULT);
		ImageIcon i332 = new ImageIcon(i112);
		JLabel label12 = new JLabel(i332);
		label12.setBounds(385,300,250,200);
		add(label12);
		
		
		ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("Images/Dashboard.gif"));
		Image i1 = im.getImage().getScaledInstance(1950,1090, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i1);
		JLabel label = new JLabel(i3);
		label.setBounds(0,0,1950,1090);
		add(label);
		

		
		setLayout(null);
		setSize(1950,1090);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		    if(e.getSource() == rec) {
		    	
		    	new Reception();
		    	setVisible(false);
		    	
		    }
		    else {
		    	
		    	new Login2();
		    	setVisible(false);
		    }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
              new Dashboard();
	}
	

}
