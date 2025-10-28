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
