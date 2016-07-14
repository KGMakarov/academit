package academit.kgm.hash;


import academit.kgm.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(5);
        Vector vector2 = new Vector(8);
        Vector vector3 = new Vector(5);

        HashTable<Vector> vectorHashTable = new HashTable<>();
        vectorHashTable.addElement(vector1);
        vectorHashTable.addElement(vector2);
        vectorHashTable.addElement(vector3);

        System.out.println(vectorHashTable.contains(vector1));
        System.out.println(vectorHashTable.size());
        System.out.println(vectorHashTable.remove(vector1));
        System.out.println(vectorHashTable.contains(vector1));
        System.out.println(vectorHashTable.remove(vector1));
        System.out.println(vectorHashTable.contains(vector1));
        System.out.println(vectorHashTable.size());
    }
}
