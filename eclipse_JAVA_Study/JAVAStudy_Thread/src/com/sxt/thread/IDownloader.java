package com.sxt.thread;

public class IDownloader implements Runnable{
	private String url;
	private String name;
	public IDownloader(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}
	public void run() {
		WebDownLoader wd=new WebDownLoader();
		wd.download(url, name);
	}
	public static void main(String[] args) {
		IDownloader td1=new IDownloader("","");
		IDownloader td2=new IDownloader("","");
		IDownloader td3=new IDownloader("","");
		new Thread(td1).start();
		new Thread(td2).start();
		new Thread(td3).start();
	}
}
