import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        // 각자의 약수를 구해서 미리 넣어놓는 방식
        // 약수 구하기 
        int[] arr = new int [e+1];
        Arrays.fill(arr, 1);
        // 각각의 곱을 미리 +해놓는 방식
        for(int i = 2; i <= e; i++){
            for(int j = 1; j * i <= e; j++){
                arr[i *j]++;
            }
        }
        int size = starts.length;
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(new int [] {i, starts[i]});
        }
        // starts 숫자가 큰 순서대로 정렬
        list.sort((o1,o2)->{
           return o2[1] - o1[1];
        });

        // 탐색 범위 
        int end = e; 
        int max = 1;
        int v = e;
        // starts[i]가 큰 순서대로 정렬을 하고 
        // 해당 숫자부터 탐색을 하고 탐색 범위를 starts[i] 에서 갱신된 e까지 탐색
        // 그 이후의 숫자는 이미 탐색하였고 크기가 같다면 작은 숫자를 반영
        for(int i = 0; i < size; i++){
            int [] temp = list.get(i);
            int start = temp[1];
            for(int j = end; j >= start; j--){
                // 크거나 같으면 갱신 
                if(arr[j] >= max){ 
                    max = arr[j];
                    v = j;
                }    
            }
            end = start;
            answer[temp[0]] = v; 
        }
        
        return answer;
    }
}
