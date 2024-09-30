package jewellery_shop;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class mainframe extends JFrame {

	private String img111;

	public mainframe() {
		// font declaration
		Font f = new Font("serif", Font.BOLD, 45);
		// label for heading
		JLabel name = new JLabel("TRISHA JEWELLERS ");
		name.setForeground(Color.BLACK);
		name.setBounds(490, 20, 800, 50);
		name.setFont(f);
		


//side panel
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 250, 1500);

		getContentPane().add(p1);

		JPanel p = new JPanel();
		p.setBounds(400, 90, 700, 700);
		

//girdlayout
		GridLayout g = new GridLayout(3,5,20,20);
		p.setLayout(g);

	ImageIcon item1 = new ImageIcon("item11.jpeg");
	Image img1 = item1.getImage();
	Image temp_img1 = img1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	
	ImageIcon i = new ImageIcon("side0.jpeg");
	Image i1=i.getImage().getScaledInstance(250,600,Image.SCALE_SMOOTH);
	ImageIcon i11=new ImageIcon(i1);
	
	JLabel background1 = new JLabel(i11);
		JButton b1 = new JButton(item1);

		ImageIcon item2 = new ImageIcon("item12.jpeg");
		ImageIcon item3 = new ImageIcon("item13.jpeg");
		ImageIcon item4 = new ImageIcon("item14.jpeg");
		ImageIcon item5 = new ImageIcon("item15.jpeg");
		ImageIcon item6 = new ImageIcon("item16.jpeg");
		ImageIcon item7 = new ImageIcon("item17.jpeg");
		ImageIcon item8 = new ImageIcon("item18.jpeg");
		ImageIcon item9 = new ImageIcon("item19.jpeg");



//button
		JButton b2 = new JButton(item2);
		JButton b3 = new JButton(item3);
		JButton b4 = new JButton(item4);
		JButton b5 = new JButton(item5);
		JButton b6 = new JButton(item6);
		JButton b7 = new JButton(item7);
		JButton b8 = new JButton(item8);
		JButton b9 = new JButton(item9);
		JButton b10 = new JButton("logout");
		
		
		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		b10.setBounds(1200, 700, 100, 50);
		b10.setBackground(new Color(32,32,32));
		b10.setForeground(Color.WHITE);
		JLabel cn0 = new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ");
		JLabel cn1 = new JLabel("              CONTACT US             ");

		JLabel cn2 = new JLabel("email-trishajewellers@gmail.com     ");
		JLabel cn3 = new JLabel("Phone- 91+7018184545");
		JLabel cn4 = new JLabel("TRISHA JEWELLERS, Street No 101,");
		JLabel cn5 = new JLabel("Savedi,\n" + "Ahmednagar.");
		
		
		JButton b11=new JButton("Sales Records");
		b11.setBackground(new Color(32,32,32));
		b11.setForeground(Color.WHITE);
		b11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Admin();
			}
		});
		b11.setBounds(50, 750, 140,35);
		
		
		
		p1.add(background1);
		p1.add(cn0);
		p1.add(cn1);
		p1.add(cn2);
		p1.add(cn3);
		p1.add(cn4);
		p1.add(cn4);
	add(b11);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				new item1();
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				new item2();
			}
		});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				new item3();
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				new item4();
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				new item5();
			}
		});
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				new item6();
			}
		});
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				new item7();
				
			}
		});
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				new item8();
			}
		});
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				new item9();
			}
		});
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				new mainlog();
			}
		});

//background image
		ImageIcon background_image = new ImageIcon("mainframe.jpeg");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1500, 850, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);
		background.setBounds(0, 0, 1500, 850);
		getContentPane().add(background);
		background.add(p);

//logo
		ImageIcon logo_image = new ImageIcon("logo1.jpeg");
		Image img11 = logo_image.getImage();
		Image temp_img11 = img11.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
		logo_image = new ImageIcon(temp_img11);
		JLabel background11 = new JLabel("", logo_image, JLabel.CENTER);
		background11.setBounds(1330, 0, 170, 170);
		background.add(background11);
		background.add(b10);
		background.add(name);

		setSize(1500, 850);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new mainframe().setLocationRelativeTo(null);
	}
}