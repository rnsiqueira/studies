


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {


    private static final double CONFIDENCE_INTERVAL = 1.96;
    private final int trials;
    private final double[] results;

    public PercolationStats(int n, int trials) {
        if (n < 0 || trials < 0) throw new IllegalArgumentException("n and trials not be less than 0");
        this.trials = trials;
        this.results = new double[trials];
        Percolation percolation = new Percolation(n);
        for (int trial = 0; trial < trials; trial++) {
            int row = StdRandom.uniformInt(1, n + 1);
            int col = StdRandom.uniformInt(1, n + 1);
            do {
                percolation.open(row, col);
                while (percolation.isOpen(row, col)) {
                    row = StdRandom.uniformInt(1, n + 1);
                    col = StdRandom.uniformInt(1, n + 1);
                }
            } while (!percolation.percolates());
            results[trial] = (double) percolation.numberOfOpenSites() / (n * n);
            percolation = new Percolation(n);
        }


    }

    // test client (see below)
    public static void main(String[] args) {


        int n = StdIn.readInt();
        int trials = StdIn.readInt();

        if (args.length >= 2) {
            n = Integer.parseInt(args[0]);
            trials = Integer.parseInt(args[1]);
        }

        PercolationStats percolationStats = new PercolationStats(n, trials);

        StdOut.printf("mean                    = %.16f\n", percolationStats.mean());
        StdOut.printf("stddev                  = %.16f\n", percolationStats.stddev());
        StdOut.printf("95%% confidence interval = [%.16f, %.16f]\n", percolationStats.confidenceLo(), percolationStats.confidenceHi());

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (CONFIDENCE_INTERVAL * stddev() / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (CONFIDENCE_INTERVAL * stddev() / Math.sqrt(trials));
    }
}
