package JAVAStudy_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * ����Դ
 * ѡ����
 * ����
 * �ͷ�
 * @author Pandamin
 *
 */
public class Study_IO_InputStream {
	public static void main(String[] args) {
		//����Դ
		File src=new File("C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy/src/JAVAStudy_IO/abc.txt");
		InputStream is=null;
		try {
			//ѡ����
			is=new FileInputStream(src);
			/*ȫ����ȡ
			int temp;
			while((temp=is.read())!=-1){
				System.out.println((char)temp);
			}*/
			//һ��һ�ζ�ȡ
			//����
			byte[] car=new byte[4];//������С:��������
			int length=-1;//���ܳ���
			while((length=is.read(car))!=-1){
				String str=new String(car,0,length);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				//�ͷ�
				if(is!=null){
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
