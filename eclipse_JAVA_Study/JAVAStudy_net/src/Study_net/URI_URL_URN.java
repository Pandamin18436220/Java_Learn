package Study_net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * @author Pandamin
 * URI=URL+URN
 * 
 * IP定位电脑
 * 端口定位软件
 * URL定位资源
 * 
 * URI是统一资源标志符，用来标识抽象或物理资源的一个紧凑字符串。
 * 
 * URN是统一资源名称，通过特定命名空间的唯一名称或ID来标识资源
 * 
 * URL统一资源定位符，一种定位资源的主要访问机制的字符串，一个标准的URL
 * 必须包括：protocal,host,port,path,parameter,anchor
 * 
 * 协议+主机名(域名|IP)+端口号(默认80)+资源名
 * 
 * 互联网的三大基石：URL,http,html
 * http://baidu.com:80/index.html?uname=shsxt&age=18#a
 */
public class URI_URL_URN {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://baidu.com:80/index.html?uname=shsxt&age=18#a");
		//获取四个值
		System.out.println("协议"+url.getProtocol());
		System.out.println("域名|IP"+url.getHost());
		System.out.println("端口号"+url.getPort());
		System.out.println("资源名"+url.getFile());
		System.out.println("资源名"+url.getPath());
		
		//参数
		System.out.println("参数"+url.getQuery());
        //锚点
		System.out.println("锚点"+url.getRef());
		
	}
}
