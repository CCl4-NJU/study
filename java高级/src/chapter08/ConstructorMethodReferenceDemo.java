package chapter08;

//��Ʒ��Product
class Product {
	String name; // ����
	int quantity; // ����

	Product() {
	}

	Product(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "��Ʒ��" + this.name + " ������" + this.quantity;
	}
}

// �Ӳ�Ʒ��ChildP�̳�Product
class ChildP extends Product {
	ChildP() {
	}

	ChildP(String name, int quantity) {
		super(name, quantity);
	}

	@Override
	public String toString() {
		return "�Ӳ�Ʒ��" + this.name + " ������" + this.quantity;
	}
}

// ��Ʒ����������ʽ�ӿڣ�
@FunctionalInterface
interface ProductFactory<P extends Product> {
	P create(String name, int quantity);
}

public class ConstructorMethodReferenceDemo {

	public static void main(String[] args) {
		ProductFactory<Product> productFactory = Product::new;
		Product p1 = productFactory.create("��ӡ��", 1000);
		System.out.println(p1);

		ProductFactory<ChildP> childPFactory = ChildP::new;
		ChildP p2 = childPFactory.create("��ӡ��", 100);
		System.out.println(p2);
	}

}
