class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
                int prev1 = 0, prev2 = 0;
                        for (int i = 2; i <= n; i++) {
                                    int current = Math.min(prev1 + cost[i - 2], prev2 + cost[i - 1]);
                                                prev1 = prev2;
                                                            prev2 = current;
                                                                    }
                                                                            return prev2;
    }
}
