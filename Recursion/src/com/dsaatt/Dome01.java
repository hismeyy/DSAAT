package com.dsaatt;

/**
 * 打印问题
 */
public class Dome01 {
    public static void main(String[] args) {
        printProblem(5);
    }

    private static void printProblem(int x){
        if(x > 2){
            printProblem(x-1);
        }
        System.out.print(x + " ");
    }


}
