package top.chao.bst;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] arr = {5, 3, 6, 8, 4, 2};
        for (int num : arr)
            bst.add(num);
        System.out.println("层序遍历：");
        bst.levelOrder();
        System.out.println("递归前序遍历：");
        bst.preOrder();     // 前序遍历
        System.out.println("非递归前序遍历：");
        bst.preOrderNR();
        System.out.println("递归中序遍历：");
        bst.imOrder();      // 中序遍历
        System.out.println("递归后续遍历：");
        bst.postOrder();    // 后续遍历

        System.out.println(bst);
        bst.remove(3);
        System.out.println(bst);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
//        removeTest();
    }

    public static void removeTest(){
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 10000; i++) {
            bst.add(new Random().nextInt(100000));
        }
        bst.imOrder();
        while (!bst.isEmpty()) {
            System.out.print(bst.removeMinimum() + "\t");
        }
    }
}
