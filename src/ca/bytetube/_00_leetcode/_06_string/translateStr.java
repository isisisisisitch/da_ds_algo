package ca.bytetube._00_leetcode._06_string;

public class translateStr {
    public static String translateStr(String str) {
        if (str == null) return str;

        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        int curr = 0;
        int cnt = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[curr]) {
                sb.append(chars[curr]).append(cnt);
                curr = i;
                cnt = 1;
            }else {
                cnt++;
            }
        }

        sb.append(chars[curr]).append(cnt);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(translateStr("arffyuddddvviiooaaacc"));
    }
}
