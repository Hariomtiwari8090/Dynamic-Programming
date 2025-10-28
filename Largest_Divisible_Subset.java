class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);
        List<Integer>temp=new ArrayList<>();
        return sub(arr,0,-1,temp);
    }
    public List<Integer> sub(int[] arr,int i,int last,List<Integer> temp){
        if(i==arr.length){
            return new ArrayList<>(temp);
        }
        List<Integer> skip=sub(arr,i+1,last,temp);
        List<Integer> take=new ArrayList<>();
        if(last==-1 || arr[i]%arr[last]==0) {
            temp.add(arr[i]);
            take=sub(arr,i+1,i,temp);
            temp.remove(temp.size()-1);
        }
        if(skip.size()>take.size()) return skip;
        else return take;
    }
}

---------------------------------------------------------------------------------

class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int[] dp=new int[n];
        int[] last=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(last,-1);
        int maxlen=1;
        int maxidx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0 && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    last[i]=j;
                }
            }
            if(dp[i]>maxlen){
                maxlen=dp[i];
                maxidx=i;
            }
        }
        List<Integer> l=new ArrayList<>();
        while(maxidx!=-1){
            l.add(arr[maxidx]);
            maxidx=last[maxidx];
        }
        Collections.reverse(l);
        return l;
    }
}
