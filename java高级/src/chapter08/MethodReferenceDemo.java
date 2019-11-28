package chapter08;

public class MethodReferenceDemo {

	public static void main(String[] args) {
		// Lambda���ʽ��ʽʵ�ֺ���ʽ�ӿ��еĳ��󷽷�
		FIConverter<String, Integer> converter1 = (from) -> Integer
				.valueOf(from);
		Integer a = converter1.convert("123");
		System.out.println(a);

		// ::�������õķ�ʽ
		FIConverter<String, Integer> converter2 = Integer::valueOf;
		Integer b = converter2.convert("456");
		System.out.println(b);

		System.out.println(a + b);
	}

}
