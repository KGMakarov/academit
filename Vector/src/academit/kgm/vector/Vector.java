package academit.kgm.vector;


/**
 * Created by ROCKfeller on 31.05.2016.
 */
public class Vector {
    private double[] vectorValue;

    public Vector(int n) {
        if (n <= 0) {
            System.out.println("IllegalArgumentException");
        } else {
            this.vectorValue = new double[n];
        }
    }

    public Vector(Vector vector) {
        this.vectorValue = vector.vectorValue;
    }

    public Vector(int n, double[] vectorValue) {
        if (n <= 0) {
            System.out.println("IllegalArgumentException");
        } else {
            this.vectorValue = new double[n];
            System.arraycopy(vectorValue, 0, this.vectorValue, 0, vectorValue.length);

            /*for (int i = 0; i < vectorValue.length; i++) {
                this.vectorValue[i] = vectorValue[i];
            }*/
        }
    }

    public int getSize() {
        return this.vectorValue.length;
    }

    public String toString() {
        String stringVector = "{";
        for (int i = 0; i < this.vectorValue.length; ++i) {
            if (i != this.vectorValue.length - 1) {
                stringVector = stringVector + this.vectorValue[i] + ", ";
            } else {
                stringVector = stringVector + this.vectorValue[i] + "}";
            }
        }
        return stringVector;
    }

    private boolean isEqualVectorsSize(double[] first, double[] second) {
        return first.length == second.length;
    }

    private double[] convertLeastVector(double[] first, double[] second) {
        if (first.length > second.length) {
            double[] newLeastVector = new double[first.length];
            System.arraycopy(second, 0, newLeastVector, 0, second.length);
        } else {
            double[] newLeastVector = new double[second.length];
            System.arraycopy(first, 0, newLeastVector, 0, first.length);
        }
        return
    }

    public Vector getSum(Vector vector) {
        if (this.vectorValue.length)
    }
}