package top.chao.datastru.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        System.out.println();
    }

    // 二分搜索树的以root为根的前序遍历，递归算法实现
    public void preOrder(Node node){
//        if (node == null)
//            return;
        if (node != null){
            System.out.println(node.e + "\t");     // 先根节点
            preOrder(node.left);            // 再左孩子节点
            preOrder(node.right);           // 最后有孩子节点
        }       // 递归自动终止，隐式结束
    }

    // 二分搜索树的以root为根的前序遍历，非递归算法实现
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            Node curr = stack.pop();    // 出栈
            System.out.println(curr.e); // 遍历出节点元素
            // 栈是后进先出的！！！
            if (curr.right != null)      // 当前出栈节点的左孩子不为空则入栈
                stack.push(curr.right);
            if (curr.left != null)     // 当前出栈节点的右孩子不为空则入栈
                stack.push(curr.left);
        }
    }

    // 二分搜索树的中序遍历
    public void imOrder(){
        imOrder(root);
        System.out.println();
    }

    // 二分搜索树的以root为根的中序遍历，递归算法实现
    private void imOrder(Node node){
        if (node != null){
            imOrder(node.left);     // 先左孩子节点
            System.out.print(node.e + "\t");     // 再根节点
            imOrder(node.right);    // 最后右孩子节点
        }
    }

    // 二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }

    // 二分搜索树的以root为根的后序遍历，递归算法实现
    private void postOrder(Node node){
        if (node != null){
            postOrder(node.left);     // 先左孩子节点
            postOrder(node.right);    // 然后右孩子节点
            System.out.println(node.e + "\t");     // 最后根节点
        }
    }

    // 二分搜索树的层序遍历（广度优先遍历）
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node curr = queue.remove();     // 当前遍历到的元素
            System.out.println(curr.e);     // 遍历当前节点元素
            // 队列是先进先出
            if (curr.left != null)          // 先将左子树入队
                queue.add(curr.left);
            if (curr.right != null)         // 再将右子树入队
                queue.add(curr.right);
        }
    }

    // 查找二分搜索树的最小元素
    public E minimum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is Empty");
        return minimum(root).e;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    // 从二分搜索树中删除最小值所在的节点，并将节点元素返回
    public E removeMinimum(){
        E rst = minimum();
        root = removeMinimum(root);  // 删除最小值后的根节点
        return rst;
    }

    // 删除以node为根的二分搜索树中的最小节点，并返回删除后新的二分搜索树
    private Node removeMinimum(Node node){
        if (node.left == null){
            Node right  = node.right;
            node.right = null;      // 进行删除
            size --;
            return right;
        }
        node.left = removeMinimum(node.left);   // 递归
        return node;
    }

    // 查找二分搜索树的最大元素
    public E maximum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is Empty");
        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node){
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    // 从二分搜索树中删除最大值所在的节点，并将节点元素返回
    public E removeMaximum(){
        E rst = maximum();
        root = removeMaximum(root);  // 删除最大值后的根节点
        return rst;
    }

    // 删除以node为根的二分搜索树中的最大节点，并返回删除后新的二分搜索树
    private Node removeMaximum(Node node){
        if (node.right == null){
            Node left  = node.left;
            node.left = null;      // 进行删除
            size --;
            return left;
        }
        node.right = removeMinimum(node.right);   // 递归
        return node;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }

    // 删除以node为根的二分搜索树中值为e的节点，并将新的二分搜索树返回，递归算法实现
    private Node remove(Node node, E e){
        if (node == null)
            return null;
        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }else { // e.equals(node.e)
            // 待删除节点的左子树为空
            if (node.left == null){
                Node right = node.right;
                node.right = null;  // 进行删除
                size --;
                return right;
            }
            // 待删除节点的右子树为空
            if (node.right == null){
                Node left = node.left;
                node.left = null;  // 进行删除
                size --;
                return left;
            }
            // 待删除节点的左右子树均不为空
//            Node successor = minimum(node.right);  // 找到比待删除节点稍大的  后继节点
//            successor.right = removeMinimum(node.right);    // 已经进行删除，即size--
//            successor.left = node.left;
//            node.left = node.right = null;  // 彻底删除
//            return successor;
            Node precursor = maximum(node.left);  // 找到比待删除节点稍小的  前驱节点
            // 需要先进行移除，再改变另一个孩子节点，否则会出现栈溢出java.lang.StackOverflowError
            precursor.left = removeMaximum(node.left);   // 已经进行删除，即size--
            precursor.right = node.right;
            node.left = node.right = null;  // 彻底删除
            return precursor;
        }
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