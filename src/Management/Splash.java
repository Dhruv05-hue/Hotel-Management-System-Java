package Management;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame {
	
	Splash(){

		
		java.net.URL location = Splash.class.getResource("/Images/perfect_4_splash.gif");

		if (location == null) {
		    System.out.println("ERROR: Image not found inside JAR!");
		} else {
		    ImageIcon im1 = new ImageIcon(location);
		    Image i11 = im1.getImage().getScaledInstance(1088, 680, Image.SCALE_DEFAULT);
		    ImageIcon i33 = new ImageIcon(i11);
		    JLabel label1 = new JLabel(i33);
		    label1.setBounds(-370, 0, 1488, 680);
		    add(label1);
		}
		
		
		setLayout(null);
		setLocation(450,80);
		setSize(790,680);
		setVisible(true);
		
		try {
			
			Thread.sleep(5000);
			new Login();
			setVisible(false);
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             new Splash();
	}

	

}
