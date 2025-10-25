package Graphs;

import java.util.Scanner;

/*Flood Fill Algorithm - Graphs

Problem Statement: An image is represented by a 2-D array of integers, each integer representing the pixel value of the image. 
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel 
of the same colour as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same colour as the starting pixel), and so on. 
Replace the colour of all of the aforementioned pixels with the newColor.

Pre-req: Connected Components, Graph traversal techniques
 */
public class prob_13 {

    static void FloodFill(int node1,int node2,int [][] grid,int new_color,int init){
        grid[node1][node2] = new_color;
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        for(int i=0;i<4;i++){
            int ni = node1+drow[i];
            int nj = node2+dcol[i];
            if(ni>=0 && ni < grid.length && nj >=0 &&nj < grid[node1].length&& grid[ni][nj]== init){
                FloodFill(ni, nj, grid, new_color, init);
            }
        }

    }
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        System.out.println("enter the no of row and coloumn");
        int V =sc.nextInt();
        int E = sc.nextInt();
        int[][] grid = new int[V][E];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                grid[i][j] =sc.nextInt();
            }
        }
        System.out.println("/nBefore FloodFill");
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("enter the source  i and j to start floodfilling:");
        int srci=sc.nextInt();
        int srcj=sc.nextInt();
        int initial_color=grid[srci][srcj];
        System.out.println("enter the new color to fill:");
        int new_Color =sc.nextInt();
        System.out.println("/n----------------------------------");
        FloodFill(srci,srcj,grid,new_Color,initial_color);
        System.out.println("/nAfter FloodFill");
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
               
    }
}
