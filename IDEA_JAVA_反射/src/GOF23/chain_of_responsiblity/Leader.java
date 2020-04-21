package GOF23.chain_of_responsiblity;

public abstract class Leader {
    protected String name;
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    /**
     * 处理请求核心的业务方法
     * @param request
     */
    public abstract void handleRequest(LeaveRequest request);
}
