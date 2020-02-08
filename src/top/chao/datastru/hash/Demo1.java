package top.chao.datastru.hash;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description:体验Java自带的HashCode函数
 * @author: YiYChao
 * @Date: 2020/2/7 10:56
 * @Version: V1.0
 */
public class Demo1 {
    public static void main(String[] args) {
        int a = 33;
        System.out.println(((Integer) a).hashCode());       // 33

        int b = -35;
        System.out.println(((Integer) b).hashCode());       // -35

        double c = 31.43;
        System.out.println(((Double) c).hashCode());        // 987638202

        String d = "Test";
        System.out.println(d.hashCode());                   // 2603186

        String e = "test";
        System.out.println(e.hashCode());                   // 3556498

        Student stu1 = new Student(3, 2, "Yi", "Chao");
        System.out.println(stu1.hashCode());                // 2246370

        Student stu2 = new Student(3, 2, "yi", "chao");
        System.out.println(stu2.hashCode());                // 2246370

        HashSet<Student> set = new HashSet<>();
        set.add(stu1);

        HashMap<Student, Integer> map = new HashMap<>();
        map.put(stu2, 99);
    }
}
