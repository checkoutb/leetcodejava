package ge200;

public class LT0211_Add_and_Search_Word
{

    public static void main(String[] args)
    {
//        addWord("bad")
//        addWord("dad")
//        addWord("mad")
//        search("pad") -> false
//        search("bad") -> true
//        search(".ad") -> true
//        search("b..") -> true
        
        WordDictionary wd = new WordDictionary();
        
//        wd.addWord("bad");
//        wd.addWord("dad");
//        wd.addWord("mad");
//        System.out.println(wd.search("pad"));
//        System.out.println(wd.search("bad"));
//        System.out.println(wd.search(".ad"));
//        System.out.println(wd.search("b.."));
        
//        ["WordDictionary","addWord","addWord","search","search","search","search","search","search"]
//        [[],              ["a"],      ["a"],      ["."],  ["a"],["aa"],   ["a"],      [".a"],["a."]]
//        [null,           null,       null,       true,   true,false,     true,       false,false]

        wd.addWord("a");
        wd.addWord("a");
//        System.out.println(wd.search("."));
//        System.out.println(wd.search("a"));
//        System.out.println(wd.search("aa"));
//        System.out.println(wd.search("a"));
        System.out.println(wd.search(".a"));
        System.out.println(wd.search("a."));
    }

}

// 觉得用前面碰到的Trie挺好的。
// 134ms, most are [103, 160]ms.
// 排前面的一溜的Trie。不过方法的实现就是八仙过海了。。
class WordDictionary {
    
    Trie root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] chArr = word.toCharArray();
        Trie node = root;
        for (char ch : chArr)
        {
            if (node.subTrie[ch - 'a'] == null)
                node.subTrie[ch - 'a'] = new Trie();
            node = node.subTrie[ch - 'a'];
        }
        node.end = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] chArr = word.toCharArray();
        Trie node = root;
        return this.recursiona2(chArr, 0, node);
    }
    
    private boolean recursiona2(char[] arr, int index, Trie node)
    {
        if (index == arr.length)
            return node.end;
        if (arr[index] == '.')
        {
            for (Trie n : node.subTrie)
                if (n != null)
                    if (recursiona2(arr, index + 1, n))
                        return true;
        }
        else
        {
            if (node.subTrie[arr[index] - 'a'] == null)
                return false;
            else
                return this.recursiona2(arr, index + 1, node.subTrie[arr[index] - 'a']);
        }
        return false;           // '.'里可能没有返回，所以需要这个。并且'.'中如果有成立的就直接返回了，所以这里返回false。
    }
    
    class Trie
    {
        Trie[] subTrie;
        boolean end;
        Trie()
        {
            this.subTrie = new Trie[26];
            end = false;
        }
    }
}