import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        
        //장르별 토탈 재생 횟수
        HashMap<String, Integer> genreTotal = new HashMap<>();
        
        //장르별 노래 고유번호,재생횟수
        HashMap<String,HashMap<Integer,Integer>> songs = new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            
            genreTotal.put(genres[i],genreTotal.getOrDefault(genres[i],0)+plays[i]); //장르별로 재생횟수 누적시키기
            HashMap<Integer,Integer> hs = songs.getOrDefault(genres[i],new HashMap<>()); //각 장르별로 해쉬맵 생성(이미 있으면 가져오기)
            hs.put(i,plays[i]); //고유번호,재생횟수 입력
            songs.put(genres[i],hs); //곡 추가한 해쉬맵으로 덮어쓰기
        }
        
        //토탈 재생횟수 높은 순으로 정렬한 장르 리스트 생성
        List<String> sortedGenres = new ArrayList<>(genreTotal.keySet());
        sortedGenres.sort((o1,o2)->genreTotal.get(o2)-genreTotal.get(o1));
        
        List<Integer>tmpList = new ArrayList<>();//정답 리스트
            
        for(String genre : sortedGenres){
            System.out.println(genre); //출력 테스트
            int cnt = 0; //상위 2개 뽑기용
            
            //재생횟수 높은순으로 노래 정렬
            HashMap<Integer,Integer> map = songs.get(genre);
            List<Integer> sortedSongs = new ArrayList<>(map.keySet());
            sortedSongs.sort((o1,o2)->map.get(o2)-map.get(o1));
            
            //상위 2개 정답 리스트에 넣기
            for(Integer song : sortedSongs){
                cnt++;
                tmpList.add(song);
                if(cnt==2)break;
            }
        }
        
        //리스트 -> 배열
        int [] answer = new int [tmpList.size()];
        int idx = 0;
        for(int a: tmpList){
            answer[idx]=a;
            idx++;
        }
        
        return answer;
    }
}
