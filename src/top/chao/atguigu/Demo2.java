package top.chao.atguigu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 *  @Description: CAS说明
 *  @author YiYChao
 *  @Date: 2020/11/12 17:50
 *  @version V1.0
 */
@Getter
@ToString
@AllArgsConstructor
class User{
    String username;
    int age;
}

public class Demo2 {

    public static void main(String[] args) {
        User zhang = new User("zhang", 12);
        User li = new User("li", 31);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(zhang);
        System.out.println(atomicReference.compareAndSet(zhang, li) + "\t" + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(zhang, li) + "\t" + atomicReference.get().toString());
    }

}
