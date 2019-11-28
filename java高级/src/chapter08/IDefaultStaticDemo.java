package chapter08;

public class IDefaultStaticDemo {
	public static void main(String[] args) {
		//����ֱ�ӷ��ʽӿڵľ�̬����
		System.out.println(IDefaultStatic.msg());
		//����IDefaultStatic�ӿڶ��󣬲�ʵ�ָýӿ��еĳ��󷽷�
		IDefaultStatic ids1=new IDefaultStatic(){
			@Override
			public double calculate(int a) {
				//��ʵ�����п���ֱ��ʹ��Ĭ�Ϸ���
				return this.sqrt(a*100);
			}
		};
		//ͨ���ӿ�ʵ����Ķ������Ĭ�Ϸ���
		System.out.println(ids1.sqrt(16));
		//ͨ���ӿ�ʵ����Ķ�����ó��󷽷�
		System.out.println(ids1.calculate(16));
		System.out.println("--------------------");
		
		//����IDefaultStatic�ӿڶ��󣬲�ʵ�ָýӿ��еĳ��󷽷�,����дĬ�Ϸ���
		IDefaultStatic ids2=new IDefaultStatic(){
			//ʵ�ֳ��󷽷�
			@Override
			public double calculate(int a) {
				//��ʵ�����п���ֱ��ʹ��Ĭ�Ϸ���
				return this.sqrt(a*100);
			}
			//��дĬ�Ϸ���
			@Override
			public double sqrt(int a) {
				return IDefaultStatic.super.sqrt(a*10000);
			}
		};
		//ͨ���ӿ�ʵ����Ķ������Ĭ�Ϸ���
		System.out.println(ids2.sqrt(16));
		//ͨ���ӿ�ʵ����Ķ�����ó��󷽷�
		System.out.println(ids2.calculate(16));

	}

}
