package JAVAnew_IO;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Create By ${潘晟凯} on S{DATE}
 * 将00-03小综合
 *
 * 1.将图片读取到数组中
 * 2.将字节数组写出到文件
 *
 */
public class IO_Study04 {
    public static void main(String[] args) {
//        1.创建源:源头是字节数组
        byte[] dest;
//        2.选择流（由于要使用新增方法，使用不能发送多态）
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
//            3.操作(写出)
            String msg = "show me the code";
            byte[] datas = msg.getBytes();
            baos.write(datas,0,datas.length);
            baos.flush();
            dest = baos.toByteArray();
            System.out.println(dest);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch(Exception e){
                e.printStackTrace();
                }
            }
        }
    }

