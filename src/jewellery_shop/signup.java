package jewellery_shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.io.*;

public class signup extends JFrame {

	// update
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String q = null;

	signup() {

		// font
		Font f = new Font("serif", Font.BOLD, 50);
		Font fp = new Font("serif", Font.BOLD, 17);
		
		// heading
		JPanel hd = new JPanel();
		hd.setLayout(null);
		hd.setBackground(new Color(0, 0, 0, 0));
		hd.setBounds(0, 0, 1500, 100);
		
		JLabel name = new JLabel("SIGN-UP");
		name.setBounds(600, 100, 500, 100);
		name.setFont(f);

		
		
		
		JLabel na = new JLabel("WELCOME!");
		na.setBounds(560, 660, 900, 100);
		na.setFont(f);
		add(na);
		

		// image1
		ImageIcon background_image = new ImageIcon("signupimage.jpeg");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1500, 850, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);
		background.setBounds(0, 0, 1500, 850);
		add(background);
		background.add(name);
		
//		logo
		ImageIcon background_image1=new ImageIcon("logo1.jpeg");
		Image img1=background_image1.getImage();
		Image temp_img1=img1.getScaledInstance(170,170,Image.SCALE_SMOOTH);
		background_image1=new ImageIcon(temp_img1);
		JLabel background1=new JLabel("",background_image1,JLabel.CENTER);
		background1.setBounds(1375,0,125,120);
		background.add(background1);

		// labels
		// l1
		JLabel l1 = new JLabel("First Name:");
		l1.setBounds(500, 220, 300, 50);
		l1.setFont(fp);
		background.add(l1);

		
		// l2
		JLabel l2 = new JLabel("Last Name:");
		l2.setBounds(500, 260, 300, 50);
		l2.setFont(fp);
		background.add(l2);
		
		
		// l3
		JLabel l3 = new JLabel("Username:");
		l3.setBounds(500, 295, 250, 60);
		l3.setFont(fp);
		background.add(l3);
		

		// l4
		JLabel l4 = new JLabel("Password:");
		l4.setBounds(500, 340, 100, 50);
		l4.setFont(fp);
		background.add(l4);
		

		// l5
		JLabel l5 = new JLabel("email_id:");
		l5.setBounds(500, 380, 100, 50);
		l5.setFont(fp);
		background.add(l5);
	

		// l6
		JLabel l6 = new JLabel("mobile no:");
		l6.setBounds(500, 420, 200, 50);
		l6.setFont(fp);
		background.add(l6);
		

		// l7
		JLabel l7 = new JLabel("gender:");
		l7.setBounds(510, 460, 100, 50);
		l7.setFont(fp);
		background.add(l7);
	

		// l8
		JLabel l8 = new JLabel("address:");
		l8.setBounds(500, 500, 100, 50);
		l8.setFont(fp);
		background.add(l8);
		

		// l9
		JLabel l15 = new JLabel("I Already have an Account!.. ");
		l15.setBounds(950, 620, 300, 50);
		l15.setFont(fp);
		background.add(l15);
		
		
		// textfieldusername
		
		// t1 firs_tname
		final JTextField t1 = new JTextField(20);
		t1.setBounds(620, 230, 250, 30);
		background.add(t1);
		
		// t2 last_name
		JTextField t2 = new JTextField(20);
		t2.setBounds(620, 270, 250, 30);
		background.add(t2);
				
		// t3 user_name
		final JTextField t3 = new JTextField(20);
		t3.setBounds(620, 310, 250, 30);
		background.add(t3);

		// t4 password
		final JPasswordField t4 = new JPasswordField(20);
		t4.setBounds(620, 350, 250, 30);
		background.add(t4);

		// t5 email
		final JTextField t5 = new JTextField(20);
		t5.setBounds(620, 390, 250, 30);
		background.add(t5);

		// t6 mobile
		final JTextField t6 = new JTextField(20);
		t6.setBounds(620, 430, 250, 30);
		background.add(t6);
	
		String s1[] = { "--None--", "Male", "Female", "Other" };
		final JComboBox cb = new JComboBox(s1);
		cb.setBounds(620, 473, 100, 25);
		background.add(cb);

		// t7
		final JTextArea t7 = new JTextArea();
		t7.setBounds(620, 510, 250, 100);
		background.add(t7);

		// buttons
		// b1
		JButton b1 = new JButton("Submit");
		b1.setBounds(690, 625, 100, 30);
		background.add(b1);
		b1.setBackground(new Color(55, 51, 51));
		b1.setForeground(Color.WHITE);

		// update
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				String first_name = t1.getText();
				String last_name = t2.getText();
				String username = t3.getText();
				String password = t4.getText();
				String email = t5.getText();
				
				String gender = (String) cb.getSelectedItem();
				String address = t7.getText();
				long mobno=0;
				boolean r1=true,r2=true,r3=true;
				if(t6.getText().length()==10) {
				try {
					 mobno = Long.parseLong(t6.getText());
				}catch(Exception e) {
					r3=false;
					
				}
				
				int cnt=0;
for(int i=0;i<first_name.length();i++) {
	if(first_name.charAt(i)>=48 && first_name.charAt(i)<=57) {
		cnt++;
	}
}
if(cnt!=0) {
	r1=false;
	
}
cnt=0;
for(int i=0;i<last_name.length();i++) {
	if(last_name.charAt(i)>=48 && last_name.charAt(i)<=57) {
		cnt++;
	}


}
if(cnt!=0) {
	r2=false;
}	
if(r1 ) {
	if(r2) {
			if(r3) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); 
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelleryshop","root","Root@123");  
					if (con == null) {
						System.out.println("connection failed");
					} else {
						System.out.println("Database connected.....");

						PreparedStatement pst = (PreparedStatement) con.prepareStatement(
								"insert into signup1(first_name,last_name,username,password,email_id,mobile_no,gender,address) values(?,?,?,?,?,?,?,?)");
						
						pst.setString(1, first_name);
						pst.setString(2, last_name);
						pst.setString(3, username);
						pst.setString(4, password);
						pst.setString(5, email);
						pst.setLong(6, mobno);
						pst.setString(7, gender);
						pst.setString(8, address);
						pst.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Data Added Successfully");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");


						con.close();
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Please Check Your Phone Number");
				t6.setText("");
			}
	}else {
		JOptionPane.showMessageDialog(null, "You can't enter number in Last name");
		t2.setText("");
	}
}else {
	JOptionPane.showMessageDialog(null, "You can't enter number in First name");
	t1.setText("");
}
				}else {
					JOptionPane.showMessageDialog(null, "Phone number should be 10 digit");
				}
			}
		});

		// b2
		JButton b2 = new JButton("sign-in");
		b2.setBounds(1250, 630, 100, 30);
		background.add(b2);
		b2.setBackground(new Color(55, 51, 51));
		b2.setForeground(Color.WHITE);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				mainlog s = new mainlog();
				s.setVisible(true);
			}
		});
		// frame
		setSize(1500, 850);
		setLayout(null);
		setVisible(true);
	}

	public static void main(String args[]) {
		new signup();
	}
}
