package academit.kgm.hash;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HashTable<T> implements Collection<T> {

    private ArrayList<T>[] hashTable;

    public HashTable() {
        //noinspection unchecked
        this.hashTable = new ArrayList[10];
    }

    public HashTable(int capacity) {
        //noinspection unchecked
        this.hashTable = new ArrayList[capacity];
    }

    public void addElement(T element) {
        int index = Math.abs(element.hashCode() % this.hashTable.length);
        if (this.hashTable[index] == null) {
            ArrayList<T> tempList = new ArrayList<>();
            this.hashTable[index] = tempList;
            this.hashTable[index].add(element);
        } else {
            this.hashTable[index].add(element);
        }
    }

    @Override
    public int size() {
        int size = 0;
        for (ArrayList<T> currentElement : this.hashTable) {
            if (currentElement != null) {
                size = size + currentElement.size();
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        int index = Math.abs(o.hashCode() % this.hashTable.length);
        return this.hashTable[index].contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int index = Math.abs(o.hashCode() % this.hashTable.length);
        return this.hashTable[index].remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
