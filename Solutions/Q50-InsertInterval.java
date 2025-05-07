class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list=new ArrayList<>();
        int n=intervals.length;
        int i=0;
        while(i<n && intervals[i][1]<newInterval[0]){
            list.add(intervals[i]);
            i++;
        }

        while(i<n && isOverlapping(newInterval,intervals[i])){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        while(i<n){
            list.add(intervals[i]);
            i++;
        }

        int[][] arr=new int[list.size()][2];
        for(int j=0;j<list.size();j++){
            arr[j]=list.get(j);
        }
        return arr;
    }

private boolean isOverlapping(int[] interval1, int[] interval2) {
    return interval1[1] >= interval2[0] && interval2[1] >= interval1[0];
}

}