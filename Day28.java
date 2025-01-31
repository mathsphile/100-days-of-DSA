// Given an incomplete Sudoku configuration in terms of a 9x9  2-D interger square matrix, mat[][], the task is to solve the Sudoku. It is guaranteed that the input Sudoku will have exactly one solution.

// A sudoku solution must satisfy all of the following rules:

// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// Note: Zeros represent blanks to be filled with numbers 1-9, while non-zero cells are fixed and cannot be changed.
class Solution {
    // Function to solve Sudoku
    static void solveSudoku(int[][] mat) {
        solve(mat);
    }

    // Helper function to solve Sudoku using backtracking
    private static boolean solve(int[][] mat) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (mat[row][col] == 0) { // Find an empty cell
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(mat, row, col, num)) { // Check if placing num is valid
                            mat[row][col] = num; // Place the number

                            if (solve(mat)) {
                                return true; // If solved, return true
                            }

                            mat[row][col] = 0; // Backtrack if no solution
                        }
                    }
                    return false; // If no number is valid, return false
                }
            }
        }
        return true; // All cells filled, Sudoku solved
    }

    // Function to check if placing a number is valid
    private static boolean isValid(int[][] mat, int row, int col, int num) {
        // Check the row
        for (int i = 0; i < 9; i++) {
            if (mat[row][i] == num)
                return false;
        }

        // Check the column
        for (int i = 0; i < 9; i++) {
            if (mat[i][col] == num)
                return false;
        }

        // Check the 3x3 sub-grid
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mat[startRow + i][startCol + j] == num)
                    return false;
            }
        }

        return true; // The number is valid
    }
}
