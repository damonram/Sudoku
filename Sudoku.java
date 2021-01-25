package SudokuSolver;

public class Sudoku {

    static int N = 9;

    boolean checkRow(int[] row, int num){
        for (int x: row) {
            if(x==num)
                return false;
        }
        return true;
    }


    boolean checkColumn(int[] column, int num){
        for (int y: column) {
            if(y==num)
                return false;
        }
        return true;
    }

    boolean checkSquare(){
        return false;
    }

}
