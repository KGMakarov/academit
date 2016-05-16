package academit.kgm.range;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by ROCKfeller on 12.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("Введите нижнюю границу диапазона 1: ");
        double from1 = scanner.nextDouble();
        System.out.println("Введите верхнюю границу диапазона 1: ");
        double to1 = scanner.nextDouble();
        System.out.println("Введите число, которое нужно проверить на принадлежность диапазону 1: ");
        double x = scanner.nextDouble();

        Range range1 = new Range(from1, to1);

        System.out.printf("Длинна диапазона 1 составляет: %.3f", range1.getLength());
        System.out.printf("%nПринадлежит ли введенный элемент %.3f диапазану 1: %b%n", x, range1.isInside(x));

        System.out.println("Введите нижнюю границу диапазона 2: ");
        double from2 = scanner.nextDouble();
        System.out.println("Введите верхнюю границу диапазона 2: ");
        double to2 = scanner.nextDouble();

        Range range2 = new Range(from2, to2);

        Range crossRange = range1.crossRange(range2);
        if (crossRange != null) {
            System.out.println("Пересечение двух диапазонов: " + crossRange.toString());
        } else {
            System.out.println("Диапазоны не пересекаются");
        }

        Range unionRange[] = range1.unionRange(range2);
        System.out.printf("Объединение двух диапазонов: ");
        for (Range currentElement : unionRange) {
            if (currentElement != null) {
                System.out.printf("%s ", currentElement.toString());
            }
        }

    }
}
