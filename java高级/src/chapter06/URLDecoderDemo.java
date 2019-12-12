package chapter06;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderDemo {

	public static void main(String[] args) {
		try {
			// 将普通字符串转换成application/x-www-form-urlencoded字符串
			String urlStr = URLEncoder.encode("Java 8高级应用与开发", "UTF-8");
			System.out.println(urlStr);

			// 将application/x-www-form-urlencoded字符串 转换成普通字符串
			String keyWord = URLDecoder.decode(
					"Java+8%E6%A5%82%E6%A8%BC%E9%AA%87%E6%90%B4%E6%97%82%E6%95%A4%E6%B6%93%E5%BA%A1%E7%B4%91%E9%8D%99%EF%BF%BD", "UTF-8");
			System.out.println(keyWord);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
