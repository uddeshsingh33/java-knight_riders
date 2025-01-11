class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        boolean[] answer = new boolean[queries.length];
        
        long[] prefixSum = new long[n];
        prefixSum[0] = candiesCount[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + candiesCount[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int favoriteType = queries[i][0];
            int favoriteDay = queries[i][1];
            int dailyCap = queries[i][2];
            
            long minCandiesNeeded = favoriteDay + 1;
            long maxCandiesEaten = (long) (favoriteDay + 1) * dailyCap;
            
            long candiesStart = favoriteType == 0 ? 1 : prefixSum[favoriteType - 1] + 1;
            long candiesEnd = prefixSum[favoriteType];

            answer[i] = !(minCandiesNeeded > candiesEnd || maxCandiesEaten < candiesStart);
        }

        return answer;
    }
}