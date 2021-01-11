package ca.bytetube._07_binarytree;

import ca.bytetube._07_binarytree.printer.BinaryTrees;

import java.util.Comparator;




public class Main {

    private static class PersonComparator implements Comparator<Person> {
        public int compare(Person e1, Person e2) {
            return e2.getAge() - e1.getAge();
        }
    }

    static void test1() {

//        Person[] data = new Person[]{new Person(21,"david"),
//                                        new Person(32,"tom"),
//                new Person(45,"jack"),new Person(24,"tony"),
//                new Person(67,"liam"),new Person(21,"william"),new Person(11,"dal"),};
//        BinarySearchTree<Person> bst = new BinarySearchTree<>(new PersonComparator());
//        for (int i = 0; i < data.length; i++) {
//            bst.add(data[i]);
//        }
//                BinaryTrees.println(bst);

        Integer data[] = new Integer[] {
                7,5,8,4
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
        //System.out.println(bst.height0());
        System.out.println(bst.isComplete());
//        System.out.println("=========================================");
//        for (int i = 2; i < 9; i++) {
//            bst.remove(i);
//            BinaryTrees.println(bst);
//            System.out.println("=========================================");
//        }
//        System.out.println(bst.isEmpty());
        //BinaryTrees.println(bst);
//        System.out.println(bst.isComplete());
//        //bst.remove(12);
//        System.out.println("=========================================");
//        BinaryTrees.println(bst);
//        System.out.println(bst.isComplete());
        //bst.remove(7);
//        System.out.println("=========================================");
//        BinaryTrees.println(bst);
//        System.out.println(bst.contains(7));
//        System.out.println(bst.height2());
        //System.out.println(bst.node(12));
    }




    public static void main(String[] args) {

        test1();
    }
}
