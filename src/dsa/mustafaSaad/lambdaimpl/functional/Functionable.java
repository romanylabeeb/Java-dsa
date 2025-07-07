package dsa.mustafaSaad.lambdaimpl.functional;

@FunctionalInterface
public interface Functionable<T,R> {
    // functional
    R applyThis(T t);
}
