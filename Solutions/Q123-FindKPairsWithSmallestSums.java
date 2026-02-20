class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(nums1[a[0]]+nums2[a[1]])-(nums1[b[0]]+nums2[b[1]]));
        List<List<Integer>> res=new ArrayList<>();

        for(int i=0;i<Math.min(nums1.length,k);i++){
            pq.add(new int[]{i,0});
        }

        while(k>0 && !pq.isEmpty()){
            int[] arr=pq.poll();
            int i=arr[0],j=arr[1];
            res.add(Arrays.asList(nums1[i],nums2[j]));
            
            if(j+1<nums2.length){
                pq.add(new int[]{i,j+1});
            }
            
            k--;
        }

        return res;
    }
}
/*
1,1 1,2 1,3 
*/