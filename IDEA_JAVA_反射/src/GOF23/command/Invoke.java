package GOF23.command;

/**
 * 调用者，发起者
 */
public class Invoke {
    private Command command;//也可以通过容器List<Command>容纳很多命令

    public Invoke(Command command){
        this.command = command;
    }
    //业务方法，用于调用命令类方法
    public void call(){
        command.execute();
    }
}
