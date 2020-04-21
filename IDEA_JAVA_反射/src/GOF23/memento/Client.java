package GOF23.memento;

public class Client {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();
        Emp emp = new Emp("pandamin",18,900);
        System.out.println(emp.getEname());
        taker.setMemento(emp.memeto());//备忘录一次
        emp.setAge(38);
        emp.setEname("hhh");
        System.out.println(emp.getEname());
        emp.recovery(taker.getMemento());//恢复
        System.out.println(emp.getEname());

    }
}
