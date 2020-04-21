package GOF23.Prototype;

import java.util.Date;
//深拷贝
public class Sheep2 implements Cloneable{//标记接口Cloneable
    private String sname;
    private Date birthday;
    public Sheep2(String sname, Date date){
        this.sname = sname;
        this.birthday = date;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone(); //直接调用object对象的clone()方法！

        //添加如下代码实现深拷贝
        Sheep2 s = (Sheep2) obj;
        s.birthday = (Date) this.birthday.clone();



        return obj;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
