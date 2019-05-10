//import java.util.Iterator;
//import java.util.NoSuchElementException;

public interface Dictionary<E>{

    boolean isEmpty();

    boolean contains(E item);

    boolean hasPredecessor(E item);

    boolean hasSuccessor(E item);

    boolean add(E item);

    boolean delete(E item);

    //Iterator<E> iterator();

    //Iterator<E> iterator(E start);

    //String getLogString();

    String toString();

}