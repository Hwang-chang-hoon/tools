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

public class ResultIPanel extends JPanel {

	LineBorder lb = new LineBorder(Color.BLUE, 1);
	int index;

	public ResultIPanel(MainFrame mainFrame, int I, int page, ID3 id3Object, String[] header, String[][] context) {
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
		JLabel iTitle_img = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("ICal.png")));
//		iTitle_img.setBorder(lb);

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
		String[][] tableContext = new String[1][id3.idValueArr.length];
		for (int i = 0; i < tableContext[0].length; i++)
			tableContext[0][i] = String.valueOf(id3.idValueArr[i]);

		int i = 0;
		String[] tableHeader = new String[id3.idKeyArr.length + 1];
		for (; i < tableHeader.length-1; ++i)
			tableHeader[i] = id3.idKeyArr[i];
		tableHeader[tableHeader.length - 1] = "�հ�";

		System.out.println(Arrays.toString(tableHeader)+" ///"+Arrays.deepToString(tableContext));

		
		JTable tt = new JTable(tableContext, tableHeader);
		JScrollPane tableSP = new JScrollPane(tt, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tableSP.setBounds(20, 50, 100 * tableHeader.length, 60);
		tt.setRowHeight(30);
		tt.getTableHeader().setPreferredSize(new Dimension(30, 30));
		tt.setFont(new Font("����", Font.BOLD, 20));
		showPanel.add(tableSP);

		index = page;
		if (page == 0)
			index = I;

		// Ǯ�̰��� ���̺�
		JLabel processLabel = new JLabel("Ǯ�� ����");
		processLabel.setFont(new Font("����", Font.BOLD, 20));
		processLabel.setBounds(20, 190, 100, 20);
		showPanel.add(processLabel);

		// Ǯ�̰��� �ؽ�Ʈ�ʵ�
		JTextArea processTF = new JTextArea();
		JScrollPane sp1 = new JScrollPane(processTF);
		sp1.setBorder(lb);
		processTF.append("I(" + id3.header[index] + ") = " + id3.getProcess(index));
		processTF.setFont(new Font("����", Font.BOLD, 20));
		showPanel.add(sp1);
		sp1.setBounds(20, 220, 500, 70);

		// ��� ���̺�
		JLabel resultLabel = new JLabel("���");
		resultLabel.setFont(new Font("����", Font.BOLD, 20));
		resultLabel.setBounds(20, 330, 100, 20);
		showPanel.add(resultLabel);

		// ��� �ؽ�Ʈ �ʵ�
		JTextArea resultTF = new JTextArea();
		resultTF.setBorder(lb);
		resultTF.append("I(" + id3.header[index] + ") =  " + id3.getResultValue(index));
		resultTF.setFont(new Font("����", Font.BOLD, 20));
		resultTF.setBounds(20, 360, 500, 50);
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

		JButton postButton = new JButton(">");
		postButton.setBounds(525, 710, 59, 59);
		postButton.setFocusPainted(false);
		add(postButton);
		postButton.addActionListener(new ActionListener() {
			MainFrame mf = mainFrame;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.changeRoom(new ResultEPanel(mf, I, page + 1, id3, null, null));
			}
		});
	}
}