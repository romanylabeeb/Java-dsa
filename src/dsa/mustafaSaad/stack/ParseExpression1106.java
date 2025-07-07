package dsa.mustafaSaad.stack;

import java.util.*;
import java.util.stream.Collectors;

public class ParseExpression1106 {
    //Input: expression = "&(|(f))"
    //// &(|(f,&(t,t,|(f,t,f))))
    public static boolean parseBoolExpr(String expression) {
        Stack<Character> stk = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == ')') {
                calc(stk);
            } else if (c != '(' && c != ',') {
                stk.push(c);
            }

        }
        return stk.pop() == 't';
    }

    static void calc(Stack<Character> stk) {
        boolean containFalse = false;
        boolean containTrue = false;
        Set<Character> opers = Set.of('&', '|', '!');
        while (!stk.isEmpty() && !opers.contains(stk.peek())) {
            char c = stk.pop();
            if (c == 'f')
                containFalse = true;
            else if (c == 't') {
                containTrue = true;
            }
        }
        char oper = stk.pop();
        if (oper == '&') {
            if (containFalse) {
                stk.push('f');
            } else {
                stk.push('t');
            }
        } else if (oper == '|') {
            if (!containTrue) {
                stk.push('f');
            } else {
                stk.push('t');
            }
        } else if (oper == '!') {
            if (!containFalse) {
                stk.push('f');
            } else {
                stk.push('t');
            }
        }
    }

    static void removeElements() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        // want to remove all even elements
        // using iterator
//        Iterator<Integer> iterator = list.iterator();
//        // Iterate through the list
//        while (iterator.hasNext()) {
//            Integer el = iterator.next();
//            if (el % 2 == 0) {
//                iterator.remove();  //Removes the last element returned by the next() method
//            }
//        }
        list = list.stream().filter(el -> el % 2 != 0).collect(Collectors.toList());
        list.forEach(System.out::println);

    }

    public static void main(String[] args) {
//        System.out.println(parseBoolExpr("&(|(f,&(t,t,|(f,t,f))))"));
        removeElements();
    }
}
