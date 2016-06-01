package academit.kgm.vector;

import java.util.Arrays;

/**
 * Created by ROCKfeller on 31.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(10);
        System.out.println(vector1.toString());

        Vector vector2 = new Vector(vector1);
        System.out.println(vector2.toString());

        double [] temp = {1, 5, 10, 88};

        Vector vector3 = new Vector(6, temp);
        System.out.println(vector3.toString());

        Vector vector4 = new Vector(vector3);
        System.out.println(vector4.toString());
        System.out.println(vector4.getSize());
    }
}
