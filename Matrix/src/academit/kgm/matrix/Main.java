package academit.kgm.matrix;


import academit.kgm.vector.Vector;


public class Main {
    public static void main(String[] args) {
        Matrix x1 = new Matrix(3, 2);
        System.out.println(x1.toString());

        Matrix x2 = new Matrix(x1);
        System.out.println(x2.toString());

        double[][] temp1 = {{5, 8}, {88, 5, 47}, {1, 1, 1, 1}};
        Matrix x3 = new Matrix(temp1);
        System.out.println(x3.toString());

        double[] temp2 = {5, 8, 81};
        double[] temp3 = {5, 81, 5, 99, 99};
        double[] temp4 = {5};
        Vector[] vectorArray = {new Vector(temp2), new Vector(temp3), new Vector(temp4)};
        Matrix x4 = new Matrix(vectorArray);
        Vector v1 = new Vector(temp4);
        System.out.println(x4.toString());
        System.out.println(x4.getNumberOfRows());
        System.out.println(x4.getNumberOfColumns());
        System.out.println(x4.getSize().toString());
        System.out.println(x4.getRow(0).toString());
        x4.setMatrixRow(0, v1);
        System.out.println(x4.toString());

        System.out.println();

        System.out.println(x4.getColumn(2).toString());

        double[] temp5 = {5, 8, 81};
        double[] temp6 = {5, 81, 5, 99, 99};
        double[] temp7 = {5};

        Vector[] vectorArray1 = {new Vector(temp5), new Vector(temp6), new Vector(temp7)};
        Matrix x5 = new Matrix(vectorArray1);
        System.out.println(x5.toString());
        System.out.println(x5.transMatrix().toString());

        System.out.println(x5.multiply(2).toString());

        double[] det0 = {2, -3, 4, 1};
        double[] det1 = {4, 0, 3, 2};
        double[] det2 = {-4, 1, 2, -2};
        double[] det3 = {3, -1, 4, 3};
        Vector[] vectorDet = {new Vector(det0), new Vector(det1), new Vector(det2), new Vector(det3)};
        Matrix matrix1 = new Matrix(vectorDet);
        double x = matrix1.getDet();
        System.out.println(x);
        System.out.println(matrix1.toString());


    }
}
