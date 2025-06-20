package ilearn.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntradaDeDados {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s = br.readLine()).startsWith("42"))
			System.out.println(s);
	}
}
