package ca.bytetube._01_timeComplexity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Times {
    private static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSS");

    public interface  Task{
        void execute();
    }


    public static void test(String title,Task task){

        if (task == null) return;

        title = (title == null)?"":("["+ title +"]");
        System.out.println(title);

        System.out.println("start:"+fmt.format(new Date()));
        long start = System.currentTimeMillis();

        task.execute();

        long end = System.currentTimeMillis();
        System.out.println("end:"+fmt.format(new Date()));
        double delta = (end - start) / 1000.0;

        System.out.println("spends"+ delta+"seconds");

        System.out.println("======================");
    }

}
