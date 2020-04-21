package GOF23.command;

/**
 * 命令模式：
 *   - 将一个请求封装为一个对象，从而使我们可用不同的请求对客户进行参数化
 *     对请求排队或者记录请求日志，以及支持可撤销的操作。
 *     也称之为：动作Action模式，事务模式
 *
 * 场景：
 *   - Struct2,action的整个调用过程中就有命令模式
 *   - 数据库事务机制的底层实现
 *   - 命令的撤销和恢复
 */
public interface Command {
    /**
     * 这个方法是一个返回结果为空的方法
     * 实际项目中，可以根据需求设计多个不同的方法
     */
    void execute();
}
class ConcreteCommand implements Command{

    private Receiver receiver;//命令的真正执行者

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //命令真正执行前后，执行相关处理
        receiver.action();
    }
}
