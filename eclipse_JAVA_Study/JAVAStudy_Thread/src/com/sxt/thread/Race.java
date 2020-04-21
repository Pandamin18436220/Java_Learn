package com.sxt.thread;

public class Race implements Runnable{
	private static String winner;//胜利
	public void run() {
		for(int steps=1;steps<=100;steps++){
			//模拟休息
			if(Thread.currentThread().getName().equals("兔子")&&steps%10==0){
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"--->"+steps);
			boolean flag=gameOver(steps);
			if(flag){
				break;
			}
		}
	}
	private boolean gameOver(int steps){
		if(winner!=null){
			return true;
		}else{
			if(steps==100){
				winner=Thread.currentThread().getName();
				System.out.println("winner is:"+winner);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Race race=new Race();
		
		new Thread(race,"乌龟").start();
		new Thread(race,"兔子").start();
		
	}
}
