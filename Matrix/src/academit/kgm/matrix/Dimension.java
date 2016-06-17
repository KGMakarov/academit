package academit.kgm.matrix;


public class Dimension {
    private int rows;
    private int columns;

    public Dimension(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String toString() {
        return String.format("%d x %d", this.rows, this.columns);
    }
}
