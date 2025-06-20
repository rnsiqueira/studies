//package ilearn.algoritmos.exercicios;

/*
 * import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.jfree.chart.plot.dial.DialLayerChangeListener;

public class DiasExpressoParaData {

	private int ano;
	private int mes;
	private int dia;

	public String converte(int dias) {
		
		double anoCalculo = dias / 365;
		double anoResto = dias % 365;
		BigDecimal bigAno = new BigDecimal(anoCalculo);
		int anoAtual = Integer.parseInt(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime()));
		ano = anoAtual - bigAno.intValue();
		double mesCalculo = anoResto / 30;
		int mesAtual = Integer.parseInt(new SimpleDateFormat("MM").format(Calendar.getInstance().getTime()));
		mes = (int) ((int) mesAtual - mesCalculo);
		int diaAtual = Integer.parseInt(new SimpleDateFormat("dd").format(Calendar.getInstance().getTime()));
		int diaCalculo = (int) anoResto % 30;
		System.out.println(diaCalculo);
		dia = diaCalculo - diaAtual;

		return dia + "/" + mes + "/" + ano;

	}

	public static void main(String[] args) {
		DiasExpressoParaData teste = new DiasExpressoParaData();
		IdadeExpressaEmDias idade = new IdadeExpressaEmDias();
		idade.idade("16/01/1990");
		System.out.println(teste.converte(idade.idadeExpressaEmDias()));
	}

}
 */