package com.dsaat;

import java.util.LinkedList;
import java.util.Stack;

public class Dome01 {
    public static void main(String[] args) {
        String prefix = "3 4 + 5 * 6 -";
        String[] s = prefix.split(" ");
        LinkedList<String> prefixList = new LinkedList<>();
        for(String item : s){
            prefixList.add(item);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < prefixList.size(); i++){
            String ele = prefixList.get(i);
            // 如果是数字进行压栈
            if(ele.matches("\\d+")){
                stack.push(Integer.parseInt(ele));
            }else {
                int result;
                int num2 = stack.pop();
                int num1 = stack.pop();
                result = cal(num1,num2,ele);
                stack.push(result);
            }
        }
        System.out.println("最后结果是：" + stack.pop());
    }

    private static int cal(int num1, int num2, String operator) {
        if("+".equals(operator)){
            return num1 + num2;
        }else if("-".equals(operator)){
            return num1 - num2;
        }else if("*".equals(operator)){
            return num1 * num2;
        }else if("/".equals(operator)){
            return num1 / num2;
        }else {
            System.out.println("运算符错误");
            return 0;
        }
    }
}
