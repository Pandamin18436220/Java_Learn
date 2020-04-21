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
		//三份资源
		TDownloader td1=new TDownloader("","");
		TDownloader td2=new TDownloader("","");
		TDownloader td3=new TDownloader("","");
		//三份代理
		td1.start();
		td2.start();
		td3.start();
	}
}
