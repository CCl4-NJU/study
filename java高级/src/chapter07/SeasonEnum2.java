package chapter07;

//带构造方法的枚举类
public enum SeasonEnum2 {
	// 在第一行列出4个枚举实例:春、夏、秋、冬
	SPRING("春"), SUMMER("夏"), FALL("秋"), WINTER("冬");
	// 定义一个属性
	private String name;

	// 构造方法
	SeasonEnum2(String name) {
		this.name = name;
	}

	// 方法
	public String toString() {
		return this.name;
	}
}
