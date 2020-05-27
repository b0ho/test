

import java.util.ArrayList;

public class three {
	public static void main(String[] args) {
		// 값이 잘 나오는지 확인하기 위해 인풋 수정 KAHEEE -> KAHEJE
		String[] cake1 = { "AAAAAA", "AAACBA", "KAHEJE", "DHMADB", "AAAHHH", "ACBAHH" };
		int[] cut_row1 = { 2, 4 };
		int[] cut_col1 = { 2, 3 };

		String[] cake2 = { "ABBD", "CAAB", "AAHA", "AAAU" };
		int[] cut_row2 = { 1, 2 };
		int[] cut_col2 = { 2 };
		// three.calcTaste(cake2, cut_row2, cut_col2);
		three.calcTaste(cake1, cut_row1, cut_col1);
	}

	// 케이크는 무조건 N*N 이라고 가정
	// 자르는 회수는 더 많고 적을 수 있음
	public static int calcTaste(String[] cake, int[] cut_row, int[] cut_col) {
		// 2차원 배열로 된 새로운 cake를 생성
		String[][] newCake = new String[cake.length][cake.length];
		for (int i = 0; i < newCake.length; i++) {
			for (int j = 0; j < newCake.length; j++) {
				newCake[i] = cake[i].split("");
				// System.out.print(newCake[i][j]);
			}
			// System.out.println();
		}

		// 맨앞에 0 맨 뒤에 N 이 추가된 새로운 row를 생성
		int[] newRow = new int[cut_row.length + 2];
		newRow[0] = 0;
		for (int i = 1; i < newRow.length - 1; i++) {
			newRow[i] = cut_row[i - 1];
			// System.out.println(newRow[i] + " " + i);
		}
		newRow[newRow.length - 1] = cake.length;

		// row 와 col 의 크기가 다를 수 있기 때문에 각각 수행
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
		// 총 row * col 자른 회수만큼 수행
		// 새롭게 만든 row, col 이기 때문에 0부터 시작
		for (int i = 0; i < newRow.length - 1; i++) {
			for (int j = 0; j < newCol.length - 1; j++) {

				// 서브 리스트와 서브맥스는 매번 초기화
				ArrayList<String> colorList = new ArrayList<>();
				int subMax = 0;

				// 현재잘린 부위부터 다음 잘림 부위까지
				for (int i2 = newRow[i]; i2 < newRow[i + 1]; i2++) {
					// 마찬가지로 잘린 부위 까지
					for (int j2 = newCol[j]; j2 < newCol[j + 1]; j2++) {
						String tmp = newCake[i2][j2];
						// System.out.print(tmp);
						// 같은 색이 없으면 추가하면서 카운터 증가
						if (!colorList.contains(tmp)) {
							colorList.add(tmp);
							subMax++;
						}
					}
					// System.out.println();
				}
				// 최대값 찾기
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
