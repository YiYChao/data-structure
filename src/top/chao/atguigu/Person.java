package top.chao.atguigu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Person {
    private Integer id;
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
