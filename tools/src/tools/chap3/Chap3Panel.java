package tools.chap3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;
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

public class Chap3Panel extends JPanel {
	public Chap3Panel(MainFrame mainFrame) {
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

		ImageIcon chap3_ImgIcon = new ImageIcon(getClass().getClassLoader().getResource("index_chap3.png"));
		JButton chap3_img = new JButton(chap3_ImgIcon);
		chap3_img.setBorderPainted(false);
		chap3_img.setContentAreaFilled(false);
		chap3_img.setFocusPainted(false);
		chap3_img.setBounds(45, 50, 540, 57);
		add(chap3_img);
		// -----------------------------------------------------------�������� ���ְ� �� ��.

		int i = 0;

		// �� ���� ��ư ����, �׷�ȭ, and�� �ʱⰪ ����, ��ġ �ʱ�ȭ, �г� �߰�------------------------
		JRadioButton[] r = new JRadioButton[3];
		r[0] = new JRadioButton("AND");
		r[1] = new JRadioButton("OR");
		r[2] = new JRadioButton("NAND");

		ButtonGroup group = new ButtonGroup();

		for (i = 0; i < r.length; i++)
			group.add(r[i]);

		i = 0;
		for (int x = 155; i < r.length; i++) {
			r[i].setBounds(x, 130, 100, 50);
			r[i].setBackground(Color.white);
			r[i].setFont(new Font("����", Font.BOLD, 20));
			x += 105;
			add(r[i]);
		}

		r[0].setSelected(true);

		// �� �� �гο� �̹��� �ְ� z-order�� �����ؼ� �̹��� ���� �۾� ǥ��
		ImageIcon picture = new ImageIcon(getClass().getClassLoader().getResource("picture.png"));
		JLabel img = new JLabel(picture);

		JPanel imgPanel = new JPanel();
		imgPanel.setBounds(55, 335, 530, 300);
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

		pictureText[0].setLocation(127, 365);
		pictureText[1].setLocation(127, 595);
		pictureText[2].setLocation(235, 390);
		pictureText[3].setLocation(235, 570);
		pictureText[4].setLocation(352, 479);
		pictureText[5].setLocation(450, 460);

		i = 0;
		for (; i < pictureText.length; i++)
			setComponentZOrder(pictureText[i], i);
		setComponentZOrder(imgPanel, 6);

		// �� ��ư ������ ��ġ �ʱ�ȭ, �гο� �߰�------------------------------------------------
		ImageIcon start_p = new ImageIcon(getClass().getClassLoader().getResource("C3_start.png"));
		ImageIcon reset_p = new ImageIcon(getClass().getClassLoader().getResource("C3_reset.png"));
		ImageIcon left_p = new ImageIcon(getClass().getClassLoader().getResource("left.png"));
		ImageIcon right_p = new ImageIcon(getClass().getClassLoader().getResource("right.png"));
		JButton start = new JButton(start_p);
		JButton pre = new JButton(left_p);
		JButton next = new JButton(right_p);
		JButton reset = new JButton(reset_p);

		start.setBounds(55, 680, 150, 50);
		pre.setBounds(480, 680, 50, 50);
		next.setBounds(535, 680, 50, 50);
		reset.setBounds(210, 680, 150, 50);

		add(start);
		add(pre);
		add(next);
		add(reset);

		// �� �� ����� �ʱ�ȭ ------------------------------------------------------------
		JLabel[] text = new JLabel[4];

		text[0] = new JLabel("w1");
		text[1] = new JLabel("w2");
		text[2] = new JLabel("��");
		text[3] = new JLabel("a");

		i = 0;
		for (int x = 90; i < text.length; i++) {
			text[i].setBounds(x, 220, 30, 20);
			text[i].setHorizontalAlignment(JLabel.CENTER);
			text[i].setFont(new Font("Dialog", Font.BOLD, 17));
			x += 115;
		}

		for (i = 0; i < text.length; i++)
			add(text[i]);

		// �� step ���� ǥ�� ------------------------------------------------------------
		JLabel step = new JLabel("Step");
		step.setFont(new Font("Dialog", Font.BOLD, 20));
		step.setBounds(55, 310, 100, 30);
		add(step);

		// �� �ؽ�Ʈ �ʵ� �迭 ����, ��ġ �ʱ�ȭ, �߰�--------------------------------------------
		JTextField[] input = new JTextField[4];

		i = 0;
		for (int x = 120; i < input.length; i++) {
			input[i] = new JTextField();
			input[i].setBounds(x, 210, 80, 40);
			x += 115;
			add(input[i]);
		}

		ArrayList<String> list = new ArrayList<>(); // �ۼ�Ʈ�� ��� ������� ������ �迭

		// ��� ����� �ؽ�Ʈ ǥ�� ----------------------------------------------------------
//		JLabel index = new JLabel("X1 X2 F   W1   W2  Y  d  W1   W2\n");
//		index.setBounds(210, 260, 200, 30);
//		index.setHorizontalAlignment(JLabel.CENTER);
//		add(index);

//		JLabel value = new JLabel();
//		value.setBounds(210, 290, 200, 30);
//		value.setHorizontalAlignment(JLabel.CENTER);
//		add(value);

		// �� ��ư���� actionListener ----------------------------------------------------
		Action action = new Action(); // ��ư���� actionListener ��ü

		pre.setEnabled(false);
		next.setEnabled(false);

		start.addActionListener(new ActionListener() { // ���� ��ư actionListener
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// �� �Է� ���� �� ���� �޽��� ���
				if (!isStringDouble(input)) {
					JOptionPane.showMessageDialog(null, "���� �ٽ� �Է��ϼ���.", "�� ����", JOptionPane.ERROR_MESSAGE);
					return;
				}

				pre.setEnabled(true);
				next.setEnabled(true);
				reset.setEnabled(true);

				step.setText("Step 1");

				radioButtonFalse(r);

				int a = 0;

				// ���� ��ư ���ÿ� ���� and, or, nand �� �Է�
				if (r[0].isSelected())
					a = 1;
				else if (r[1].isSelected())
					a = 2;
				else if (r[2].isSelected())
					a = 3;

				double[] array = new double[4]; // �Է�â�� �Էµ� ���� ����

				for (int i = 0; i < array.length; i++)
					array[i] = Double.parseDouble(input[i].getText());

				perceptron p = new perceptron();
				p.array.clear();
				p.mainMethod(a, array);

				textFieldFalse(input);

				pre.setEnabled(false);
				start.setEnabled(false);

				if (perceptron.array.size() >= 100) {
					textFieldFalse(input);

					pre.setEnabled(false);
					next.setEnabled(false);

					radioButtonFalse(r);

					JOptionPane.showMessageDialog(null, "�н��� �����Ͽ����ϴ�.", "����", JOptionPane.ERROR_MESSAGE);
				} else {
					pictureText[4].setText(input[2].getText().trim());
					list.addAll(perceptron.array);
					// value.setText(perceptron.array.get(0));

					action.s = list.get(0).split("   ");

					pictureText[0].setText(action.s[0]);
					pictureText[1].setText(action.s[1]);
					pictureText[2].setText(action.s[3]);
					pictureText[3].setText(action.s[4]);
					pictureText[5].setText(action.s[5]);
				}
			}
		});

