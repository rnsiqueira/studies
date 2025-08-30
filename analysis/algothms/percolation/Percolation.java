import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {


    private final boolean[] openedSites;
    private final int sizeGrid;
    private final WeightedQuickUnionUF weightedQuickUnionUF;
    private int countOpenedSites = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        this.sizeGrid = n;
        if (n <= 0) throw new IllegalArgumentException("n must be greater than 0");
        weightedQuickUnionUF = new WeightedQuickUnionUF(n * n);
        openedSites = new boolean[n * n];

    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation percolation = new Percolation(6);

        int row = 1;
        int col = 6;
        percolation.open(row, col);
        row = 2;
        col = 6;
        percolation.open(row, col);
        row = 3;
        col = 6;
        percolation.open(row, col);
        row = 4;
        col = 6;
        percolation.open(row, col);
        row = 5;
        col = 6;
        percolation.open(row, col);
        row = 5;
        col = 5;
        percolation.open(row, col);
        StdOut.println("Is full (5,5) " + percolation.isFull(5, 5));


    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateGrid(row, col);
        if (isOpen(row, col)) {
            return;
        }

        openedSites[calcPosition(row - 1, col - 1)] = true;
        countOpenedSites++;
        if (existInGrid(row - 1, col) && isOpen(row - 1, col)) {
            weightedQuickUnionUF.union(calcPosition(row - 2, col - 1), calcPosition(row - 1, col - 1));
        }
        if (existInGrid(row + 1, col) && isOpen(row + 1, col)) {
            weightedQuickUnionUF.union(calcPosition(row - 1, col - 1), calcPosition(row, col - 1));
        }
        if (existInGrid(row, col - 1) && isOpen(row, col - 1)) {
            weightedQuickUnionUF.union(calcPosition(row - 1, col - 2), calcPosition(row - 1, col - 1));
        }
        if (existInGrid(row, col + 1) && isOpen(row, col + 1)) {
            weightedQuickUnionUF.union(calcPosition(row - 1, col - 1), calcPosition(row - 1, col));
        }

    }

    private int calcPosition(int rowIndex, int colIndex) {
        return rowIndex * sizeGrid + colIndex;
    }

    private void validateGrid(int row, int col) {
        if (!existInGrid(row, col)) throw new IllegalArgumentException("Index out of bounds");
    }

    private boolean existInGrid(int row, int col) {
        return row - 1 >= 0 && row - 1 < sizeGrid && col - 1 >= 0 && col - 1 < sizeGrid;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateGrid(row, col);
        return openedSites[calcPosition(row - 1, col - 1)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateGrid(row, col);
        if (!isOpen(row, col)) return false;
        return connectedWithTopLayer(row - 1, col - 1);

    }

    private boolean connectedWithTopLayer(int row, int col) {
        for (int i = 0; i < sizeGrid; i++) {
            if (weightedQuickUnionUF.connected(calcPosition(0, i), calcPosition(row, col))) {
                return true;
            }
        }
        return false;
    }


    // returns the number of open sites
    public int numberOfOpenSites() {
        return countOpenedSites;
    }

    // does the system percolate?
    public boolean percolates() {
        boolean pecolate = false;
        for (int i = 1; i <= sizeGrid; i++) {
            pecolate = isFull(sizeGrid, i);
            if (pecolate) break;
        }

        return pecolate;
    }
}
