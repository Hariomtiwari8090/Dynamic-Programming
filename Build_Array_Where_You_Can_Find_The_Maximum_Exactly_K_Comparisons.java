class Solution {
    public int n,m,k;
    public int numOfArrays(int N, int M, int K) {
        n=N;
        m=M;
        k=K;
        return find(0,0,0);
    }
    public int find(int i,int max,int maxval){
        if(i==n){
            if(max==k) return 1;
            else return 0;
        }
        int res=0;
        for(int j=1;j<=m;j++){
            if(j>maxval){
                res=res+find(i+1,max+1,j);
            }
            else {
                res=res+find(i+1,max,maxval);
            }
        }
        return res;
    }
}

----------------------------------------------------------------

class Solution {
    public int n,m,k;
    public int numOfArrays(int N, int M, int K) {
        n=N;
        m=M;
        k=K;
        int[][][] dp=new int[n+1][k+1][m+1];
        for(int i=0;i<n;i++){
            for(int[] r:dp[i]){
                Arrays.fill(r,-1);
            }
        }
        return find(0,0,0,dp);
    }
    public int find(int i,int max,int maxval,int[][][] dp){
        if(i==n){
            if(max==k) return 1;
            else return 0;
        }
        if(max>k) return 0;
        if(dp[i][max][maxval]!=-1) return dp[i][max][maxval];
        int res=0;
        for(int j=1;j<=m;j++){
            if(j>maxval){
                res=res+find(i+1,max+1,j,dp);
            }
            else {
                res=res+find(i+1,max,maxval,dp);
            }
            res%=1000000007;
        }
        return dp[i][max][maxval]=res;
    }
}
