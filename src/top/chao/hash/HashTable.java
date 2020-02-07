package top.chao.hash;

import java.util.TreeMap;

/**
 * @Description:自定义哈希表实现
 * @author: YiYChao
 * @Date: 2020/2/7 11:22
 * @Version: V1.0
 */
public class HashTable<K, V> {

    private static final int[] capacity = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593, 49157, 98317, 196613, 393241, 786433,
            1572869, 3145739, 6291469, 12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 161062741};
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private int capacityIndex = 0;

    private TreeMap<K, V>[] hashtable;
    private int size;
    private int M;

    public HashTable(int m) {
        this.M = m;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(capacity[0]);
    }

    // 获得键的哈希值
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    // 获得哈希表中元素的个数
    public int getSize() {
        return size;
    }

    // 向哈希表中添加元素
    public void add(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key))
            map.put(key, value);
        else {
            map.put(key, value);
            size++;
            // 进行数组的动态扩容
            if (size >= upperTol * M && capacityIndex + 1 < capacity.length) {   // 将除法转变成为乘法
                capacityIndex ++;
                resize(capacity[capacityIndex]);
            }
        }
    }

    // 从哈希表中移除元素
    public V remove(K key) {
        V ret = null;
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
            // 进行数组的动态缩容
            if (size < lowerTol * M && capacityIndex - 1 >= 0)
                capacityIndex --;
                resize(capacity[capacityIndex]);
        }
        return ret;
    }

    // 动态对数组进行扩容和缩容操作
    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++)
            newHashTable[i] = new TreeMap<>();

        int oldM = M;   // 用户循环取值
        this.M = newM;  // 用于计算新的哈希键值！！！
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashtable[i];
            for (K key : map.keySet())
                newHashTable[hash(key)].put(key, map.get(key));
        }

        this.hashtable = newHashTable;
    }

    // 修改哈希表中元素键所对应的值
    public void set(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");

        map.put(key, value);
    }

    // 判断哈希表中是否包含某个键
    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    // 获取哈希表中元素的key所对应元素的值
    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }

}
