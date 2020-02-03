package top.chao.uf;
/**
 *  @Description:并查集接口定义
 *  @author: YiYChao
 *  @Date: 2020/2/3 21:23
 *  @Version: V1.0
 */
public interface UF {
    // 获取并查集中元素的个数
    int getSize();
    // 判断并查集中两个元素是否连接
    boolean isConnected(int p, int q);
    // 合并两个并查集
    void unionElement(int p, int q);
}
