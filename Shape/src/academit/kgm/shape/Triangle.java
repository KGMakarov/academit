package academit.kgm.shape;

/**
 * Created by ROCKfeller on 22.05.2016.
 */
public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    private static double getMax(double x, double y, double z) {
        if (x > y && x > z) {
            return x;
        } else if (y > x && y > z) {
            return y;
        } else {
            return z;
        }
    }

    private static double getMin(double x, double y, double z) {
        if (x < y && x < z) {
            return x;
        } else if (y < x && y < z) {
            return y;
        } else {
            return z;
        }
    }

    public double getWidth() {
        return getMax(this.x1, this.x2, this.x3) - getMin(this.x1, this.x2, this.x3);
    }

    public double getHeight() {
        return getMax(this.y1, this.y2, this.y3) - getMin(this.y1, this.y2, this.y3);
    }

    public double getArea() {
        return 0.5 * this.getHeight() * this.getWidth();
    }


}
