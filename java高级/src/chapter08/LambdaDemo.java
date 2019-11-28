package chapter08;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {
	public static void main(String[] args) {

		String[] names = { "QST����ʵѵ", "��ƸѧԺ", "��֪����", "������Դ����", "��ӭ��" };
		List<String> arrNames = Arrays.asList(names);

		// ��ͳ��ѭ����ʽ
		System.out.println("��ͳ��ѭ����ʽ���:");
		for (String name : arrNames) {
			System.out.println(name);
		}
		System.out.println("--------------------------");

		// �� Java 8 ��ʹ�� Lambda���ʽ���
		System.out.println("ʹ�� Lambda���ʽ���:");
		arrNames.forEach((name) -> System.out.println(name));
		System.out.println("--------------------------");

		// �� Java 8 ��ʹ��˫ð�Ų�����::
		arrNames.forEach(System.out::println);

	}

}
