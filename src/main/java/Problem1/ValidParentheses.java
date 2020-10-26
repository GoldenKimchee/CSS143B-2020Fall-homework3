package Problem1;

public class ValidParentheses {

    // Do not change signature (function name, parameters, return type)
    public static boolean isValid(String str) {
        //Uses ArrayStack
        if (str == null || str.length() == 0) {
            return true;
        }
        Stack<Character> stk= new ArrayStack<>(str.length());
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[' || c == ')' || c == '}' || c == ']') {
                switch (c) {
                    case '(':
                    case '{':
                    case '[':
                        stk.push(c);
                        break;
                    case ')':
                    case '}':
                    case ']':
                        if (stk.peek() != null) {
                            char last = stk.peek();
                            if (c == ')' && last == '(' || c == '}' && last == '{' || c == ']' && last == '[') {
                                stk.pop();
                                if (i == str.length() - 1) { //check if it is the last one
                                    return true;
                                }
                            } else {
                                return false;
                            }
                        }
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
