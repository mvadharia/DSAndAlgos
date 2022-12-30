package datastructure;

import java.util.HashMap;
import java.util.Objects;

public class Tries {
    static class TrieNode {
        HashMap<Character, TrieNode> children;
        String content;
        boolean isEnd;
        int count;

        public TrieNode() {
            content = "";
            count = 0;
            isEnd = false;
            children = new HashMap<>();
        }

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public void setChildren(HashMap<Character, TrieNode> children) {
            this.children = children;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    TrieNode root;

    public Tries() {
        root = new TrieNode();
    }

    void buildTrie(String[] arr) {
        for (String str : arr) {
            this.addString(str);
        }
    }

    void addString(String key) {
        TrieNode newNode = root;
        for (char c : key.toCharArray()) {
            newNode.children.computeIfAbsent(c, l -> new TrieNode());
            newNode = newNode.children.get(c);
        }
        newNode.setEnd(true);
        newNode.setCount(newNode.getCount() + 1);
    }

    boolean search(String key) {
        TrieNode newNode = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            TrieNode temp = newNode.getChildren().get(c);
            if (!Objects.isNull(temp)) {
                return false;
            }
            newNode = temp;
        }
        return newNode.isEnd() && newNode.getCount() > 0;
    }

//    void delete(String key) {
//        TrieNode newNode = root;
//        for (int i = 0; i < key.length(); i++) {
//            char c = key.charAt(i);
//            if (newNode.getChildren().containsKey(c)) {
//                throw new RuntimeException("Unable to delete");
//            }
//            newNode = newNode.getChildren().get(c);
//        }
//        if (newNode.isEnd() && newNode.getCount() > 0) {
//            newNode.setCount(newNode.getCount() - 1);
//        } else {
//            throw new RuntimeException("Unable to delete");
//        }
//    }

    void delete(String key){
        deleteHelper(this.root,key,0);
    }

    boolean deleteHelper(TrieNode node, String key, int index){
        if(index==key.length()){
            if(!node.isEnd()){
                return false;
            }
            node.setEnd(false);
            return node.getChildren().isEmpty();
        }
        char c=key.charAt(index);
        if(!node.getChildren().containsKey(c)){
            return false;
        }
        boolean shouldDelete=deleteHelper(node.getChildren().get(c), key, index+1) && !node.isEnd();
        if(shouldDelete){
            node.getChildren().remove(c);
            return node.getChildren().isEmpty();
        }
        return false;
    }
}
