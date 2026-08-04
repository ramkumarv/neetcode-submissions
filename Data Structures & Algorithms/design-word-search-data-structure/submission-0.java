class WordDictionary {
    final TrieNode root;
    char wildcard = '.';
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        char[] wordChars = word.toCharArray();
        for(int i=0 ; i<wordChars.length; i++) {
            if(!cur.children.containsKey(wordChars[i])) {
                cur.children.put(wordChars[i], new TrieNode());
            }
            cur = cur.children.get(wordChars[i]);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        char[] wordChars = word.toCharArray();
        return dfs(root, wordChars, 0);
    }    

    boolean dfs(TrieNode curNode, char[] wordChars, int currIndex) {
        //base case 
        if(curNode == null) {
            return false;
        }
        if(currIndex == wordChars.length) {
            return curNode.isWord;
        }

        if(wordChars[currIndex] == '.') {
            for(Character wordChar : curNode.children.keySet()) {
                if(dfs(curNode.children.get(wordChar), wordChars, currIndex+1)){
                    return true;
                }
            }
            return false;
        } else {
            return dfs(curNode.children.get(wordChars[currIndex]), wordChars, currIndex+1);
        }
        
    }
}


class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean isWord = false;
}