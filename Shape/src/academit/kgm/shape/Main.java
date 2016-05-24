package academit.kgm.shape;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by ROCKfeller on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

       System.out.println("Введите длину стороны квадрата:");
        double cubeSide = scanner.nextDouble();
        Square cube = new Square(cubeSide);
        System.out.printf("Высота квадрата: %.3f%nШирина квадрата: %.3f%nПлощадь квадрата: %.3f%n",
                cube.getHeight(), cube.getWidth(), cube.getArea());

        System.out.println("Введите координаты треугольника:");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();
        Triangle triangle = new Triangle(x1,y1,x2,y2,x3,y3);
        System.out.printf("Высота треугольника: %.3f%nШирина треугольника: %.3f%nПлощадь треугольника: %.3f%n",
                triangle.getHeight(), triangle.getWidth(), triangle.getArea());

        System.out.println("Введите высоту и ширину прямоугольника: ");
        double rectangleHeight = scanner.nextDouble();
        double rectangleWidth = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(rectangleHeight, rectangleWidth);
        System.out.printf("Высота прямоугольника: %.3f%nШирина прямоугольника: %.3f%nПлощадь прямоугольника: %.3f%n",
                rectangle.getHeight(), rectangle.getWidth(), rectangle.getArea());

        System.out.println("Введите радиуc окружности: ");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);
        System.out.printf("Радиус окружности: %.3f%nДиаметр окружности: %.3f%nПлощадь окружности: %.3f%n",
                circle.getHeight(), circle.getWidth(), circle.getArea());

    }
}
