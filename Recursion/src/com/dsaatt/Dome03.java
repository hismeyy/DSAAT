package com.dsaatt;

public class Dome03 {
    private static final int[][] maze = new int[7][6];

    public static void main(String[] args) {
        buildMaze();
        goMaze(1,1);
        // 打印迷宫
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void buildMaze(){
        // 加墙
        for(int i = 0; i < 6; i++){
            maze[0][i] = 1;
            maze[6][i] = 1;
        }
        for(int i = 0; i < 7; i++){
            maze[i][0] = 1;
            maze[i][5] = 1;
        }
        maze[3][1] = 1;
        maze[3][2] = 1;
    }

    private static void goMaze(int x, int y){
        if(maze[5][4] == 2){
           return;
        } else if(maze[x][y] == 0){
            if(maze[x+1][y] == 0){ // 下
                maze[x][y] = 2;
                goMaze(x+1,y);
            }else if(maze[x][y+1] == 0){
                maze[x][y] = 2;
                goMaze(x,y+1);
            }else if(maze[x-1][y] == 0){
                maze[x][y] = 2;
                goMaze(x,y+1);
            }else if(maze[x][y-1] == 0){
                maze[x][y] = 2;
                goMaze(x,y+1);
            }else {
                maze[x][y] = 3;
                return;
            }
        }
    }
}
