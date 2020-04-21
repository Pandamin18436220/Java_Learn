package GOF23.chain_of_responsiblity;

/**
 * 定义：
 *   将能够处理同一类请求的对象连成一条链，所提交的请求沿着链传递
 *   链上的对象逐个判断是否有能力处理请求，如果能则处理，如果不能
 *   则传递给链上的下一个对象。
 *
 * 链表方式实现责任链
 *   - 链表LinkList
 * 非链表方式实现责任链
 *   - 集合
 *   - 数组 ArrayList
 *
 *  场景：
 *   - Java中，异常机制就是一种责任链模式，一个try可以对应多个catch
 *     当第一个catch不匹配类型，则自动跳到第二个catch
 *   - Javascript语言中，事件冒泡和捕获机制。java语言中，事件的处理采用观察者模式。
 *   - Servlet开发中，过滤器的链式处理
 *   - Struts2中,拦截器的调用也是典型的责任链模式
 */
public class responsiblity {
}
