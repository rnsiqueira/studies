package ilearn.thread.testes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Listas {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();

		System.out.println(sb.capacity());

		sb.append("Geek Welcome");

		System.out.println(sb.capacity());

		sb.append("Hello Welcome to the java code");

		System.out.println(sb.capacity());

		int[] nums = { 9, 8, 3, 6, 9, 15, 22, 5, 7, 1 };

		ArrayList<Integer> lista = new ArrayList<>();

		for (int i = 1; i < nums.length; i++) {
			lista.add(nums[i]);
		}

		Collections.sort(lista);

		lista.forEach(n -> System.out.println(n));

		System.out.println("\n");

		lista.stream().filter(n -> n.intValue() > 8).forEach(n -> System.out.println(n));

		System.out.println("--------------------------------------------------------");

		for (int i = 0; i < nums.length; i++) {

			System.out.println(nums[i]);

		}

		System.out.println("-------------------");

		Arrays.sort(nums);
		
		

		for (Integer integer : lista) {

			System.out.println(integer);

		}
		
		
		System.out.println("------------------------");
		
		
		for(int i =1; i<nums.length; i++) {
			for(int j = 0; j< nums.length; j++) {
				int aux = 0;
				if(nums[i]<nums[j]) {
					aux = nums[i];
					nums[i] = nums[j];
					nums[j] = aux;
				}
			}
		}
		
		for(int i : nums) {
			System.out.println(i);
		}
		
		
		

	}

}
