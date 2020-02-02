package top.chao.trie;

import java.util.TreeMap;
/**
 *  @Description:字典树
 *  @author: YiYChao
 *  @Date: 2020/2/2 12:40
 *  @Version: V1.0
 */
public class Trie {

    // 节点，内部内
    private class Node{
        private boolean isWord;     // 白哦是截止本字符是否可以组成一个单词
        private TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }
    private int size;   // 节点个数
    private Node root;  // 根节点

    // 初始化字典树的构造函数
    public Trie(){
        root = new Node();
        size = 0;
    }


    // 获得Trie中存储的单词的个数
    public int getSize(){
        return size;
    }

    // 新字典树中添加新的单词
    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 字符在树中不存在
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);    //重新赋值当前字符节点
        }
        // 字符添加完毕，判断结尾是否已经标识，为表示则创建
        if (!cur.isWord){
            cur.isWord = true;
            size ++;
        }
    }

    // 查询单词是否存在于字典树中
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }


}
