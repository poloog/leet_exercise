package 前缀树.实现Trie;

public class Trie {
    class trie{
        public int[] word = new int[26];
        public boolean isEnd = false;
        public trie[] next = new trie[26];
    }

    trie root;

    // init trie
    public Trie() {
        root = new trie();
    }

    // insert string
    public void insert(String word) {
        if (search(word)) return;
        trie p = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.next[index] == null) p.next[index] = new trie();
            p.next[index].word[c-'a']++;
            p = p.next[index];
        }
        p.isEnd = true;
    }

    //
    public boolean search(String word) {
        trie p = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.next[index] == null) return false;
            if (p.next[index].word[c-'a'] == 0) return false;
            else {
                p = p.next[index];
            }
        }
        return p.isEnd;
    }

    public boolean startsWith(String prefix) {
        trie p = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (p.next[index] == null) return false;
            if (p.next[index].word[c-'a'] == 0) return false;
            else {
                p = p.next[index];
            }
        }
        return true;
    }
}

