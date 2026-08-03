import java.util.Arrays;

class Solution {
    int n;
    int[] t;

    int solve(int[] stoneValue, int i) {
        if (i == n) return 0;
        if (t[i] != -1) return t[i];
        
        int res = stoneValue[i] - solve(stoneValue, i + 1);
        if (i + 1 < n) {
            res = Math.max(res, stoneValue[i] + stoneValue[i + 1] - solve(stoneValue, i + 2));
        }
        if (i + 2 < n) {
            res = Math.max(res, stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - solve(stoneValue, i + 3));
        }
        
        return t[i] = res;
    }

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        t = new int[n + 1];
        Arrays.fill(t, -1);
        
        int diff = solve(stoneValue, 0);
        if (diff < 0) return "Bob";
        else if (diff > 0) return "Alice";
        return "Tie";
    }
}
