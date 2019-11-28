package chapter08;

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		// ��ͳ��ʽʵ�ֺ���ʽ�ӿ��еĳ��󷽷�
		FIConverter<String, Integer> converter1 = new FIConverter<String, Integer>() {
			@Override
			public Integer convert(String from) {
				return Integer.valueOf(from);
			}
		};
		// ����convert()���������ַ���ת��������
		Integer a = converter1.convert("88");
		System.out.println(a);

		// Lambda���ʽ��ʽʵ�ֺ���ʽ�ӿ��еĳ��󷽷�
		FIConverter<String, Integer> converter2 = (from) -> Integer
				.valueOf(from);
		Integer b = converter2.convert("123");
		System.out.println(b);

		System.out.println(a + b);
	}

}
