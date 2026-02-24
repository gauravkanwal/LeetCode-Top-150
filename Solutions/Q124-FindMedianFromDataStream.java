class MedianFinder {
    PriorityQueue<Integer> small=new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> big=new PriorityQueue<>();
    int size=0;
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(size%2==0){
            //that means both heaps are equal we will insert the extra element to max heap i.e. small
            big.add(num);
            small.add(big.poll()); 
        } else {
            small.add(num);
            big.add(small.poll());
        }
        size++;
    }
    
    public double findMedian() {
        if(size%2!=0) return small.peek();
        return (small.peek()+big.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */