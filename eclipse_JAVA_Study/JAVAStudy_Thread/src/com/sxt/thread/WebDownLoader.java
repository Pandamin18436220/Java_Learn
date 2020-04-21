package com.sxt.thread;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;

/**
 * 下载图片
 * @author Pandamin
 *
 */
public class WebDownLoader {
	public void download(String url,String name){
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("不合法的URL");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("图片加载失败");
		}
	}
	public static void main(String[] args) {
		
	}
}
