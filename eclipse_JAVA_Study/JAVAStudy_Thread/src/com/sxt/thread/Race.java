package com.sxt.thread;

public class Race implements Runnable{
	private static String winner;//ʤ��
	public void run() {
		for(int steps=1;steps<=100;steps++){
			//ģ����Ϣ
			if(Thread.currentThread().getName().equals("����")&&steps%10==0){
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
		
		new Thread(race,"�ڹ�").start();
		new Thread(race,"����").start();
		
	}
}
