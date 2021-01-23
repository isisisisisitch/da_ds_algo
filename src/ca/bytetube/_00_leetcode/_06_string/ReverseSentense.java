package ca.bytetube._00_leetcode._06_string;

public class ReverseSentense {

    public static String reverseSentence(String str) {
        if (str == null) return str;

        str = str.trim();
        String[] strings = str.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (i == strings.length - 1) {
                String oldWord = strings[i];//dal
                String newWord = oldWord.toUpperCase();//DAL
                oldWord = oldWord.replace(oldWord.charAt(0), newWord.charAt(0));//Dal
                sb.append(oldWord);
            }else if (i == 0) {//Hello
                String oldStr = strings[i];
                String newStr = oldStr.toLowerCase();
                oldStr = oldStr.replace(oldStr.charAt(0), newStr.charAt(0));//hello
                sb.append(oldStr);
            }else {
                sb.append(strings[i]);
            }

            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Hello bytetube and dal";
        System.out.println(reverseSentence(s));
    }
}
