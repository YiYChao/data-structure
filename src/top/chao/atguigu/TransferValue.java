package top.chao.atguigu;

public class TransferValue {
    public void change1Value1(int age){
        age = 30;
    }
    public void changeValue2(Person person){
        person.setName("bbb");
    }
    public void changeValue3(String str){
        str = "ccc";
    }

    public static void main(String[] args) {
        TransferValue transferValue = new TransferValue();
        int age = 20;
        transferValue.change1Value1(age);
        System.out.println("age--------->" + age);

        Person person = new Person("aaa");
        transferValue.changeValue2(person);
        System.out.println("name--------->" + person.getName());

        String str = "ddd";
        transferValue.changeValue3(str);
        System.out.println("String-------->" + str);
    }

}
