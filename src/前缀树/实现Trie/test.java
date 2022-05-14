package 前缀树.实现Trie;

public class test {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        t.search("apple");
        t.search("app");
        t.startsWith("app");
        t.insert("app");
        t.search("app");
    }
}
