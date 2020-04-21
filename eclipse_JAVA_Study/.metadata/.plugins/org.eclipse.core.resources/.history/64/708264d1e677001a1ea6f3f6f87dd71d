package JAVAnew_IO;

import java.io.*;

/**
 * Create By ${潘晟凯} on S{DATE}
 * 字节流 缓存流
 *
 * 创建源：内部维护
 * 选择流：不关联
 * 操作(写出内容)
 * 释放资源：可以不用释放
 */
public class Buffur_IO_01 {
    public static void main(String[] args) {
        File src = new File("dst.txt");
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(src));
            byte[] flush = new byte[1024];
            int len =-1;
            while ((len=is.read(flush))!=-1){
                is.read(flush,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch(Exception e){
                e.printStackTrace();
                }
            }
    }
}