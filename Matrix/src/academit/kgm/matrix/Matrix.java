package academit.kgm.matrix;

import academit.kgm.vector.Vector;


public class Matrix {
    private Vector[] matrixValue;

    public Matrix(int lines, int columns) {
        if (lines <= 0) {
            throw new IllegalArgumentException("Колличество строк матрицы не может быть меньше или равно 0");
        }
        if (columns <= 0) {
            throw new IllegalArgumentException("Колличество столбцов матрицы не может быть меньше или равно 0");
        }
        this.matrixValue = new Vector[lines];
        for (int i = 0; i < lines; ++i) {
            this.matrixValue[i] = new Vector(columns);
        }
    }

    public Matrix(Matrix matrix) {
        this(matrix.matrixValue);
    }

    public Matrix(double[][] matrixArray) {
        this.matrixValue = new Vector[matrixArray.length];
        int maxLengthOfLine = 0;
        for (double[] currentElement : matrixArray) {
            if (currentElement.length > maxLengthOfLine) {
                maxLengthOfLine = currentElement.length;
            }
        }
        for (int i = 0; i < matrixArray.length; ++i) {
            this.matrixValue[i] = new Vector(maxLengthOfLine, matrixArray[i]);
        }
    }

    public Matrix(Vector[] vectorArray) {
        int maxLengthOfVector = 0;
        for (Vector currentElement : vectorArray) {
            if (currentElement.getSize() > maxLengthOfVector) {
                maxLengthOfVector = currentElement.getSize();
            }
        }
        this.matrixValue = new Vector[vectorArray.length];
        for (int i = 0; i < matrixValue.length; ++i) {
            this.matrixValue[i] = new Vector(maxLengthOfVector, vectorArray[i]);
        }
    }

    public int[] getSize() {
        int[] matrixSize = new int[2];
        matrixSize[0] = this.matrixValue.length;
        matrixSize[1] = this.matrixValue[1].getSize();
        return matrixSize;
    }

    public Vector getLine(int lineNumber) {
        if (lineNumber < 0) {
            throw new IllegalArgumentException("Номер запрашиваемой строки не долен быть меньше 0");
        }
        if (lineNumber > this.matrixValue.length) {
            throw new ArrayIndexOutOfBoundsException("Номер запрашиваемой строки больше размерности матрицы");
        }
        return this.matrixValue[lineNumber];
    }

    public void setMatrixLine(int lineNumber, Vector vector) {
        this.matrixValue[lineNumber] = new Vector(this.matrixValue[lineNumber].getSize(), vector);
    }

    public double[] getColumn(int numberOfColumn) {
        double[] requiredColumn = new double[this.matrixValue.length];
        for (int i = 0; i < requiredColumn.length; ++i) {
            requiredColumn[i] = this.matrixValue[i].getElement(numberOfColumn);
        }
        return requiredColumn;
    }

    public Matrix transMatrix() {
        Matrix transMatrix = new Matrix(this.matrixValue[0].getSize(), this.matrixValue.length);
        for (int i = 0; i < this.matrixValue.length; ++i) {
            for (int j = 0; j < this.matrixValue[i].getSize(); ++j) {
                transMatrix.matrixValue[j].setElement(i, this.matrixValue[i].getElement(j));
            }
        }
        return transMatrix;
    }


    public String toString() {
        StringBuilder stringMatrix = new StringBuilder("{");
        for (int i = 0; i < this.matrixValue.length - 1; ++i) {
            stringMatrix.append(this.matrixValue[i].toString()).append(", ");
        }
        stringMatrix.append(this.matrixValue[this.matrixValue.length - 1].toString()).append("}");
        return stringMatrix.toString();
    }
}
