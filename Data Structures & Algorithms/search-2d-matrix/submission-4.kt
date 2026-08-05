class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if(matrix.isEmpty()) return false
        if(matrix[0].isEmpty()) return false

        var top = 0
        var bottom = matrix.size - 1
        var r = -1

        while(top <= bottom) {
            val i = (bottom - top)/2 + top
            // println("i row: $i, bottom: $bottom, top: $top")

            if(r == -1 && top == bottom) {
                r = i
                break;
            }

            if(matrix[i][0] == target) {
                return true
            }

            if(matrix[i][0] > target) bottom = i - 1
            else top = i + 1

        }

        // println("match row: $r")

        while(r > 0 && matrix[r][0] > target) r--
        if(r == -1) return false

        var left = 0;
        var right = matrix[r].size - 1
        
        while(left <= right) {
            val i = (right - left)/2 + left

            if(matrix[r][i] == target) return true
            if(matrix[r][i] > target) right = i - 1
            else left = i + 1

        }

        return false
    }
}
