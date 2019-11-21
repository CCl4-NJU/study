package com.qst.chapter07;

import java.util.Locale;

public class LocaleDemo {

	public static void main(String[] args) {
		// 返回Java所支持的全部国家和语言的数组
		Locale[] localeList = Locale.getAvailableLocales();
		// 遍历数组的每个元素，依次获取所支持的国家和语言
		for (int i = 0; i < localeList.length ; i++ )
		{
			// 输出出所支持的国家和语言
			System.out.println(localeList[i].getDisplayCountry()
				+ "=" + localeList[i].getCountry()+ " "
				+ localeList[i].getDisplayLanguage()
				+ "=" + localeList[i].getLanguage());
		}
		// 获取缺省Locale信息
		Locale locale = Locale.getDefault();
		// 语言代码
		System.out.println("Language        : " + locale.getLanguage());
		// 国家代码
		System.out.println("Country         : " + locale.getCountry());
		// 语言显示名称
		System.out.println("DisplayLanguage : " + locale.getDisplayLanguage());
		// 国家显示名称
		System.out.println("DisplayCountry  : " + locale.getDisplayCountry());
		System.out.println("locale : " + locale);
		Locale newLocale = new Locale("en", "US");
		// 重设缺省Locale信息
		Locale.setDefault(newLocale);
		locale = Locale.getDefault();
		System.out.println("Language        : " + locale.getLanguage());
		System.out.println("Country         : " + locale.getCountry());
		System.out.println("DisplayLanguage : " + locale.getDisplayLanguage());
		System.out.println("DisplayCountry  : " + locale.getDisplayCountry());
		System.out.println("locale : " + locale);
	}

}
