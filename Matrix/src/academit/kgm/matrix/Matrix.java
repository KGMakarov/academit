package academit.kgm.matrix;

import academit.kgm.vector.Vector;


public class Matrix {
    private Vector[] matrixRows;

    // 1. Конструкторы

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

    // 2. Нестатические методы

    // а. Получение размеров, количества строк и количества столбцов матрицы

    public Dimension getSize() {
        return new Dimension(this.getNumberOfRows(), this.getNumberOfColumns());
    }

    public int getNumberOfRows() {
        return this.matrixRows.length;
    }

    public int getNumberOfColumns() {
        return this.matrixRows[0].getSize();
    }

    // b. Получение и задание вектора-строки по индексу

    public Vector getRow(int rowNumber) {
        if (rowNumber < 0) {
            throw new IllegalArgumentException("Номер запрашиваемой строки не долен быть меньше 0");
        }
        if (rowNumber >= this.getNumberOfRows()) {
            throw new ArrayIndexOutOfBoundsException("Номер запрашиваемой строки больше размерности матрицы");
        }
        return new Vector(this.matrixRows[rowNumber]);
    }

    public void setRow(int rowNumber, Vector vector) {
        if (rowNumber < 0) {
            throw new IllegalArgumentException("Номер зменяемой строки не долен быть меньше 0");
        }
        if (rowNumber >= this.getNumberOfRows()) {
            throw new ArrayIndexOutOfBoundsException("Номер изменяемой строки больше размерности матрицы");
        }
        this.matrixRows[rowNumber] = new Vector(this.getNumberOfColumns(), vector);
    }

    // c. Получение вектора-столбца по индексу

    public Vector getColumn(int numberOfColumn) {
        if (numberOfColumn < 0) {
            throw new IllegalArgumentException("Номера запрашиваемого столбца не должен быть меньше 0");
        }
        if (numberOfColumn >= this.getNumberOfColumns()) {
            throw new ArrayIndexOutOfBoundsException("Номер запрашиваемого столбца больше размерности матрицы");
        }
        double[] requiredColumn = new double[this.getNumberOfRows()];
        for (int i = 0; i < requiredColumn.length; ++i) {
            requiredColumn[i] = this.matrixRows[i].getElement(numberOfColumn);
        }
        return new Vector(requiredColumn);
    }

    // d. Транспонирование матрицы

    public Matrix transMatrix() {
        Vector[] transMatrix = new Vector[this.getNumberOfColumns()];
        for (int i = 0; i < transMatrix.length; ++i) {
            transMatrix[i] = this.getColumn(i);
        }
        this.matrixRows = transMatrix;
        return this;
    }

    // e. Умножение на скаляр

    public Matrix multiply(double x) {
        for (int i = 0; i < this.matrixRows.length; ++i) {
            this.matrixRows[i] = this.matrixRows[i].multiply(x);
        }
        return this;
    }

    // Метод сравнения 2х double'ов

    private static boolean isEqual(double x1, double x2) {
        final double EPSILON = 0.0001;
        return Math.abs(x1 - x2) < EPSILON;
    }

    // f. Вычисление определителя матрицы

    public double getDet() {
        if (this.getNumberOfRows() != this.getNumberOfColumns()) {
            throw new IllegalArgumentException("Определитель может рассчитываться только для квадратной матрицы");
        }
        double matrixDet = 1;
        int countOfLineTransposition = 0;

        for (int i = 0; i < this.matrixRows.length - 1; ++i) {
            if (isEqual(this.matrixRows[i].getElement(i), 0)) {
                for (int k = i + 1; k < this.matrixRows.length; ++k) {
                    if (!isEqual(this.matrixRows[k].getElement(i), 0)) {
                        Vector tempVector = new Vector(this.matrixRows[k]);
                        this.matrixRows[k] = this.matrixRows[i];
                        this.matrixRows[i] = tempVector;
                        countOfLineTransposition += 1;
                        break;
                    }
                }
            }
            for (int j = i + 1; j < this.matrixRows.length; ++j) {
                if (!isEqual(this.matrixRows[j].getElement(i), 0)) {
                    double k = this.matrixRows[j].getElement(i) / this.matrixRows[i].getElement(i);
                    Vector kVector = Vector.getMultiply(this.matrixRows[i], k);
                    this.matrixRows[j].sub(kVector);
                }
            }
        }

        for (int i = 0; i < this.matrixRows.length; ++i) {
            matrixDet = matrixDet * this.matrixRows[i].getElement(i);

        }
        return matrixDet * Math.pow(-1, countOfLineTransposition);
    }

