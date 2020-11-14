package ca.bytetube._02_arrayList;


public class Main {

    public static void main(String[] args) {
       ArrayList<Integer> arrayList = new ArrayList<>();
       arrayList.add(10);
       arrayList.add(11);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);



        int size = arrayList.size();
        //System.out.println(size);
       // System.out.println(arrayList.contains(16));
//        System.out.println(arrayList.set(1,100));
//        System.out.println(arrayList.get(1));
//        System.out.println(arrayList.remove(size-1));
//        System.out.println(arrayList.size());

       // System.out.println(arrayList.indexOf(13));
        arrayList.clear();
        System.out.println(arrayList.isEmpty());



    }
}
