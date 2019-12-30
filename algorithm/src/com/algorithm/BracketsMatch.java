package com.algorithm;

import java.util.Stack;

public class BracketsMatch {
    public static void main(String[] args) {
        boolean match = isMatch("s(f)b");
        System.out.println(match);
    }

    private static boolean isMatch(String str){
        Stack<Character> st = new Stack<>();
        char temp;
        for(int i = 0; i < str.length(); i++) {
            temp = str.charAt(i);
            if(temp == '('){
                st.push(')');
            }
            if (temp == '{') {
                st.push('}');
            }
            if (temp == '['){
                st.push(']');
            }
            if (temp == ')' || temp == '}' || temp == ']') {
                if (temp != st.pop()) {
                    return false;
                }
            }
        }
        if (st.isEmpty() == true) {
            return true;
        }else {
            return false;
        }
    }
}
