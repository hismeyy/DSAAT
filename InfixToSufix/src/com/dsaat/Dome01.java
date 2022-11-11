package com.dsaat;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.dsaat.Priority.getPriority;

public class Dome01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        String expression = "( 5 + 1 ) * 20 + 3 - 1";
        String[] strings = expression.split(" ");

        // 初始化运算符栈和存储结果栈
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList();

        for(int i = 0; i < strings.length; i++){
            // 如果是一个数字
            if(strings[i].matches("\\d+")){
                s2.add(strings[i]);
            } else if(strings[i].equals("(")){ // 如果是左括号 则直接压入s1
                s1.push(strings[i]);
            } else if (strings[i].equals(")")) { // 如果是右括号 则从s1pop出放入s2遇到(停止，并且pop出(
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                while (true){
                    if(s1.size() == 0 || s1.peek().equals("(")){
                        s1.push(strings[i]);
                        break;
                    }else if(getPriority(strings[i]) > getPriority(s1.peek())){
                        s1.push(strings[i]);
                        break;
                    }else {
                        s2.add(s1.pop());
                    }
                }
            }
        }

        // 将剩余的运算符栈中的值依次弹出压入s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }

        System.out.println(s2);


        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s2.size(); i++){
            String ele = s2.get(i);
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

// 优先级类
class Priority{
    public final static int ADD = 1;
    public final static int SUB = 1;
    public final static int MUL = 2;
    public final static int DIV = 2;

    // 获取优先级
    public static int getPriority(String o){
        if(o.equals("+")){
            return ADD;
        }else if(o.equals("-")){
            return SUB;
        }else if(o.equals("*")){
            return MUL;
        }else if(o.equals("/")){
            return DIV;
        }else {
            System.out.println("符号错误");
            return 0;
        }
    }
}
