package Solutions;
import java.util.*;


class RandomizedSet {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    Random random;
    int listSize=0;
    public RandomizedSet() {
        map=new HashMap<Integer,Integer>();
        list=new ArrayList<Integer>();
        random=new Random();
    }
    
    public boolean insert(int val) {

        if(!map.containsKey(val))
        {
            list.add(val);
            listSize++;
            map.put(val,listSize-1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {

        if(map.containsKey(val))
        {
            int index=map.get(val);     
            //replacing the element to remove in the arraylist with the last element of  arraylist:
//but instead of replacing we can just set the last element in the current index also and then remove the last element:
            int lastElement=list.get(listSize-1);
            list.set(index,lastElement);
            map.put(lastElement,index);//updating the map for the changed index element
            //removing from map:
            map.remove(val);
            list.remove(listSize-1);
            listSize--;
            return true;
        }
        return false;     
    }
    
    public int getRandom() {
        int index = random.nextInt(listSize);
        return list.get(index); 
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */