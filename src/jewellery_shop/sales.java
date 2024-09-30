package jewellery_shop;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class sales extends JFrame{
public sales() {
	setLayout(null);
	Connection con;
	Statement st;
	JTable t=new JTable();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelleryshop","root","Root@123");
		st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from payment");
		
		t.setModel(DbUtils.resultSetToTableModel(rs));
		
	}catch(Exception E) {
		E.printStackTrace();
	}
	JScrollPane jp=new JScrollPane(t);
	jp.setBounds(2,2,549,430);
	add(jp);
	
	JButton back=new JButton("BACK");
	back.setForeground(Color.WHITE);
	back.setBackground(Color.RED);
	back.setBounds(450,450,100,35);
	back.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new mainframe();
		}
	});
	add(back);
	
	setLocation(500,200);
setSize(554,530);
setVisible(true);
}
	public static void main(String[] args) {
	new sales();
	}

}
