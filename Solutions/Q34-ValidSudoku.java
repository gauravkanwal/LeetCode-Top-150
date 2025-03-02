package Solutions;
import java.util.*;

//third and most optimal approach:
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck=new boolean[9][9];
        boolean[][] colCheck=new boolean[9][9];
        boolean[][] boxCheck=new boolean[9][9];

        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')continue;
                int num=board[i][j]-'1';
                if(rowCheck[i][num]||colCheck[j][num]||boxCheck[(i/3)*3+(j/3)][num]) return false;
                rowCheck[i][num]=true;
                colCheck[j][num]=true;
                boxCheck[(i/3)*3+(j/3)][num]=true;
            }
        }
        return true;
    }
}

//second approach:
class Solution_ {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set =new HashSet<>();
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')continue;
                //string for vertical check
                String vString=board[i][j]+"in column"+j;
                
                //string for horizontal check
                String cString=board[i][j]+"in row"+i;
                
                //string for 3 x 3 sub-boxes  check
                String sbString=board[i][j]+"in box"+i/3+"-"+j/3;

                if(set.contains(vString)||set.contains(cString)||set.contains(sbString)) return false;
                set.add(vString);
                set.add(cString);
                set.add(sbString);
            }
        }
        return true;
    }
}

//first approach:
class Solution__ {
    public boolean isValidSudoku(char[][] board) {
        // Check rows
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        // Check columns
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;  // Corrected indexing
                if (set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
        }

        // Check 3x3 sub-boxes
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                HashSet<Character> set = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char current = board[boxRow * 3 + i][boxCol * 3 + j];
                        if (current == '.') continue;
                        if (set.contains(current)) return false;
                        set.add(current);
                    }
                }
            }
        }

        return true;
    }
}