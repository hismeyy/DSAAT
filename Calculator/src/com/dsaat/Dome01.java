package com.dsaat;

import java.util.Stack;

public class Dome01 {
    public static void main(String[] args) {
        String cal = "1+1+12";
        char[] data = cal.toCharArray();
        int index = -1;
        Stack numberStack = new Stack();
        Stack operatorStack = new Stack();
        String number = "";

        while(true){
            index++;
            // 首先判断一下index是否大于data的长度,小于执行循环，大于退出
            if(index < data.length){
                // 判断data是否为运算符
                if(isOperator(data[index])){// 是运算符
                    // 判断operatorStack是否未空
                    if(operatorStack.size() == 0){ //符号栈为空
                        // 直接放入运算符
                        operatorStack.push(data[index]);
                    }else {//符号栈不为空
                        // 判断优先级 将要push到operatorStack中的运算符和已经在operatorStack中的运算符比较
                        if(getPriority(data[index]) <= getPriority((char)operatorStack.peek())){ // 小或者相同
                            // 取出numberStack中的两个数字和operatorStack中的运算符进行计算
                            int result = cal((int)numberStack.pop(),(int)numberStack.pop(),(char)operatorStack.pop());
                            // 将算出的结果放入numberStack中
                            numberStack.push(result);
                            // 将未放入的运算符放入operatorStack中
                            operatorStack.push(data[index]);
                        }else {// 优先级大直接放入operatorStack中
                            operatorStack.push(data[index]);
                        }
                    }
                }else {// 不是运算符
                    // 看一下index的下一个是否大于data.length
                    int i = index + 1;
                    if(i  < data.length){ // 没有越界
                        // 查看下一个是否是运算符
                        if(isOperator(data[i])){// 是运算符
                            // 直接将数字让如numberStack中 因为是char类型需要转换
                            number = number + data[index];
                            int x = Integer.parseInt(number);
                            numberStack.push(x);
                            number = "";
                        }else { // 不是运算符
                            // 进行拼接
                            number = number + data[index];
                        }
                    }else {//越界直接将最后一个数字放入numberStack中
                        // 看一下number是否为空
                        if(number == ""){ // 空
                            // 说明上一个不是数字
                            numberStack.push(Integer.parseInt(String.valueOf(data[index])));
                        }else {// 不空说明是数字
                            // 拼接后放入
                            number = number + data[index];
                            int x = Integer.parseInt(number);
                            numberStack.push(x);
                            number = "";
                        }
                    }
                }
            }else {break;}
        }

        // 遍历numberStack和operatorStack进行运算
        int result = 0;
        while (operatorStack.size() != 0){
            // 取出numberStack中的两个数字和operatorStack中的运算符进行计算
            result = cal((int)numberStack.pop(),(int)numberStack.pop(),(char)operatorStack.pop());
            // 将算出的结果放入numberStack中
            numberStack.push(result);
        }
        System.out.println("最后结果是" + result);
    }

    /**
     * 判断是否为运算符
     */
    private static boolean isOperator(char data){
        return data == '+' || data == '-' || data == '*' || data == '/';
    }

    /**
     * 获取优先级
     * @return 1表示优先级最低 依次增加类推
     */
    private static int getPriority(char data){
        if(data == '+' || data == '-'){
            return 1;
        } else if (data == '*' || data == '/') {
            return 2;
        }else {
            return 0; // 错误的符号
        }
    }

    /**
     * 计算
     * @param num1 数字1
     * @param num2 数字2
     * @param o 符号
     * @return 计算结果
     */
    private static int cal(int num1, int num2, char o){
        int result;
        // 判断符号进行计算
        switch (o){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result= -(num1 - num2);
                break;
            case '*':
                result= num1 * num2;
                break;
            case '/':
                result= num2 / num1;
                break;
            default:
                throw new RuntimeException("运算符错误！");
        }
        return result;
    }



}


