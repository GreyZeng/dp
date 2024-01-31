package Iterator;

import static java.lang.System.arraycopy;

/**
 * @author Grey
 * @param <E>
 * @date 2020/4/15
 */
public class ArrayList_<E> implements Collection_<E> {
    private E[] objects = (E[]) new Object[10];
    private int index = 0;

    @Override
    public int size() {
        return index;
    }

    @Override
    public void add(E element) {
        if (objects.length == size()) {
            // 满了就扩容为原来的两倍
            E[] newObjects = (E[]) new Object[objects.length * 2];
            arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index] = element;
        index++;
    }

    @Override
    public Iterator_<E> iterator() {
        return new ArrayListIterator_<>();
    }

    private class ArrayListIterator_<E> implements Iterator_<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < index;
        }

        @Override
        public E next() {
            E o = (E) objects[currentIndex];
            currentIndex++;
            return o;
        }
    }

}
