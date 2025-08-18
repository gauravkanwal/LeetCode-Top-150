class LRUCache {
    private class DListNode {
        int key;
        int value;
        DListNode next;
        DListNode pre;
        DListNode() {}
        DListNode(int key, int val) { this.key=key; 
        this.value = val; }
     }
    
    DListNode head=new DListNode(-1,-1);
    DListNode tail=new DListNode(-2,-2);
    int remainingSize;
    HashMap<Integer,DListNode> map =new HashMap<>();

    private void addAtStart(DListNode newNode){
        newNode.next=head.next;
        head.next.pre=newNode;
        head.next=newNode;
        newNode.pre=head;
    }
    
    private void removeNode(DListNode node){
        DListNode pre=node.pre;
        DListNode next=node.next;
        pre.next=next;
        next.pre=pre;
    }

    public LRUCache(int capacity) {
        remainingSize=capacity;
        head.pre=null;
        head.next=tail;
        tail.pre=head;
        tail.next=null;    
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DListNode node=map.get(key);
            removeNode(node);
            addAtStart(node);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            DListNode node=map.get(key);
            node.value=value;
            removeNode(node);
            addAtStart(node);
        }else{
            DListNode node=new DListNode(key,value);
            addAtStart(node);
            map.put(key,node);
            remainingSize--;
            if(remainingSize<0){
                map.remove(tail.pre.key);
                removeNode(tail.pre);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */