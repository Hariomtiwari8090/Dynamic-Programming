class Solution {
    public int rob(int[] arr) {
        return r(arr,0);
    }
    public int r(int[] arr,int i){
        if(i>=arr.length) return 0;
        int take=arr[i]+r(arr,i+2);
        int skip=r(arr,i+1);
        return Math.max(take,skip);
    }
}

-----------------------------------------------

class Solution {
    public int rob(int[] arr) {
        int[] dp=new int[arr.length+1];
        Arrays.fill(dp,-1);
        return r(arr,0,dp);
    }
    public int r(int[] arr,int i,int[] dp){
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int take=arr[i]+r(arr,i+2,dp);
        int skip=r(arr,i+1,dp);
        return dp[i]=Math.max(take,skip);
    }
}

-------------------------------------------------

class Solution {
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        int[] dp=new int[n];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-2]+arr[i],dp[i-1]);
        }
        return Math.max(dp[n-1],dp[n-2]);
    }
}

----------------------------------------------------

class Solution {
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        int a=arr[0];
        int b=Math.max(arr[0],arr[1]),c=Math.max(a,b);
        for(int i=2;i<n;i++){
            c=Math.max(b,arr[i]+a);
            a=b;
            b=c;
        }
        return c;
    }
}
