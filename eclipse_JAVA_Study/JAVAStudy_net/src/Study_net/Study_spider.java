package Study_net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ��������ԭ��
 * 
 * @author Pandamin
 *
 */
public class Study_spider {
	public static void main(String[] args) throws Exception {
		//��ȡURL
		URL url = new URL("https://www.jd.com");
		//������Դ
		InputStream is =url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		String msg = null;
		while(null!=(msg=br.readLine())){
			System.out.println(msg);
		}
		br.close();
		//����
		
		//����
	}
}
