class Trie {
    Trie[] children=new Trie[26];
    boolean eow;
    public Trie() {
    }
    
    public void insert(String word) {
        Trie node=this;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            int idx=c-'a';
            if(node.children[idx]==null){
                node.children[idx]=new Trie();
            }
            node=node.children[idx];
        }    
        node.eow=true;    
    }
    
    public boolean search(String word) {
        Trie node=this;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            int idx=c-'a';
            if(node.children[idx]==null) return false;
            node=node.children[idx];
        }
        return node.eow;
    }
    
    public boolean startsWith(String prefix) {
        Trie node=this;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            int idx=c-'a';
            if(node.children[idx]==null) return false;
            node=node.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */