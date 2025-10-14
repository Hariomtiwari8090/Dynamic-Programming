class Solution {
    public int lengthOfLIS(int[] arr) {
        return max(arr,0,-1);
    }
    public int max(int[] arr,int i,int t){
        if(i==arr.length) return 0;
        int skip=max(arr,i+1,t);
        int take=0;
        if(t==-1 || arr[i]>arr[t]) take=1+max(arr,i+1,i);
        return Math.max(take,skip);
    }
}

--------------------------------------------------------------

class Solution {
    public int lengthOfLIS(int[] arr) {
        int[][] dp=new int[arr.length][arr.length+1];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
        return max(arr,0,-1,dp);
    }
    public int max(int[] arr,int i,int t,int[][] dp){
        if(i==arr.length) return 0;
        if(dp[i][t+1]!=-1) return dp[i][t+1];
        int skip=max(arr,i+1,t,dp);
        int take=0;
        if(t==-1 || arr[i]>arr[t]) take=1+max(arr,i+1,i,dp);
        return dp[i][t+1]=Math.max(take,skip);
    }
}

----------------------------------------------------------------

class Solution {
    public int lengthOfLIS(int[] arr) {
        int[] dp=new int[arr.length];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
}
