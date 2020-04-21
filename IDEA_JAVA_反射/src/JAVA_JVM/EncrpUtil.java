package JAVA_JVM;

import java.io.*;

/**
 * 加密工具类
 */
public class EncrpUtil {
    public static void main(String[] args) {
        encrpt("","");
    }
    public static void encrpt(String src,String dest){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            int temp = -1;
            while((temp=fis.read())!=-1){
                fos.write(temp^0xff);//取反操作
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
