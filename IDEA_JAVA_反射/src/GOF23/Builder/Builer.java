package GOF23.Builder;

/**
 * 建造模式的本质
 *   - 分离了对象子组件的单独构造（builder）和装配（Director负责）。从而可以构建出负责的对象。
 *     这个模式适用于：某个对象的构建过程复杂的情况下使用。
 *   - 由于实现了构建和装配的解耦。不同的构造器，相同的装配，也可以做出不同的对象；
 *     相同的构造器，不同的装配顺序也可以做出不同的对象。也就是实现构建算法，装配算法的解耦，实现了更好的复用。
 *
 * 开发中应用场景
 *   - StringBuider类的append方法
 *   - SqL中的prepredStatement
 *   - JDOM中，DomBuider，SAXBuider
 */
public class Builer {
}
