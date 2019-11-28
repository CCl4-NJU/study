package chapter08;

//���庯��ʽ�ӿ�
@FunctionalInterface
public interface FIConverter<F, T> {
	T convert(F from);
}
