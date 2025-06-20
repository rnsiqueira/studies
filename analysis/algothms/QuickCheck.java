package analysis.algothms;

public class QuickCheck {


    public static void main(String[] args) {

        int maxN = Integer.parseInt("50000000");

        double[] c = new double[maxN + 1];
        c[0] = 0;
        for (int N = 1; N <= maxN; N++) {
            c[N] = (N + 1) * c[N - 1] / N + 2;
        }

        System.out.println("calculo de aproximação sem função euler: 2NlogN - 2N");

        for (int N = 10; N <= maxN; N *= 5) {

            double aprox = 2 * N * Math.log(N) - 2 * N;
            System.out.printf("%10d %15.2f %15.2f\n", N, c[N], aprox);
        }

        System.out.println("\ncalculo de aproximação com função euler: 2NlogN - 2(1 - 1/e)N");


        for (int N = 10; N <= maxN; N *= 5) {

            double aprox = 2 * N * Math.log(N) - 2 * (1 - .577215665) * N;
            System.out.printf("%10d %15.2f %15.2f\n", N, c[N], aprox);
        }
    }
}
