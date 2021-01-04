package ca.bytetube._07_binarytree;

public class Person implements Comparable<Person>{
    int age;
    String name;


    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.age-o.age;
    }


    @Override
    public String toString() {
        return "{age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
