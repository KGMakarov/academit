package academit.kgm.vector;


public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(2); /** Проверка работоспособности  1го конструктора Vector(n) и работы toString**/
        System.out.println(vector1.toString());


        Vector vector2 = new Vector(vector1);     /** Проверка работоспособности  2го конструктора Vector(Vector)**/
        System.out.println(vector2.toString());

        double[] temp1 = {1, 5, 10, 88};       /** Проверка работоспособности  3го конструктора Vector(n, double [])**/
        double[] temp2 = {1, 5, 10, 88};
        Vector vector3 = new Vector(4, temp1);
        System.out.println(vector3.toString());
        Vector vector4 = new Vector(4, temp2);
        System.out.println(vector4.toString());

        System.out.println(vector3.getSize()); /** Проверка getSize**/

        System.out.printf("Сложение:%n%s%n%s%n", vector3.toString(), vector4.toString());
        System.out.println(vector3.sum(vector4).toString());/** Прибавление вектора к другому вектору **/
        System.out.printf("vector.this = %s, vector = %s%n", vector3.toString(), vector4.toString());


        System.out.printf("Вычитание:%n%s%n%s%n", vector3.toString(), vector4.toString());
        System.out.println(vector3.sub(vector4).toString());


        System.out.println("Умножение на скаляр:");
        System.out.println(vector3.multiply(2).toString());

        System.out.println("Разворот:");
        System.out.println(vector3.reverse().toString());

        System.out.println("Получение длины:");
        System.out.println(vector4.getLength());

        System.out.println("Получение и установка компоненты вектора по индексу:");
        System.out.println(vector3.getElement(2));
        vector4.setElement(1, 8.88);
        System.out.println(vector4);

        double[] temp3 = {1, 5, 10, 88};       /** Создание векторов для сравнения**/
        double[] temp4 = {1, 5, 10, 88};
        Vector vector5 = new Vector(4, temp3);
        System.out.println(vector3.toString());
        Vector vector6 = new Vector(4, temp4);
        System.out.println(vector4.toString());

        System.out.println("Сравнение:");
        System.out.println(vector5);
        System.out.println(vector6);
        System.out.println(vector5.equals(vector6));

        double[] temp5 = {1, 5, 10, 88};       /** Создание векторов для сравнения**/
        double[] temp6 = {1, 5};
        Vector vector7 = new Vector(4, temp5);
        Vector vector8 = new Vector(2, temp6);


        System.out.printf("Сложение static:%n%s%n%s%n", vector7.toString(), vector8.toString());
        System.out.println(Vector.getSum(vector7, vector8));

        System.out.printf("Вычитание static:%n%s%n%s%n", vector7.toString(), vector8.toString());
        System.out.println(Vector.getSub(vector7, vector8));

        System.out.printf("Скалярное произведение static:%n%s%n", vector7.toString());
        System.out.println(Vector.getMultiply(vector7, 2));

    }
}
