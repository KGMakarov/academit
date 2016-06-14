package academit.kgm.matrix;


import academit.kgm.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix x1 = new Matrix(3, 4);
        System.out.println(x1.toString());

        Matrix x2 = new Matrix(x1);
        System.out.println(x2.toString());

        double[][] temp1 = {{5, 8}, {88, 5, 47}, {1, 1, 1, 1}};
        Matrix x3 = new Matrix(temp1);
        System.out.println(x3.toString());

        double[] temp2 = {5, 8};
        double[] temp3 = {5, 81, 5};
        double[] temp4 = {5, 8, 8, 8};
        Vector[] vectorArray = {new Vector(temp2), new Vector(temp3), new Vector(temp4)};
        Matrix x4 = new Matrix(vectorArray);
        System.out.println(x4.toString());

    }
}
