package JAVAnew_IO;

import java.io.*;

/**
 * Create By ${潘晟凯} on S{DATE}
 * 字符流+缓冲流
 *
 * 创建源：
 * 选择流：
 * 操作：
 * 释放资源：
 */
public class Buffur_IO_05 {
    public static void main(String[] args) {
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
                String msg = "";
                while (!msg.equals("exit")){
                    msg = reader.readLine();
                    writer.write(msg);
                    writer.newLine();
                    writer.flush();
                }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}