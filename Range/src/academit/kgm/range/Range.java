package academit.kgm.range;

/**
 * Created by ROCKfeller on 12.05.2016.
 */
public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        if (from < to) {
            this.from = from;
            this.to = to;
        } else {
            this.from = to;
            this.to = from;
        }

    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double x) {
        return (x >= from && x <= to);
    }

    private static double getMax(double x, double y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }

    private static double getMin(double x, double y) {
        if (x < y) {
            return x;
        } else {
            return y;
        }
    }

    private boolean isNonCrossing(Range range) {
        return (range.to < from || to < range.from);
    }

    public Range crossRange(Range range) {
        if (this.isNonCrossing(range)) {
            return null;
        } else if (range.to > to && from < range.from) {
            return new Range(range.from, to);
        } else if (from > range.from && range.to < to) {
            return new Range(from, range.to);
        } else if (from < range.from && to > range.to) {
            return new Range(range.from, range.to);
        } else {
            return new Range(from, to);
        }
    }

    public Range[] unionRange(Range range) {
        if (this.isNonCrossing(range)) {
            Range[] unionRange = new Range[2];
            unionRange[0] = new Range(from, to);
            unionRange[1] = new Range(range.from, range.to);
            return unionRange;
        } else {
            Range[] unionRange = new Range[1];
            unionRange[0] = new Range(getMin(from, range.from), getMax(to, range.to));
            return unionRange;
        }
    }

    public String toString() {
        return String.format("[ %.2f, %.2f ]", from, to);
    }
}
