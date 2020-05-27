
import java.util.Comparator;
import java.util.PriorityQueue;

// �̷��� ������ �̸��� string �迭�� �־����� ���� ��ǥ�� [x,y]���� �迭�� �־���. �б��� 0,0 �̶�� ������
// �����Ÿ��� �б����� �������� �Ÿ�(x,y�������Ѱ�), ������ 1.0~4.5���� �־���.
// �켱������ ���� -> �� -> �̸����ε� ������ �����κ� ���ڸ� ��. ������ 3.8�ξֶ� 3.2�ξֶ��� ���������� ������ ����.
// �׸��� ������ �������� �Ÿ��� �վְ� �켱�̰� �Ÿ��� �������� �̸� ���������� �켱������ ����.
// �켱������� index�� ���� int �迭�� return��!!

public class Dormitory {
	public static void main(String[] args) {
		String[] strs = { "ada", "bbb", "aad", "aab" };
		int[][] numss = { { 5, 2 }, { 2, 5 }, { 4, 4 }, { 5, 5 } };
		double[] dums = { 3.5, 4.1, 3.0, 3.2 };
		Dormitory.solution(strs, numss, dums);
	}

	// ����(����), �Ÿ�(����), �̸� �� ����
	public static int[] solution(String[] names, int[][] homes, double[] scores) {
		int[] answer = new int[names.length];

		// �켱����ť�� �����ϸ鼭 ���� ��Ģ�� ���Ѵ�.
		// ��ȯ���� ������ ��� ���������� �ö󰣴�.
		PriorityQueue<Student> pq = new PriorityQueue<Student>(new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				int ret = 0;
				if (s1.score < s2.score) {
					ret = 1;
				} else if (s1.score == s2.score) {
					if (s1.distance < s2.distance) {
						ret = 1;
					} else if (s1.distance == s2.distance) {
						if (s1.name.compareTo(s2.name) < 0) {
							ret = -1;
						} else if (s1.name.compareTo(s2.name) == 0) {
							ret = 0;
						} else if (s1.name.compareTo(s2.name) > 0) {
							ret = 1;
						}
					} else if (s1.distance > s2.distance) {
						ret = -1;
					}
				} else if (s1.score > s2.score) {
					ret = -1;
				}
				return ret;
			}
		});

		// �ĺ� ũ�⸸ŭ �л� ��ü�� �����
		// �켱����ť�� �ִ´�.
		for (int i = 0; i < answer.length; i++) {
			int score = getScore(scores[i]);
			int distance = getDistance(homes[i][0], homes[i][1]);
			Student std = new Student(score, distance, names[i], i + 1);
			pq.offer(std);
		}

		// �ĺ� ũ�⸸ŭ �켱�������� ���鼭 �л� ��ü�� ������ �����´�.
		// �л���ü�� index�� �о �־��ָ� ��
		// ���� ���� �л��� �켱������ ����
		for (int i = 0; i < answer.length; i++) {
			Student s = pq.poll();
			System.out.println("idx: " + s.index + " score: " + s.score + " dist: " + s.distance + " name: " + s.name);
			answer[i] = s.index;
			// System.out.println(answer[i]);
		}

		return answer;
	}

	// �л� ������ ��ü�� ����
	public static class Student {
		int score;
		int distance;
		String name;
		int index;

		Student(int score, int distance, String name, int index) {
			this.score = score;
			this.distance = distance;
			this.name = name;
			this.index = index;
		}

	}

	// ���� ���� ���ϱ�
	// ������ �ʿ��ϹǷ� int �� �ٲٸ� �ȴ�.
	public static int getScore(double insScore) {
		int outScore = 0;
		outScore = (int) insScore;

		return outScore;
	}

	// �Ÿ� ���ϱ�
	// 0, 0�� �������� �ϹǷ� �ﰢ���� �밢���� ���ϸ� �ȴ�.
	public static int getDistance(int insDistanceA, int insDistanceB) {
		int outDistance = 0;
		outDistance = (int) Math.sqrt(insDistanceA * insDistanceA + insDistanceB * insDistanceB);

		return outDistance;
	}

}
