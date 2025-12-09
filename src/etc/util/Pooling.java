package etc.util;

public interface Pooling<E> {

  E get();

  void revert(E thread);

}
