package JAVAStudy_Array;

/**二维数组
 * @param args
 */
public class Study_2DArrays {
	public static void main(String[] args) {
		//动态创建数组
		int[][] a=new int[3][];
		a[0]=new int[]{1,2,3};
		a[1]=new int[]{4,5,6};
		a[2]=new int[]{7,8,9};
		for(int[] m:a){
			for(int n:m)
				System.out.println(n);
		}
		//静态创建数组
		int[][] b={
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		for(int[] m:b){
			for(int n:m)
				System.out.println(n);
		}

	}

}
