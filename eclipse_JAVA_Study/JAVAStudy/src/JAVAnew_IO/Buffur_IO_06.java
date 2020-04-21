package JAVAnew_IO;

import java.io.*;

/**
 * Create By ${潘晟凯} on S{DATE}
 * 字符流+缓冲流+网络流
 *
 * 创建源：
 * 选择流：
 * 操作：
 * 释放资源：
 */
public class Buffur_IO_06 {
    public static void main(String[] args) throws IOException {
        //写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos =new DataOutputStream(baos);

        dos.writeUTF("编码性酸类");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.flush();
        byte[] datas = baos.toByteArray();
        //读取
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(datas));
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
    }
}
class Employee implements Serializable{
    private transient String name;//使用transient 可以该数据不需要序列化
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}