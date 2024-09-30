package jewellery_shop;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class item2 extends JFrame {
	public item2() {

		Font fl = new Font("serif", Font.BOLD, 25);
		Font ft = new Font("serif", Font.BOLD, 15);

		JLabel t1 = new JLabel("ITEM DETAILS :");
		t1.setBounds(300, -200, 500, 500);
		JLabel t2 = new JLabel("ITEM NAME:-> Yellow Gold Ring");
		t2.setBounds(300, 10, 500, 200);
		JLabel t3 = new JLabel("SIZE:-> 6 MM");
		t3.setBounds(300, 50, 500, 200);
		JLabel t4 = new JLabel("PURITY:-> 22 KT");
		t4.setBounds(300, 90, 500, 200);
		JLabel t5 = new JLabel("TOTAL:-> 18,668");
		t5.setBounds(300, 130, 500, 200);
		JButton b1 = new JButton("buy");
		b1.setBounds(350, 300, 90, 50);
		b1.setBackground(new Color(32, 32, 32));
		b1.setForeground(Color.WHITE);

		JButton b2 = new JButton("back");
		b2.setBounds(750, 300, 90, 50);
		b2.setBackground(new Color(32, 32, 32));
		b2.setForeground(Color.WHITE);

		t1.setFont(fl);
		t2.setFont(ft);
		t3.setFont(ft);
		t4.setFont(ft);
		t5.setFont(ft);
		ImageIcon background_image = new ImageIcon("background.jpeg");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1500, 850, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);
		background.setBounds(0, 0, 1500, 850);
		add(background);
		// bottom panel
		JPanel f = new JPanel();
		f.setLayout(null);
		f.setBounds(0, 380, 900, 400);
		background.add(f);
		f.setBackground(new Color(255, 255, 255, 0));
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(t4);
		f.add(t5);
		f.add(b1);
		f.add(b2);
		// top panel
		JPanel f1 = new JPanel();
		f1.setLayout(new BorderLayout());
		ImageIcon item = new ImageIcon("item12.jpeg");
		Image img1 = item.getImage();
		Image temp_img1 = img1.getScaledInstance(900, 900, Image.SCALE_SMOOTH);
		item = new ImageIcon(temp_img1);
		JLabel background1 = new JLabel("", item, JLabel.CENTER);
		background1.setBounds(0, 0, 900, 900);
		f1.add(background1);
		f1.setBounds(260, 10, 360, 360);
		background.add(f1);
		setSize(900, 900);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				payment s = new payment("18,668/-");
				setVisible(false);
			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				new mainframe();
			}
		});

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new item2();
	}
}
