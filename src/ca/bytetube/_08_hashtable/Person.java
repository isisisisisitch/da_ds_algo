package ca.bytetube._08_hashtable;

import java.util.HashMap;
import java.util.Map;

public class Person {
    private int age;
    private float height;
    private String name;

    public Person(int age, float height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    /**
     *为什么要重写equals方法？
     * 假设有一个index的位置上连接了多个value（bucket）
     * 这时新插入一个新的key，经过hash函数运算得到hashcode，算出其对应的索引index
     * 假设新的key和老key对应的index相同，
     * 既然相同，就需要把这个key和index索引上的list的多个value进行对比
     * 如果是同一个key，就替换，不同则追加
     *
     *
     *不能用hashcode值作为equals方法的比较的标准
     * 有可能不同类型的数据可以得到相同的hash值，但是它们不是同一个对象  long student
     *
     * equals方法的调用时机：当发生哈希冲突时用来对比2个key是否相同
     */
    @Override
    public boolean equals(Object obj){
        Person person = (Person) obj;
        if (this == obj) return true;
        return person.age==this.age && person.height == this.height
                &&(person.name == null ? this.name == null : person.name.equals(this.name));

    }


    @Override
    public int hashCode(){
        int hashCode = Integer.hashCode(age);
        hashCode = 31 * hashCode + Float.hashCode(height);
        hashCode = 31 * hashCode + (name != null ? name.hashCode() : 0);
        return hashCode;
    }

    public static void main(String[] args) {
        Person p1 = new Person(20,1.74f,"dal");
        Person p2 = new Person(20,1.74f,"dal");
        System.out.println(p1.hashCode());//1639705018
        System.out.println(p2.hashCode());//1627674070
        Map<Object,Object> map = new HashMap<>();
        map.put(p1,"abc");
        map.put(p2,"bcd");
        System.out.println(map.size());
        System.out.println(p1.equals(p2));
    }
}
