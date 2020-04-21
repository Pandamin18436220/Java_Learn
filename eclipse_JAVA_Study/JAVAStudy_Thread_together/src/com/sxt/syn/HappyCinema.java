package com.sxt.syn;

import java.util.ArrayList;
import java.util.List;

public class HappyCinema {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ӰԺ�ṩ��λ��
		List<Integer> available=new ArrayList<Integer>();
		available.add(1);available.add(2);available.add(3);available.add(4);
		//�˿���Ҫ��λ��
		List<Integer> seats1=new ArrayList<Integer>();
		seats1.add(1);seats1.add(2);seats1.add(3);
		
		List<Integer> seats2=new ArrayList<Integer>();
		seats2.add(3);
		
		Cinema c=new Cinema(available, "happysxt");
		new Thread(new Customer(c, seats1),"���ɿ�").start();
		new Thread(new Customer(c, seats2),"������").start();
	}
}
class Customer implements Runnable{
	Cinema cinema;
	List<Integer> seats;
	
	public Customer(Cinema cinema, List<Integer> seats) {
		super();
		this.cinema = cinema;
		this.seats = seats;
	}
	public void run() {
		// TODO Auto-generated method stub
		synchronized (cinema) {
			boolean flag=cinema.bookTickets(seats);
			if(flag){
				System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+"-<λ��Ϊ:"+seats);
			}else{
				System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+"-<λ�ò���");
			}
		}
	}
}
class Cinema{
	List<Integer> available;
	int money;
	String name;
	public Cinema (List<Integer> available,String name){
		this.available=available;
		this.name=name;
	}
	
	//��Ʊ
	public boolean bookTickets(List<Integer> seats){
		System.out.println("����λ��Ϊ:"+available);
		List<Integer> copy=new ArrayList<Integer>();
		copy.addAll(available);
		//���
		copy.removeAll(seats);
		//�жϴ�С
		if(available.size()-copy.size()!=seats.size()){
			return false;
		}
		available=copy;
		return true;
	}
}
