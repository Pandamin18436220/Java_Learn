package com.sxt.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * �˽ⴴ���̵߳ķ�ʽ��
 * �������쳣�����Է���ֵ���������鷳
 * @author Pandamin
 *
 */
public class CDownloader implements Callable<Boolean>{
	private String url;
	private String name;
	public CDownloader(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}
	public Boolean call() throws Exception{
		WebDownLoader wd=new WebDownLoader();
		wd.download(url, name);
		return true;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CDownloader cd1=new CDownloader("","");
		CDownloader cd2=new CDownloader("","");
		CDownloader cd3=new CDownloader("","");
		//����ִ�з���
		ExecutorService ser=Executors.newFixedThreadPool(3);
		//�ύִ��
		Future<Boolean> result1=ser.submit(cd1);
		Future<Boolean> result2=ser.submit(cd2);
		Future<Boolean> result3=ser.submit(cd3);
		//��ȡ���
		boolean r1=result1.get();
		boolean r2=result2.get();
		boolean r3=result3.get();
		System.out.println(r3);
		//�رշ���
		ser.shutdownNow();
	}
	
}
