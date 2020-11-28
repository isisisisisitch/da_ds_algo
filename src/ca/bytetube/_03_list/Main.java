package ca.bytetube._03_list;



public class Main {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.indexOf(12));
        System.out.println(list.get(2));
        System.out.println(list.set(1,122));
        System.out.println(list);

    }
}
