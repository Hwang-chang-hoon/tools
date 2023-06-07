package tools.chap4;
//제발좀 되라!!!!!!!!!

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import tools.IndexPanel;
import tools.MainFrame;
import tools.chap2.ResultIPanel;

public class Chap4Panel extends JPanel {
	static LineBorder lb = new LineBorder(Color.BLUE, 1);
	static LineBorder whitelb = new LineBorder(Color.WHITE, 1);
	JPanel tablePanel = new JPanel();
	int i = 0;

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

		// ※ 라벨 선언과 초기화 ------------------------------------------------------------
		JLabel[] text = new JLabel[4];

		text[0] = new JLabel("w1");
		text[1] = new JLabel("w2");
		text[2] = new JLabel("θ");
		text[3] = new JLabel("a");

		i = 0;
		for (int x = 90; i < text.length; i++) {
			text[i].setBounds(x, 150, 30, 20);
			text[i].setHorizontalAlignment(JLabel.CENTER);
			text[i].setFont(new Font("Dialog", Font.BOLD, 17));
			x += 115;
		}

		for (i = 0; i < text.length; i++)
			add(text[i]);
		// ※ 텍스트 필드 배열 선언, 위치 초기화, 추가--------------------------------------------
		JTextField[] input = new JTextField[4];

		i = 0;
		for (int x = 120; i < input.length; i++) {
			input[i] = new JTextField();
			input[i].setBounds(x, 140, 80, 40);
			x += 115;
			add(input[i]);
		}

		ArrayList<String> list = new ArrayList<>(); // 퍼셉트론 출력 결과값을 저장할 배열

		// ※ 새 패널에 이미지 넣고 z-order값 조절해서 이미지 위에 글씨 표시
		ImageIcon picture = new ImageIcon(getClass().getClassLoader().getResource("secret_picture.png"));

		Image tempimg = picture.getImage();
		// 창의 사이즈인 530,300에 맞춰서 이미지를 변경
		Image changeImg = tempimg.getScaledInstance(530, 300, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel img = new JLabel(changeIcon);

		JPanel imgPanel = new JPanel();
		imgPanel.setBounds(55, 170, 530, 300);
		imgPanel.setBackground(Color.white);
		imgPanel.add(img);

		add(imgPanel);

		// ※ 버튼 생성과 위치 초기화, 패널에 추가------------------------------------------------
		ImageIcon start_p = new ImageIcon(getClass().getClassLoader().getResource("C3_start.png"));
		ImageIcon reset_p = new ImageIcon(getClass().getClassLoader().getResource("C3_reset.png"));
		ImageIcon right_p = new ImageIcon(getClass().getClassLoader().getResource("right.png"));
		JButton start = new JButton(start_p);
		JButton next = new JButton(right_p);
		JButton reset = new JButton(reset_p);

		start.setBounds(55, 680, 150, 50);
		next.setBounds(535, 680, 50, 50);
		reset.setBounds(210, 680, 150, 50);

		add(start);
		add(next);
		add(reset);

		// 각 버튼들의 actionListener ----------------------------------------------------
		Action action = new Action(); // 버튼들의 actionListener 객체

		next.setEnabled(true);//false

		start.addActionListener(new ActionListener() { // 시작 버튼 actionListener
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// 값 입력 없을 때 에러 메시지 출력
				if (!isStringDouble(input)) {
					JOptionPane.showMessageDialog(null, "값을 다시 입력하세요.", "값 오류", JOptionPane.ERROR_MESSAGE);
					return;
				}

				next.setEnabled(true);
				reset.setEnabled(true);
				int a = 1;

				double[] array = new double[4]; // 입력창에 입력된 값들 저장

				for (int i = 0; i < array.length; i++)
					array[i] = Double.parseDouble(input[i].getText());

				perceptron p = new perceptron();
				p.array.clear();
				p.mainMethod(a, array);

				textFieldFalse(input);

				start.setEnabled(false);

				if (perceptron.array.size() >= 100) {
					textFieldFalse(input);

					//next.setEnabled(false);

					JOptionPane.showMessageDialog(null, "학습에 실패하였습니다.", "오류", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		reset.addActionListener(new ActionListener() { // 초기화 버튼 - 모든 입력창과 버튼 초기화(사용 가능), 값 표시할 배열과 라벨 초기화
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldTrue(input);

				for (int i = 0; i < input.length; i++)
					input[i].setText("");


				list.clear();

				// value.setText("");

				action.value = 0;

				//next.setEnabled(false);
				start.setEnabled(true);
		
			}
		});
		next.addActionListener(new ActionListener() {
			MainFrame mf = mainFrame;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.changeRoom(new First_LayerNand(mf));
			}
		});

	}

	public static boolean isStringDouble(JTextField[] t) { // 입력창의 값이 double형이 맞는지 확인
		try {
			for (int i = 0; i < t.length; i++)
				Double.parseDouble(t[i].getText());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static void textFieldTrue(JTextField[] j1) { // textfield 전부 입력 가능
		for (int i = 0; i < j1.length; i++)
			j1[i].setEnabled(true);
	}

	public static void textFieldFalse(JTextField[] j2) { // textfield 전부 입력 불가능
		for (int i = 0; i < j2.length; i++)
			j2[i].setEnabled(false);
	}

	public static void radioButtonTrue(JRadioButton[] r1) { // radiobutton 전부 사용 가능
		for (int i = 0; i < r1.length; i++)
			r1[i].setEnabled(true);
	}

	public static void radioButtonFalse(JRadioButton[] r2) { // radiobutton 전부 사용 불가능
		for (int i = 0; i < r2.length; i++)
			r2[i].setEnabled(false);
	}

}
