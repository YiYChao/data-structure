package top.chao.array;

/**
 *  @Description: 自定义动态数组结构
 *  @author: YiYChao
 *  @Date: 2020/1/14 15:40
 *  @Version: V1.0
 */
public class Array<E> {
    private E[] data;  // 定义数组
    private int size;   // 记录数组元素的个数

    // 有参构造函数，定义数字的大小

    public Array(int capacity){
        this.data = (E[]) new Object[capacity];    // 此处绕了一个弯
    }

    // 无参构造函数
    public Array(){
        this(10);
    }

    // 获取数组中元素的个数
    public int getSize(){
        return size;
    }

    // 获取数组的容量
    public  int getCapacity(){
        return data.length;
    }

    // 判断数字是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * @Description: 向数字的最后添加元素
     * @Param: e 向数组的末尾添加元素
     * @return: 空
     * @Author：YiYChao
     * @date: 2020/1/14 16:04
     */
    public void addLast(E e){
//        if (size == data.length)
//            throw new IllegalArgumentException("Add Last  Failed, Array is full");
//        data[size++] = e;   // 向数组的最后添加元素，并且增加完成将记录数组元素个数的size变量的值增加1
        add(size,e);
    }

    // 向数组的最前面添加一个元素
    public void addFirst(E e){
        add(0,e);
    }

    // 向数组中的指定位置插入元素
    public void add(int index, E e){
        if (index > size || index < 0)
            throw new IllegalArgumentException("Index out of range!" + index);
        if (size == data.length)
            resize(data.length * 2);
        // 将数组中在index之后的数据都往后移动
        for(int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = e;    // 将数据添加到index位置上
        size ++;
    }

    // 获取数组中的某位位置的元素
    public E get(int index){
        // 首先判断数组的索引是否超出范围
        if (index < 0 || index >= size)
            throw  new IllegalArgumentException("Index out of range, get Failed!");
        return data[index];
    }

    // 修改数组中指定位置的元素
    public void set(int index, E e){
        // 首先判断数组的索引是否超出范围
        if (index < 0 || index >= size)
            throw  new IllegalArgumentException("Index out of range, get Failed!");
        data[index] = e;
    }

    // 判断数组中是否包含某个元素
    public boolean contains(E e){
        for (int i = 0; i < size; i++){
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * @Description: 查找数组中的某个元素，并将其索引返回，未找到返回-1
     * @Param: e 所要查找的元素
     * @return: int 元素对应的索引
     * @Author：YiYChao
     * @date: 2020/1/14 16:01
     */
    public int find(E e){
        for (int i = 0; i < size; i++){
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * @Description: 删除数组中指定位置的元素，并将该元素返回
     * @Param: index 元素的索引
     * @return: E 索引所对应的元素
     * @Author：YiYChao
     * @date: 2020/1/14 16:02
     */
    public E remove(int index){
        if (index < 0 || index >= size)
            throw  new IllegalArgumentException("Index out of range, remove Failed!" + index);
        E rst = data[index];
        // 将后面元素往前移动
        for (int i = index; i < size - 1; i++)
            data[i] = data[i + 1];
        size --;    // 将标记元素个数的size减1
        data[size] = null;     // 由于采用了泛型，这样可以有利于GCC垃圾回收
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return rst;
    }

    // 删除第一个元素,并将该元素返回
    public E removeFirst(){
        return remove(0);
    }

    // 删除最后一个元素，并将该元素返回
    public E removeLast(){
        return remove(size - 1);
    }

    // 删除数组中指定的元素
    public void removeElement(E e){
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    // 改变数组的大小
    private void resize(int newCapacity){
        E[] newDate = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++){
            newDate[i] = data[i];
        }
        data = newDate;
    }


    // 重写同String方法，发方便查看数组的所有元素
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Array : size = %d, capacity = %d\n", size, data.length));
        str.append("[");
        for (int i = 0; i < size; i++){
            str.append(data[i]);
            if (i != size - 1)
                str.append(",");
        }
        str.append("]");
        return str.toString();
    }
}
