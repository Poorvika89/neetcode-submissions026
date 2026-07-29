class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int num[]=new int[2*n];
        int index=0;
        for(int i=0;i<2;i++){
            for(int a:nums){
                num[index++]=a;
            }
        }
       return num; 
    }
}