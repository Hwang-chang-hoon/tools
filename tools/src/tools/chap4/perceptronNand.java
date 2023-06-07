package tools.chap4;

import java.math.BigDecimal;
import java.util.ArrayList;

public class perceptronNand {
	public static ArrayList<String> array = new ArrayList<>();
	public static int opt;
	static int[][] x = new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
	static int[][] f = new int[4][1]; // ��ǥ ��� F
	static double[][] w = new double[2][2]; // ����ġ
	public static double theta;
	public static double a; // �н���
	static int count; // ��� d�� 0�϶� step ����
	static int y;
	static int d;
	static int step;
	static BigDecimal[] b = new BigDecimal[2];


	public void mainMethod(double[] list) {

		step = 1;

		System.out.println("\nNAND");

		f = new int[][] { { 1 }, { 1 }, { 1 }, { 0 } };
		double[] Nand_list = new double[4];
		Nand_list[0] = -1 * list[0];
		Nand_list[1] = -1 * list[1];
		Nand_list[2] = -1 * list[2];
		Nand_list[3] = list[3];
		learn(f, Nand_list);

		System.out.println("���α׷��� �����մϴ�.");
	}

	public static void learn(int[][] f, double[] list) {
		System.out.print("w1, w2, ��, a : ");
		w[0][0] = list[0];
		w[1][0] = list[1];
		theta = list[2];
		a = list[3];
		int step = 1;
		System.out.println(w[0][0] + " " + w[1][0] + " " + theta + " " + a);

		System.out.println("X1 X2 F   W1   W2  Y  d  W1   W2");
		do {
			if (step == 100) // 100���� ���Ƶ� �н��� �ȵȴٸ� �н��� �Ұ����ϴٰ� �����ǹǷ� ����.
				break;
			count = 0;
			System.out.println("step" + (step++));
			for (int i = 0; i < 4; i++) {
				w[0][1] = w[0][0];
				w[1][1] = w[1][0];
				y = (x[i][0] * w[0][0] + x[i][1] * w[1][0] > theta) ? 1 : 0;
				d = f[i][0] - y;
				if (d == 0)
					count++;
				else {
					b[0] = new BigDecimal(String.valueOf(a * d * x[i][0]));
					b[1] = new BigDecimal(String.valueOf(w[0][0]));
					w[0][0] = b[0].add(b[1]).doubleValue();

					b[0] = new BigDecimal(String.valueOf(a * d * x[i][1]));
					b[1] = new BigDecimal(String.valueOf(w[1][0]));
					w[1][0] = b[0].add(b[1]).doubleValue();
				}
				print(x[i], f[i], w, y, d);		
				
			}			

			System.out.println();
		} while (count != 4);
		opt = 4;
	}

	public static void print(int[] x, int[] f, double[][] w, int y, int d) {
		System.out.println(x[0] + "  " + x[1] + "  " + f[0] + "  " + w[0][1] + "  " + w[1][1] + "  " + y + "  " + d
				+ "  " + w[0][0] + "  " + w[1][0]);
		array.add(x[0] + "   " + x[1] + "   " + f[0] + "   " + w[0][1] + "   " + w[1][1] + "   " + y + "   " + d + "   "
				+ w[0][0] + "   " + w[1][0] + "\n");
	}

}