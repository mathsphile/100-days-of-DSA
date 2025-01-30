// The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.

// Given an integer n, find all distinct solutions to the n-queens puzzle.
// You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, where the solutions are represented as permutations of [1, 2, 3, ..., n]. In this representation, the number in the ith position denotes the row in which the queen is placed in the ith column.
// For eg. below figure represents a chessboard [3 1 4 2].
import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> board = new ArrayList<>();
        solveNQueens(n, 0, board, result);
        return result;
    }

    private void solveNQueens(int n, int col, ArrayList<Integer> board, ArrayList<ArrayList<Integer>> result) {
        if (col == n) {  // A valid solution is found
            result.add(new ArrayList<>(board));
            return;
        }
        
        for (int row = 1; row <= n; row++) {
            if (isSafe(board, col, row)) {
                board.add(row);
                solveNQueens(n, col + 1, board, result);
                board.remove(board.size() - 1);
            }
        }
    }

    private boolean isSafe(ArrayList<Integer> board, int col, int row) {
        for (int prevCol = 0; prevCol < board.size(); prevCol++) {
            int prevRow = board.get(prevCol);
            if (prevRow == row || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }
}
