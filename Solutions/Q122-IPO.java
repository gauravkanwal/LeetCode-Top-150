class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCapital=new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<Integer> maxProfit=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<capital.length;i++){
            minCapital.add(new int[]{capital[i],profits[i]});
        }

        for(int i=0;i<k;i++){
            while(!minCapital.isEmpty() && minCapital.peek()[0]<=w){
                int profit=minCapital.poll()[1];
                maxProfit.add(profit);
            }

            if(maxProfit.isEmpty()) break;
            w+=maxProfit.poll();
        }

        return w;
    }
}