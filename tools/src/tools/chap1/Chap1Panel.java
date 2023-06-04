package tools.chap1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import tools.IndexPanel;
import tools.MainFrame;

public class Chap1Panel extends JPanel {

	static LineBorder lb = new LineBorder(Color.BLUE, 1);
	static LineBorder errorLB = new LineBorder(Color.RED, 3);

	JTextField vNumTF = new JTextField();
	JTextField startTF = new JTextField();
	JTextField eNumTF = new JTextField();
	JCheckBox returnCB = new JCheckBox("�������� ����", true);
	static JTextArea VWTA;
	static JScrollPane VWScrollPane;

	public Chap1Panel(MainFrame mainFrame) {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBackground(Color.WHITE);

		// ó������ �̵��ϴ� ��ư
		JButton home_img = new JButton(new ImageIcon(getClass().getClassLoader().getResource("home.png")));
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

		// chap1 Ÿ��Ʋ
		JLabel chap1_img = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("index_chap1.png")));
		chap1_img.setBounds(45, 50, 540, 57);
		add(chap1_img);

		// �ǽ� ���� ����� ä���ִ� ��ư
		JButton ex_Check_Button = new JButton("�ǽ� ����");
		ex_Check_Button.setBounds(45, 130, 150, 30);
		ex_Check_Button.setFocusPainted(false);
		add(ex_Check_Button);
		ex_Check_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vNumTF.setText("4");
				returnCB.setSelected(true);
				eNumTF.setText("6");
				startTF.setText("0");
				VWTA.setText("0 1 1\n0 2 5\n0 3 4\n1 2 2\n1 3 6\n2 3 3");
			}
		});

		// �ؽ�Ʈ �ʵ峪 �ؽ�Ʈ ����� ����ִ� ��ư
		JButton reset_Button = new JButton("�ʱ�ȭ");
		reset_Button.setBounds(195, 130, 150, 30);
		reset_Button.setFocusPainted(false);
		add(reset_Button);
		reset_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vNumTF.setText("");
				returnCB.setSelected(true);
				eNumTF.setText("");
				startTF.setText("");
				VWTA.setText("");
			}
		});

		// �Է� ������Ʈ�� ���ִ� �г�
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(null);
		inputPanel.setBackground(Color.WHITE);

		// �ǽ� ���� ����
		JLabel ex_Img = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("ex_chap1.png")));
		ex_Img.setBounds(50, 10, 450, 225);
		inputPanel.add(ex_Img);

		// ������ ���̺�� �ؽ�Ʈ �ʵ�
		JLabel vNumLabel = new JLabel("���� ��", 0);
		vNumLabel.setBounds(50, 270, 100, 50);
		inputPanel.add(vNumLabel);
		vNumTF.setBounds(150, 270, 100, 50);
		inputPanel.add(vNumTF);

		returnCB.setBounds(330, 270, 150, 50);
		returnCB.setBackground(Color.WHITE);
		inputPanel.add(returnCB);

		// ������ ���̺�� �ؽ�Ʈ �ʵ�
		JLabel eNumLabel = new JLabel("���� ��", 0);
		eNumLabel.setBounds(50, 340, 100, 50);
		inputPanel.add(eNumLabel);
		eNumTF.setBounds(150, 340, 100, 50);
		inputPanel.add(eNumTF);

		JLabel startLabel = new JLabel("���� ���", 0);
		startLabel.setBounds(250, 340, 100, 50);
		inputPanel.add(startLabel);
		startTF.setBounds(350, 340, 100, 50);
		inputPanel.add(startTF);

		// ���� ���̺�� �ؽ�Ʈ ������
		JLabel VWLabel = new JLabel("���� �Է� \n(V1, V2, W)");
		VWLabel.setBounds(50, 410, 150, 50);
		inputPanel.add(VWLabel);
		VWTA = new JTextArea();
		VWScrollPane = new JScrollPane(VWTA);
		VWScrollPane.setBounds(200, 410, 250, 100);
		inputPanel.add(VWScrollPane);

		// input�г� ����
		inputPanel.setBorder(lb);
		inputPanel.setBounds(45, 160, 540, 530);
		add(inputPanel);

		// ������Ž�� �̵� ��ư
		JButton hillButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("hill.png")));
		hillButton.setBounds(80, 710, 200, 59);
		hillButton.setBorderPainted(false);
		hillButton.setContentAreaFilled(false);
		hillButton.setFocusPainted(false);
		add(hillButton);
		hillButton.addActionListener(new ActionListener() {
			MainFrame mf = mainFrame;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (vNumTF.getText().length() != 0 && eNumTF.getText().length() != 0 && VWTA.getText().length() != 0) {
					UndirectedListGraph graph = makeGraph(vNumTF.getText(), eNumTF.getText(), VWTA.getText());
					if (graph != null)
						mainFrame.changeRoom(new SearchPanel(mf, 1, Integer.parseInt(startTF.getText()),
								returnCB.isSelected(), graph));
				}
			}
		});

		// A* Ž�� �̵� ��ư
		JButton aStarButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("astar.png")));
		aStarButton.setBounds(350, 710, 200, 59);
		aStarButton.setBorderPainted(false);
		aStarButton.setContentAreaFilled(false);
		aStarButton.setFocusPainted(false);
		add(aStarButton);
		aStarButton.addActionListener(new ActionListener() {
			MainFrame mf = mainFrame;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (vNumTF.getText().length() != 0 && eNumTF.getText().length() != 0 && VWTA.getText().length() != 0) {
					UndirectedListGraph graph = makeGraph(vNumTF.getText(), eNumTF.getText(), VWTA.getText());
					if (graph != null)
						mainFrame.changeRoom(new SearchPanel(mf, 2, Integer.parseInt(startTF.getText()),
								returnCB.isSelected(), graph));
				}
			}
		});

	}

	public static UndirectedListGraph makeGraph(String vNumTF, String eNumTF, String VWTA) {
		int n = Integer.parseInt(vNumTF);

		// ���� ���� n�� ������ �׷����� ����
		UndirectedListGraph graph = new UndirectedListGraph(n);

		// ���� �� e �Է�
		int e = Integer.parseInt(eNumTF);

		String[] ls = VWTA.split("[ \n]+");
		// e���� ����(���� ��)�� �Է¹޾� �׷����� ����
		int l = 0;
		try {
			while (l < 3 * e) {
				int v1 = Integer.parseInt(ls[l++]);
				int v2 = Integer.parseInt(ls[l++]);
				int w = Integer.parseInt(ls[l++]);
				if (!graph.addEdge(v1, v2, w)) { // �߸��� ����
					Chap1Panel.VWScrollPane.setBorder(errorLB);
					return null;
				}
			}
		} catch (ArrayIndexOutOfBoundsException exception) { // �߸��� �Է�
			// TODO: handle exception
			Chap1Panel.VWTA.setBorder(errorLB);
			return null;
		}

		return graph;
	}

}
