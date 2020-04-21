package GOF23.chain_of_responsiblity;

public class Client {
    public static void main(String[] args) {
        Leader a =new Director("1");
        Leader b =new Manager("2");
        Leader c =new GeneralManager("3");

        //组织责任链对象关系
        a.setNextLeader(b);
        b.setNextLeader(c);

        //开始请假
        LeaveRequest req1 = new LeaveRequest("TOM",10,"123");
        a.handleRequest(req1);
    }
}
