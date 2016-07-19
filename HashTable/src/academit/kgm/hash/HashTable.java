package academit.kgm.hash;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HashTable<E> implements Collection<E> {

    private ArrayList<E>[] hashTable;

    public HashTable(int capacity) {
        //noinspection unchecked
        this.hashTable = new ArrayList[capacity];
    }

    public HashTable() {
        this(10);
    }

    private int getIndex(int hashCode, int arrayCapacity) {
        return Math.abs(hashCode % arrayCapacity);
    }


    @Override
    public int size() {
        int size = 0;
        for (ArrayList<E> currentElement : this.hashTable) {
            if (currentElement != null) {
                size = size + currentElement.size();
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (ArrayList<E> currentElement : this.hashTable) {
            if (currentElement != null && !currentElement.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        int index = getIndex(o.hashCode(), this.hashTable.length);
        return this.hashTable[index].contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] hashToArray = new Object[this.size()];
        int k = 0;
        for (ArrayList<E> currentElement : this.hashTable) {
            if (currentElement != null && !currentElement.isEmpty()) {
                for (int i = 0; i < currentElement.size(); ++i) {
                    hashToArray[k] = currentElement.get(i);
                    k++;
                }
            }

        }
        return hashToArray;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(E t) {
        int index = getIndex(t.hashCode(), this.hashTable.length);
        if (this.hashTable[index] == null) {
            ArrayList<E> tempList = new ArrayList<>();
            this.hashTable[index] = tempList;
            this.hashTable[index].add(t);
        } else {
            this.hashTable[index].add(t);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = getIndex(o.hashCode(), this.hashTable.length);
        return this.hashTable[index].remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for ( Iterator <?> iterator = c.iterator(); iterator.hasNext();){
            <?> = // как здесь быть? выходит непонять какая коллекция непонять каких объектов, как взять текущий элемент?
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
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
