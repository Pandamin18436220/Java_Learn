package JAVAStudy_IO;

import java.io.UnsupportedEncodingException;
//String<----------->byte
public class Study_编码解码 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg="性命生命使命";
		//编码
		byte[] datas=msg.getBytes("utf8");
		//解码
		msg=new String(datas,0,datas.length,"utf8");
		System.out.println(msg);
	}
}
