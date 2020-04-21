package GOF23.iterator;

/**
 * 自定义迭代接口
 */
public interface MyIterator {
    void first();           // 将游标指向第一个元素
    void next();
    boolean hasNext();

    boolean isFirst();
    boolean isLast();

    Object getCurrentObj();  //获取当前游标指向的对象
}
