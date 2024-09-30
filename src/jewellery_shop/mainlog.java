package jewellery_shop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.Statement;

public class mainlog extends JFrame {
	// update
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String q = null;

	mainlog() {
		// font declaration
		Font f = new Font("serif", Font.BOLD, 50);
		Font fl = new Font("serif", Font.BOLD, 30);
		Font ft = new Font("serif", Font.BOLD, 20);

		// label for heading
		JLabel name = new JLabel("LOGIN PAGE");
		name.setForeground(Color.DARK_GRAY);
		name.setBounds(525, 75, 400, 50);
		name.setFont(f);

		// labels
		JLabel l1 = new JLabel("USERNAME:");
		l1.setBounds(80, -150, 500, 500);
		l1.setFont(fl);

		JLabel l2 = new JLabel("PASSWORD:");
		l2.setBounds(80, -55, 500, 500);
		l2.setFont(fl);

		JLabel l4 = new JLabel();
		l4.setBounds(320, 350, 250, 50);
		l4.setFont(ft);

		// textfield
		final JTextField t1 = new JTextField();
		t1.setBounds(320, 80, 250, 50);
		t1.setFont(ft);

		final JPasswordField p1 = new JPasswordField();
		p1.setBounds(320, 170, 250, 50);
		p1.setFont(ft);

		// buttons
		JButton b1 = new JButton("Login");
		b1.setBounds(380, 300, 150, 50);
		b1.setFont(ft);
		b1.setBackground(new Color(96, 96, 96));
		b1.setForeground(Color.WHITE);

		JButton b2 = new JButton("sign-up");
		b2.setBounds(100, 300, 150, 50);
		b2.setFont(ft);
		b2.setBackground(new Color(96, 96, 96));
		b2.setForeground(Color.WHITE);

		JButton b3 = new JButton("clear");
		b3.setBounds(250, 400, 150, 50);
		b3.setFont(ft);
		b3.setBackground(new Color(0, 153, 153));
		b3.setForeground(Color.WHITE);

		// sign-up frame
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				signup s = new signup();
				s.setVisible(true);

			}
		});
		// clear
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				t1.setText("");
				p1.setText("");

			}
		});

		// login panel
		JPanel login = new JPanel();
		login.setLayout(null);
		login.setSize(700, 350);
		login.setBackground(new Color(0, 0, 0, 20));
		login.setBounds(370, 175, 650, 550);
		add(login);
		login.add(l1);
		login.add(l2);
		login.add(t1);
		login.add(p1);
		login.add(b1);
		login.add(b2);
		login.add(b3);
		login.add(l4);

		// background image
		ImageIcon background_image = new ImageIcon("loginpageimage.jpeg");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1500, 850, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);

		background.setBounds(0, 0, 1500, 850);
		add(background);
		background.add(name);
		// logo
		ImageIcon background_image1 = new ImageIcon("logo1.jpeg");
		Image img1 = background_image1.getImage();
		Image temp_img1 = img1.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
		background_image1 = new ImageIcon(temp_img1);
		JLabel background1 = new JLabel("", background_image1, JLabel.CENTER);
		background1.setBounds(1275, 0, 125, 120);
		background.add(background1);

		// main frame
		setSize(1400, 850);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// action on login
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String username = t1.getText();
				String password = p1.getText();

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelleryshop", "root", "Root@123");
					if (con == null) {
						System.out.println("connection failed");
					} else {
						System.out.println("Database connected.....");

						PreparedStatement pst = (PreparedStatement) con
								.prepareStatement("select *from signup1 where username=? and password=?");

						pst.setString(1, username);
						pst.setString(2, password);
						rs = pst.executeQuery();

						if (rs.next()) {
							// open new frame
//							dispose();
						setVisible(false);
						new mainframe();

						}

						else {
							JFrame f = new JFrame();
							JOptionPane.showMessageDialog(f, "Invalid Username or Password ");

						}
						con.close();
					}
				} catch (Exception e) {
					System.out.println(e);
				}

			}

		});
	}

	public static void main(String args[]) {
		mainlog ml = new mainlog();
	}
}
