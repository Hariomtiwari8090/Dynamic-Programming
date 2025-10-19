class Solution {
    public int longestStrChain(String[] arr) {
        Arrays.sort(arr,(a,b)->a.length()-b.length());
        return chain(arr,0,-1);
    }
    public int chain(String[] arr,int i,int prev){
        if(i==arr.length) return 0;
        int skip=chain(arr,i+1,prev);
        int take=0;
        if(prev==-1 || subset(arr,prev,i)) take=1+chain(arr,i+1,i);
        return Math.max(take,skip);
    }
    public boolean subset(String[] arr,int prev,int next){
        String s1=arr[prev],s2=arr[next];
        if(s1.length()+1!=s2.length()) return false;
        int i=0,j=0,skip=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)!=s2.charAt(j)){
                skip++;
                j++;
            }
            else{
                i++;
                j++;
            }
            if(skip>1) return false;
        }
        return true;
    }
}

-------------------------------------------------------------------------------

class Solution {
    public int longestStrChain(String[] arr) {
        Arrays.sort(arr,(a,b)->a.length()-b.length());
        int[][] dp=new int[arr.length+1][arr.length+1];
        for(int[] r:dp) Arrays.fill(r,-1);
        return chain(arr,0,-1,dp);
    }
    public int chain(String[] arr,int i,int prev,int[][] dp){
        if(i==arr.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int skip=chain(arr,i+1,prev,dp);
        int take=0;
        if(prev==-1 || subset(arr,prev,i)) take=1+chain(arr,i+1,i,dp);
        return dp[i][prev+1]=Math.max(take,skip);
    }
    public boolean subset(String[] arr,int prev,int next){
        String s1=arr[prev],s2=arr[next];
        if(s1.length()+1!=s2.length()) return false;
        int i=0,j=0,skip=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)!=s2.charAt(j)){
                skip++;
                j++;
            }
            else{
                i++;
                j++;
            }
            if(skip>1) return false;
        }
        return true;
    }
}

------------------------------------------------------------------------------

class Solution {
    public int longestStrChain(String[] arr) {
        Arrays.sort(arr,(a,b)->a.length()-b.length());
        int[] dp=new int[arr.length];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=0;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(subset(arr,j,i)){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
                max=Math.max(dp[i],max);
            }
        }
        return max;
    }
    public boolean subset(String[] arr,int prev,int next){
        String s1=arr[prev],s2=arr[next];
        if(s1.length()+1!=s2.length()) return false;
        int i=0,j=0,skip=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)!=s2.charAt(j)){
                skip++;
                j++;
            }
            else{
                i++;
                j++;
            }
            if(skip>1) return false;
        }
        return true;
    }
}
