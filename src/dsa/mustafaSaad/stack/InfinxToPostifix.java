package dsa.mustafaSaad.stack;

import java.util.*;

public class InfinxToPostifix {
    Map<String, Integer> operatorWeightMap = getWeightMap();
    public int calculate(String s) {
        StringBuilder formattedS = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                formattedS.append(c);
            } else if (operatorWeightMap.containsKey(Character.toString(c))) {
                formattedS.append(" ").append(c).append(" ");
            }
        }
        String  []tokens=getPostfix(formattedS.toString().split(" "));
        return evalRPN(tokens);
    }
    public String []getPostfix(String []s) {
//        String[] cs = s.split(" ");
        Stack<String> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (String c  : s) {
            if (operatorWeightMap.containsKey(c)) {
                validateOpertors(stack, sb, c);
            }
            else{
                sb.append(c).append(" ");
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString().split(" ");
    }

    private void validateOpertors(Stack<String> stack, StringBuilder sb, String c) {
        boolean checking = true;
        int currentWeight = operatorWeightMap.get(c);
        while (!stack.isEmpty() && checking) {
            int topWeight = operatorWeightMap.get(stack.peek());
            if (topWeight >= currentWeight) {
                sb.append(stack.pop()).append(" ");
            } else {
                checking = false;
            }
        }
        stack.push(c);
    }

    private Map<String, Integer> getWeightMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("+", 0);
        map.put("-", 0);

        map.put("/", 1);
        map.put("*", 1);
        return map;
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack=new ArrayDeque<>();
        Set<String> operations=new HashSet<>(List.of("*","-","+","/"));
        for(String s:tokens){
            if(operations.contains(s)){
                doCalc(s,stack);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }

    private void doCalc(String s, Deque<Integer> stack) {
        int v2=stack.pop(),v1=stack.pop();
        switch (s){
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
        stack.push(v1);
    }
    public static void main(String[] args) {
        InfinxToPostifix f=new InfinxToPostifix();
        System.out.println(f.calculate("60/2 - 3+ 4* 2"));
    }


}
