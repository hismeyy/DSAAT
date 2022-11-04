package com.dsaat;

public class Dome01 {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        // 1. 创建一个二维数组
        int[][] arrays = new int[5][4];
        // 2. 在二维数组中添加值
        arrays[1][1] = 1;
        arrays[2][2] = 11;
        arrays[0][3] = 3;

        // 二维数组转稀疏数组
        // 1. 遍历二维数组得到有效数据个数sum
        int sum = 0;
        for(int[] array : arrays){
            for(int ele : array){
                if(ele != 0){
                    sum++;
                }
            }
        }
        // 2. 创建稀疏数组
        int[][] sparseArrays = new int[sum + 1][3];
        // 3. 将二维数组的有效数据存储在稀疏数组中
        int i = 0;
        sparseArrays[0][0] = arrays.length;
        sparseArrays[0][1] = arrays[i].length;
        sparseArrays[0][2] = sum;
        for(int[] array : arrays){
            for(int j = 0; j < array.length; j++){
                if(array[j] != 0){
                    sparseArrays[i+1][0] = i;
                    sparseArrays[i+1][1] = j;
                    sparseArrays[i+1][2] = array[j];
                }
            }
            i++;
        }

        // 稀疏数组转二维数组
        // 1. 读取稀疏数组的第0行创建二维数组
        int[][] oldArrays = new int[sparseArrays[0][0]][sparseArrays[0][1]];

        // 2. 从第一行开始遍历稀疏数组，把值转换到二维数组中
        for(int x = 1; x <= sparseArrays[0][2]; x++){
            oldArrays[sparseArrays[x][0]][sparseArrays[x][1]] = sparseArrays[x][2];
        }


        // 测试代码
        for(int[] array : oldArrays){
            for(int ele : array){
                System.out.printf("%d\t", ele);
            }
            System.out.println();
        }

    }
}
