package com.dsaatt;

/**
 * 阶乘问题
 */
public class Dome02 {
    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    private static int factorial(int x){
        if(x == 1){
            return x;
        }else {
            return x * factorial(x - 1);
        }
    }
}
