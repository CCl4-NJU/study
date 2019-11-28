package chapter08;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo2 {

	public static void main(String[] args) {

		List<String> arrNames1 = Arrays.asList("QST����ʵѵ", "��ƸѧԺ", "��֪����",
				"������Դ����", "��ӭ��");
		// ��дComparator�ӿ��е�compare()����ʵ������
		Collections.sort(arrNames1, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
		// ʹ��Lambda���ʽ�������
		arrNames1.forEach((x) -> System.out.println(x));
		System.out.println("----------------------------------");

		List<String> arrNames2 = Arrays.asList("QST����ʵѵ", "��ƸѧԺ", "��֪����",
				"������Դ����", "��ӭ��");
		// ʹ��Lambda���ʽ�򻯷�������д
		Collections.sort(arrNames2, (a, b) -> b.compareTo(a));
		arrNames2.forEach((x) -> System.out.println(x));
	}
}
