package SudokuSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku {

    static int N = 8;
    static int EMPTY = 0;

    static boolean isInRow(int[] row, int num){
        for (int x: row) {
            if(x==num)
                return true;
        }
        return false;
    }

    static boolean isInColumn(int[] column, int num){
        for (int y: column) {
            if(y==num)
                return true;
        }
        return false;
    }

    static void checkSquare(int x, int y, List<Integer> possible, int[][] grid){
        int r = x - (x%3);
        int c = y - (y%3);

        for(int i = r;i<r+3;i++){
            for(int j = c;j<c+3;j++){
                possible.remove((Integer) grid[i][j]);
            }
        }

    }

    static void checkRow(int x, int y, List<Integer> possible, int[][] grid){
        for(int i=0;i<=N;i++)
            if(grid[x][i]!=EMPTY)
                possible.remove((Integer) grid[x][i]);
    }
    static void checkColumn(int x, int y, List<Integer> possible, int[][] grid){
        for(int i=0;i<=N;i++)
            if(grid[i][y]!=EMPTY)
                possible.remove((Integer)grid[i][y]);
    }

    static void evaluation(int[][] grid){

    }


    static void elimination(int[][] grid){
        List<Integer> possible = new ArrayList<>();
        int openSpaces = 0;

        for(int j=0;j<=N;j++){
            for(int k=0;k<=N;k++){
                possible.clear();
                for(int i = 1;i<10;i++)
                    possible.add(i);

                if(grid[j][k]==EMPTY){
                    checkRow(j, k, possible, grid);
                    checkColumn(j, k, possible, grid);
                    checkSquare(j, k, possible, grid);
                    if(possible.size()==1) {
//                        System.out.println(grid[j][k]);
                        grid[j][k] = possible.get(0);
                        elimination(grid);
                    }
//                    else{
//                        //System.out.println(possible);
//                    }
//                    openSpaces++;
                }

            }
        }
//        System.out.println(openSpaces);

    }

    public static void main(String[] args) {

        int[][] easyBoard = {
                {8,0,1,3,0,0,9,0,0},
                {0,4,9,0,0,0,0,5,1},
                {2,5,6,8,9,0,4,0,0},
                {0,1,5,6,8,0,0,4,0},
                {4,0,0,0,0,0,0,0,8},
                {0,8,0,0,0,4,1,9,7},
                {1,0,2,0,7,9,0,0,0},
                {0,6,0,5,3,8,0,0,0},
                {0,0,8,0,6,0,0,3,4}
        };
        int[][] medBoard = {
                {0,0,0,0,0,0,6,0,9},
                {1,0,0,0,0,4,0,0,0},
                {0,0,5,3,0,6,8,2,1},
                {0,0,4,6,7,0,0,5,0},
                {0,0,7,0,0,0,9,0,0},
                {0,0,0,5,4,0,0,0,0},
                {3,7,0,4,0,5,2,0,6},
                {0,0,0,0,0,0,5,1,0},
                {0,6,0,0,2,0,0,3,7},
        };
        int[][] hardBoard = {
                {0,0,0,0,0,0,0,0,8},
                {3,0,0,0,0,0,5,0,0},
                {0,0,4,3,0,0,0,9,1},
                {0,0,1,0,4,6,7,5,0},
                {0,4,9,0,0,0,0,1,0},
                {0,7,0,0,0,5,0,0,0},
                {0,0,0,4,0,0,0,6,0},
                {0,0,0,0,8,1,0,0,4},
                {0,0,5,0,0,0,0,7,3}
        };

        int[][] expertBoard = {
                {0,0,6,0,0,0,0,0,4},
                {3,0,0,0,6,0,0,0,0},
                {0,0,1,0,0,8,0,0,0},
                {0,9,0,0,0,2,0,0,5},
                {2,0,4,0,1,0,0,3,0},
                {0,0,0,0,7,0,0,4,1},
                {0,7,0,0,0,1,0,0,0},
                {9,0,0,0,0,5,0,1,2},
                {6,0,0,0,0,0,0,9,0}};

        elimination(hardBoard);

        System.out.println(Arrays.deepToString(hardBoard).replace("], ","]\n"));

    }

}
