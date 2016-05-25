package academit.kgm.shape;

/**
 * Created by ROCKfeller on 24.05.2016.
 */
public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return 2 * radius;
    }

    public double getWidth() {
        return 2 * radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);

    }
}
