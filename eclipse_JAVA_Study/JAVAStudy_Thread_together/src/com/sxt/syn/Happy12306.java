package com.sxt.syn;

import java.util.ArrayList;
import java.util.List;

import com.sun.swing.internal.plaf.synth.resources.synth;

public class Happy12306 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Web12306 c=new Web12306(2, "happysxt");
		new Passenger(c, "���ɿ�", 2).start();
		new Passenger(c, "��С��", 1).start();
	}
}
class Passenger extends Thread{
	int seats;
	public Passenger(Runnable target,String name,int seats) {
		super(target,name);
		this.seats = seats;
	}
}
class Web12306 implements Runnable{
	int available;
	int money;
	String name;
	public Web12306 (int available,String name){
		this.available=available;
		this.name=name;
	}
	public void run() {
		// TODO Auto-generated method stub
		Passenger p=(Passenger)Thread.currentThread();
		boolean flag=this.bookTickets(p.seats);
		if(flag){
			System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+"-<λ��Ϊ:"+p.seats);
		}else{
			System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+"-<λ�ò���");
		}
	}
	
	//��Ʊ
	public synchronized boolean bookTickets(int seats){
		System.out.println("����λ��Ϊ:"+available);
		if(available<seats){
			return false;
		}
		available-=seats;
		return true;
	}
}
