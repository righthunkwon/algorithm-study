import java.util.*;
//블로그 가져옴 ,,
class Solution {
    //알파벳 하위로 노드를 추가 
    public class Node {
        Map<Character, Node> child = new HashMap<>();
        Node before = null;
        Boolean isEnd = false; 
    }

    public class Trie {
        public Node root = new Node();
        //알파벳 넣기 
        public void insert(String input) {
            Node node = this.root;
            
            for (int i = 0; i < input.length(); i++) {
                Node before = node;
                //이미 자식 중 있는 지 없다면 새로 생성하고 부모랑 연결
                node = node.child.computeIfAbsent(input.charAt(i), k -> new Node());
                node.before = before;
            }

            node.isEnd = true; //마지막 알파벳 끝처리 알려주기 
        }

        //각 단어의 최소 입력 횟수 계산
        public int calInputCnt(String input) {
            Node node = this.root;

            //마지막 노드로 이동
            for (int i = 0; i < input.length(); i++) {
                node = node.child.getOrDefault(input.charAt(i), null);
            }

            //1. 마지막 노드가 leaf 노드가 아닐 경우
            //모두 입력해야 검색 결과가 나옴 
            if (node.child.size() != 0) return input.length();

            //2. 마지막 노드가 leaf 노드일 경우
            int cnt = 0;
            while(true) {
                node = node.before;
                if (node == null) { //더 앞으로 갈 곳이 없는 경우
                    cnt--;
                    break;
                }
                if (node.isEnd == false && node.child.size() == 1) //내가 유일한 자식일 때   
                    cnt++;
                else
                    break;
            }
            return input.length() - cnt; //전체 길이에서 빼주기 
        }
    }

    public int solution(String[] words) {
        Trie trie = new Trie();
        //트라이 입력
        for (int i = 0; i < words.length; i++)
            trie.insert(words[i]);

        //각 단어의 최소 입력 횟수 계산
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            result += trie.calInputCnt(words[i]);
        }
        return result;
    }
}
