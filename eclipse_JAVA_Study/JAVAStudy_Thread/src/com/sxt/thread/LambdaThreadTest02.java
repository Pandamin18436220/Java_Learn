package com.sxt.thread;

public class LambdaThreadTest02 {
	public static void main(String[] args) {
		ILove love=new ILove(){
			public int lambda(int a,int b) {
				System.out.println("i like lambda--->"+a);
				return a>b?a:b;
			}
		};
		love.lambda(1,4);
		/*
		ILove love=(int a)-> {
			System.out.println("i like lambda--->"+a);
		};*/
	}
}
interface ILove{
	int lambda(int a,int b);
}
class Love implements ILove{
	public int lambda(int a,int b) {
		System.out.println("i like lambda--->"+a);
		return a>b?a:b;
	}
	
}
