class Solution {
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        int c1=r(arr,0,n-2);
        int c2=r(arr,1,n-1);
        return Math.max(c1,c2);
    }
    public int r(int[] arr,int i,int j){
        if(i>j) return 0;
        int take=arr[i]+r(arr,i+2,j);
        int skip=r(arr,i+1,j);
        return Math.max(take,skip); 
    }
}

------------------------------------------

class Solution {
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int c1=r(arr,0,n-2,dp);
        Arrays.fill(dp,-1);
        int c2=r(arr,1,n-1,dp);
        return Math.max(c1,c2);
    }
    public int r(int[] arr,int i,int j,int[] dp){
        if(i>j) return 0;
        if(dp[i]!=-1) return dp[i];
        int take=arr[i]+r(arr,i+2,j,dp);
        int skip=r(arr,i+1,j,dp);
        return dp[i]=Math.max(take,skip); 
    }
}

----------------------------------------------

class Solution {
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        if (n==2) return Math.max(arr[0],arr[1]);
        int[] dp=new int[n];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<n-1;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+arr[i]);
        } 
        int c1=dp[n-2];
        Arrays.fill(dp,0);
        dp[1]=arr[1];
        dp[2]=Math.max(arr[1],arr[2]);
        for(int i=3;i<n;i++){
            dp[i]=Math.max(dp[i-2]+arr[i],dp[i-1]);
        }
        return Math.max(c1,dp[n-1]);
    }
}
