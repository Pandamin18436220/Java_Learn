package com.sxt.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CRace implements Callable<Integer>{
	private static String winner;//ʤ��
	public Integer call() throws Exception{
		for(int steps=1;steps<=100;steps++){
			//ģ����Ϣ
			if(Thread.currentThread().getName().equals("pool-1-thread-1")&&steps%10==0){
				Thread.sleep(2);
			}
			System.out.println(Thread.currentThread().getName()+"--->"+steps);
			boolean flag=gameOver(steps);
			if(flag){
				return steps;
			}
		}
		return null;
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
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CRace race=new CRace();
		//����ִ�з���
		ExecutorService ser=Executors.newFixedThreadPool(2);
		//�ύִ��
		Future<Integer> result1=ser.submit(race);
		Future<Integer> result2=ser.submit(race);
		//��ȡ���
		Integer r1=result1.get();
		Integer r2=result2.get();
		System.out.println(r1+"---->"+r2);
		//�رշ���
		ser.shutdownNow();
	}
}
