class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var rowStart = 0
        var rowEnd = matrix.size - 1
        var matchRow = 0

        while(rowStart < rowEnd) {
            val mid = (rowEnd - rowStart)/2 + rowStart
            val num = matrix[mid][0]
            
            if(num == target) return true
            else if(num < target) rowStart += 1
            else rowEnd -= 1
        }

        val midRow = (rowEnd - rowStart)/2 + rowStart

        if(matrix[midRow][0] == target) return true

        // println("midRow: $midRow, $rowEnd, $rowStart ")

        if(matrix[midRow][0] > target) matchRow = (midRow - 1).coerceAtLeast(0)
        else {
            if(matrix[midRow][matrix[0].size - 1] > target) matchRow = (midRow + 1).coerceAtMost(matrix.size - 1)
            else matchRow = midRow  
        }

        // println(matchRow)

        var colStart = 0
        var colEnd = matrix[0].size - 1

        while(colStart <= colEnd) {
            val midCol = (colEnd - colStart)/2 + colStart
            val num = matrix[matchRow][midCol]

            // println("$num -> midCol: $midCol")

            if(num == target) return true
            else if(num > target) colEnd -= 1
            else colStart += 1
        }

        return false
    }
}
