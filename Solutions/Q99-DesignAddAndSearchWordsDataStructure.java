class WordDictionary {
    WordDictionary[] children;
    boolean eow;
    public WordDictionary() {
        children=new WordDictionary[26];
    }
    
    public void addWord(String word) {
        WordDictionary node=this;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            int idx=c-'a';
            if(node.children[idx]==null){
                node.children[idx]=new WordDictionary();
            }
            node=node.children[idx];
        }
        node.eow=true;
    }
    
    public boolean search(String word) {
        return searchHelper(word,0);
    }

    private boolean searchHelper(String word,int in){
        WordDictionary node=this;
        for(int i=in;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='.'){
                for(WordDictionary child :node.children){
                    if(child!=null
                        &&
                        child.searchHelper(word,i+1)
                    )return true;
                }
                return false;
            }
            int idx=c-'a';
            if(node.children[idx]==null) return false;
            if(i==word.length()-1) return node.children[idx].eow;
            node=node.children[idx];
        }
        return node!=null && node.eow;
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */