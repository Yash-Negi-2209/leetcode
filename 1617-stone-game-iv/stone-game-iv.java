class Solution {
    private Boolean[] memo;

    public boolean winnerSquareGame(int n) {
        memo = new Boolean[n + 1];
        return dfs(n);
    }

    private boolean dfs(int i) {
        if (i == 0) {
            return false;
        }
        if (memo[i] != null) {
            return memo[i];
        }

        int maxSquare = (int) Math.sqrt(i);
        for (int j = 1; j <= maxSquare; j++) {
            if (!dfs(i - j * j)) {
                return memo[i] = true;
            }
        }

        return memo[i] = false;
    }
}
