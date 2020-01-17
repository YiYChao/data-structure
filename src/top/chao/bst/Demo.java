package top.chao.bst;

public class Demo {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] arr = {5, 3, 6, 8, 4, 2};
        for (int num : arr)
            bst.add(num);
//        bst.preOrder();

        System.out.println(bst);
    }
}
