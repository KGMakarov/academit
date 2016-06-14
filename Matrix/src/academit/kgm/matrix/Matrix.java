package academit.kgm.matrix;

import academit.kgm.vector.Vector;


public class Matrix {
    private Vector[] matrixValue;

    public Matrix(int lines, int columns) {
        if (lines <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Размерность матрицы не может быть меньше или равна 0");
        }
        this.matrixValue = new Vector[lines];
        for (int i = 0; i < lines; ++i) {
            this.matrixValue[i] = new Vector(columns);
        }
    }

    public Matrix(Matrix matrix) {
        this.matrixValue = new Vector[matrix.matrixValue.length];
        for (int i = 0; i < matrixValue.length; ++i) {
            this.matrixValue[i] = new Vector(matrix.matrixValue[i]);
        }
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
        this.matrixValue = new Vector[vectorArray.length];
        for (int i = 0; i < matrixValue.length; ++i) {
            this.matrixValue[i] = new Vector(vectorArray[i]);
        }
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
