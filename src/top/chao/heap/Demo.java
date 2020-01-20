package top.chao.heap;

import java.util.Arrays;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        int num = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>(num);

        for (int i = 0; i < num; i++) {
            maxHeap.add(new Random().nextInt(Integer.MAX_VALUE));
        }
        int[] rst = new int[num];
        int[] tmp = new int[num];
        for (int i = 0; i < num; i++) {
            rst[i] = tmp[i] = maxHeap.extractMax();
        }

        Arrays.sort(tmp);
        // 进行比较
        for (int i = 0; i < num; i++) {
            if (rst[i] != tmp[num - 1 - i])
                throw new IllegalArgumentException("Sorted Error");
//            System.out.print(rst[i] + "\t");
        }
        System.out.println("SUCCESS");
//        for (int i = 0; i < num; i++) {
//            System.out.print(rst[i] + "\t");
//        }
        compare();
    }

    private static double testHeap(Integer[] testData, boolean isHeapify){
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if(isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else{
            maxHeap = new MaxHeap<>();
            for(int num: testData)
                maxHeap.add(num);
        }
        int[] rst = new int[testData.length];
        int[] tmp = new int[testData.length];
        for(int i = 0 ; i < testData.length ; i ++)
            rst[i] = tmp[i] = maxHeap.extractMax();
        Arrays.sort(tmp);
        // 进行比较
        for (int i = 0; i < testData.length; i++) {
            if (rst[i] != tmp[testData.length - 1 - i])
                throw new IllegalArgumentException("Sorted Error");
//            System.out.print(rst[i] + "\t");
        }
        System.out.println("Test MaxHeap completed.");
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void compare() {

        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for(int i = 0 ; i < n ; i ++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");
    }
}
