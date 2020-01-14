package top.chao.array;

import java.util.Random;

public class Student {
    private String name;
    private int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString(){
        return String.format("Student[name : %s, socre : %d]",name, score);
    }

    public static void main(String[] args) {
        Array<Student> stuList = new Array<>(3);
        for (int i = 0; i < stuList.getCapacity(); i++){
            stuList.addLast(new Student("zhagns" + i, new Random(100).nextInt()));
        }
        System.out.println(stuList);
    }
}
