package com.sxt.thread;

public class LambdaThreadTest {
	public static void main(String[] args) {
		new ILike(){
			public void lambda() {
				// TODO Auto-generated method stub
				System.out.println("I like lambda");
			}
		}.lambda();
		/*
		 * lambda�Ƶ������������
		like=()->{
			System.out.println("I like lambda");
		};*/
		
	}
}
interface ILike{
	void lambda();
}

