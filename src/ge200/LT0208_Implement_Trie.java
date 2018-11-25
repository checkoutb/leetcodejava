package ge200;

public class LT0208_Implement_Trie
{

    public static void main(String[] args)
    {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("app"));
        System.out.println(t.startsWith("app"));
        System.out.println(t.search("apple"));
        t.insert("app");
        System.out.println(t.search("app"));
    }

}


// 102ms, most are [94, 156]ms
/* 直接2个属性，不需要内部类。靠下标就知道是什么字符了。
    Trie [] children;
    boolean end;
*/
class Trie {

    TrieNode root = null;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('-');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chArr = word.toCharArray();
        TrieNode node = root;
        for (char ch : chArr)
        {
            if (node.subTrie[ch - 'a'] == null)
                node.subTrie[ch - 'a'] = new TrieNode(ch);
            node = node.subTrie[ch - 'a'];
        }
        node.endFlag = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chArr = word.toCharArray();
        TrieNode node = root;
        for (char ch : chArr)
            if (node.subTrie[ch - 'a'] == null)
                return false;
            else
                node = node.subTrie[ch - 'a'];
        return node.endFlag;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chArr = prefix.toCharArray();
        TrieNode node = root;
        for (char ch : chArr)
            if (node.subTrie[ch - 'a'] == null)
                return false;
            else
                node = node.subTrie[ch - 'a'];
        return true;
    }
    
    class TrieNode
    {
        TrieNode[] subTrie = null;
        
        char ch = '\0';
        
        boolean endFlag = false;
        
        TrieNode(char ch)
        {
            subTrie = new TrieNode[26];     // 'a' - 'z'
            this.ch = ch;
            endFlag = false;
        }
    }
}