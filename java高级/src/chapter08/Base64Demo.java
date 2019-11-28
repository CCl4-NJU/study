package chapter08;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Demo {

	public static void main(String[] args) {
		// ����һ���ַ���
		String text = "Base64 class in Java 8!";

		// Base64����
		String encoded = Base64.getEncoder()
				.encodeToString(text.getBytes(StandardCharsets.UTF_8));
		System.out.println(encoded);

		// Base64����
		String decoded = new String(
				Base64.getDecoder().decode(encoded),
				StandardCharsets.UTF_8);
		System.out.println(decoded);
	}

}
