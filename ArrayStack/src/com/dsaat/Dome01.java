package com.dsaat;

import java.util.Arrays;

public class Dome01 {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        // 测试
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class ArrayStack{
    private int top = -1;
    private int maxSize;
    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 栈是否满
     */
    private boolean isFull(){
        return top == maxSize - 1;
    }

    /**
     * 栈是否空
     */
    private boolean isEmpty(){
        return top == -1;
    }

    /**
     * 压栈
     * @param data 栈数据
     */
    public void push(int data){
        if(isFull()){
            System.out.println("栈已满!");
            return;
        }
        top++;
        stack[top] = data;
    }

    /**
     * 弹栈
     * @return 栈中数据
     */
    public Integer pop(){
        if(isEmpty()){
            System.out.println("栈已空!");
            return null;
        }
        int x = stack[top];
        top--;
        return x;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "stack=" + Arrays.toString(stack) +
                '}';
    }
}
