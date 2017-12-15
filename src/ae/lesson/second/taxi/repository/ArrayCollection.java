package ae.lesson.second.taxi.repository;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

public class ArrayCollection<Item> implements Collection<Item>, Serializable {

    class Iterator implements java.util.Iterator<Item> {

        protected int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[current++];
        }
    }

    protected final int defaultCapacity = 10;

    protected int capacity = defaultCapacity;
    private int size = 0;

    protected Item[] items;

    ArrayCollection() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) throw new NullPointerException();

        for (int i = 0; i < size(); i++) {
            if (items[i].equals(o)) return true;
        }

        return false;
    }

    public java.util.Iterator<Item> iterator() {
        return new Iterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) toArray();
    }

    @Override
    public boolean add(Item item) {
        if (size == capacity) increaseCapacity();
        items[size++] = item;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size(); i++) {
            if (items[i].equals(o)) return true;
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int count = 0;
        for (Object cItem : c) {
            if (contains(cItem)) count++;
        }

        return count == c.size();
    }

    @Override
    public boolean addAll(Collection<? extends Item> c) {
        for (Object cItem : c) add((Item) cItem);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object cItem : c) remove(cItem);
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        size = 0;
        capacity = defaultCapacity;
        items = (Item[]) new Object[capacity];
    }

    protected void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

}
