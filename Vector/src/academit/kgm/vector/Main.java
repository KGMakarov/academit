package academit.kgm.vector;


/**
 * Created by ROCKfeller on 31.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(2);
        System.out.println(vector1.toString());


       Vector vector2 = new Vector(vector1);
        System.out.println(vector2.toString());

        double [] temp1 = {1, 5, 10, 88};
        double [] temp2 = {2, 3};

        Vector vector3 = new Vector(4, temp1);
        System.out.println(vector3.toString());
        Vector vector4 = new Vector(2, temp2);
        System.out.println(vector4.toString());

        System.out.println(vector3.getSum(vector4).toString());

    }
}
