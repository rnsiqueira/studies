package ilearn.algoritmos.exercicios;

public class Statics {
	
	
	public static void inset(Byte b) {
		System.out.println("B");
	}
	
	
	public static void inset(Number num) {
		System.out.println("N");
	}
	
	
	
	
	public static void main(String[] args) {
		inset((byte)2 + (byte)5);
	}

}
