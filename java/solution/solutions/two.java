package solutions;



import java.util.ArrayList;

public class two {
	public static void main(String[] args) {
		String[] str = { "A/B/C/A.TXT", "A/CC/D/", "A/DD/E.TXT", "A/CC/README", "A/DD/LL/" };
		two.findFile(str);
		two.findDirectory(str);
	}

	public static int findFile(String[] location) {
		int answer = 0;

		// System.out.println(location[0].split("/")[3]);
		// System.out.println(location[1].substring(location[1].length() - 1,
		// location[1].length()));
		// �� ��� ���ڿ��� ������ ��Ʈ���� / �� �ƴϸ� ���� ����,,
		for (int i = 0; i < location.length; i++) {
			if (!location[i].substring(location[i].length() - 1, location[i].length()).equals("/")) {
				answer++;
			}
		}

		System.out.println("������ ������ : " + answer);
		return answer;
	}

	public static int findDirectory(String[] location) {
		int answer = 0;
		// ���⿡ ���丮 �ĺ����� ��� ����
		ArrayList<String> dirList = new ArrayList<>();

		// ���ø����� �ɰ��� ��� ������ �������� ������Ƿ� �󺧸�
		for (int i = 0; i < location.length; i++) {
			location[i] += "@";
			// System.out.println(location[i]);
		}

		// �� ��� ���ڿ��� ���丮�� ��� ����
		for (int i = 0; i < location.length; i++) {
			// �ϳ��� ���ڿ��� ���ø����� �ɰ���
			// ���������� ������ ���´�
			// �տ��� @�� �󺧸��Ͽ��� ������
			// �������� �����ϸ� ��� ������ �ȴ�.
			String[] lot = location[i].split("/");
			// System.out.println(lot[0]);

			String tmp = "";
			// �ϳ��� ��θ� ������ ����
			for (int j = 0; j < lot.length; j++) {
				// ����� �������� �ƴϰ�
				if (!lot[j].endsWith("@")) {
					// ������� ������
					if (!tmp.equals("")) {
						// �������� �����Ͽ� �κ� ��θ� �����
						tmp += "/";
					}
					// �κа�θ� �ϼ��Ѵ�
					tmp += lot[j];
					//System.out.print(tmp + " ");
				}

				// ����Ʈ�� ������ �߰�
				if (!dirList.contains(tmp)) {
					dirList.add(tmp);
				}
			}
			//System.out.println();
		}

		// ���丮 �ĺ� �迭�� ũ�Ⱑ ����
		answer = dirList.size();
		System.out.println("����� ������ : " + answer);
		return answer;
	}
}
