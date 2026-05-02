import java.util.*;
class Solution {
    public int maxPoints(int[][] points) {
        HashMap<String,Integer> map=new HashMap<>();
        int max=1;
        for(int i=0;i<points.length;i++){
            map.clear();
            for(int j=i+1;j<points.length;j++){
                int dy=(points[j][1]-points[i][1]), dx=(points[j][0]-points[i][0]);
                int hcf=hcf(dy,dx);
                String s=dy/hcf+"_"+dx/hcf;
                map.put(s,map.getOrDefault(s,1)+1);
                max=Math.max(max,map.get(s));
            }
        }
        return max;

    }
    private int hcf(int x,int y){
        if(y==0) return x;
        return hcf(y,x%y);
    }
}