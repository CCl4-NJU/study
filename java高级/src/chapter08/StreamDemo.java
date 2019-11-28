package chapter08;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



//ö��Status
enum Status {
	OPEN, CLOSED
}

// ������Task
class Task {
	private final Status status;// ״̬
	private final Integer points;// ���������Ӷȣ�

	Task(final Status status, final Integer points) {
		this.status = status;
		this.points = points;
	}

	public Integer getPoints() {
		return points;
	}

	public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return String.format("[%s, %d]", status, points);
	}
}

public class StreamDemo {

	public static void main(String[] args) {
		Collection<Task> tasks = Arrays.asList(
				new Task(Status.OPEN, 5),
				new Task(Status.OPEN, 13),
				new Task(Status.CLOSED, 8));

		// ʹ�ô�ͳ��ʽͳ��״̬ΪOPEN�������ܷ�
		int sum = 0;
		for (Task t : tasks) {
			if (t.getStatus() == Status.OPEN) {
				sum += t.getPoints();
			}
		}
		System.out.println("forѭ��ͳ��״̬ΪOPEN�������ܷ�Ϊ��" + sum);

		// ʹ��Stream����ʽͳ��״̬ΪOPEN�������ܷ�
		int totalPointsOfOpenTasks = tasks.stream()
				.filter(t -> t.getStatus() == Status.OPEN)
				.mapToInt(Task::getPoints).sum();

		System.out.println("ʹ��Stream����ʽͳ��״̬ΪOPEN�������ܷ�Ϊ��"
				+ totalPointsOfOpenTasks);

		// ʹ��Stream����ʽ�������������ܷ�
		int totalPoints = tasks.stream()
				.parallel()
				.map(Task::getPoints)
				.reduce(0, Integer::sum);

		System.out.println("���������ܷ�: " + totalPoints);

		// ����״̬���з���
		Map<Status, List<Task>> map = tasks.stream()
				.collect(Collectors.groupingBy(Task::getStatus));
		System.out.println(map);

	}

}
