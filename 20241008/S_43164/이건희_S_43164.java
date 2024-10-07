    import java.util.*;

    class Solution {
        public String[] solution(String[][] tickets) {
            HashMap<String, PriorityQueue<String>> map = new HashMap<>();  
            List<String> result = new ArrayList<>();

            for (String[] ticket : tickets) {
                if(!map.containsKey(ticket[0])){
                    map.put(ticket[0], new PriorityQueue<>());
                }
                map.get(ticket[0]).offer(ticket[1]);
            }
            // dfs("ICN", map, result);
            Stack<String> stack = new Stack<>();
            stack.push("ICN");
            while(!stack.isEmpty()){
                String airport = stack.peek();
                if(map.containsKey(airport) && !map.get(airport).isEmpty()){// poll로 다 뺀거 체크 안해주면 무한루프 돈다.
                    stack.push(map.get(airport).poll());// 우선순위 큐로 알파벳 순으로 정렬되니까, 가장 최신을 poll로 빼온다.
                }else{
                    result.add(stack.pop());
                }
            }
            
            Collections.reverse(result);
            return result.toArray(new String[0]);
        }
        // private void dfs(String airport, HashMap<String, PriorityQueue<String>> map, List<String> result){
        //     while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
        //         String next = map.get(airport).poll();
        //         dfs(next, map, result);
        //     }
        //     result.add(airport);
        // }
    }