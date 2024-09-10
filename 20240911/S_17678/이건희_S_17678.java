import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        // 사용하기 쉽게 int 분으로 변환
        int[] inttable = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            String[] time = timetable[i].split(":");
            inttable[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }
        // 시간이 내림차순으로 들어와서 오름차순으로 변겨
        Arrays.sort(inttable);
        // 셔틀 도착 시간 계산
        int shuttleTime = 540; // 9*60
        int lastTime = 0;// 결과값
        int idx = 0;// 시간테이블 인덱스
        for (int i = 0; i < n; i++) {
            int tmp = 0; // 셔틀 탄 사람
            // 최대 m명
            while (tmp < m && idx < inttable.length && inttable[idx] <= shuttleTime) {
                tmp++;
                idx++;
            }
            // 마지막 셔틀 저장
            if (i == n - 1) {
                if (tmp < m) {
                    lastTime = shuttleTime; // 자리가 있으면 셔틀 시간에 맞춰 도착
                } else {
                    lastTime = inttable[idx - 1] - 1; // 자리가 없으면 마지막 크루보다 1분 일찍 도착
                }
            }
            shuttleTime += t; // 다음 셔틀 시간으로 이동
        }
        // 시간 문자열로 변환해서 출력
        return String.format("%02d:%02d", lastTime/60, lastTime%60);
    }
}