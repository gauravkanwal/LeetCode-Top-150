package Solutions;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int totalGas=0,currGas=0,totalCost=0,startingPoint=0;
        for(int i=0;i<n;i++)
        {
            totalGas+=gas[i];
            totalCost+=cost[i];
            currGas+=gas[i]-cost[i];

            //changing starting point:
            if(currGas<0)
            {
                currGas=0;
                startingPoint=i+1;
            }
        }
        return totalGas>=totalCost ? startingPoint : -1;
    }
}
