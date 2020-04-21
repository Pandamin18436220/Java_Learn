package JAVA_Dynamic.byteCode;

@Author(name="pandamiin",year=2000)
public class Emp {
    private int empno;
    private String ename;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Emp(){
    }

    public Emp(int empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }
    public void sayHello(int a){
        System.out.println("Hello"+a);
    }
}
