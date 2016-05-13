/**
 * Created by ROCKfeller on 12.05.2016.
 */
public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getLength() {
        return Math.abs(to - from);
    }

    public boolean isInside(double x) {
        if (from < to) {
            if (x >= from && x <= to) {
                return true;
            } else if (x <= from && x >= to) {
                return true;
            }
        }
        return false;
    }

    public double[] getCrossing(Range range) {
        double[] crossRange = new double[2];
        if (from > to) {
            if (from > range.from && range.from > to) {
                if (range.to > from) {
                    crossRange[0] = range.from;
                    crossRange[1] = from;
                } else if (range.to < to) {
                    crossRange[0] = to;
                    crossRange[1] = range.from;
                } else {
                    crossRange = null;
                }
            } else if (from > range.to && range.to > to) {
                if (range.from > from) {
                    crossRange[0] = range.to;
                    crossRange[1] = from;
                } else if (range.from < to) {
                    crossRange[0] = to;
                    crossRange[1] = range.to;
                } else {
                    crossRange = null;
                }
            } else {
                crossRange = null;
            }
        } else if (to > range.from && range.from > from) {
            if (range.to > to) {
                crossRange[0] = range.from;
                crossRange[1] = to;
            } else if (range.to < from) {
                crossRange[0] = from;
                crossRange[1] = range.from;
            } else {
                crossRange = null;
            }
        } else if (to > range.to && range.to > from) {
            if (range.from > to) {
                crossRange[0] = range.to;
                crossRange[1] = to;
            } else if (range.from < from) {
                crossRange[0] = from;
                crossRange[1] = range.to;
            } else {
                crossRange = null;
            }
        } else {
            crossRange = null;
        }
        return crossRange;
    }
}
