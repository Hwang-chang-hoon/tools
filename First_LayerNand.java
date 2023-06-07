package tools.chap4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import tools.IndexPanel;
import tools.MainFrame;
import tools.chap2.Chap2Panel;

public class First_LayerNand extends JPanel {

	static LineBorder lb = new LineBorder(Color.BLUE, 1);
	static LineBorder whitelb = new LineBorder(Color.WHITE, 1);
	JPanel tablePanel = new JPanel();
	int i = 0;

	public First_LayerNand(MainFrame mainFrame) {
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

		// 풀이과정 레이블
		JLabel NANDLabel = new JLabel("NAND");
		NANDLabel.setFont(new Font("돋움", Font.BOLD, 20));
		NANDLabel.setBounds(20, 140, 100, 20);
		add(NANDLabel);

		JButton resetButton = new JButton("다시 입력");
		resetButton.setBounds(485, 140, 100, 30);
		resetButton.setFocusPainted(false);
		add(resetButton);
		resetButton.addActionListener(new ActionListener() {
			MainFrame mf = mainFrame;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.changeRoom(new Chap4Panel(mf));

			}
		});
		tablePanel.setLayout(new BorderLayout());
		tablePanel.setBackground(Color.white);
		tablePanel.setBounds(45, 470, 540, 200);
		tablePanel.setBorder(lb);
		add(tablePanel);

		// ※ 새 패널에 이미지 넣고 z-order값 조절해서 이미지 위에 글씨 표시
		ImageIcon picture = new ImageIcon(getClass().getClassLoader().getResource("picture.png"));
		JLabel img = new JLabel(picture);

		JPanel imgPanel = new JPanel();
		imgPanel.setBounds(55, 170, 530, 300);
		imgPanel.setBackground(Color.white);
		imgPanel.add(img);

		add(imgPanel);

		JLabel[] pictureText = new JLabel[6];

		i = 0;
		for (; i < pictureText.length; i++) {
			pictureText[i] = new JLabel("");
			pictureText[i].setFont(new Font("Dialog", Font.BOLD, 20));
			pictureText[i].setSize(70, 30);
			setComponentZOrder(pictureText[i], i);
			add(pictureText[i]);
		}

		pictureText[0].setHorizontalAlignment(JLabel.LEFT);
		pictureText[1].setHorizontalAlignment(JLabel.LEFT);
		pictureText[2].setHorizontalAlignment(JLabel.CENTER);
		pictureText[3].setHorizontalAlignment(JLabel.CENTER);
		pictureText[4].setHorizontalAlignment(JLabel.LEFT);
		pictureText[5].setHorizontalAlignment(JLabel.LEFT);

		pictureText[0].setLocation(127, 200);
		pictureText[1].setLocation(127, 430);
		pictureText[2].setLocation(235, 225);
		pictureText[3].setLocation(235, 405);
		pictureText[4].setLocation(352, 314);
		pictureText[5].setLocation(450, 295);

		pictureText[0].setText("2");
		pictureText[1].setText("2");
		pictureText[2].setText("2");
		pictureText[3].setText("3");
		pictureText[4].setText("3");
		pictureText[5].setText("3");

		i = 0;
		for (; i < pictureText.length; i++)
			setComponentZOrder(pictureText[i], i);
		setComponentZOrder(imgPanel, 6);
	}

}
