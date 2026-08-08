class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]!='.'){
                    if(!isValid(board[row][col], row,col, board)){
                        return false;
                    }
                }
            }
        }

        return true;
        */

        Set<String> seen=new HashSet<>();

        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                char c=board[row][col];

                if(c=='.') continue;

                String rowKey=c +" in row "+row;
                String colKey=c +" in col "+col;
                String boxKey=c +" in box "+(row/3)+"-"+(col/3);

                if(seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)){
                    return false;
                }

                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);
            }
        }
         return true;
    }

    public boolean isValid(char num, int row, int col, char[][] board){
        for(int i=0;i<9;i++){
            if(i!=row && board[i][col]==num) return false;
            if(i!=col && board[row][i]==num) return false;
        }

        int startRow= (row/3)*3;
        int startCol= (col/3)*3;

        for(int i=startRow; i<startRow+3;i++){
            for(int j=startCol; j<startCol+3;j++){
                if((i!=row || j!=col) && board[i][j]==num) return false;
            }
        }

        return true;
    }
}
