package top.chao.segment;
/**
 *  @Description:两个元素的比较接口定义
 *  @author: YiYChao
 *  @Date: 2020/1/21 16:16
 *  @Version: V1.0
 */
public interface Merger<E> {

    // 定义两个元素的比较接口和规则，具体看实现
    E merge(E a, E b);
    
}
