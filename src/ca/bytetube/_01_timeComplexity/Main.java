package ca.bytetube._01_timeComplexity;

public class Main {

    public static void main(String[] args) {
//       Times.test("fib1", new Times.Task() {
//           @Override
//           public void execute() {
//               System.out.println(fib1(45));
//           }
//       });

        Times.test("fib2", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib2(1000));
            }
        });
    }

    //fib(4) = fib(3)+ fib(2)=2+1 =3
    //fib(3) = fib(2) + fib(1)=1+1 = 2
    //fib(2) = fib(1) + fib(0)=0+1=1
    //fib(0) = fib(-1) + fib(-2)
    //fib(1) = fib(0) + fib(-1)
    //
    public static int fib1(int n){//5
        if (n <= 1) return n;
        return fib1(n - 1) + fib1(n - 2);
    }

    public static int fib2(int n){
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        //n表示整个累加的过程
        for (int i = 0; i < n-1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }

        return second;
    }



    public static void test1(int n){//O(1)
        //12
        //1
        if (n > 10) {
            System.out.println("n> 10");
        }else if (n > 5) {
            System.out.println("n> 5");
        }else {
            System.out.println("n<=5");
        }

        //1 +4+ 4+ 4 = 13
        for (int i = 0; i < 4; i++) {
            System.out.println("test1");

        }

        //1+ 13 = 14
    }

    public static void test2(int n){//O(n)
        //1 n n n
        for (int i = 0; i < n; i++) {

            System.out.println("test2");
        }

        //3n+1
    }

    public static void test3(int n){//O(n^2 )

        //1+ n +n+ n*(3n+1) = 2n+1+ 3n^2 + n = n^2
        for (int i = 0; i < n; i++) {
            //1 n n  n = 3n+1
            for (int j = 0; j < n; j++) {
                System.out.println("test3");
            }

        }



    }


    public static void test4(int n){
        /*
        n = 8
        n/2 = 4 sout
        n/2 = 2 sout
        n/2 = 1 sout
        n/2 = 0
        2^3 = 8
        3= log2(8)
        log2(n)
         */
        while ((n = n/2) > 0){
            System.out.println("aaaaa");
        }
    }
}
