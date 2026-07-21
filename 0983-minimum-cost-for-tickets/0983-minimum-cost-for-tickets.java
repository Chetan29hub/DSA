class Solution {
    private int[] dp;

    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        Arrays.fill(dp, -1);
        return solve(0, days, costs);
    }

    private int solve(int i, int[] days, int[] costs) {
        if (i >= days.length)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        // 1-day pass
        int one = costs[0] + solve(i + 1, days, costs);

        // 7-day pass
        int j = i;
        while (j < days.length && days[j] < days[i] + 7)
            j++;
        int seven = costs[1] + solve(j, days, costs);

        // 30-day pass
        j = i;
        while (j < days.length && days[j] < days[i] + 30)
            j++;
        int thirty = costs[2] + solve(j, days, costs);

        dp[i] = Math.min(one, Math.min(seven, thirty));
        return dp[i];
    }
}