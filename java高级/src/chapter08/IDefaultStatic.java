package chapter08;

public interface IDefaultStatic {
	// ���󷽷�
	double calculate(int a);

	// Ĭ�Ϸ���
	default double sqrt(int a) {
		return Math.sqrt(a);
	}

	// ��̬����
	static String msg() {
		return "�ӿ��еľ�̬����";
	}

}
