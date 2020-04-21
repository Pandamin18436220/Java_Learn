package JAVAStudy_Array;

import java.util.Arrays;

/**≤‚ ‘Arraysπ§æﬂ¿‡
 * @param args
 * Arrays.toString
 * Arrays.sort
 * Arrays.binarySearch
 */
public class Study_Arrays {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={10,20,30,90,5,1};
		System.out.println(a);
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.binarySearch(a, 1));
	}

}
