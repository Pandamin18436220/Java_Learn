package Study_net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ��������ԭ��
 * 
 * @author Pandamin
 *
 */
public class CopyOfStudy_spide {
	public static void main(String[] args) throws Exception {
		//��ȡURL
		URL url = new URL("https://www.dianping.com");
		//������Դ
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.9 Safari/537.36");
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String msg = null;
		while(null!=(msg=br.readLine())){
			System.out.println(msg);
		}
		br.close();
		//����
		
		//����
	}
}
