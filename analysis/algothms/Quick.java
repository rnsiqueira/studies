package analysis.algothms;

public class Quick {


    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo])) {
                if (i == hi) break;

            }
            while (less(a[lo], a[--i])) {
                if (j == lo) break;
            }

            exch(a, lo, j);
            return j;
        }
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static void exch(Object[] a, int i, int j) {
        Object aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

    private static boolean less(Comparable c0, Comparable c1) {
        if (c0 == c1) return false;
        return c0.compareTo(c1) < 0;
    }
}
