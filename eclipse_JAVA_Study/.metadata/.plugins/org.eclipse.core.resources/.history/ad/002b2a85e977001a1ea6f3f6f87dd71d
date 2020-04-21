package JAVAnew_IO;

import java.io.*;
import java.util.Date;

/**
 * Create By ${潘晟凯} on S{DATE}
 * 字符流+缓冲流+网络流
 *
 * 创建源：
 * 选择流：
 * 操作：
 * 释放资源：
 */
public class Buffur_IO_07 {
    public static void main(String[] args) throws Exception {
        //写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream dos =new ObjectOutputStream(new BufferedOutputStream(baos));

        dos.writeUTF("编码性酸类");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.flush();
        //加入对象
        dos.writeObject("谁解其中味");
        dos.writeObject(new Date());
        dos.writeObject(new Employee("mayu",400));
        byte[] datas = baos.toByteArray();
        //读取
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
        Object str = dis.readObject();
        Object date = dis.readObject();
        Object employee = dis.readObject();

        if(str instanceof String){
            String strObj = (String)str;
            System.out.println(strObj);
        }
        if(date instanceof Date){
            Date dateObj = (Date)date;
            System.out.println(dateObj);
        }
        if(employee instanceof Employee){
            Employee EmployeeObj = (Employee)employee;
            System.out.println(EmployeeObj);
        }

    }
}
