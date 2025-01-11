class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] prefix = new int[102];
        for(List<Integer> car : nums){
            prefix[car.get(0)]++;
            prefix[car.get(1) + 1]--;
        }
        int count=0;
        int p_sum=0;
        for(int i=1;i<102;i++){
            p_sum+=prefix[i];
            if(p_sum>0){
                count++;
            }
        }
        return count++;
    }
}
