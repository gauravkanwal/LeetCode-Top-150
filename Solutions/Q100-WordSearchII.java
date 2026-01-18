class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean eow;
        // StringBuilder word;
        TrieNode(){
            children=new TrieNode[26];
        }

        public void addWord(String word){
            TrieNode node=this;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                int idx=c-'a';
                if(node.children[idx]==null){
                    node.children[idx]=new TrieNode();
                }
                node=node.children[idx];
            }
            node.eow=true;
        } 

        public TrieNode getChild(char c){
            return children[c-'a'];
        }

    }
    public List<String> findWords(char[][] board, String[] words) {
            List<String> res=new ArrayList<>();
            TrieNode root=new TrieNode();

            //add words to TrieNode;
            for(String word:words){
                root.addWord(word);
            }

            //dfs
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    searchAndAdd(board,i,j,res,root,new StringBuilder());
                }
            }

            return res;
    }

    private void searchAndAdd(char[][] board,int i,int j,List<String> res,TrieNode root,StringBuilder s)
    {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return ;
        if(board[i][j]=='#') return;
        TrieNode child=root.getChild(board[i][j]);
        if(child==null) return ;
        char temp=board[i][j];
        s.append(temp);

        board[i][j]='#';

        if(child.eow){
            res.add(s.toString());
            child.eow=false;
        }

        searchAndAdd(board,i+1,j,res,child,s);
        searchAndAdd(board,i-1,j,res,child,s);
        searchAndAdd(board,i,j+1,res,child,s);
        searchAndAdd(board,i,j-1,res,child,s);

        s.deleteCharAt(s.length()-1);
        board[i][j]=temp;
    }
}