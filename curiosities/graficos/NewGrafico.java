package ilearn.graficos;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class NewGrafico {

    private DefaultCategoryDataset ds;
    private JFreeChart chart;
    private ChartFrame frame;

    public NewGrafico() {
        ds = new DefaultCategoryDataset();
        chart = ChartFactory.createLineChart("Graficos", "dias", "valor", ds, PlotOrientation.VERTICAL, true, true, true);
    }

    private JFreeChart getChart() {
        return chart;
    }

    public void addDados(double n, String nome, String classificacaoColuna) {
        ds.addValue(n, nome, classificacaoColuna);

    }

    public ChartFrame getFrame(String NomeGrafico) {
        frame = new ChartFrame(NomeGrafico, getChart());
        frame.setSize(600, 500);
        frame.setVisible(true);

        return frame;
    }

    public static void main(String[] args) {
        NewGrafico grafico = new NewGrafico();
        grafico.addDados(3.2, "meta", "dia 1");
        grafico.addDados(3.3, "meta", "dia 2");
        grafico.addDados(3.4, "meta", "dia 3");
        grafico.addDados(1.4, "realizado", "dia 1");
        grafico.addDados(2, "realizado", "dia 2");
        grafico.addDados(3.4, "realizado", "dia 3");

        grafico.getFrame("Grafico");
    }

}
