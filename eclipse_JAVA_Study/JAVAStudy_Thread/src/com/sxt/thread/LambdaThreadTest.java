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
		 * lambda推导必须存在类型
		like=()->{
			System.out.println("I like lambda");
		};*/
		
	}
}
interface ILike{
	void lambda();
}

