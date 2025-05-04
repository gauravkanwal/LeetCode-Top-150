class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans=new ArrayList<>();

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int n=intervals.length;
        int[] interval=intervals[0];
        for(int i=0;i<n;i++){
            int[] newInterval=intervals[i];
            if(newInterval[0]<=interval[1]){
                interval[1]=Math.max(interval[1],newInterval[1]);
            } else {
                ans.add(interval);
                interval=newInterval;
            }
        }
        ans.add(interval);

        int[][] res=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }        
        return res;
    }
}