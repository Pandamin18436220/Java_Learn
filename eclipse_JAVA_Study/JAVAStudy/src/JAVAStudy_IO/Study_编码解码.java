package JAVAStudy_IO;

import java.io.UnsupportedEncodingException;
//String<----------->byte
public class Study_������� {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg="��������ʹ��";
		//����
		byte[] datas=msg.getBytes("utf8");
		//����
		msg=new String(datas,0,datas.length,"utf8");
		System.out.println(msg);
	}
}
