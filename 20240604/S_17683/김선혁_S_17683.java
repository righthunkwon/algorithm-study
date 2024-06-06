class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        // 음이 일단 12개로 샵잇는거랑 없는거 
        
        
        // 일단우선 입력받는 배열에서 각 곡마다 분을 구하자
        // 그리고 곡을 재생해서 쭉 하나로 만들고
        // m배열이랑 다르면 다음배열 진행
        
        // 실행전 분 구하고 #은 소문자 바꿔서 진행
          m = convertSound(m);
         int maxRunningTime = 0;
        for (String info : musicinfos) {
            // 배열에서 하나씩 ,기준으로 자른다음에 시간 구하자
            String[] musicInfo = info.split(",");
            int runningTime = getTime(musicInfo[0], musicInfo[1]); // 총 시간 구함
            String musicName = musicInfo[2];
            String sound = convertSound(musicInfo[3]);
            
            // 곡 정보를 재생해서 만든 악보
            String music = playMusic(sound, runningTime);
            // m을 포함안하고 있으면 continue;
            if (!music.contains(m)) continue;
            // 가장 시간 긴거로 answer 교체
            if (runningTime > maxRunningTime) {
                answer = musicName;
                maxRunningTime = runningTime;
            }
        }
        return answer;
        
    }
    static int getTime(String startInfo, String endInfo) {
        // :을 기준으로 맨처음 시간 , 분 , 시간 , 분
        // 분으로 바꿔서 return
        int startHour = Integer.parseInt(startInfo.split(":")[0]);
        int startMinute = Integer.parseInt(startInfo.split(":")[1]);
        int endHour = Integer.parseInt(endInfo.split(":")[0]);
        int endMinute = Integer.parseInt(endInfo.split(":")[1]);
        return (endHour - startHour) * 60 + (endMinute - startMinute);
    }
    // #을 소문자로 교체
    static String convertSound(String m) {
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        m = m.replaceAll("A#", "a");
        return m;
    }
    // 시간에 맞춰서 다 sb에 더해서 return
    static String playMusic(String sound, int runningTime) {
        StringBuilder sb = new StringBuilder();
        int soundLength = sound.length();
        for (int i=0; i<runningTime; i++) {
            sb.append(sound.charAt(i % soundLength));
        }
        return sb.toString();
    }
}
