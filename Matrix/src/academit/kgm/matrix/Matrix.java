package academit.kgm.matrix;

import academit.kgm.vector.Vector;


public class Matrix {
    private Vector[] matrixRows;

    public Matrix(int rows, int columns) {
        if (rows <= 0) {
            throw new IllegalArgumentException("Количество строк матрицы не может быть меньше или равно 0");
        }
        if (columns <= 0) {
            throw new IllegalArgumentException("Количество столбцов матрицы не может быть меньше или равно 0");
        }
        this.matrixRows = new Vector[rows];
        for (int i = 0; i < rows; ++i) {
            this.matrixRows[i] = new Vector(columns);
        }
    }

    public Matrix(Matrix matrix) {
        this(matrix.matrixRows);
    }

    public Matrix(double[][] matrixArray) {
        this.matrixRows = new Vector[matrixArray.length];
        int maxLengthOfRow = 0;
        for (double[] currentMatrixRow : matrixArray) {
            if (currentMatrixRow.length > maxLengthOfRow) {
                maxLengthOfRow = currentMatrixRow.length;
            }
        }
        for (int i = 0; i < matrixArray.length; ++i) {
            this.matrixRows[i] = new Vector(maxLengthOfRow, matrixArray[i]);
        }
    }

    public Matrix(Vector[] vectorArray) {
        int maxLengthOfVector = 0;
        for (Vector currentVector : vectorArray) {
            if (currentVector.getSize() > maxLengthOfVector) {
                maxLengthOfVector = currentVector.getSize();
            }
        }
        this.matrixRows = new Vector[vectorArray.length];
        for (int i = 0; i < matrixRows.length; ++i) {
            this.matrixRows[i] = new Vector(maxLengthOfVector, vectorArray[i]);
        }
    }

    public Dimension getSize() {
        return new Dimension(this.matrixRows.length, this.matrixRows[0].getSize());
    }

    public int getNumberOfRows() {
        return getSize().getRows();
    }

    public int getNumberOfColumns() {
        return getSize().getColumns();
    }

    public Vector getRow(int rowNumber) {
        if (rowNumber < 0) {
            throw new IllegalArgumentException("Номер запрашиваемой строки не долен быть меньше 0");
        }
        if (rowNumber >= this.matrixRows.length) {
            throw new ArrayIndexOutOfBoundsException("Номер запрашиваемой строки больше размерности матрицы");
        }
        return this.matrixRows[rowNumber];
    }

    public void setMatrixRow(int rowNumber, Vector vector) {
        this.matrixRows[rowNumber] = new Vector(this.matrixRows[rowNumber].getSize(), vector);
    }

    public Vector getColumn(int numberOfColumn) {
        if (numberOfColumn < 0) {
            throw new IllegalArgumentException("Номера запрашиваемого столбца не должен быть меньше 0");
        }
        if (numberOfColumn >= this.matrixRows[0].getSize()) {
            throw new ArrayIndexOutOfBoundsException("Номер запрашиваемого столбца больше размерности матрицы");
        }
        double[] requiredColumn = new double[this.matrixRows.length];
        for (int i = 0; i < requiredColumn.length; ++i) {
            requiredColumn[i] = this.matrixRows[i].getElement(numberOfColumn);
        }
        return new Vector(requiredColumn);
    }

    public Matrix transMatrix() {
        Vector[] transMatrix = new Vector[this.matrixRows[0].getSize()];
        for (int i = 0; i < transMatrix.length; ++i) {
            transMatrix[i] = this.getColumn(i);
           /* for (int j = 0; j < this.matrixRows[i].getSize(); ++j) {
                transMatrix[j].setElement(i, this.matrixRows[i].getElement(j));
            }*/
        }
        this.matrixRows = transMatrix;
        return this;
    }


    public String toString() {
        StringBuilder stringMatrix = new StringBuilder("{");
        for (int i = 0; i < this.matrixRows.length - 1; ++i) {
            stringMatrix.append(this.matrixRows[i].toString()).append(", ");
        }
        stringMatrix.append(this.matrixRows[this.matrixRows.length - 1].toString()).append("}");
        return stringMatrix.toString();
    }
}
