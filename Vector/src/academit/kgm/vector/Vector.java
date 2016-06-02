package academit.kgm.vector;


/**
 * Created by ROCKfeller on 31.05.2016.
 */
public class Vector {
    private double[] vectorValue;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна 0");
        }
        this.vectorValue = new double[n];
    }

    public Vector(Vector vector) {
        this.vectorValue = new double[vector.vectorValue.length];
        System.arraycopy(vector.vectorValue, 0, this.vectorValue, 0, vector.vectorValue.length);
    }

    public Vector(int n, double[] vectorValue) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна 0");
        } else {
            this.vectorValue = new double[n];
            System.arraycopy(vectorValue, 0, this.vectorValue, 0, vectorValue.length);
        }
    }

    public int getSize() {
        return this.vectorValue.length;
    }

    public String toString() {
        StringBuilder stringVector = new StringBuilder("{");
        for (int i = 0; i < this.vectorValue.length; ++i) {
            if (i != this.vectorValue.length - 1) {
                stringVector.append(this.vectorValue[i]).append(", ");
            } else {
                stringVector.append(this.vectorValue[i]).append("}");
            }
        }
        return stringVector.toString();
    }

    private boolean isEqualVectorsSize(double[] first, double[] second) {
        return first.length == second.length;
    }

    private double[] convertLeastVector(double[] maxVector, double[] minVector) {
        double[] newLeastVector = new double[maxVector.length];
        System.arraycopy(minVector, 0, newLeastVector, 0, minVector.length);
        return newLeastVector;
    }

    private double[] getSumFor(double[] first, double[] second) {
        for (int i = 0; i < first.length; ++i) {
            first[i] = first[i] + second[i];
        }
        return first;
    }

    public Vector getSum(Vector vector) {
        if (isEqualVectorsSize(this.vectorValue, vector.vectorValue)) {
            this.vectorValue = getSumFor(this.vectorValue, vector.vectorValue);
        } else if (this.vectorValue.length > vector.vectorValue.length) {
            vector.vectorValue = convertLeastVector(this.vectorValue, vector.vectorValue);
            this.vectorValue = getSumFor(this.vectorValue, vector.vectorValue);
        } else {
            this.vectorValue = convertLeastVector(vector.vectorValue, this.vectorValue);
            this.vectorValue = getSumFor(this.vectorValue, vector.vectorValue);
        }
        return this;
    }
}