package top.chao.bst;
/**
 *  @Description:自定义二分搜索树的实现
 *  @author: YiYChao
 *  @Date: 2020/1/17 20:46
 *  @Version: V1.0
 */
public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left,right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
    private Node root;
    private  int size;

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e
    public void add(E e){
        root = add(root, e);
    }

    // 递归调用添加元素，内部使用
    private Node add(Node node, E e){
        if (node == null){
            size ++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }

    // 查看二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root, e);
    }

    // 递归查找二分搜索树中是否包含某个元素
    private boolean contains(Node node, E e){
        if (node == null)
            return  false;
        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else    // e.compareTo(node.e) > 0
            return contains(node.right, e);
    }

    // 二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    // 二分搜索树的以root为根的前序遍历，递归算法实现
    public void preOrder(Node node){
//        if (node == null)
//            return;
        if (node != null){
            System.out.println(node.e);     // 先根节点
            preOrder(node.left);            // 再左孩子节点
            preOrder(node.right);           // 最后有孩子节点
        }       // 递归自动终止，隐式结束
    }

    @Override
    public String toString(){
        StringBuilder rst = new StringBuilder();
        generateBSTString(root, 0, rst);
        return rst.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder rst){
        if (node == null){
            rst.append(generateDepthString(depth) + "null\n");
            return;
        }
        rst.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, rst);
        generateBSTString(node.right, depth + 1, rst);
    }

    private String generateDepthString(int depth){
        StringBuilder rst = new StringBuilder();
        for (int i = 0; i < depth; i++)
            rst.append("--  ");
        return rst.toString();
    }

}
