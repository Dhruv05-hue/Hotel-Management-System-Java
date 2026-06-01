package Management;

import java.awt.Choice;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateRoom extends JFrame {

	Choice cbId;
    JTextField  tfName, tfPaid, tfPending,tfCheckin;
    JButton update, back, check;
    JLabel nametext,tfRoom;
    String old = "";
     
	
	UpdateRoom(){
		

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 880, 520);
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel heading = new JLabel("Update Room Status");
        heading.setBounds(60, 20, 300, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        // ID
        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(60, 90, 150, 25);
        lblId.setFont(new Font("Tahoma",Font.BOLD,14));
        lblId.setForeground(Color.WHITE);
        panel.add(lblId);

        cbId = new Choice();
        cbId.setBounds(230, 90, 200, 25);
        panel.add(cbId);
        
        try {
        	data d = new data();
        	ResultSet rs = d.statement.executeQuery("select * from customer");
        	while(rs.next()) {
        		
        		cbId.add(rs.getString("number"));
        	}
        }catch(Exception e) {
        	
        	e.printStackTrace();
        	
        }

        // Room Number
        JLabel lblRoom = new JLabel("Room Number :");
        lblRoom.setBounds(60, 130, 150, 25);
        lblRoom.setForeground(Color.WHITE);
        lblRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblRoom);

        tfRoom = new JLabel();
        tfRoom.setBounds(230, 130, 200, 25);
        tfRoom.setForeground(Color.white);
        tfRoom.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(tfRoom);

        // Name
        JLabel lblName = new JLabel("Check in Time :");
        lblName.setBounds(60, 170, 150, 25);
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblName);

        nametext = new JLabel();
        nametext.setBounds(230, 170, 200, 25);
        nametext.setFont(new Font("Tahoma",Font.BOLD,15));
        nametext.setForeground(Color.white);
        panel.add(nametext);

        // Checked-in
        JLabel lblCheckin = new JLabel("Cleaning Status :");
        lblCheckin.setBounds(60, 210, 150, 25);
        lblCheckin.setForeground(Color.WHITE);
        lblCheckin.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblCheckin);

        tfCheckin = new JTextField();
        tfCheckin.setBounds(230, 210, 200, 25);
        tfCheckin.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(tfCheckin);

        // Buttons

        back = new JButton("Back");
        back.setBounds(200, 360, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				setVisible(false);
			}
        	
        	
        });
        panel.add(back);

        check = new JButton("Check");
        check.setBounds(320, 360, 100, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					
					data d = new data();
					String q = "select * from customer where number = '"+cbId.getSelectedItem()+"'";
					ResultSet rs = d.statement.executeQuery(q);
					while(rs.next()) {

						tfRoom.setText(rs.getString("room_number"));
						nametext.setText(rs.getString("checkin_time"));
					}
					
					ResultSet rs2 = d.statement.executeQuery("select * from room where room_number ='"+tfRoom.getText()+"'");
				    while(rs2.next()) {
				    	
				    	tfCheckin.setText(rs2.getString("cleaning_status"));
				    	old = tfCheckin.getText();
				    }
				}catch(Exception F) {
					
					F.printStackTrace();
					
				}
			}
        	
        	
        });
        panel.add(check);
        
        
        update = new JButton("Update");
        update.setBounds(80, 360, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					
					data d = new data();
					String q = "update room set cleaning_status = '"+tfCheckin.getText()+"' where room_number ='"+tfRoom.getText()+"'";
					d.statement.executeUpdate(q);
					if (tfCheckin.getText().equals(old)) {
					JOptionPane.showMessageDialog(null,"No Update");
					}
					else {
						JOptionPane.showMessageDialog(null,"Updated");
					}
				}catch(Exception E) {

					E.printStackTrace();
					
			}
			}
        	
        });
        panel.add(update);
        
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Images/update.png"));
        Image im = ic.getImage().getScaledInstance(260, 220, Image.SCALE_SMOOTH);
        JLabel l = new JLabel(new ImageIcon(im));
        l.setBounds(550, 100, 260, 220);
        panel.add(l);
        
        setLayout(null);
        setLocation(450, 150);
        setSize(900, 550);
        setVisible(true);
	}
	
	
	


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new UpdateRoom();
	}

}
