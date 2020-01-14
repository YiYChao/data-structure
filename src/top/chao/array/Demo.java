package top.chao.array;

public class Demo {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++){
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.addFirst(-1);
        System.out.println(arr);
        arr.add(2,20);
        System.out.println(arr);
        arr.set(4,14);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);
        arr.removeElement(14);
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);

    }
}
