package com.sxt.thread;

public class TDownloader extends Thread{
	private String url;
	private String name;
	public TDownloader(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}
	public void run() {
		WebDownLoader wd=new WebDownLoader();
		wd.download(url, name);
	}
	public static void main(String[] args) {
		//������Դ
		TDownloader td1=new TDownloader("","");
		TDownloader td2=new TDownloader("","");
		TDownloader td3=new TDownloader("","");
		//���ݴ���
		td1.start();
		td2.start();
		td3.start();
	}
}
