class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
                int[] suffixSum = new int[n + 1];
                        for (int i = n - 1; i >= 0; i--) suffixSum[i] = suffixSum[i + 1] + piles[i];

                                Map<String, Integer> memo = new HashMap<>();
                                        return stoneGameIIHelper(piles, 0, 1, suffixSum, memo);
                                            }

                                                private int stoneGameIIHelper(int[] piles, int index, int m, int[] suffixSum, Map<String, Integer> memo) {
                                                        if (index == piles.length) return 0;
                                                                if (index + 2 * m >= piles.length) return suffixSum[index];

                                                                        String key = index + "," + m;
                                                                                if (memo.containsKey(key)) return memo.get(key);

                                                                                        int minOpponent = Integer.MAX_VALUE;
                                                                                                for (int x = 1; x <= 2 * m; x++) {
                                                                                                            minOpponent = Math.min(minOpponent, stoneGameIIHelper(piles, index + x, Math.max(m, x), suffixSum, memo));
                                                                                                                    }
                                                                                                                            int result = suffixSum[index] - minOpponent;
                                                                                                                                    memo.put(key, result);
                                                                                                                                            return result;
    }
}