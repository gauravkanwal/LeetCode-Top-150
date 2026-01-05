class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet=new HashSet<String>(wordList);
        if(!wordSet.contains(endWord))return 0;

        Queue<String> q=new LinkedList<>();
        int n=beginWord.length();
        int count=1;
        q.offer(beginWord);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String popped=q.poll();
                if(endWord.equals(popped)) return count;
                char[] sArr=popped.toCharArray();
                for(int i=0;i<n;i++){
                    char org=sArr[i];
                    for(char c='a';c<='z';c++){
                        if(sArr[i]==c) continue;
                        sArr[i]=c;
                        String s=new String(sArr);
                        if(wordSet.contains(s)){
                            q.offer(s);
                            wordSet.remove(s);
                        }
                    }
                    sArr[i]=org;
                }
            }
            count++;
        }
        return 0;
    }
}