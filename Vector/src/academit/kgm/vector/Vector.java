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

    public Vector(int size, Vector vector) {
        this(size, vector.vectorValue);
    }

    public Vector(int size, double[] vectorValue) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна 0");
        }
        double[] newVectorValue = new double[size];
        int countOfCopySymbols = Math.min(size, vectorValue.length);
        System.arraycopy(vectorValue, 0, newVectorValue, 0, countOfCopySymbols);
        this.vectorValue = newVectorValue;
    }

    public Vector(double[] vectorValue) {
        this(vectorValue.length, vectorValue);
    }

    public int getSize() {
        return this.vectorValue.length;
    }

    public String toString() {
        StringBuilder stringVector = new StringBuilder("{");
        for (int i = 0; i < this.vectorValue.length - 1; ++i) {
            stringVector.append(this.vectorValue[i]).append(", ");
        }
        stringVector.append(this.vectorValue[this.vectorValue.length - 1]).append("}");
        return stringVector.toString();
    }

    private static double[] extendVector(double[] minVector, int requiredLength) {
        if (minVector.length >= requiredLength) {
            return minVector;
        }
        double[] newExtendVector = new double[requiredLength];
        System.arraycopy(minVector, 0, newExtendVector, 0, minVector.length);
        return newExtendVector;
    }

    private static double[] getSumFor(double[] first, double[] second) {
        int requiredLength = Math.max(first.length, second.length);
        double[] sumArray = extendVector(first, requiredLength);
        int countOfIteration = Math.min(sumArray.length, second.length);
        for (int i = 0; i < countOfIteration; ++i) {
            sumArray[i] = sumArray[i] + second[i];
        }
        return sumArray;
    }

    private static double[] getSubFor(double[] first, double[] second) {
        int numberOfIterations = Math.min(first.length, second.length);
        double[] subArray = new double[Math.max(first.length, second.length)];
        System.arraycopy(first, 0, subArray, 0, first.length);
        for (int i = 0; i < numberOfIterations; ++i) {
            subArray[i] = subArray[i] - second[i];
        }
        return subArray;
    }


    public Vector sum(Vector vector) {
        this.vectorValue = getSumFor(this.vectorValue, vector.vectorValue);
        return this;
    }

    public Vector sub(Vector vector) {
        int requiredLength = Math.max(this.vectorValue.length, vector.vectorValue.length);
        this.vectorValue = extendVector(this.vectorValue, requiredLength);
        this.vectorValue = getSubFor(this.vectorValue, vector.vectorValue);
        return this;
    }

    public Vector multiply(double x) {
        for (int i = 0; i < this.vectorValue.length; ++i) {
            this.vectorValue[i] = this.vectorValue[i] * x;
        }
        return this;
    }

    public Vector reverse() {
        return multiply(-1);
    }

    public double getLength() {
        double vectorSquareTemp = 0;
        for (double currentElement : this.vectorValue) {
            vectorSquareTemp += Math.pow(currentElement, 2);
        }
        return Math.sqrt(vectorSquareTemp);
    }

    public double getElement(int positionNumber) {
        return this.vectorValue[positionNumber];
    }

    public void setElement(int positionNumber, double value) {
        this.vectorValue[positionNumber] = value;
    }

    private static boolean isEqualValue(double first, double second) {
        double epsilon = 0.0001;
        return Math.abs(first - second) < epsilon;
    }

    public boolean equals(Object vector) {
        if (vector == this) return true;
        if (vector == null || vector.getClass() != this.getClass()) return false;
        Vector tempVector = (Vector) vector;
        if (tempVector.vectorValue.length != this.vectorValue.length) return false;
        for (int i = 0; i < this.vectorValue.length; ++i) {
            if (!isEqualValue(this.vectorValue[i], tempVector.vectorValue[i])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(vectorValue);
        return hash;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector tempVector = new Vector(vector1);
        tempVector = tempVector.sum(vector2);
        return tempVector;
    }

    public static Vector getSub(Vector vector1, Vector vector2) {
        Vector tempVector = new Vector(vector1);
        tempVector = tempVector.sub(vector2);
        return tempVector;

    }

    public static Vector getMultiply(Vector vector, double x) {
        Vector tempVector = new Vector(vector);
        tempVector = tempVector.multiply(x);
        return tempVector;
    }

    public static double getVectorMultiply(Vector vector1, Vector vector2) {
        double vectorMultiply = 0;
        int countOfIteration = Math.min(vector1.vectorValue.length, vector2.vectorValue.length);
        for (int i = 0; i < countOfIteration; ++i) {
            vectorMultiply = vectorMultiply + (vector1.vectorValue[i] * vector2.vectorValue[i]);
        }
        return vectorMultiply;
    }
}