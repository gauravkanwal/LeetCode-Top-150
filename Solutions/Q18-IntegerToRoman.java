package Solutions;

class Solution {
    public String intToRoman(int num) {
        int [] nums={1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String [] romans={"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder res=new StringBuilder();
        int n=nums.length;
        int i=n-1;
        while(num>0)
        {            
            while(nums[i]>num)i--;
            res.append(romans[i]);
            num-=nums[i];
        }
        return res.toString();
        
    }
}