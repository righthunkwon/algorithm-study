import java.io.*;
import java.util.*;

class Solution {
    public int solution(int N, int number) {
        //8까지 만들어질 수 있는 수를 배열에 넣고 9의 8승 얼마지 43,046,721 
        //dp로 어케 푸는겨 ..
        //블로그 참고 풀이  https://small-stap.tistory.com/65
        List<Set<Integer>> dp = new ArrayList<>();//idx개로 만들 수 있는 숫자 넣기
        for(int i=0; i<9; i++){
	        dp.add(new HashSet<>()); 
        }
        dp.get(1).add(N);
        for(int i=2;i<9;i++){
                Set set=dp.get(i);
            	for(int j=1; j<=i; j++){
                    Set<Integer> preSet = dp.get(j);
                    Set<Integer> postSet = dp.get(i - j);

                    for(int preNum : preSet){
                        for(int postNum : postSet){
                            set.add(preNum + postNum);
                            set.add(preNum - postNum);
                            set.add(preNum * postNum);

                            if(preNum != 0 && postNum != 0)
                                set.add(preNum / postNum);
                        }
                    }
	            }
            set.add(Integer.parseInt(String.valueOf(N).repeat(i))); //55같은 애들
        }
        for(Set<Integer> set : dp){
	        if(set.contains(number))//숫자가 있다면 그 set 번호 반환
	        	return dp.indexOf(set);
        }

        return -1;
    }
}
