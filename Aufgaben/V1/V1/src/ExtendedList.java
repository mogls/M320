import java.util.AbstractList;

public class ExtendedList<E> extends AbstractList<E> {

    private E[] array;

    public ExtendedList(E[] array) {
        this.array = array;
    }

    @Override
    public boolean add(E e) {
        return super.add(e);
    }

    @Override
    public E get(int index) {
        return this.array[index];
    }

    @Override
    public E remove(int index) {
        return super.remove(index);
    }

    @Override
    public int size() {
        return array.length;
    }
}