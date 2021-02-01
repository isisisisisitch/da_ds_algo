package ca.bytetube._11_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LowestLexicography {

    private static class LowestLexicographyComparator implements Comparator<String>{

        @Override
        public int compare(String s1, String s2) {
            return (s1 + s2).compareTo(s2 + s1);
        }
    }

    public static String lowestLexicography(String[] strings){
        if (strings == null || strings.length == 0) return "";

        Arrays.sort(strings,new LowestLexicographyComparator());
        String res = "";
        for (int i = 0; i < strings.length; i++) {
            res += strings[i];
        }


        return res;
    }

    public static void main(String[] args) {
        String[] strings = {"ba","b"};
        System.out.println(lowestLexicography(strings));
    }
}
