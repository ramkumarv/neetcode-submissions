class PrefixTree {
    
    private final TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        char[] wordCharacters = word.toCharArray();
        TrieNode cur = root;
        for(int i =0; i < wordCharacters.length; i++) {
            if(!cur.children.containsKey(wordCharacters[i])) {
                TrieNode newNode = new TrieNode();
                cur.children.put(wordCharacters[i], newNode);
            }
            cur = cur.children.get(wordCharacters[i]);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        char[] wordCharacters = word.toCharArray();
        TrieNode cur = root;
        for(int i =0; i < wordCharacters.length; i++) {
            if(!cur.children.containsKey(wordCharacters[i])) {
                return false;
            }
            cur = cur.children.get(wordCharacters[i]);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        char[] wordCharacters = prefix.toCharArray();
        TrieNode cur = root;
        for(int i =0; i < wordCharacters.length; i++) {
            if(!cur.children.containsKey(wordCharacters[i])) {
                return false;
            }
            cur = cur.children.get(wordCharacters[i]);
        }
        return true;
    }
}


class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean isWord = false;
}