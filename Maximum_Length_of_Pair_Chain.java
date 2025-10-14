class Solution {
    public int findLongestChain(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        return chain(arr,0,-1);
    }
    public int chain(int[][] arr,int i,int pre){
        if(i==arr.length) return 0;
        int skip=chain(arr,i+1,pre);
        int take=0;
        if(pre==-1 || arr[pre][1]<arr[i][0]) take=1+chain(arr,i+1,i);
        return Math.max(skip,take);
    }
}

-----------------------------------------------------------------------

class Solution {
    public int findLongestChain(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int[][] dp=new int[arr.length][arr.length+1];
        for(int[] r:dp) Arrays.fill(r,-1);
        return chain(arr,0,-1,dp);
    }
    public int chain(int[][] arr,int i,int pre,int[][] dp){
        if(i==arr.length) return 0;
        if(dp[i][pre+1]!=-1) return dp[i][pre+1];
        int skip=chain(arr,i+1,pre,dp);
        int take=0;
        if(pre==-1 || arr[pre][1]<arr[i][0]) take=1+chain(arr,i+1,i,dp);
        return dp[i][pre+1]=Math.max(skip,take);
    }
}

-------------------------------------------------------------------------

class Solution {
    public int findLongestChain(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i][0]>arr[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
