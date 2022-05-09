class Solution {
    int[] row = new int[3];
    int[] col = new int[3];
    int diag1 = 0;
    int diag2 = 0;
    
    public String tictactoe(int[][] moves) {
        
        for(int i = 0; i < moves.length; i++) {
            int v = (i % 2 == 0)? 1 : -1;
            int[] m = moves[i];
            
            row[m[0]] += v;
            col[m[1]] += v;
            
            if (m[0] == m[1]) diag1 += v;
            if (m[0] + m[1] == 2) diag2 += v;
            
            if (win()) return (i % 2 == 0)? "A" : "B";
        }
        
        return (moves.length == 9)? "Draw" : "Pending";
    }
    
    boolean win() {
        for(int i = 0; i < 3; i++) {
            if (Math.abs(row[i]) == 3 || Math.abs(col[i]) == 3) {
                return true;
            }
        }
        
        return Math.abs(diag1) == 3 || Math.abs(diag2) == 3;
    }
}