		pre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// value.setText(list.get(--action.value)); // ���� �� ���� ��ġ�� ���� ����.
				--action.value;

				if (action.value == 0)
					pre.setEnabled(false);

				if (action.value < list.size() - 1)
					next.setEnabled(true);

				action.s = list.get(action.value).split("   ");

				pictureText[0].setText(action.s[0]);
				pictureText[1].setText(action.s[1]);
				pictureText[2].setText(action.s[3]);
				pictureText[3].setText(action.s[4]);
				pictureText[5].setText(action.s[5]);

				step.setText("Step " + Integer.toString(action.value / 4 + 1));
			}
		});

		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// value.setText(list.get(++action.value)); // ���� �� ���� ��ġ�� �� ����.
				++action.value;

				if (action.value == list.size() - 1)
					next.setEnabled(false);

				if (action.value > 0)
					pre.setEnabled(true);

				action.s = list.get(action.value).split("   ");

				pictureText[0].setText(action.s[0]);
				pictureText[1].setText(action.s[1]);
				pictureText[2].setText(action.s[3]);
				pictureText[3].setText(action.s[4]);
				pictureText[5].setText(action.s[5]);

				step.setText("Step " + Integer.toString(action.value / 4 + 1));
			}
		});

		reset.addActionListener(new ActionListener() { // �ʱ�ȭ ��ư - ��� �Է�â�� ��ư �ʱ�ȭ(��� ����), �� ǥ���� �迭�� �� �ʱ�ȭ
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldTrue(input);

				for (int i = 0; i < input.length; i++)
					input[i].setText("");

				r[0].setSelected(true);

				list.clear();

				// value.setText("");

				action.value = 0;

				pre.setEnabled(false);
				next.setEnabled(false);
				start.setEnabled(true);
				step.setText("Step");

				for (int j = 0; j < pictureText.length; j++)
					pictureText[j].setText("");

				radioButtonTrue(r);
			}
		});
	}

	public static boolean isStringDouble(JTextField[] t) { // �Է�â�� ���� double���� �´��� Ȯ��
		try {
			for (int i = 0; i < t.length; i++)
				Double.parseDouble(t[i].getText());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static void textFieldTrue(JTextField[] j1) { // textfield ���� �Է� ����
		for (int i = 0; i < j1.length; i++)
			j1[i].setEnabled(true);
	}

	public static void textFieldFalse(JTextField[] j2) { // textfield ���� �Է� �Ұ���
		for (int i = 0; i < j2.length; i++)
			j2[i].setEnabled(false);
	}

	public static void radioButtonTrue(JRadioButton[] r1) { // radiobutton ���� ��� ����
		for (int i = 0; i < r1.length; i++)
			r1[i].setEnabled(true);
	}

	public static void radioButtonFalse(JRadioButton[] r2) { // radiobutton ���� ��� �Ұ���
		for (int i = 0; i < r2.length; i++)
			r2[i].setEnabled(false);
	}
}