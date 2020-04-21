package GOF23.Prototype;

import java.io.Serializable;
import java.util.Date;
//浅拷贝
public class Sheep implements Cloneable, Serializable {//标记接口Cloneable
    private String sname;
    private Date birthday;
    public Sheep(String sname, Date date){
        this.sname = sname;
        this.birthday = date;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone(); //直接调用object对象的clone()方法！

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
