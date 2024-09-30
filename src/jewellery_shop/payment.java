package jewellery_shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class payment extends JFrame {
	
		 Connection con;
String n;
	payment(String n) {
		this.n=n;
		// font decleration
		Font f = new Font("serif", Font.BOLD, 50);
		Font fl = new Font("serif", Font.BOLD, 30);
		Font ft = new Font("serif", Font.BOLD, 20);

		// label for heading
		JLabel name = new JLabel("PAYMENT PAGE");
		name.setForeground(Color.WHITE);
		name.setBounds(200, 50, 600, 50);
		name.setFont(f);
		String s1[] = { "--None--", "Card", "UPI", "Net Banking" };
		final JComboBox cb = new JComboBox(s1);

		// labels
		JLabel l1 = new JLabel("USERNAME:");
		l1.setBounds(80, -150, 500, 500);
		l1.setFont(ft);
		l1.setForeground(Color.WHITE);

		JLabel l2 = new JLabel("ADDRESS:");
		l2.setBounds(80, -55, 500, 500);
		l2.setFont(ft);
		l2.setForeground(Color.WHITE);

		JLabel l3 = new JLabel("MOBILE NO:");
		l3.setBounds(80, 28, 500, 500);
		l3.setFont(ft);
		l3.setForeground(Color.WHITE);

		JLabel l4 = new JLabel("Payment way:");
		l4.setBounds(80, 90, 500, 500);
		l4.setFont(ft);
		l4.setForeground(Color.WHITE);

		JLabel l5 = new JLabel("Toatl Amount:");
		l5.setBounds(80, 160, 500, 500);		
		l5.setFont(ft);
		l5.setForeground(Color.WHITE);

		JLabel l6 = new JLabel(""+n);
		l6.setBounds(250, 160, 500, 500);
		l6.setFont(ft);
		l6.setForeground(Color.WHITE);

		// textfield
		final JTextField t1 = new JTextField(5);
		t1.setBounds(250, 85, 250, 30);
		t1.setFont(ft);

		final JTextArea p1 = new JTextArea();
		p1.setBounds(250, 160, 250, 50);
		p1.setFont(ft);

		final JTextField t2 = new JTextField(10);
		t2.setBounds(250, 260, 250, 30);
		t2.setFont(ft);

		JTextField t3 = new JTextField(10);
		cb.setBounds(250, 325, 125, 30);
		cb.setFont(new Font("serif", Font.BOLD, 15));
		
		// buttons
		JButton b1 = new JButton("PAY");
		b1.setBounds(320, 490, 100, 30);
		b1.setFont(ft);
		b1.setBackground(new Color(32,32,32));
		b1.setForeground(Color.WHITE);
		
		JButton b2 = new JButton("BACK");
		b2.setBounds(450, 490, 100, 30);
		b2.setFont(ft);
		b2.setBackground(new Color(32,32,32));
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.RED);
	
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new mainframe();
			}
		});

		// login panel
		JPanel login = new JPanel();
		login.setLayout(null);
		login.setSize(700, 350);
		login.setBackground(new Color(0, 0, 0, 20));
		login.setBounds(50, 175, 850, 550);
		add(login);

		login.add(l1);
		login.add(l2);
		login.add(l3);
		login.add(l4);
		login.add(l5);
		login.add(l6);
		login.add(t1);
		login.add(t2);
		login.add(cb);
		login.add(p1);
		login.add(b1);
		login.add(b2);

		// background image
		ImageIcon background_image = new ImageIcon("paymentexa.jpeg");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1400, 850, Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);

		background.setBounds(0, 0, 1400, 850);
		add(background);
		background.add(name);
		// logo
		ImageIcon background_image1 = new ImageIcon("logo1.jpeg");
		Image img1 = background_image1.getImage();
		Image temp_img1 = img1.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
		background_image1 = new ImageIcon(temp_img1);
		JLabel background1 = new JLabel("", background_image1, JLabel.CENTER);
		background1.setBounds(875, 0, 125, 100);
		background.add(background1);
		// main frame
		setSize(1000, 850);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){

				String username = t1.getText();
				String address = p1.getText();
				long mobno =Long.parseLong(t2.getText());
				String payment = (String) cb.getSelectedItem();

				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); 
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelleryshop","root","Root@123");  
					if (con == null) {
						System.out.println("connection failed");
					} else {
						System.out.println("Database connected.....");

						PreparedStatement pst = (PreparedStatement) con.prepareStatement(
								"insert into payment(username,address,mobileno,paymentway,amount) values(?,?,?,?,?)");

						pst.setString(1, username);

						pst.setString(2, address);
						pst.setLong(3, mobno);
						pst.setString(4, payment);
						pst.setString(5,l6.getText());
						pst.executeUpdate();
						t1.setText("");
						p1.setText("");
						t2.setText("");
						JFrame f = new JFrame();
						JOptionPane.showMessageDialog(f, "Payment Done");

						System.out.println("Data added sucessfully");

						con.close();
					}
				} catch (Exception e) {
					System.out.println(e);
				}

			}
		});

	}

	public static void main(String args[]) {
		new payment("");
	}
}
