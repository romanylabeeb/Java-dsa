package dsa.mustafaSaad.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BasicCalculator {
    Map<String, Integer> operatorWeightMap = getWeightMap();

    private Map<String, Integer> getWeightMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("+", 0);
        map.put("-", 0);

        map.put("/", 1);
        map.put("*", 1);
        return map;
    }
    public int calculate(String s) {

        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                }
                else if (operation == '+') {
                    stack.push(currentNumber);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
    public int calculate2(String s) {
        String[] tokens = formatTokens(s);
        Stack<Integer> operandStk = new Stack<>();
        Stack<String> operatorStk = new Stack<>();
        for (String token : tokens) {
            if(isOperator(token)){
                extractOperator(operatorStk,operandStk,token);
            }
            else {
                operandStk.push(Integer.valueOf(token));
            }
        }
        while (!operatorStk.isEmpty()){
            doCalc(operandStk,operatorStk.pop());
        }

        return operandStk.pop();
    }

    private void extractOperator(Stack<String> operatorStk, Stack<Integer> operandStk, String token) {
        if(operatorStk.isEmpty()){
            operatorStk.push(token);
        }
        else{
            boolean checking=true;
            int currentWeight=operatorWeightMap.get(token);
            while (!operatorStk.isEmpty()&&checking){
                int topWeight=operatorWeightMap.get(operatorStk.peek());
                if(topWeight>=currentWeight){
                    doCalc(operandStk,operatorStk.pop());
                }
                else{
                    checking=false;
                }
            }
            operatorStk.push(token);
        }
    }

    private void doCalc(Stack<Integer> operandStk, String operator) {
        int v2=operandStk.pop(),v1=operandStk.pop();
        switch (operator){
            case "*":
                v1*=v2;
                break;
            case "/":
                v1/=v2;
                break;
            case "-":
                v1-=v2;
                break;
            default:
                v1+=v2;
                break;
        }
        operandStk.push(v1);
    }

    boolean isOperator(String t) {
        return operatorWeightMap.containsKey(t);
    }

    private String[] formatTokens(String s) {
        StringBuilder formattedS = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                formattedS.append(c);
            } else if (operatorWeightMap.containsKey(String.valueOf(c))) {
                formattedS.append(" ").append(c).append(" ");
            }
        }
        return formattedS.toString().split(" ");
    }

    public static void main(String[] args) {
        BasicCalculator b = new BasicCalculator();
        String s = "50/ 2 -3 + 4*2";
        int y=b.calculate(s);
        System.out.println(y);
    }
}
