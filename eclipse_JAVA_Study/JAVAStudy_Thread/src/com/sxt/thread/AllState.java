package com.sxt.thread;

import java.lang.Thread.State;

public class AllState {
	public static void main(String[] args) {
		Thread t=new Thread(new Runnable(){
			public void run() {
				for(int i=0;i<5;i++){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("....");
				}
			}
		});
		//观察状态
		
		State state=t.getState();
		System.out.println(state);					//new
		
		t.start();
		state=t.getState();							//RUNNABLE
		System.out.println(state);
		
		/*
		while(state!=Thread.State.TERMINATED){		//TERMINATED
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			state=t.getState();
			System.out.println(state);
		}*/
		while(true){		//TERMINATED
			int num=Thread.activeCount();//线程数：此时有两个线程(主线程和开辟线程)1为主线程
			System.out.println(num);
			if(num==1){
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			state=t.getState();
			System.out.println(state);
		}
		
		
	}
}
