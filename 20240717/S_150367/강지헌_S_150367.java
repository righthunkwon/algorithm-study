class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) answer[i] = chk(numbers[i]);
        return answer;
    }
    
    private int chk(long n) {
        String s = Long.toBinaryString(n);
        int t = (int)Math.pow(2,Integer.toBinaryString(s.length()).length()) - 1;
        String fill = String.format("%"+t+"s",s).replace(' ','0');
        for (int i = 1; i <= fill.length(); i++) {
            if (i%2 == 0 && fill.charAt(i-1) == '0') {
                int h = (i & (-i)) / 2;
                if (fill.charAt(i-h-1)-'0' + fill.charAt(i+h-1)-'0' != 0) return 0;
            }
        }
        return 1;
    }
}
