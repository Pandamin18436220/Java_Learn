package com.sxt.syn;

public class �źŵ� {
	public static void main(String[] args) {
		Tv tv=new Tv();
		new Palyer(tv).start();
		new Watcher(tv).start();
	}
}
//������ ��Ա
class Palyer extends Thread{
	Tv tv;
	
	public Palyer(Tv tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<20;i++){
			if(i%2==0){
				this.tv.play("pandamin");
			}else{
				this.tv.play("panchengkai");
			}
		}
	}
}
//������ ����
class Watcher extends Thread{
	Tv tv;
	
	public Watcher(Tv tv) {
		super();
		this.tv = tv;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<20;i++){
			tv.watch();
		}
	}
}
//ͬһ����Դ������
class Tv{
	String voice;
	//�źŵ�
	//���Ϊ�棬��ʾ��Ա���ݣ����ڵȴ�
	//���Ϊ�٣���ʾ���ڹۿ�����Ա�ȴ�
	boolean flag=true;
	
	//����
	public synchronized void play(String voice){
		//��Ա�ȴ�
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//����
		System.out.println("������:"+voice);
		this.voice=voice;
		//����
		this.notifyAll();
		//�л��źŵ�
		this.flag=!this.flag;
	}
	//�ۿ�
	public synchronized void watch(){
		//���ڵȴ�
		if(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("������:"+voice);
		//����
		this.notifyAll();
		//�л��źŵ�
		this.flag=!this.flag;
	}
}
