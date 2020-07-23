package solutions;


import java.util.ArrayList;

public class three {
	public static void main(String[] args) {
		// ���� �� �������� Ȯ���ϱ� ���� ��ǲ ���� KAHEEE -> KAHEJE
		String[] cake1 = { "AAAAAA", "AAACBA", "KAHEJE", "DHMADB", "AAAHHH", "ACBAHH" };
		int[] cut_row1 = { 2, 4 };
		int[] cut_col1 = { 2, 3 };

		String[] cake2 = { "ABBD", "CAAB", "AAHA", "AAAU" };
		int[] cut_row2 = { 1, 2 };
		int[] cut_col2 = { 2 };
		// three.calcTaste(cake2, cut_row2, cut_col2);
		three.calcTaste(cake1, cut_row1, cut_col1);
	}

	// ����ũ�� ������ N*N �̶�� ����
	// �ڸ��� ȸ���� �� ���� ���� �� ����
	public static int calcTaste(String[] cake, int[] cut_row, int[] cut_col) {
		// 2���� �迭�� �� ���ο� cake�� ����
		String[][] newCake = new String[cake.length][cake.length];
		for (int i = 0; i < newCake.length; i++) {
			for (int j = 0; j < newCake.length; j++) {
				newCake[i] = cake[i].split("");
				// System.out.print(newCake[i][j]);
			}
			// System.out.println();
		}

		// �Ǿտ� 0 �� �ڿ� N �� �߰��� ���ο� row�� ����
		int[] newRow = new int[cut_row.length + 2];
		newRow[0] = 0;
		for (int i = 1; i < newRow.length - 1; i++) {
			newRow[i] = cut_row[i - 1];
			// System.out.println(newRow[i] + " " + i);
		}
		newRow[newRow.length - 1] = cake.length;

		// row �� col �� ũ�Ⱑ �ٸ� �� �ֱ� ������ ���� ����
		int[] newCol = new int[cut_col.length + 2];
		newCol[0] = 0;
		for (int i = 1; i < newCol.length - 1; i++) {
			newCol[i] = cut_col[i - 1];
		}
		newCol[newCol.length - 1] = cake.length;

//		for (int i = 0; i < newCol.length; i++) {
//			System.out.println(newCol[i]);
//		}

		int max = 0;
		// �� row * col �ڸ� ȸ����ŭ ����
		// ���Ӱ� ���� row, col �̱� ������ 0���� ����
		for (int i = 0; i < newRow.length - 1; i++) {
			for (int j = 0; j < newCol.length - 1; j++) {

				// ���� ����Ʈ�� ����ƽ��� �Ź� �ʱ�ȭ
				ArrayList<String> colorList = new ArrayList<>();
				int subMax = 0;

				// �����߸� �������� ���� �߸� ��������
				for (int i2 = newRow[i]; i2 < newRow[i + 1]; i2++) {
					// ���������� �߸� ���� ����
					for (int j2 = newCol[j]; j2 < newCol[j + 1]; j2++) {
						String tmp = newCake[i2][j2];
						// System.out.print(tmp);
						// ���� ���� ������ �߰��ϸ鼭 ī���� ����
						if (!colorList.contains(tmp)) {
							colorList.add(tmp);
							subMax++;
						}
					}
					// System.out.println();
				}
				// �ִ밪 ã��
				if (subMax > max) {
					max = subMax;
				}
				// System.out.println();
			}
		}

		System.out.println(max);
		return max;
	}
}
