package chapter07;

public class SeasonEnum2Demo {
	public static void main(String[] args) {
		System.out.println("SeasonEnum2枚举类的所有实例值：");
		// 枚举类默认有一个values方法，返回该枚举类的所有实例值
		for (SeasonEnum2 s : SeasonEnum2.values()) {
			System.out.println(s);
		}
		System.out.println("---------------------");

		// 使用valueOf()方法获取指定的实例
		SeasonEnum2 se = SeasonEnum2.valueOf("SUMMER");
		// 输出se
		System.out.println(se);
		// 调用judge()方法
		judge(se);
		System.out.println("---------------------");

		// 定义一个枚举类对象,并直接赋值
		SeasonEnum2 season = SeasonEnum2.WINTER;
		// 输出season
		System.out.println(season);

		// 调用judge()方法
		judge(season);

	}

	// 判断季节并输出
	private static void judge(SeasonEnum2 season) {
		// 使用switch语句判断枚举值
		switch (season) {
		case SPRING:
			System.out.println("春暖花开，正好踏青");
			break;
		case SUMMER:
			System.out.println("夏日炎炎，适合游泳");
			break;
		case FALL:
			System.out.println("秋高气爽，进补及时");
			break;
		case WINTER:
			System.out.println("冬日雪飘，围炉赏雪");
			break;
		}
	}

}
