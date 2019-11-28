package chapter08;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

//�����������
public class ParallelArraysDemo {

	public static void main(String[] args) {
		// ����һ������Ϊ20000������
		Integer[] arrayOfLong = new Integer[20000];
		// ʹ��parallelSetAll()������������и�ֵ
		Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current()
				.nextInt(1000000));

		// ���ǰʮ����
		System.out.println("δ�����ǰ10������");
		Arrays.stream(arrayOfLong).limit(10)
				.forEach(i -> System.out.print(i + " "));
		System.out.println();

		// ʹ��parallelSort()�����������������
		Arrays.parallelSort(arrayOfLong);
		// ���ǰʮ����
		System.out.println("������ǰ10������");
		Arrays.stream(arrayOfLong).limit(10)
				.forEach(i -> System.out.print(i + " "));
		System.out.println();

		// ������ת����List����
		List<Integer> list = Arrays.asList(arrayOfLong);
		// ����������ż����������з���
		Map<Boolean, List<Integer>> groupByOdd = list.parallelStream().collect(
				Collectors.groupingBy(x -> x % 2 == 0));
		// ���ǰ10������
		System.out.println("ǰ10��������");
		groupByOdd.get(false).parallelStream().limit(10)
				.forEach(i -> System.out.print(i + " "));
		System.out.println();
		// ���ǰ10��ż��
		System.out.println("ǰ10��������");
		groupByOdd.get(true).parallelStream().limit(10)
				.forEach(i -> System.out.print(i + " "));
		System.out.println();

		System.out.println("ǰ10��5�ı�����");
		// ��������й��ˣ����˳�5�ı���,�����ǰ10��
		list.parallelStream().filter(x -> x % 5 == 0).limit(10)
				.forEach(i -> System.out.print(i + " "));
		System.out.println();
	}

}