    // g. Переопределение toString

    public String toString() {
        StringBuilder stringMatrix = new StringBuilder("{");
        for (int i = 0; i < this.matrixRows.length - 1; ++i) {
            stringMatrix.append(this.matrixRows[i].toString()).append(", ");
        }
        stringMatrix.append(this.matrixRows[this.matrixRows.length - 1].toString()).append("}");
        return stringMatrix.toString();
    }

    // h. умножение матрицы на вектор

    public Vector vectorMultiply(Vector vector) {
        if (this.getNumberOfColumns() != vector.getSize()) {
            throw new IllegalArgumentException("Перемножаться могут только матрицы у которых число столбцов первой совпадает с числом строк второй");
        }

        Vector tempVector = new Vector(this.getNumberOfRows());
        double currentNewElement = 0;
        for (int i = 0; i < this.matrixRows.length; ++i) {
            for (int j = 0; j < this.matrixRows[i].getSize(); ++j) {
                currentNewElement = currentNewElement + this.matrixRows[i].getElement(j) * vector.getElement(j);
            }
            tempVector.setElement(i, currentNewElement);
            currentNewElement = 0;
        }
        return tempVector;
    }

    // i. Сложение матриц

    public Matrix sum(Matrix matrix1) {
        if (this.getNumberOfRows() != matrix1.getNumberOfRows() ||
                this.getNumberOfColumns() != matrix1.getNumberOfColumns()) {
            throw new IllegalArgumentException("Складываться могут только матрицы одинаковой размерности");
        }
        for (int i = 0; i < this.matrixRows.length; ++i) {
            this.matrixRows[i].sum(matrix1.matrixRows[i]);
        }
        return this;
    }

    // j. Вычитание матриц

    public Matrix sub(Matrix matrix1) {
        if (this.getNumberOfRows() != matrix1.getNumberOfRows() ||
                this.getNumberOfColumns() != matrix1.getNumberOfColumns()) {
            throw new IllegalArgumentException("Вычитать можно только матрицы одинаковой размерности");
        }
        for (int i = 0; i < this.matrixRows.length; ++i) {
            this.matrixRows[i].sub(matrix1.matrixRows[i]);
        }
        return this;
    }

    // 3. Статические методы

    // a. Сложение матриц

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        Matrix tempMatrix = new Matrix(matrix1);
        return tempMatrix.sum(matrix2);
    }

    // b. Вычитание матриц

    public static Matrix getSub(Matrix matrix1, Matrix matrix2) {
        Matrix tempMatrix = new Matrix(matrix1);
        return tempMatrix.sub(matrix2);
    }

    // c. Умножение матриц

    public static Matrix getMultiply(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getNumberOfColumns() != matrix2.getNumberOfRows()) {
            throw new IllegalArgumentException("Перемножаться могут только матрицы у которых число столбцов первой совпадает с числом строк второй");
        }

        Matrix tempMatrix = new Matrix(matrix1.getNumberOfRows(), matrix2.getNumberOfColumns());
        double currentNewElement = 0;
        for (int i = 0; i < matrix1.matrixRows.length; ++i) {
            for (int j = 0; j < matrix2.matrixRows[i].getSize(); ++j) {
                for (int k = 0; k < matrix2.matrixRows.length; ++k) {
                    currentNewElement = currentNewElement + matrix1.matrixRows[i].getElement(k) * matrix2.matrixRows[k].getElement(j);
                }
                tempMatrix.matrixRows[i].setElement(j, currentNewElement);
                currentNewElement = 0;
            }
        }
        return tempMatrix;
    }
}

