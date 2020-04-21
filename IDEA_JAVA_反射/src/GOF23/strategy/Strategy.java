package GOF23.strategy;

/**
 * 与责任链模式做对比
 *
 * 本质
 *   - 分离算法，选择实现
 *  场景：
 *    - JAVASE中GUI编程中，布局管理
 *    - Spring框架中，Resource接口，资源访问策略
 *    - java.servlet.http.HttpServlet#service()
 */
public interface Strategy {
    public double getPrice(double standerPrice);
}
