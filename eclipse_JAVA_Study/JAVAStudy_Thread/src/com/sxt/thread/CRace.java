package com.sxt.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CRace implements Callable<Integer>{
	private static String winner;//胜利
	public Integer call() throws Exception{
		for(int steps=1;steps<=100;steps++){
			//模拟休息
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
		//创建执行服务
		ExecutorService ser=Executors.newFixedThreadPool(2);
		//提交执行
		Future<Integer> result1=ser.submit(race);
		Future<Integer> result2=ser.submit(race);
		//获取结果
		Integer r1=result1.get();
		Integer r2=result2.get();
		System.out.println(r1+"---->"+r2);
		//关闭服务
		ser.shutdownNow();
	}
}
