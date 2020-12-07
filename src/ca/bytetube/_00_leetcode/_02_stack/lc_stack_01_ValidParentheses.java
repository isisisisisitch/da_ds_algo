package ca.bytetube._00_leetcode._02_stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * @author dal
 */
public class lc_stack_01_ValidParentheses {

    private static HashMap<Character,Character> map = new HashMap<>();
    static {
              //entry
             //key--->value
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        //#$
    }
    public  boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            //1. 遇见左括号，将左括号入栈
            if (map.containsKey(c)) {
                stack.push(c);
            }else {//一定遇见右括号
                if (stack.isEmpty()) return false;
                //如果栈不为空，将栈顶括号出栈，与右括号之匹配
                char left = stack.pop();
                if (c !=  map.get(left)) return false;
            }
        }
        //栈为空，说明括号有效
        //栈不为空，说明括号无效
        return stack.isEmpty();


    }
    public static boolean isValid1(String s){
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
           char c = chars[i];
           //1. 遇见左括号，将左括号入栈
            if (c == '(' || c == '['  || c == '{') {
                stack.push(c);
            }else {//一定遇见右括号
                if (stack.isEmpty()) return false;
                //如果栈不为空，将栈顶括号出栈，与右括号之匹配
                char left = stack.pop();
                if (left == '(' && c != ')') return false;
                if (left == '[' && c != ']') return false;
                if (left == '{' && c != '}') return false;
            }
        }
        //栈为空，说明括号有效
        //栈不为空，说明括号无效
        return stack.isEmpty();
    }




    public static boolean isValid0(String s) {
        while (s.contains("()")|| s.contains("{}")||s.contains("[]")){
            s.replace("()","");
            s.replace("{}","");
            s.replace("[]","");
        }

        return s.isEmpty();

    }
}
