package JAVAnew_IO;

import java.io.*;

/**
 * Create By ${潘晟凯} on S{DATE}
 * 字节数组流
 *
 * 创建源：源头是字节数组
 * 选择流：
 * 操作(写入内容)
 * 释放资源：可以不用释放
 */
public class IO_Study02 {
    public static void main(String[] args) {
//        1.创建源:源头是字节数组
        byte[] src = "talk is cheap show me the code".getBytes();
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(src);
            byte[] flush = new byte[1024];
            int len=-1;
            while((len=is.read(flush))!=-1) {
                String msg = new String(flush, 0, flush.length);
                System.out.println(msg);
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

