package jewellery_shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Admin extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	public Admin() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 15));
		lblNewLabel.setBounds(74, 33, 155, 40);
		add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 15));
		lblPassword.setBounds(74, 107, 155, 40);
		add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 15));
		textField.setBounds(292, 32, 238, 40);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 15));
		passwordField.setBounds(292, 109, 238, 40);
		add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(20, 109, 89));
		btnNewButton.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 15));
		btnNewButton.setBounds(133, 195, 140, 40);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection con;
				Statement st;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); 
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelleryshop","root","Root@123");
					st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from admin where user='"+textField.getText()+"'and password='"+passwordField.getText()+"'");
			if(rs.next()) {
				setVisible(false);
				new sales();
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Data");
			}
				
				}catch(Exception E) {
				E.printStackTrace();
			}
			}
		});
		
		add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(204, 0, 0));
		btnBack.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 15));
		btnBack.setBounds(343, 195, 140, 40);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new mainframe();
			}
		});
		add(btnBack);
	
		
		
		setTitle("Admin Login");
		setVisible(true);
		setSize(600,300);
		setLocation(500,300);
	}
	
	public static void main(String[] args) {
		new Admin();
	} 
}
