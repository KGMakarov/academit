package academit.kgm.vector;

import java.util.Arrays;

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
        int numberOfIteration = Math.min(first.length, second.length);
        if (first.length >= second.length) {
            for (int i = 0; i < numberOfIteration; ++i) {
                first[i] = first[i] + second[i];
            }
            return first;
        } else {
            for (int i = 0; i < numberOfIteration; ++i) {
                second[i] = second[i] + first[i];
            }
            return second;
        }
    }

    private static double[] getSubFor(double[] first, double[] second) {
        int numberOfIteration = Math.min(first.length, second.length);
        for (int i = 0; i < numberOfIteration; ++i) {
            first[i] = first[i] - second[i];
        }
        return first;
    }


    public Vector sum(Vector vector) {
        this.vectorValue = getSumFor(this.vectorValue, vector.vectorValue);
        return this;
    }

    public Vector sub(Vector vector) {
        if (this.vectorValue.length >= vector.vectorValue.length) {
            this.vectorValue = getSubFor(this.vectorValue, vector.vectorValue);
        } else {
            this.vectorValue = convertLeastVector(vector.vectorValue, this.vectorValue);
            this.vectorValue = getSubFor(this.vectorValue, vector.vectorValue);
        }
        return this;
    }

    public Vector multiply(int x) {
        for (int i = 0; i < this.vectorValue.length; ++i) {
            this.vectorValue[i] = this.vectorValue[i] * x;
        }
        return this;
    }

    public Vector reverseVector() {
        return multiply(-1);
    }

    public double getVectorSquare() {
        double vectorSquareTemp = 0;
        for (double currentElement : this.vectorValue) {
            vectorSquareTemp += Math.pow(currentElement, 2);
        }
        return Math.sqrt(vectorSquareTemp);
    }

    public double getElementOfVector(int positionNumber) {
        return this.vectorValue[positionNumber];
    }

    public void setVectorElement(int positionNumber, double value) {
        this.vectorValue[positionNumber] = value;
    }

    private boolean isEqualValue(double first, double second) {
        double epsilon = 0.0001;
        return Math.abs(first - second) < epsilon;
    }

    public boolean equals(Vector vector) {
        if (vector == this) return true;
        if (vector == null || vector.getClass() != this.getClass()) return false;
        boolean a = true;
        if (vector.vectorValue.length == this.vectorValue.length) {
            for (int i = 0; i < this.vectorValue.length; ++i) {
                if (!isEqualValue(this.vectorValue[i], vector.vectorValue[i])) {
                    a = false;
                    break;
                }
            }
        } else {
            a = false;
        }
        return a;
    }

    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(vectorValue);
        return hash;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        double [] sum = getSumFor(vector1.vectorValue, vector2.vectorValue);
        return new Vector(sum.length,sum);
    }
}