package JAVAnew_IO;

import java.io.*;

/**
 * Create By ${潘晟凯} on S{DATE}
 * 将00-03小综合
 *
 * 1.将图片读取到字节数组中
 * 2.将字节数组写出到文件
 *
 */
public class IO_Study05 {
    public static void main(String[] args) {
        byte[] datas = fileToByteArray("E:\\IDEA_JAVAStudy\\src\\1.jpg");
        System.out.println(datas.length);
        ByteArrayTofile(datas,"E:\\IDEA_JAVAStudy\\src\\p-b.jpg");
    }
    /**
     * 1.将图片读取到字节数组中
     *  1)图片到程序
     *  2)程序到字节数组
     * @param filePath
     * @return
     */
    public static byte[] fileToByteArray(String filePath) {
        File src = new File(filePath);
        byte[] dest = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();
            byte[] flush = new byte[1024 * 10];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                String msg = new String(flush, 0, flush.length);
//                System.out.println(msg);
                baos.write(flush, 0, len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dest;
    }
    /**
     * 2.将字节数组写出到文件
     *  1）字节数组到程序
     *  2）程序到文件
     * @param src
     * @param filePath
     */
    public static void ByteArrayTofile(byte[] src,String filePath){
        File dest = new File("filePath");

        InputStream is = null;
        OutputStream os = null;
        try{
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);
            byte[] flush = new byte[1024];
            int len = -1;
            while((len=is.read(flush))!=-1){
                String msg = new String(flush,0,len);
//                System.out.println(msg);
                os.write(flush);
                os.flush();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(os!=null) {
                try {
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(is!=null) {
                try {
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}