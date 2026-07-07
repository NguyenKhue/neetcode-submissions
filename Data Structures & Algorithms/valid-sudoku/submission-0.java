class Solution {
    public boolean isValidSudoku(char[][] board) {
        char[] counts = new char[9];

        for(int i  = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];

                if(c != '.') {
                    int index = (c - '0') - 1;
                    if(counts[index] != '\u0000') return false;
                    else counts[index] = c;
                }
            }

            counts = new char[9];
        }

        for(int i  = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char c = board[j][i];

                if(c != '.') {
                    int index = (c - '0') - 1;
                    if(counts[index] != '\u0000') return false;
                    else counts[index] = c;
                }
            }

            counts = new char[9];
        }

        for(int i  = 0; i < 9; i+=3) {
            for(int j = 0; j < 9; j+=3) {

                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                        char c = board[k + i][l + j];

                        if(c != '.') {
                            int index = (c - '0') - 1;
                            if(counts[index] != '\u0000') return false;
                            else counts[index] = c;
                        }
                    }
                }

                counts = new char[9];
            }
        }

        return true;
    }
}
