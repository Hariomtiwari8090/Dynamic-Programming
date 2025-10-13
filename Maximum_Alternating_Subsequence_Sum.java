class Solution {
    public long maxAlternatingSum(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        return max(arr,0,true);
    }
    public long max(int[] arr,int i,boolean b){
        if(i==arr.length) return 0;
        long take=0;
        if(b) take=arr[i]+max(arr,i+1,false);
        else take=-arr[i]+max(arr,i+1,true);
        long skip=max(arr,i+1,b);
        return Math.max(take,skip);
    }
}

-------------------------------------------------

class Solution {
    public long maxAlternatingSum(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        long[][] dp=new long[n+1][2];
        for(long[] r:dp) Arrays.fill(r,-1);
        return max(arr,0,true,dp);
    }
    public long max(int[] arr,int i,boolean b,long[][] dp){
        if(i==arr.length) return 0;
        int e=0;
        if(b==false) e=1;
        if(dp[i][e]!=-1) return dp[i][e];
        long take;
        if(b) take=arr[i]+max(arr,i+1,false,dp);
        else take=-arr[i]+max(arr,i+1,true,dp);
        long skip=max(arr,i+1,b,dp);
        return dp[i][e]=Math.max(skip,take);
    }
}

--------------------------------------------------

class Solution {
    public long maxAlternatingSum(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        long[][] dp=new long[n][2];
        dp[0][0]=arr[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][1]+arr[i],dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-1][0]-arr[i],dp[i-1][1]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}

-------------------------------------------------------

