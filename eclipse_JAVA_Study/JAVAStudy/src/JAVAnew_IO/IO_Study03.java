package JAVAnew_IO;

import java.io.*;

/**
 * Create By ${潘晟凯} on S{DATE}
 * 字节数组流
 *
 * 创建源：内部维护
 * 选择流：不关联
 * 操作(写出内容)
 * 释放资源：可以不用释放
 *
 * 需要注意的是：因为数据保存到内部去了，所以需要获取一下数据
 * 通过toByteArray()
 */
public class IO_Study03 {
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

