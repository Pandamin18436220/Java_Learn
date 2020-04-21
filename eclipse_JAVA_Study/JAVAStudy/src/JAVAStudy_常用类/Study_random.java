package JAVAStudy_≥£”√¿‡;

import java.util.Random;

public class Study_random {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand=new Random();
		System.out.println(rand.nextDouble());//0-1(double)
		System.out.println(rand.nextInt());
		System.out.println(rand.nextFloat());//0-1(float)
		System.out.println(rand.nextBoolean());
		System.out.println(rand.nextInt(15));
		
		System.out.println(rand.nextInt(49)+50);
		
		
	}

}
