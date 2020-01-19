package top.chao.map;

public interface Map<K, V> {
    int getSize();      // 获取映射元素个数

    boolean isEmpty();      // 判断是否为空

    boolean contains(K key);    // 检查是否包含

    void add(K key, V value);   // 添加元素

    V remove(K key);    //删除映射元素

    V get(K key);       // 获取key对应的值

    void set(K key, V value);   // 修改映射元素
}
