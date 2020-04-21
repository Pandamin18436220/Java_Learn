package GOF23.Observer;

import javax.security.auth.Subject;

/**
 * 可以把多个订阅者，客户端称为观察者；
 *   需要同步给多个订阅者数据封装到对象中，称之为目标。
 *
 *  核心：
 *   观察者模式，当一个对象（目标对象Subject或者Objservable）的状态变化时，他需要及时告知一系列对象
 *   （观察者对象，observer）,令他们做出响应
 *
 *   - 通知观察者的方式：
 *     推
 *        - 每次都会把通知以广播方式发送给所有观察者，所有观察者只能被动接收
 *     拉
 *        - 观察者只要直到有情况即可。至于什么时候获取内容，获取什么内容，都可以自主决定
 */
public interface Obser {
    void update(Sub subject);
}
