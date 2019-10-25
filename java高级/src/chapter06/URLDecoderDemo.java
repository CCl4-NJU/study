package chapter06;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderDemo {

	public static void main(String[] args) {
		try {
			// 将普通字符串转换成application/x-www-form-urlencoded字符串
			String urlStr = URLEncoder.encode("Java 8高级应用与开发", "GBK");
			System.out.println(urlStr);

			// 将application/x-www-form-urlencoded字符串 转换成普通字符串
			String keyWord = URLDecoder.decode(
					"Java+8%B8%DF%BC%B6%D3%A6%D3%C3%D3%EB%BF%AA%B7%A2", "GBK");
			System.out.println(keyWord);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
