package tools.chap2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import tools.IndexPanel;
import tools.MainFrame;
import tools.chap1.Chap1Panel;

public class ResultEPanel extends JPanel {

	static LineBorder lb = new LineBorder(Color.BLUE, 1);

	public ResultEPanel(MainFrame mainFrame, int I, int index, ID3 id3Object, String[] header, String[][] context) {
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

		// title �̹���
		JLabel iTitle_img = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("e_title.png")));
		iTitle_img.setBounds(45, 50, 540, 86);
		add(iTitle_img);

		JButton resetButton = new JButton("�ٽ� �Է�");
		resetButton.setBounds(485, 140, 100, 30);
		resetButton.setFocusPainted(false);
		add(resetButton);
		resetButton.addActionListener(new ActionListener() {
			MainFrame mf = mainFrame;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.changeRoom(new Chap2Panel(mf));

			}
		});

		// id3 ��� ��� ���� �г�
		JPanel showPanel = new JPanel();
		showPanel.setLayout(null);
		showPanel.setBackground(Color.WHITE);
//		showPanel.setBorder(lb);
		showPanel.setBounds(45, 170, 540, 530);
		add(showPanel);

		// ID3 ��ü
		ID3 id3 = id3Object == null ? new ID3(I, header, context) : id3Object;

		// ���̺�
		String[] tableHeader = new String[id3.idKeyArr.length + 2];
		tableHeader[0] = " ";
		for (int i = 1; i < tableHeader.length - 1; ++i)
			tableHeader[i] = id3.idKeyArr[i - 1];
		tableHeader[tableHeader.length - 1] = "�հ�";

		System.out.println("index" + index);
		String[][] tableContext = id3.makeContext(index);

		JTable tt = new JTable(tableContext, tableHeader);
		JScrollPane tableSP = new JScrollPane(tt, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tableSP.setBounds(20, 20, 100 * tableHeader.length, (tableContext.length + 1) * 30);
		tt.setRowHeight(30);
		tt.getTableHeader().setPreferredSize(new Dimension(30, 30));
		tt.setFont(new Font("����", Font.BOLD, 20));
		showPanel.add(tableSP);

		// Ǯ�̰��� ���̺�
		JLabel processLabel = new JLabel("Ǯ�� ����");
		processLabel.setFont(new Font("����", Font.BOLD, 20));
		processLabel.setBounds(20, 170, 100, 20);
		showPanel.add(processLabel);

		// Ǯ�̰��� �ؽ�Ʈ�ʵ�
		JTextArea processTF = new JTextArea();
		JScrollPane sp1 = new JScrollPane(processTF);
		sp1.setBorder(lb);
		processTF.append("E(" + id3.header[index] + ") = " + id3.getProcess(index) + "\n\n");
		processTF.append("E(" + id3.header[index] + ") =  " + id3.getResultValue(index) + "\n\n");
		processTF
				.append("Gain(" + id3.header[index] + ") =  " + id3.getResultValue(index) + " - " + id3.getGain(index));
		processTF.setFont(new Font("����", Font.BOLD, 20));
		showPanel.add(sp1);
		sp1.setBounds(20, 200, 500, 200);

		// ��� Gain ���̺�
		JLabel resultLabel = new JLabel("���");
		resultLabel.setFont(new Font("����", Font.BOLD, 20));
		resultLabel.setBounds(20, 420, 100, 20);
		showPanel.add(resultLabel);

		// ��� Gain �ؽ�Ʈ �ʵ�
		JTextArea resultTF = new JTextArea();
		resultTF.setBorder(lb);
		resultTF.append("Gain(" + id3.header[index] + ") =  " + id3.getGain(index) + "\n\n");
		resultTF.setFont(new Font("����", Font.BOLD, 20));
		resultTF.setBounds(20, 450, 500, 50);
		showPanel.add(resultTF);

		// �ǻ���� Ʈ���� �̵��ϴ� ��ư
		JButton treeButton = new JButton("�ǻ����Ʈ��");
		treeButton.setBounds(230, 710, 150, 59);
		treeButton.setFocusPainted(false);
		add(treeButton);
		treeButton.addActionListener(new ActionListener() {
			MainFrame mf = mainFrame;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				mainFrame.changeRoom(new DecisionTree(mf, id3));
			}
		});

		// ���� ID3 ��� �гη� �̵��ϴ� ��ư
		if (index > 0) {
			JButton preButton = new JButton("<");
			preButton.setBounds(450, 710, 59, 59);
			preButton.setFocusPainted(false);
			add(preButton);
			preButton.addActionListener(new ActionListener() {
				MainFrame mf = mainFrame;

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (index - 1 == 0)
						mainFrame.changeRoom(new ResultIPanel(mf, I, index - 1, id3, null, null));
					else
						mainFrame.changeRoom(new ResultEPanel(mf, I, index - 1, id3, null, null));
				}
			});
		}
		// ���� ID3 ��� �гη� �̵��ϴ� ��ư 3 length 5
		JButton postButton = new JButton(">");
		postButton.setBounds(525, 710, 59, 59);
		postButton.setFocusPainted(false);
		add(postButton);
		postButton.addActionListener(new ActionListener() {
			MainFrame mf = mainFrame;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (index + 1 == I && (I == id3.header.length - 1)) // ������ I�ε� I�� ������
					mainFrame.changeRoom(new DecisionTree(mf, id3));
				else if (index == id3.header.length - 1)
					mainFrame.changeRoom(new DecisionTree(mf, id3));
				else if (index + 1 == I) // ������ I
					mainFrame.changeRoom(new ResultEPanel(mf, I, index + 2, id3, null, null));
				else
					mainFrame.changeRoom(new ResultEPanel(mf, I, index + 1, id3, null, null));
			}
		});
	}
}
