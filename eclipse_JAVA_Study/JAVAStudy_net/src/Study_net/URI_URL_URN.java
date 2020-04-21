package Study_net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * @author Pandamin
 * URI=URL+URN
 * 
 * IP��λ����
 * �˿ڶ�λ���
 * URL��λ��Դ
 * 
 * URI��ͳһ��Դ��־����������ʶ�����������Դ��һ�������ַ�����
 * 
 * URN��ͳһ��Դ���ƣ�ͨ���ض������ռ��Ψһ���ƻ�ID����ʶ��Դ
 * 
 * URLͳһ��Դ��λ����һ�ֶ�λ��Դ����Ҫ���ʻ��Ƶ��ַ�����һ����׼��URL
 * ���������protocal,host,port,path,parameter,anchor
 * 
 * Э��+������(����|IP)+�˿ں�(Ĭ��80)+��Դ��
 * 
 * �������������ʯ��URL,http,html
 * http://baidu.com:80/index.html?uname=shsxt&age=18#a
 */
public class URI_URL_URN {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://baidu.com:80/index.html?uname=shsxt&age=18#a");
		//��ȡ�ĸ�ֵ
		System.out.println("Э��"+url.getProtocol());
		System.out.println("����|IP"+url.getHost());
		System.out.println("�˿ں�"+url.getPort());
		System.out.println("��Դ��"+url.getFile());
		System.out.println("��Դ��"+url.getPath());
		
		//����
		System.out.println("����"+url.getQuery());
        //ê��
		System.out.println("ê��"+url.getRef());
		
	}
}
