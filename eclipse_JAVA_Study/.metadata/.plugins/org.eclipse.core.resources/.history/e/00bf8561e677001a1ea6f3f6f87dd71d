package JAVAnew_IO;

import java.io.*;

/**
 * Create By ${潘晟凯} on S{DATE}
 * 字节流
 *
 * 创建源：内部维护
 * 选择流：不关联
 * 操作(写出内容)
 * 释放资源：可以不用释放
 */
public class IO_Study {
    public static void main(String[] args) {
        File src = new File("dst.txt");
        OutputStream os = null;
        try {
            os = new FileOutputStream(src,true);
            String mgs = "潘晟凯";
            byte[] datas = mgs.getBytes();
            os.write(datas,0,datas.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch(Exception e){
                e.printStackTrace();
                }
            }
        }
    }

