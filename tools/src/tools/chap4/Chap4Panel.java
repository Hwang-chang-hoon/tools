package tools.chap4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import tools.IndexPanel;
import tools.MainFrame;

public class Chap4Panel extends JPanel {
	public Chap4Panel(MainFrame mainFrame) {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBackground(Color.WHITE);

		ImageIcon home_ImgIcon = new ImageIcon(getClass().getClassLoader().getResource("home.png"));
		JButton home_img = new JButton(home_ImgIcon);
		home_img.setBorderPainted(false);
		home_img.setContentAreaFilled(false);
		home_img.setFocusPainted(false);
		home_img.addActionListener(new ActionListener() {
			MainFrame mf = mainFrame;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.changeRoom(new IndexPanel(mf));
			}
		});
		home_img.setBounds(10, 10, 45, 29);
		add(home_img);

		ImageIcon chap4_ImgIcon = new ImageIcon(getClass().getClassLoader().getResource("index_chap4.png"));
		JButton chap4_img = new JButton(chap4_ImgIcon);
		chap4_img.setBorderPainted(false);
		chap4_img.setContentAreaFilled(false);
		chap4_img.setFocusPainted(false);
		chap4_img.setBounds(45, 50, 540, 57);
		add(chap4_img);

	}

}
