package academit.kgm.vector;


/**
 * Created by ROCKfeller on 31.05.2016.
 */
public class Vector {
    private double[] vectorValue;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна 0");
        }
        this.vectorValue = new double[size];
    }

    public Vector(Vector vector) {
        this.vectorValue = new double[vector.vectorValue.length];
        System.arraycopy(vector.vectorValue, 0, this.vectorValue, 0, vector.vectorValue.length);
    }

    public Vector(int size, double[] vectorValue) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна 0");
        }
        this.vectorValue = new double[size];
        System.arraycopy(vectorValue, 0, this.vectorValue, 0, vectorValue.length);
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

    private static double[] convertLeastVector(double[] maxVector, double[] minVector) {
        double[] newLeastVector = new double[maxVector.length];
        System.arraycopy(minVector, 0, newLeastVector, 0, minVector.length);
        return newLeastVector;
    }

    private static double[] getSumFor(double[] first, double[] second) {
        for (int i = 0; i < Math.min(first.length, second.length); ++i) {
            first[i] = first[i] + second[i];
        }
        return first;
    }

    private static double[] getSubFor(double[] first, double[] second) {
        for (int i = 0; i < Math.min(first.length, second.length); ++i) {
            first[i] = first[i] - second[i];
        }
        return first;
    }


    public Vector getSum(Vector vector) {
        if (this.vectorValue.length >= vector.vectorValue.length) {
            this.vectorValue = getSumFor(this.vectorValue, vector.vectorValue);
        } else {
            this.vectorValue = convertLeastVector(vector.vectorValue, this.vectorValue);
            this.vectorValue = getSumFor(this.vectorValue, vector.vectorValue);
        }
        return this;
    }

    public Vector getSub(Vector vector) {
        if (this.vectorValue.length >= vector.vectorValue.length) {
            this.vectorValue = getSubFor(this.vectorValue, vector.vectorValue);
        } else {
            this.vectorValue = convertLeastVector(vector.vectorValue, this.vectorValue);
            this.vectorValue = getSubFor(this.vectorValue, vector.vectorValue);
        }
        return this;
    }

    public Vector getMultiplication(int x) {
        for (int i = 0; i < this.vectorValue.length; ++i) {
            this.vectorValue[i] = this.vectorValue[i] * x;
        }
        /* for (double currentElement : this.vectorValue) {
            currentElement = currentElement * x;
        }*/
        return this;
    }

    public Vector getVectorSpread (){
        for (int i = 0; i < this.vectorValue.length; ++i) {
            this.vectorValue[i] = this.vectorValue[i] * -1;
        }
        return this;
    }
}