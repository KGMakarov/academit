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

    public Range crossRange(Range range) {
        if (from < range.from && range.from < to) {
            if (range.to > to) {
                return new Range(range.from, to);
            } else {
                return null;
            }
        } else if (from < range.to && range.to < to) {
            if (range.from < from) {
                return new Range(from, range.to);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Range unionRange (Range range){
        if (from < range.from && range.from < to) {
            if (range.to > to) {
                return new Range(from, range.to);
            } else {
                return null;
            }
        } else if (from < range.to && range.to < to) {
            if (range.from < from) {
                return new Range(range.from, to);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public String toString (){
        return "["+from+", "+to+']';
    }
}
