package academit.kgm.matrix;


import academit.kgm.vector.Vector;


public class Main {
    public static void main(String[] args) {
        // Проверка работы конструктора Matrix(n, m)
        System.out.println("Работа конструктора Matrix(n, m):");
        Matrix x1 = new Matrix(3, 2);
        System.out.println(x1.toString());

        // Проверка работы конструктора Matrix(Matrix)
        System.out.println("Проверка работы конструктора Matrix(Matrix):");
        Matrix x2 = new Matrix(x1);
        System.out.println(x2.toString());

        // Проверка работы конструктора Matrix(double[][])
        System.out.println("Проверка работы конструктора Matrix(double[][]):");
        double[][] temp1 = {{5, 8}, {88, 5, 47}, {1, 1, 1, 1}};
        Matrix x3 = new Matrix(temp1);
        System.out.println(x3.toString());

        // Проверка работы конструктора Matrix(Vector[])
        System.out.println("Проверка работы конструктора Matrix(Vector[]):");
        double[] temp2 = {5, 8, 81};
        double[] temp3 = {5, 81, 5, 99, 99};
        double[] temp4 = {5};
        Vector[] vectorArray = {new Vector(temp2), new Vector(temp3), new Vector(temp4)};
        Matrix x4 = new Matrix(vectorArray);
        System.out.println(x4.toString());

        //Проверка работы метода получения размеров матрицы
        System.out.println("Получение размеров матрицы:");
        System.out.println(x4.getNumberOfRows());
        System.out.println(x4.getNumberOfColumns());
        System.out.println(x4.getSize().toString());

        //Проверка работы метода получения и задания вектора-строки по индексу
        System.out.println("Получение и задание вектора-строки по индексу:");
        Vector v1 = new Vector(temp4);
        System.out.println(x4.getRow(0).toString());
        x4.setRow(0, v1);
        System.out.println(x4.toString());

        //Проверка работы метода получения вектора-столбца по индексу
        System.out.println("Получение вектора-столбца по индексу:");
        System.out.println(x4.getColumn(2).toString());

        //Проверка работы метода транспонирования матрицы
        System.out.println("Транспонирование матрицы:");

        //Создание массивов double'ов для массива Vector'ов
        double[] temp5 = {5, 8, 81};
        double[] temp6 = {5, 81, 5, 99, 99};
        double[] temp7 = {5};

        //Создание массива Vector'ов и матрицы на его основе
        Vector[] vectorArray1 = {new Vector(temp5), new Vector(temp6), new Vector(temp7)};
        Matrix x5 = new Matrix(vectorArray1);
        System.out.println(x5.toString());
        System.out.println(x5.transMatrix().toString());

        //Проверка работы метода умножения на скаляр
        System.out.println("Умножение на скаляр:");
        System.out.println(x5.toString());
        System.out.println(x5.multiply(2).toString());

        //Проверка работы метода вычисления определителя матрицы
        System.out.println("Вычисление определителя:");

        ////Создание массивов double'ов для массива Vector'ов
        double[] det0 = {2, -3, 4, 1};
        double[] det1 = {4, 0, 3, 2};
        double[] det2 = {-4, 1, 2, -2};
        double[] det3 = {3, -1, 4, 3};

        //Создание массива Vector'ов и матрицы на его основе
        Vector[] vectorDet = {new Vector(det0), new Vector(det1), new Vector(det2), new Vector(det3)};
        Matrix matrix1 = new Matrix(vectorDet);

        double x = matrix1.getDet();
        System.out.println(matrix1.toString());
        System.out.println(x);
        System.out.println(matrix1.toString());

        //Проверка работы метода умножения матрицы на вектор
        System.out.println("Умножение матрицы на вектор:");

        ////Создание массивов double'ов для матрицы и вектора
        double[] arrayForMatrix1 = {2, -1, 3};
        double[] arrayForMatrix2 = {0, 4, -2};
        double[] arrayForVector = {1, -3, 2};
        Vector vectorForMultiply = new Vector(arrayForVector); //создал вектор, на который буду умножать
        Vector[] vectorArrayForMatrix = {new Vector(arrayForMatrix1), new Vector(arrayForMatrix2)}; //создал массив векторов для матрицы
        Matrix matrixForMultiply = new Matrix(vectorArrayForMatrix);// создал матрицу для умножения
        System.out.println(matrixForMultiply.toString());
        System.out.println(vectorForMultiply.toString());
        System.out.println(matrixForMultiply.vectorMultiply(vectorForMultiply).toString());

        //Проверка метода сложения матриц
        System.out.println("Сложение матриц:");
        Matrix forSumMatrix1 = new Matrix(4, 4); // создал матрицу из нулей для сложения
        Matrix forSumMatrix2 = new Matrix(matrix1); // создал новую матрицу скопировав ее из вычисления определителя
        System.out.println(forSumMatrix1.toString());
        System.out.println(forSumMatrix2.toString());
        System.out.println(forSumMatrix1.sum(forSumMatrix2).toString());

        //Проверка метода вычитания матриц
        System.out.println("Вычитание матриц:");
        System.out.println(forSumMatrix1.toString());
        System.out.println(forSumMatrix2.toString());
        System.out.println(forSumMatrix1.sub(forSumMatrix2).toString());

        //Проверка метода статического сложения матриц
        System.out.println("Статическое сложение матриц:");
        double[][] arrayForMatrix3 = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        Matrix staticSumMatrix1 = new Matrix(arrayForMatrix3);
        double[][] arrayForMatrix4 = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        Matrix staticSumMatrix2 = new Matrix(arrayForMatrix4);
        System.out.println(staticSumMatrix1.toString());
        System.out.println(staticSumMatrix1.toString());
        System.out.println(Matrix.getSum(staticSumMatrix1, staticSumMatrix2).toString());
        System.out.println(staticSumMatrix1.toString());// для проверки того, что переданные аргументы не изменились
        System.out.println(staticSumMatrix1.toString());

        //Проверка метода статического вычитания матриц
        System.out.println("Статическое вычитание матриц:");
        System.out.println(staticSumMatrix1.toString());
        System.out.println(staticSumMatrix1.toString());
        System.out.println(Matrix.getSub(staticSumMatrix1, staticSumMatrix2).toString());
        System.out.println(staticSumMatrix1.toString());// для проверки того, что переданные аргументы не изменились
        System.out.println(staticSumMatrix1.toString());

        //Проверка метода статического умножения матриц
        System.out.println("Статическое умножение матриц:");
        double[][] arrayForMatrix5 = {{3, -1, 2}, {0, 1, -3}};
        Matrix staticMultiplyMatrix1 = new Matrix(arrayForMatrix5);
        double[][] arrayForMatrix6 = {{-3, 2, 1}, {1, 1, 2}, {2, 3, 0}};
        Matrix staticMultiplyMatrix2 = new Matrix(arrayForMatrix6);
        System.out.println(staticMultiplyMatrix1.toString());
        System.out.println(staticMultiplyMatrix2.toString());
        System.out.println(Matrix.getMultiply(staticMultiplyMatrix1, staticMultiplyMatrix2).toString());
        System.out.println(staticMultiplyMatrix1.toString());// для проверки того, что переданные аргументы не изменились
        System.out.println(staticMultiplyMatrix2.toString());
        System.out.println(Matrix.getMultiply(staticMultiplyMatrix2, staticMultiplyMatrix1)); // проверка работы исключения

    }
}
