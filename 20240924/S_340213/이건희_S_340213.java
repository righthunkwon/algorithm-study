class Solution {
    public int convertInt(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }
    public String convertString(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = convertInt(video_len);
        int currentPos = convertInt(pos);
        int openingStart = convertInt(op_start);
        int openingEnd = convertInt(op_end);
        for (String command : commands) {
            switch (command) {
                case "prev":
                    currentPos = Math.max(0, currentPos - 10);
                    break;
                case "next":
                    if (currentPos >= openingStart && currentPos <= openingEnd) {// 예제2
                        currentPos = openingEnd;
                    }
                    currentPos = Math.min(videoLen, currentPos + 10);
                    break;
                default:
                    break;
            }
            if (currentPos >= openingStart && currentPos <= openingEnd) {// 예제3
                    currentPos = openingEnd;
            }
        }
        return convertString(currentPos);
    }
}