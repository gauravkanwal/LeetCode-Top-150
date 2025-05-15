//Approach 1: Sorting by starting point:
class Solution {
    public int findMinArrowShots(int[][] points) {
        int count=1;
        int n=points.length;
        Arrays.sort(points, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] common=points[0]; 
        for(int i=1;i<n;i++){
            if(haveCommon(common,points[i])){
                common[0]=Math.max(common[0],points[i][0]);
                common[1]=Math.min(common[1],points[i][1]);

            } else{
                count++;
                common=points[i];
            }
        }

        return count;
    }

    public boolean haveCommon(int[] intvl1, int[] intvl2){
        return(intvl1[1]>=intvl2[0] && intvl2[1]>=intvl1[0]);
    }
}


//Approach 2: Sorting by end point:
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort intervals by end points
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // If current interval starts after the tracked end, increment arrow
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }
}
