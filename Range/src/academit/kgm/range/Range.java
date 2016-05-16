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

    public boolean isEqual(double x, double y) {
        double epsilon = 0.0001;
        return (Math.abs(x - y) < epsilon);
    }

    public Range crossRange(Range range) {
        if (range.to < from || to < range.from) {
            return null;
        } else if (range.to > to && from < range.from) {
            return new Range(range.from, to);
        } else if (from > range.from && range.to < to) {
            return new Range(from, range.to);
        } else if (from < range.from && to > range.to) {
            return range;
        } else {
            return this;
        }
    }

    public Range[] unionRange(Range range) {
        Range[] unionRange = new Range[2];
        if (range.to < from || to < range.from) {
            unionRange[0] = this;
            unionRange[1] = range;
            return unionRange;
        } else if ((range.to > to && from < range.from) || isEqual(range.from, to)) {
            unionRange[0] = new Range(from, range.to);
            return unionRange;
        } else if ((from > range.from && range.to < to) || isEqual(from, range.to)) {
            unionRange[0] = new Range(range.from, to);
            return unionRange;
        } else if (from < range.from && to > range.to) {
            unionRange[0] = this;
            return unionRange;
        } else {
            unionRange[0] = range;
            return unionRange;
        }
    }

    public String toString() {
        return String.format("[ %.2f, %.2f ]", from, to);
    }
}
