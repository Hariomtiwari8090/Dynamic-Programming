class Solution {
    public long maxBalancedSubsequenceSum(int[] arr) {
        return bal(arr,0,-1);
    }
    public long bal(int[] arr,int i,int prev){
        if(i==arr.length) return Long.MIN_VALUE;
        long skip=bal(arr,i+1,prev);
        long take=0;
        if(prev==-1 || (arr[i]-arr[prev]>=i-prev)) {
            long next=bal(arr,i+1,i);
            if(next==Long.MIN_VALUE) take=arr[i];
            else take=arr[i]+bal(arr,i+1,i);
        }
        return Math.max(take,skip);
    }
}

------------------------------------------------------------------

class Solution {
    public long maxBalancedSubsequenceSum(int[] arr) {
        long[][] dp=new long[arr.length+1][arr.length+1];
        for(long[] r:dp) Arrays.fill(r,-1);
        return bal(arr,0,-1,dp);
    }
    public long bal(int[] arr,int i,int prev,long[][] dp){
        if(i==arr.length) return Long.MIN_VALUE;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        long skip=bal(arr,i+1,prev,dp);
        long take=0;
        if(prev==-1 || (arr[i]-arr[prev]>=i-prev)) {
            long next=bal(arr,i+1,i,dp);
            if(next==Long.MIN_VALUE) take=arr[i];
            else take=arr[i]+bal(arr,i+1,i,dp);
        }
        return dp[i][prev+1]=Math.max(take,skip);
    }
}

---------------------------------------------------------------------

  class Solution {
    public long maxBalancedSubsequenceSum(int[] arr) {
        int n=arr.length;
        long[] dp=new long[n];
        long max=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            dp[i]=arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[i]-arr[j]>=i-j){
                    dp[i]=Math.max(dp[i],arr[i]+dp[j]);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
