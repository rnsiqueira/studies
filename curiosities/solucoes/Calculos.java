package ilearn.solucoes;

import java.util.*;

public class Calculos {

    List<Double> listaNumero;

    double a, b, c, d, e, f;

    private List<Double> ordenados;

    private DoubleSummaryStatistics statistics;

    public Calculos() {

    }

    public Calculos(double a, double b, double c, double d, double e, double f) {

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        ordenados = new ArrayList<Double>();

        statistics = numerosOrdenados().stream().mapToDouble(x -> x).summaryStatistics();
    }

    public List<Double> numerosOrdenados() {

        listaNumero = Arrays.asList(a, b, c, d, e, f);

        ordenados = listaNumero;

        Collections.sort(ordenados);

        return ordenados;
    }

    public double mediana() {

        double mediana = 0;

        double posicao = numerosOrdenados().size() / 2;
        int posicaoP = (int) Math.ceil(posicao);

        mediana = numerosOrdenados().get(posicaoP - 1);

        return mediana;

    }

    public double media() {

        return statistics.getAverage();
    }

    public double soma() {
        return statistics.getSum();
    }

    // teste
    public static void main(String[] args) {

        Calculos calculo = new Calculos(8, 4, 5, 7, 9, 6);

        System.out.println(calculo.numerosOrdenados());
        System.out.println(calculo.mediana());

    }

}
