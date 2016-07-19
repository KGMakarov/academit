package academit.kgm.hash;


import academit.kgm.vector.Vector;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(5);
        Vector vector2 = new Vector(8);
        Vector vector3 = new Vector(5);

        HashTable<Vector> vectorHashTable = new HashTable<>();
        vectorHashTable.add(vector1);
        vectorHashTable.add(vector2);
        vectorHashTable.add(vector3);

        System.out.println(Arrays.toString(vectorHashTable.toArray()));

        System.out.println(vector1.hashCode());
        System.out.println(vector3.hashCode());

        System.out.println(vectorHashTable.contains(vector1));
        System.out.println(vectorHashTable.size());
        System.out.println(vectorHashTable.remove(vector1));
        System.out.println(vectorHashTable.contains(vector1));
        System.out.println(vectorHashTable.remove(vector1));
        System.out.println(vectorHashTable.contains(vector1));
        System.out.println(vectorHashTable.size());
        System.out.println(Arrays.toString(vectorHashTable.toArray()));
    }
}
