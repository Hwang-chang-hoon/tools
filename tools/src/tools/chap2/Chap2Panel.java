package tools.chap2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import tools.IndexPanel;
import tools.MainFrame;

public class Chap2Panel extends JPanel {

	static LineBorder lb = new LineBorder(Color.BLUE, 1);
	static LineBorder whitelb = new LineBorder(Color.WHITE, 1);
	JPanel tablePanel = new JPanel();
	JTable table;
	String[] header;
	String[][] context;
	JRadioButton[] radioButton;
	int check = 0;

	public Chap2Panel(MainFrame mainFrame) {
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

		// chap2 Ÿ��Ʋ
		ImageIcon chap2_ImgIcon = new ImageIcon(getClass().getClassLoader().getResource("index_chap2.png"));
		JButton chap2_img = new JButton(chap2_ImgIcon);
		chap2_img.setBorderPainted(false);
		chap2_img.setContentAreaFilled(false);
		chap2_img.setFocusPainted(false);
		chap2_img.setBounds(45, 50, 540, 57);
		add(chap2_img);

		/*
		 * // ���� ���� �۵��� �ϴ� �г� JPanel openPanel = new JPanel();
		 * openPanel.setLayout(null); openPanel.setBackground(Color.WHITE);
		 * openPanel.setBorder(lb);
		 * 
		 * // ���� ���� ��ư JButton chooseButton = new JButton("���� ����");
		 * chooseButton.setBounds(15, 20, 110, 35); chooseButton.setFocusPainted(false);
		 * openPanel.add(chooseButton);
		 * 
		 * // ���� ���� ��ư JButton openButton = new JButton("����"); openButton.setBounds(15,
		 * 75, 110, 35); openButton.setFocusPainted(false); openPanel.add(openButton);
		 * 
		 * openPanel.setBounds(45, 140, 540, 130); add(openPanel);
		 */
		/*-------------------------------------------------------------------------------------*/
		// �ǽ� ���� ����� ä���ִ� ��ư
		JButton ex_Button = new JButton("�ǽ� ����");
		ex_Button.setBounds(45, 300, 150, 30);
		ex_Button.setFocusPainted(false);
		add(ex_Button);
		ex_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				header = new String[] { "no", "ū����", "����", "60���̻�", "��" };
				context = new String[][] { { "1", "�׷���", "����", "�ƴϴ�", "�ƴϴ�" }, 
										   { "2", "�׷���", "����", "�׷���", "�ƴϴ�" },
										   { "3", "�ƴϴ�", "����", "�ƴϴ�", "�׷���" }, 
										   { "4", "�ƴϴ�", "����", "�׷���", "�ƴϴ�" },
										   { "5", "�ƴϴ�", "�ִ�", "�׷���", "�׷���" } };

				table = new JTable(context, header);
				// ǥ ����
				JScrollPane tableSP = new JScrollPane(table);
				tableSP.setOpaque(false);
				tableSP.getViewport().setOpaque(false);
				table.setRowHeight(30);
				table.getColumnModel().getColumn(0).setPreferredWidth(10);
				table.getTableHeader().setPreferredSize(new Dimension(30, 30));

				table.setFocusable(false); // ��
				table.setRowSelectionAllowed(false); // ��
				table.getTableHeader().setReorderingAllowed(false); // �̵��Ұ�
				table.getTableHeader().setResizingAllowed(false); // ũ�� ���� �Ұ�

				tablePanel.add(tableSP);

				ButtonGroup group = new ButtonGroup();
				radioButton = new JRadioButton[header.length];
				int x = 95;
				for (int i = 1; i < radioButton.length; i++) {
					radioButton[i] = new JRadioButton(header[i]);
					group.add(radioButton[i]);
					radioButton[i].setBackground(Color.WHITE);
					radioButton[i].setBounds(x, 560, 125, 100);
					x += 130;
					radioButton[i].setFont(new Font("����", Font.BOLD, 15));
					add(radioButton[i]);
				}
				radioButton[1].setSelected(true);

				JButton calStart = new JButton("��� ����");
				calStart.setBounds(385, 680, 200, 60);
				calStart.addActionListener(new ActionListener() {
					MainFrame mf = mainFrame;

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						check = checkRadio(radioButton);
						mainFrame.changeRoom(new ResultIPanel(mf, check, 0, null, header, context));
					}
				});

				add(calStart);

				revalidate();
				repaint();
			}

		});

		tablePanel.setLayout(new BorderLayout());
		tablePanel.setBackground(Color.white);
		tablePanel.setBounds(45, 350, 540, 200);
		tablePanel.setBorder(lb);
		add(tablePanel);

	}

	public static int checkRadio(JRadioButton[] radioButton) {
		for (int i = 1; i < radioButton.length; i++)
			if (radioButton[i].isSelected())
				return i;
		return 0;
	}

}