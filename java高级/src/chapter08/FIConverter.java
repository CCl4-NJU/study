package chapter08;


@FunctionalInterface
public interface FIConverter<F, T> {
	T convert(F from);
}
