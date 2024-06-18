func solveNQueens(n int) [][]string {
    // Create a slice to store the column positions of queens in each row.
    positions := make([]int, n)
    // Initialize all positions to -1, indicating no queens placed yet.
    for i := range positions {
        positions[i] = -1
    }
    // Result slice to store the final board configurations.
    result := [][]string{}
    // Start the recursive process to place queens.
    placeQueen(positions, 0, n, &result)
    return result
}

// placeQueen tries to place a queen in the targetRow and proceeds
// recursively to place queens in subsequent rows.
func placeQueen(positions []int, targetRow int, n int, result *[][]string) {
    // Base case: If targetRow equals n, all queens are placed successfully.
    if targetRow == n {
        // Create a board representation from the positions array.
        board := make([]string, n)
        for row := 0; row < n; row++ {
            chars := make([]string, n)
            for i := 0; i < n; i++ {
                // Place 'Q' for the queen and '.' for empty spaces.
                if positions[row] == i {
                    chars[i] = "Q"
                } else {
                    chars[i] = "."
                }
            }
            // Join the row into a single string and add to the board.
            board[row] = strings.Join(chars, "")
        }
        // Add the board to the result.
        *result = append(*result, board)
        return
    }

    // Try placing a queen in each column of the targetRow.
    for col := 0; col < n; col++ {
        // Check if placing a queen in (targetRow, col) is valid.
        if isValid(positions, targetRow, col) {
            // Place the queen.
            positions[targetRow] = col
            // Move on to place queens in the next row.
            placeQueen(positions, targetRow+1, n, result)
            // Reset the position for backtracking.
            positions[targetRow] = -1
        }
    }
}

// isValid checks if placing a queen at (occupiedRows, column) is valid.
func isValid(positions []int, occupiedRows int, column int) bool {
    for i := 0; i < occupiedRows; i++ {
        // Check if any queens are in the same column.
        if positions[i] == column {
            return false
        }
        // Check if any queens are in the same major diagonal.
        if positions[i]-i == column-occupiedRows {
            return false
        }
        // Check if any queens are in the same minor diagonal.
        if positions[i]+i == column+occupiedRows {
            return false
        }
    }
    return true
}
